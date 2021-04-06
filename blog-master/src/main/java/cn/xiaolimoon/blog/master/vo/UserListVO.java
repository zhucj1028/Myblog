package cn.xiaolimoon.blog.master.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Zcj
 */
@Data
public class UserListVO {

    private Integer id;
    private String nickname;
    private String phone;
    private Integer type;
    private LocalDateTime createTime;

}
