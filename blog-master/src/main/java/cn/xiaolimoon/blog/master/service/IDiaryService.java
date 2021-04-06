package cn.xiaolimoon.blog.master.service;

import cn.xiaolimoon.blog.master.model.Diary;
import cn.xiaolimoon.blog.master.model.Link;
import cn.xiaolimoon.blog.master.vo.DiaryVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wuqu
 * @since 2021-01-05
 */
public interface IDiaryService extends IService<Diary> {

    /**
     * 返回所有日记
     * @return 日记列表
     */
    List<DiaryVO> getList();

    /**
     * 写日记
     * @param diary 日记
     */
    void insertDiary(Diary diary);

    /**
     * 删除日记
     * @param id 日记id
     */
    Diary deleteDiary(Integer id);


}
