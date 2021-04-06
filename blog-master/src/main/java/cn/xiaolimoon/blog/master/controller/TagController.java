package cn.xiaolimoon.blog.master.controller;


import cn.xiaolimoon.blog.master.model.Link;
import cn.xiaolimoon.blog.master.model.Tag;
import cn.xiaolimoon.blog.master.service.ITagService;
import cn.xiaolimoon.blog.master.vo.R;
import cn.xiaolimoon.blog.master.vo.TagVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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
 * @since 2020-12-17
 */
@RestController
@RequestMapping("/api/v1/tags")
public class TagController {

    @Autowired
    private ITagService tagService;

    // http://localhost:8080/api/v1/tags/
    @GetMapping("")
    public R<List<TagVO>> getTags() {
        return R.ok(tagService.getTags());
    }

    // http://localhost:8080/api/v1/tags/create?name=Mysql
    @RequestMapping("/create")
    public R insertTag(Tag tag) {
        tagService.insertTag(tag);
        return R.ok();
    }

    // http://localhost:8080/api/v1/diary/31/delete
    @RequestMapping("/{tagId}/delete")
    public R<Link> delete(@PathVariable("tagId") Integer tagId) {
        Tag tag = tagService.deleteTag(tagId);
        return R.ok(tag);
    }

}
