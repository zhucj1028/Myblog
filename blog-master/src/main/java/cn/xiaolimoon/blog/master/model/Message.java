package cn.xiaolimoon.blog.master.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author wuqu
 * @since 2021-01-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("message")
@Accessors(chain = true)
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 留言ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 留言用户ID
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * 留言用户昵称
     */
    @TableField("user_nickname")
    private String userNickname;

    /**
     * 留言内容
     */
    @TableField("content")
    private String content;

    /**
     * 父留言ID
     */
    @TableField("parent_comment_id")
    private Integer parentCommentId;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @TableField("update_time")
    private LocalDateTime updateTime;


}
