package cn.xiaolimoon.blog.master.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2020-12-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("question_tag")
@Accessors(chain = true)
public class QuestionTag implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("question_id")
    private Integer questionId;

    @TableField("tag_id")
    private Integer tagId;


}
