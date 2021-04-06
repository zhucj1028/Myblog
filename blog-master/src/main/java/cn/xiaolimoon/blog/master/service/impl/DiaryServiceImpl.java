package cn.xiaolimoon.blog.master.service.impl;

import cn.xiaolimoon.blog.master.model.Diary;
import cn.xiaolimoon.blog.master.mapper.DiaryMapper;
import cn.xiaolimoon.blog.master.service.IDiaryService;
import cn.xiaolimoon.blog.master.service.ex.DeleteException;
import cn.xiaolimoon.blog.master.service.ex.InsertException;
import cn.xiaolimoon.blog.master.service.ex.NotFoundException;
import cn.xiaolimoon.blog.master.vo.DiaryVO;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wuqu
 * @since 2021-01-05
 */
@Service
public class DiaryServiceImpl extends ServiceImpl<DiaryMapper, Diary> implements IDiaryService {

    @Autowired
    private DiaryMapper diaryMapper;

    @Override
    public List<DiaryVO> getList() {
        List<DiaryVO> diaryList = diaryMapper.findDiary();
        return diaryList;
    }

    @Override
    public void insertDiary(Diary diary) {
        diary.setCreateTime(LocalDateTime.now());
        int result = diaryMapper.insert(diary);
        if (result != 1) {
            throw new InsertException("发布失败！服务器忙，请稍后再次尝试！");
        }
    }

    @Override
    public Diary deleteDiary(Integer id) {
        // 根据参数Id调用mapper.selectById()查询被删除的“日记”的信息
        Diary diary = diaryMapper.selectById(id);
        // 判断查询结果是否为null
        if (diary == null) {
            // 是：该“评论”不存在，抛出NotFoundException异常
            throw new NotFoundException("删除日记失败！尝试访问的日记数据不存在！");
        }
        // 根据参数diaryId调用mapper.deleteById()执行删除，并获取返回的受影响行数
        int rows = diaryMapper.deleteById(id);
        // 判断返回值是否不为1
        if (rows != 1) {
            // 是：抛出DeleteException
            throw new DeleteException("删除失败！请稍后再次尝试！");
        }
        // 返回查询结果
        return diary;
    }
}
