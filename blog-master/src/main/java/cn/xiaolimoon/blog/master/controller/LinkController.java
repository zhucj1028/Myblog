package cn.xiaolimoon.blog.master.controller;


import cn.xiaolimoon.blog.master.model.Diary;
import cn.xiaolimoon.blog.master.model.Link;
import cn.xiaolimoon.blog.master.service.ILinkService;
import cn.xiaolimoon.blog.master.vo.LinkVO;
import cn.xiaolimoon.blog.master.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @since 2021-01-03
 */
@RestController
@RequestMapping("/api/v1/links")
public class LinkController {

    @Autowired
    private ILinkService linkService;

    // http://localhost:8080/api/v1/links
    @GetMapping("")
    public R<List<LinkVO>> getLinks() {
        return R.ok(linkService.getLinks());
    }

    // http://localhost:8080/api/v1/links/create?name=Github&url=www.github.com
    @RequestMapping("/create")
    public R insertLink(Link link) {
        linkService.insertLink(link);
        return R.ok();
    }

    // http://localhost:8080/api/v1/diary/31/delete
    @RequestMapping("/{linkId}/delete")
    public R<Link> delete(@PathVariable("linkId") Integer linkId) {
        Link link = linkService.deleteLink(linkId);
        return R.ok(link);
    }

}
