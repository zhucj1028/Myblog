package cn.xiaolimoon.blog.master.service;

import cn.xiaolimoon.blog.master.model.Link;
import cn.xiaolimoon.blog.master.vo.LinkVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wuqu
 * @since 2021-01-03
 */
public interface ILinkService extends IService<Link> {

    /**
     * 获取标签列表
     * @return 标签列表
     */
    List<LinkVO> getLinks();

    /**
     * 发布友情链接
     * @param link 连接
     */
    void insertLink(Link link);

    /**
     * 删除链接
     * @param id 链接数据id
     * @return 成功删除的数据
     */
    Link deleteLink(Integer id);

}
