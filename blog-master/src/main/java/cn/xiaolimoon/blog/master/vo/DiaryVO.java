package cn.xiaolimoon.blog.master.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Zcj
 */
@Data
public class DiaryVO {
    private Integer id;
    private String content;
    private LocalDateTime createTime;
}
