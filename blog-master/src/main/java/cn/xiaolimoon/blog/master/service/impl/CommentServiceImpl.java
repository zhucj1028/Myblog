package cn.xiaolimoon.blog.master.service.impl;

import cn.xiaolimoon.blog.master.dto.CommentDTO;
import cn.xiaolimoon.blog.master.model.Comment;
import cn.xiaolimoon.blog.master.mapper.CommentMapper;
import cn.xiaolimoon.blog.master.service.ICommentService;
import cn.xiaolimoon.blog.master.service.ex.InsertException;
import cn.xiaolimoon.blog.master.vo.CommentVO;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wuqu
 * @since 2021-01-09
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements ICommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public void post(CommentDTO commentDTO, Integer userId, String userNickname) {
        // 创建Comment对象
        Comment comment = new Comment();
        // 补全comment对象的属性值：content
        comment.setContent(commentDTO.getContent());
        // 补全comment对象的属性值：user_id
        comment.setUserId(userId);
        // 补全comment对象的属性值：user_nickname
        comment.setUserNickname(userNickname);
        // 补全comment对象的属性值：Article_id
        comment.setArticleId(commentDTO.getArticleId());
        // 补全answer对象的属性值：created_time
        comment.setCreateTime(LocalDateTime.now());
        // 调用int commentMapper.insert(Comment comment)方法插入“回复”的数据，并获取返回结果
        int rows = commentMapper.insert(comment);
        // 判断返回值是否不为1
        if (rows != 1) {
            // 是：抛出InsertException
            throw new InsertException("评论失败！服务器忙，请稍后再次尝试！");
        }
    }

    @Override
    public List<CommentVO> getListByArticleId(Integer articleId) {
        return commentMapper.findListByArticleId(articleId);
    }
}
