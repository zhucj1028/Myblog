package cn.xiaolimoon.blog.master.service;

import cn.xiaolimoon.blog.master.model.Tag;
import cn.xiaolimoon.blog.master.vo.TagVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author wuqu
 * @since 2020-12-17
 */
public interface ITagService extends IService<Tag> {

    /**
     * 创建标签
     * @param tag 标签
     */
    void insertTag(Tag tag);

    /**
     * 获取标签列表
     * @return 标签列表
     */
    List<TagVO> getTags();

    /**
     * 获取缓存的标签列表
     * @return 缓存的标签列表
     */
    List<TagVO> getCachedTags();

    /**
     * 根据标签的id从缓存中获取标签对象
     *
     * @param tagId 标签的id
     * @return 标签对象
     */
    TagVO getTagVOById(Integer tagId);

    /**
     * 获取缓存的标签的Map集合
     *
     * @return 缓存的标签的Map集合
     */
    Map<Integer, TagVO> getCachedTagsMap();

    /**
     * 删除标签
     * @param id 标签数据id
     * @return 成功删除的数据
     */
    Tag deleteTag(Integer id);

}
