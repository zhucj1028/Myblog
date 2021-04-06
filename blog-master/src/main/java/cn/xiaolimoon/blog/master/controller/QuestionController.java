package cn.xiaolimoon.blog.master.controller;


import cn.xiaolimoon.blog.master.dto.QuestionDTO;
import cn.xiaolimoon.blog.master.model.Diary;
import cn.xiaolimoon.blog.master.model.Question;
import cn.xiaolimoon.blog.master.security.UserInfo;
import cn.xiaolimoon.blog.master.service.IQuestionService;
import cn.xiaolimoon.blog.master.service.ex.FileEmptyException;
import cn.xiaolimoon.blog.master.service.ex.FileIOException;
import cn.xiaolimoon.blog.master.service.ex.FileSizeException;
import cn.xiaolimoon.blog.master.service.ex.FileTypeException;
import cn.xiaolimoon.blog.master.vo.QuestionVO;
import cn.xiaolimoon.blog.master.vo.R;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author wuqu
 * @since 2020-12-26
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/questions")
public class QuestionController {
    @Autowired
    private IQuestionService questionService;

    // http://localhost:8080/api/v1/questions/create?title=Java&content=HelloWorld&tagIds=2
    @RequestMapping("/create")
    public R<Void> create(QuestionDTO questionDTO, @AuthenticationPrincipal UserInfo userInfo) {
        questionService.create(questionDTO, userInfo.getId(), userInfo.getNickname());
        return R.ok();
    }

    // http://localhost:8080/api/v1/questions/my
    @RequestMapping("/my")
    public R<PageInfo<QuestionVO>> getMyQuestions(Integer page, @AuthenticationPrincipal Question question) {
        if (page == null || page < 1) {
            page = 1;
        }
        PageInfo<QuestionVO> questions = questionService.getQuestions(question, page);
        return R.ok(questions);
    }

    // http://localhost:8080/api/v1/questions/56
    @GetMapping("/{id}")
    public R<QuestionVO> getQuestionById(@PathVariable("id") Integer id) {
        return R.ok(questionService.getQuestionById(id));
    }

    // http://localhost:8080/api/v1/question/31/delete
    @RequestMapping("/{questionId}/delete")
    public R<Question> delete(@PathVariable("questionId") Integer questionId) {
        Question question = questionService.deleteQuestion(questionId);
        return R.ok(question);
    }


    @Value("${project.question.image-upload-path}")
    private String imageUploadPath;
    @Value(("${project.question.image-host}"))
    private String imageHost;
    @Value("${project.question.image-max-size}")
    private long imageMaxSize;
    @Value(("${project.question.image-content-types}"))
    private List<String> imageContentTypes;

    @PostMapping("/upload-image")
    public R<String> uploadImage(MultipartFile imageFile) {
        // 判断上传的文件是否为空
        if (imageFile.isEmpty()) {
            throw new FileEmptyException("上传图片失败！请选择有效的图片文件！");
        }
        // 判断上传的文件大小是否超标
        if (imageFile.getSize() > imageMaxSize) {
            throw new FileSizeException("上传图片失败！不允许使用超过" + (imageMaxSize / 1024) + "KB的图片文件！");
        }
        // 判断上传的文件类型是否超标
        if (!imageContentTypes.contains(imageFile.getContentType())) {
            throw new FileTypeException("上传图片失败！图片类型错误！允许上传的图片类型有：" + imageContentTypes);
        }

        // 确定本次上传时使用的文件夹
        String dir = DateTimeFormatter.ofPattern("yyyy/MM").format(LocalDateTime.now());
        File parent = new File(imageUploadPath, dir);
        if (!parent.exists()) {
            parent.mkdirs();
        }
        log.debug("dir >>> {}", parent);
        // 确定本次上传时使用的文件名
        String filename = UUID.randomUUID().toString();
        String originalFilename = imageFile.getOriginalFilename();
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        String child = filename + suffix;
        // 创建最终保存时的文件对象
        File dest = new File(parent, child);
        // 执行保存
        try {
            imageFile.transferTo(dest);
        } catch (IOException e) {
            throw new FileIOException("上传图片失败！当前服务器忙，请稍后再次尝试！");
        }
        // 确定网络访问路径
        String imageUrl = imageHost + dir + "/" + child; // http://localhost:8081/1.jpg
        log.debug("image url >>> {}", imageUrl);

        // 返回
        return R.ok(imageUrl);
    }
}
