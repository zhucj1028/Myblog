package cn.xiaolimoon.blog.master.mapper;

import cn.xiaolimoon.blog.master.model.Message;
import cn.xiaolimoon.blog.master.vo.MessageVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author wuqu
 * @since 2021-01-07
 */
@Repository
public interface MessageMapper extends BaseMapper<Message> {


    /**
     * 获取留言
     * @return 返回留言列表
     */
    List<MessageVO> findMessages(Message message);

}
