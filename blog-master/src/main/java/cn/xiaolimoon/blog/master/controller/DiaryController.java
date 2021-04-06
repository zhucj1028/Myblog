package cn.xiaolimoon.blog.master.controller;


import cn.xiaolimoon.blog.master.mapper.DiaryMapper;
import cn.xiaolimoon.blog.master.model.Diary;
import cn.xiaolimoon.blog.master.security.UserInfo;
import cn.xiaolimoon.blog.master.service.IDiaryService;
import cn.xiaolimoon.blog.master.vo.DiaryVO;
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
 * @since 2021-01-05
 */
@RestController
@RequestMapping("/api/v1/diary")
public class DiaryController {
    @Autowired
    private IDiaryService diaryService;

    // http://localhost:8080/api/v1/diarys/
    @GetMapping("")
    public R<List<DiaryVO>> getDiary() {
        return R.ok(diaryService.getList());
    }

    // http://localhost:8080/api/v1/diary/create?userid=9&content=今天你学习了嘛
    @RequestMapping("/create")
    public R insertDiary(Diary diary) {
        diaryService.insertDiary(diary);
        return R.ok();
    }

    // http://localhost:8080/api/v1/diary/31/delete
    @RequestMapping("/{diaryId}/delete")
    public R<Diary> delete(@PathVariable("diaryId") Integer diaryId) {
        Diary diary = diaryService.deleteDiary(diaryId);
        return R.ok(diary);
    }
}
