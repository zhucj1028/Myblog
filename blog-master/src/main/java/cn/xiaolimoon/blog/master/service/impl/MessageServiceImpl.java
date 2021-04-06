package cn.xiaolimoon.blog.master.service.impl;

import cn.xiaolimoon.blog.master.model.Link;
import cn.xiaolimoon.blog.master.model.Message;
import cn.xiaolimoon.blog.master.mapper.MessageMapper;
import cn.xiaolimoon.blog.master.model.Question;
import cn.xiaolimoon.blog.master.service.IMessageService;
import cn.xiaolimoon.blog.master.service.ex.DeleteException;
import cn.xiaolimoon.blog.master.service.ex.InsertException;
import cn.xiaolimoon.blog.master.service.ex.NotFoundException;
import cn.xiaolimoon.blog.master.vo.MessageVO;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wuqu
 * @since 2021-01-07
 */
@Service
@Slf4j
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements IMessageService {

    @Autowired
    private MessageMapper messageMapper;

    @Override
    public List<MessageVO> getMessageList(Message message) {
        List<MessageVO> messageList = messageMapper.findMessages(message);
        return messageList;
    }

    @Override
    public void insertMessage(Message message,Integer userId,String userNickname) {
        LocalDateTime now = LocalDateTime.now();
        // 向数据库中插入评论数据
        message.setUserId(userId)
                .setUserNickname(userNickname)
                .setContent(message.getContent())
                .setParentCommentId(message.getParentCommentId())
                .setCreateTime(now);

        if (userNickname == null && userId == null) {
            throw new NotFoundException("留言失败！当前未登录,请登陆后重试！");
        }
        int rows = messageMapper.insert(message);
        if (rows != 1) {
            throw new InsertException("留言失败！当前服务器忙，请稍后再次尝试！");
        }
    }

    @Override
    public Message deleteMessage(Integer id) {
        // 根据参数Id调用mapper.selectById()查询被删除的“日记”的信息
        Message message = messageMapper.selectById(id);
        // 判断查询结果是否为null
        if (message == null) {
            // 是：该“评论”不存在，抛出NotFoundException异常
            throw new NotFoundException("删除留言失败！尝试访问的留言数据不存在！");
        }
        // 根据参数diaryId调用mapper.deleteById()执行删除，并获取返回的受影响行数
        int rows = messageMapper.deleteById(id);
        // 判断返回值是否不为1
        if (rows != 1) {
            // 是：抛出DeleteException
            throw new DeleteException("删除失败！请稍后再次尝试！");
        }
        // 返回查询结果
        return message;
    }
}
