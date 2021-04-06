package cn.xiaolimoon.blog.master.controller;


import cn.xiaolimoon.blog.master.model.Diary;
import cn.xiaolimoon.blog.master.model.Link;
import cn.xiaolimoon.blog.master.model.Message;
import cn.xiaolimoon.blog.master.model.Tag;
import cn.xiaolimoon.blog.master.security.UserInfo;
import cn.xiaolimoon.blog.master.service.IMessageService;
import cn.xiaolimoon.blog.master.vo.MessageVO;
import cn.xiaolimoon.blog.master.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author wuqu
 * @since 2021-01-07
 */
@RestController
@RequestMapping("/api/v1/message")
public class MessageController {

    @Autowired
    IMessageService messageService;

    // http://localhost:8080/api/v1/message/
    @GetMapping("")
    public R<List<MessageVO>> getMessagesList(Message message) {
        return R.ok(messageService.getMessageList(message));
    }

    // http://localhost:8080/api/v1/message/create?userid=9&user_nickname=小李&content=今天你学习了嘛
    @RequestMapping("/create")
    public R<Void> insertMessage(Message message, @AuthenticationPrincipal UserInfo userInfo) {
        messageService.insertMessage(message, userInfo.getId(), userInfo.getNickname());
        return R.ok();
    }

    // http://localhost:8080/api/v1/message/31/delete
    @RequestMapping("/{messageId}/delete")
    public R<Link> delete(@PathVariable("messageId") Integer messageId) {
        Message message = messageService.deleteMessage(messageId);
        return R.ok(message);
    }
}
