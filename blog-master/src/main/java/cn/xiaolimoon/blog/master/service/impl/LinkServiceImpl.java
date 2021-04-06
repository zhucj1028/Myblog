package cn.xiaolimoon.blog.master.service.impl;

import cn.xiaolimoon.blog.master.model.Diary;
import cn.xiaolimoon.blog.master.model.Link;
import cn.xiaolimoon.blog.master.mapper.LinkMapper;
import cn.xiaolimoon.blog.master.service.ILinkService;
import cn.xiaolimoon.blog.master.service.ex.DeleteException;
import cn.xiaolimoon.blog.master.service.ex.InsertException;
import cn.xiaolimoon.blog.master.service.ex.NotFoundException;
import cn.xiaolimoon.blog.master.vo.LinkVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wuqu
 * @since 2021-01-03
 */
@Service
public class LinkServiceImpl extends ServiceImpl<LinkMapper, Link> implements ILinkService {

    @Autowired
    LinkMapper mapper;

    @Override
    public List<LinkVO> getLinks() {
        List<LinkVO> links = mapper.findLinkAll();
        return links;
    }

    @Override
    public void insertLink(Link link) {
        String linkUrl = link.getUrl();
        QueryWrapper<Link> linkQueryWrapper = new QueryWrapper<>();
        linkQueryWrapper.eq("url", linkUrl);
        Link result = mapper.selectOne(linkQueryWrapper);
        if (result != null) {
            throw new InsertException("创建失败，链接已存在！");
        }
        // 向数据库中写入时间
        link.setCreateTime(LocalDateTime.now());
        // 调用mtagMapper的insert()方法插入数据
        int rows = mapper.insert(link);
        // 判断返回值是否不为1
        if (rows != 1) {
            // 是：受影响的行数不是1，则插入数据失败，抛出异常
            throw new InsertException("创建失败！服务器忙，请稍后再次尝试！");
        }
    }

    @Override
    public Link deleteLink(Integer id) {
        // 根据参数Id调用mapper.selectById()查询被删除的“日记”的信息
        Link link = mapper.selectById(id);
        // 判断查询结果是否为null
        if (link == null) {
            // 是：该“评论”不存在，抛出NotFoundException异常
            throw new NotFoundException("删除链接失败！尝试访问的链接数据不存在！");
        }
        // 根据参数diaryId调用mapper.deleteById()执行删除，并获取返回的受影响行数
        int rows = mapper.deleteById(id);
        // 判断返回值是否不为1
        if (rows != 1) {
            // 是：抛出DeleteException
            throw new DeleteException("删除失败！请稍后再次尝试！");
        }
        // 返回查询结果
        return link;
    }
}
