package cn.xiaolimoon.blog.master.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

/**
 * @author Zcj
 */
@Data
public class MessageVO {
    private Integer id;
    private String userNickname;
    @NotBlank(message="必须填写评论内容！")
    private String content;
    private Integer parentCommentId;
    private LocalDateTime createTime;
}
