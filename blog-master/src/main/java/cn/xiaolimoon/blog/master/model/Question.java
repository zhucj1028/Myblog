package cn.xiaolimoon.blog.master.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author wuqu
 * @since 2020-12-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("question")
@Accessors(chain = true)
public class Question implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 博文ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 发表用户ID
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * 作者名称
     */
    @TableField("user_nickname")
    private String userNickname;

    /**
     * 博文标题
     */
    @TableField("title")
    private String title;

    /**
     * 博文内容
     */
    @TableField("content")
    private String content;

    /**
     * 浏览量
     */
    @TableField("hits")
    private Integer hits;

    /**
     * 评论总数
     */
    @TableField("comment_count")
    private Integer commentCount;

    /**
     * 文章封面图
     */
    @TableField("image")
    private String image;

    /**
     * 标签
     */
    @TableField("tag_ids")
    private String tagIds;

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
