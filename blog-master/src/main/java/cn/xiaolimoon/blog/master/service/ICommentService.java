package cn.xiaolimoon.blog.master.service;

import cn.xiaolimoon.blog.master.dto.CommentDTO;
import cn.xiaolimoon.blog.master.model.Comment;
import cn.xiaolimoon.blog.master.vo.CommentVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wuqu
 * @since 2021-01-09
 */
public interface ICommentService extends IService<Comment> {
    /**
     * 提交评论
     * @param commentDTO    客户端提交的评论
     * @param userId       当前登录的用户id
     * @param userNickname 当前登录的用户昵称
     */
    void post(CommentDTO commentDTO, Integer userId, String userNickname);

    /**
     * 根据博客的id查询评论的列表
     * @param articleId 博客的id
     * @return 该博客的所有评论的列表
     */
    List<CommentVO> getListByArticleId(Integer articleId);
}
