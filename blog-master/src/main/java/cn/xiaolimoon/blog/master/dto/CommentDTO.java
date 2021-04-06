package cn.xiaolimoon.blog.master.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Zcj
 */
@Data
@Accessors(chain = true)
public class CommentDTO {

    @NotNull(message="问题id不允许为空！")
    private Integer articleId;
    @NotBlank(message="必须填写回复的内容！")
    private String content;
}
