package cn.xiaolimoon.blog.master.service;

import cn.xiaolimoon.blog.master.model.Link;
import cn.xiaolimoon.blog.master.model.Message;
import cn.xiaolimoon.blog.master.model.Question;
import cn.xiaolimoon.blog.master.vo.DiaryVO;
import cn.xiaolimoon.blog.master.vo.MessageVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author wuqu
 * @since 2021-01-07
 */
public interface IMessageService extends IService<Message> {


    /**
     * 留言
     * @return 留言列表
     */
    List<MessageVO> getMessageList(Message message);


    /**
     * @param message
     * @param userId
     * @param userNickname
     */
    void insertMessage(Message message, Integer userId, String userNickname);

    /**
     * 删除留言
     * @param id 留言数据id
     * @return 成功删除的数据
     */
    Message deleteMessage(Integer id);

}
