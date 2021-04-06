package cn.xiaolimoon.blog.master.vo;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Zcj
 */
@Data
public class QuestionVO {

    private Integer id;
    private String title;
    private String content;
    private Integer userId;
    private String userNickname;
    private Integer hits;
    private String image;
    private Integer commentCount;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private String tagIds;
    private List<TagVO> tags;


}
