package cn.xiaolimoon.blog.master.service.impl;

import cn.xiaolimoon.blog.master.model.Diary;
import cn.xiaolimoon.blog.master.model.Tag;
import cn.xiaolimoon.blog.master.mapper.TagMapper;
import cn.xiaolimoon.blog.master.service.ITagService;
import cn.xiaolimoon.blog.master.service.ex.DeleteException;
import cn.xiaolimoon.blog.master.service.ex.InsertException;
import cn.xiaolimoon.blog.master.service.ex.NotFoundException;
import cn.xiaolimoon.blog.master.service.ex.UsernameDuplicationException;
import cn.xiaolimoon.blog.master.vo.TagVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wuqu
 * @since 2020-12-17
 */
@Service
@Slf4j
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements ITagService {
    @Autowired
    private TagMapper tagMapper;

    /**
     * 缓存的标签列表
     */
    private List<TagVO> tags = new CopyOnWriteArrayList<>();

    @Override
    public void insertTag(Tag tag) {
        // 从tag表中取出标签名称
        String tagName = tag.getName();
        // 调用tagMapper的selectOne()方法去查询
        QueryWrapper<Tag> tagQueryWrapper = new QueryWrapper<>();
        tagQueryWrapper.eq("name", tagName);
        Tag result = tagMapper.selectOne(tagQueryWrapper);
        // 判断查询的结果是否不为Null
        if (result != null) {
            // 是：找到了数据，则不允许创建，抛出异常
            throw new UsernameDuplicationException("创建失败！该标签已存在！");
        }
        // 向数据库中写入时间
        tag.setCreateTime(LocalDateTime.now());
        // 调用mtagMapper的insert()方法插入数据
        int rows = tagMapper.insert(tag);
        // 判断返回值是否不为1
        if (rows != 1) {
            // 是：受影响的行数不是1，则插入数据失败，抛出异常
            throw new InsertException("创建失败！服务器忙，请稍后再次尝试！");
        }
    }

    @Override
    public List<TagVO> getTags() {
        // 判断有没有必要锁住代码
        if (tags.isEmpty()) {
            // 锁住代码
            synchronized (tags) {
                // 判断有没有必要重新加载数据
                if (tags.isEmpty()) {
                    tags.addAll(tagMapper.findAll());
                    log.debug("create tags cache ...");
                    log.debug(">>> tags : {}", tags);

                    for (TagVO tag : tags) {
                        tagsMap.put(tag.getId(), tag);
                    }
                    log.debug("create tags map cache ...");
                    log.debug(">>> tags map : {}", tagsMap);
                }
            }
        }
        return tags;
    }

    @Override
    public List<TagVO> getCachedTags() {
        return tags;
    }

    @Override
    public TagVO getTagVOById(Integer tagId) {
        // 如果缓存数据不存在，调用以上方法从数据库中读取数据并缓存下来
        if (tagsMap.isEmpty()) {
            getTags();
        }
        // 从缓存的Map中取出数据
        TagVO tag = tagsMap.get(tagId);
        // 返回
        return tag;
    }

    @Override
    public Map<Integer, TagVO> getCachedTagsMap() {
        return tagsMap;
    }

    @Override
    public Tag deleteTag(Integer id) {
        // 根据参数Id调用mapper.selectById()查询被删除的“日记”的信息
        Tag tag = tagMapper.selectById(id);
        // 判断查询结果是否为null
        if (tag == null) {
            // 是：该“评论”不存在，抛出NotFoundException异常
            throw new NotFoundException("删除标签失败！尝试访问的标签数据不存在！");
        }
        // 根据参数diaryId调用mapper.deleteById()执行删除，并获取返回的受影响行数
        int rows = tagMapper.deleteById(id);
        // 判断返回值是否不为1
        if (rows != 1) {
            // 是：抛出DeleteException
            throw new DeleteException("删除失败！请稍后再次尝试！");
        }
        // 返回查询结果
        return tag;
    }

    /**
     * 缓存的标签Map集合
     */
    private Map<Integer, TagVO> tagsMap = new ConcurrentHashMap<>();
}
