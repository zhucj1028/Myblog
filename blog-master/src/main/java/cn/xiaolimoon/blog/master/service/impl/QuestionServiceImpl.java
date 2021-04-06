package cn.xiaolimoon.blog.master.service.impl;

import cn.xiaolimoon.blog.master.dto.QuestionDTO;
import cn.xiaolimoon.blog.master.mapper.QuestionTagMapper;
import cn.xiaolimoon.blog.master.model.Diary;
import cn.xiaolimoon.blog.master.model.Question;
import cn.xiaolimoon.blog.master.mapper.QuestionMapper;
import cn.xiaolimoon.blog.master.model.QuestionTag;
import cn.xiaolimoon.blog.master.service.IQuestionService;
import cn.xiaolimoon.blog.master.service.ITagService;
import cn.xiaolimoon.blog.master.service.ex.DeleteException;
import cn.xiaolimoon.blog.master.service.ex.InsertException;
import cn.xiaolimoon.blog.master.service.ex.NotFoundException;
import cn.xiaolimoon.blog.master.service.ex.QuestionNotFoundException;
import cn.xiaolimoon.blog.master.vo.QuestionVO;
import cn.xiaolimoon.blog.master.vo.TagVO;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wuqu
 * @since 2020-12-26
 */
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements IQuestionService {

    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private QuestionTagMapper questionTagMapper;
    @Autowired
    private ITagService tagService;

    @Override
    public void create(QuestionDTO questionDTO, Integer userId, String userNickname) {
        // 创建当前时间对象：now
        LocalDateTime now = LocalDateTime.now();
        // 将questionDTO中的tagIds转换成例如 2,7,9 这种格式的字符串，名为tagIdsStr
        String tagIdsStr = Arrays.toString(questionDTO.getTagIds());
        tagIdsStr = tagIdsStr.substring(1, tagIdsStr.length() - 1);
        // 创建Question对象
        // 向Question对象中补全数据
        // - title / content > questionDTO的title / content
        // - userId / userNickName > 参数
        // - CommentCount > 0
        // - hits > 0
        // - createdTime
        // - tagIds > tagIdsStr
        Question question = new Question()
                .setTitle(questionDTO.getTitle())
                .setContent(questionDTO.getContent())
                .setUserNickname(userNickname)
                .setUserId(userId)
                .setCommentCount(0)
                .setHits(0)
                .setCreateTime(now)
                .setTagIds(tagIdsStr);
        // 基于以上Question对象，调用questionMapper的insert()方法，向question表中插入数据，获取返回值
        int rows = questionMapper.insert(question);
        // 判断返回值是否不为1
        if (rows != 1) {
            // 是：抛出InsertException
            throw new InsertException("发布问题失败！当前服务器忙，请稍后尝试！");
        }
        // 遍历questionDTO中的tagIds
        for (Integer tagId : questionDTO.getTagIds()) {
            // - 创建QuestionTag对象
            // - 补全属性：questionId > 以上插入Question对象的id
            // - 补全属性：tagId > 被遍历到的数据
            QuestionTag questionTag = new QuestionTag()
                    .setQuestionId(question.getId())
                    .setTagId(tagId);

            // - 基于以上QuestionTag对象，调用questionTagMapper的insert()方法，
            // 向question_tag表中插入数据，以记录“问题”与“标签”的对应关系，并需要获取当前调用方法的返回值
            rows = questionTagMapper.insert(questionTag);
            // - 判断返回值是否不为1
            if (rows != 1) {
                // - 是：抛出InsertException
                throw new InsertException("发布问题失败！当前服务器忙，请稍后再尝试！");
            }

        }
    }

    //分页查询参数
    @Value("${project.question-list.page-size}")
    private Integer pageSize;

    @Override
    public PageInfo<QuestionVO> getQuestions(Question question,Integer page) {
        // 设置分页参数
        PageHelper.startPage(page,pageSize);
        // 调用持久层方法查询问题列表，该列表中的数据只有标签的id，并不包括标签数据
        List<QuestionVO> questions = questionMapper.findQuestionList(question);
        // 遍历以上列表，取出每个问题中记录的标签的ids，并根据这些id从缓存中取出TagVO封装到QuestionVO对象中
        for (QuestionVO q : questions) {
            // 取出标签的id
            String tagIdsStr = q.getTagIds();
            // 拆分
            String[] tagIds = tagIdsStr.split(", ");
            // 创建用于存放若干个标签的集合
            q.setTags(new ArrayList<>());
            // 便利数组，从缓存中找出对应的TagVO
            for (String tagId : tagIds) {
                // 从缓存中取出对应的TagVO
                Integer id = Integer.valueOf(tagId);
                TagVO tag = tagService.getTagVOById(id);
                // 将取出的TagVO添加到QuestionVO对象中
                q.getTags().add(tag);
            }
        }
        // 返回
        return new PageInfo<>(questions);
    }

    /**
     * 根据标签id获取标签（TagVO）数据的集合
     * @param tagIdsStr 由若干个标签id组成的字符串，各id之间使用 , 分隔
     * @return 签（TagVO）数据的集合
     */
    private List<TagVO> getTagsByIds(String tagIdsStr) {
        // 拆分
        String[] tagIds = tagIdsStr.split(", ");
        // 创建用于存放若干个标签的集合
        List<TagVO> tags = new ArrayList<>();
        // 遍历数组，从缓存中找出对应的TagVO
        for (String tagId : tagIds) {
            // 从缓存中取出对应的TagVO
            Integer id = Integer.valueOf(tagId);
            TagVO tag = tagService.getTagVOById(id);
            // 将取出的TagVO添加到QuestionVO对象中
            tags.add(tag);
        }
        // 返回
        return tags;
    }

    @Override
    public QuestionVO getQuestionById(Integer id) {
        // 实现过程中，先通过持久层查询数据，并判断查询结果是否为null，如果为null，则抛出异常
        QuestionVO questionVO = questionMapper.findById(id);
        if (questionVO == null) {
            throw new QuestionNotFoundException("获取博客详情失败，");
        }
        // 根据查询结果中的tagIds确定tags的值
        questionVO.setTags(getTagsByIds(questionVO.getTagIds()));
        // 返回查询结果
        return questionVO;
    }

    @Override
    public Question deleteQuestion(Integer id) {
        // 根据参数Id调用mapper.selectById()查询被删除的“日记”的信息
        Question question = questionMapper.selectById(id);
        // 判断查询结果是否为null
        if (question == null) {
            // 是：该“评论”不存在，抛出NotFoundException异常
            throw new NotFoundException("删除博客失败！尝试访问的博客数据不存在！");
        }
        // 根据参数diaryId调用mapper.deleteById()执行删除，并获取返回的受影响行数
        int rows = questionMapper.deleteById(id);
        // 判断返回值是否不为1
        if (rows != 1) {
            // 是：抛出DeleteException
            throw new DeleteException("删除失败！请稍后再次尝试！");
        }
        // 返回查询结果
        return question;
    }
}
