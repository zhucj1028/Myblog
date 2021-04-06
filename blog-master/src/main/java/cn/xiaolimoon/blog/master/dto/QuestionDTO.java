package cn.xiaolimoon.blog.master.dto;

import lombok.Data;

/**
 * @author Zcj
 */
@Data
public class QuestionDTO {

    private String title;
    private Integer[] tagIds;
    private String content;
}
