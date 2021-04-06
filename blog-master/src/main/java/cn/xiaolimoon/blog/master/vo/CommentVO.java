package cn.xiaolimoon.blog.master.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * @author Zcj
 */
@Data
@Accessors(chain = true)
public class CommentVO {
    private Integer id;
    private String content;
    private Integer userId;
    private String userNickname;
    private Integer articleId;
    private LocalDateTime createTime;

}
