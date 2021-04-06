package cn.xiaolimoon.blog.master.mapper;

import cn.xiaolimoon.blog.master.model.Diary;
import cn.xiaolimoon.blog.master.vo.DiaryVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wuqu
 * @since 2021-01-05
 */
@Repository
public interface DiaryMapper extends BaseMapper<Diary> {

    /**
     * 查询日记
     * @return 返回日记列表
     */
    List<DiaryVO> findDiary();

}
