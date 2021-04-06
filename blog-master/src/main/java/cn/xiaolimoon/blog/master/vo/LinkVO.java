package cn.xiaolimoon.blog.master.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Zcj
 */
@Data
public class LinkVO {

    private Integer id;
    private String url;
    private String name;
    private String description;
    // private LocalDateTime createTime;

}
