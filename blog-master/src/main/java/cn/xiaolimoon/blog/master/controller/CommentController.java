package cn.xiaolimoon.blog.master.controller;


import cn.xiaolimoon.blog.master.dto.CommentDTO;
import cn.xiaolimoon.blog.master.security.UserInfo;
import cn.xiaolimoon.blog.master.service.ICommentService;
import cn.xiaolimoon.blog.master.service.ex.ParameterValidationException;
import cn.xiaolimoon.blog.master.vo.CommentVO;
import cn.xiaolimoon.blog.master.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author wuqu
 * @since 2021-01-09
 */
@RestController
@RequestMapping("/api/v1/comment")
public class CommentController {


    @Autowired
    private ICommentService commentService;

    // http://localhost:8080/api/v1/comment/post?articleId=1&content=666
    @RequestMapping("/post")
    public R<Void> post(@Validated CommentDTO commentDTO,
                        BindingResult bindingResult,
                        @AuthenticationPrincipal UserInfo userInfo) {
        if (bindingResult.hasErrors()) {
            String message = bindingResult.getFieldError().getDefaultMessage();
            throw new ParameterValidationException(message);
        }
        commentService.post(commentDTO, userInfo.getId(), userInfo.getNickname());
        return R.ok();
    }

    // http://localhost:8080/api/v1/comment/80
    @GetMapping("/{articleId}")
    public R<List<CommentVO>> getListByCommentId(
            @PathVariable("articleId") Integer articleId) {
        return R.ok(commentService.getListByArticleId(articleId));
    }


}
