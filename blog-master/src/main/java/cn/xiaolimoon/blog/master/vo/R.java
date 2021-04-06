package cn.xiaolimoon.blog.master.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author Zcj
 */
@Data
@Accessors(chain = true)
public class R<T> {
    private Integer state;
    private String message;
    private T data;

    public static R ok() {
        return new R().setState(State.OK);
    }

    public static <T> R ok(T data) {
        return new R<T>().setState(State.OK).setData(data);
    }

    public static R failure(Integer state, String message) {
        return new R().setState(state).setMessage(message);
    }

    public static R failure(Integer state, Throwable e) {
        return failure(state, e.getMessage());
    }

    public static interface State {
        int OK = 2000;
        int ERR_INVITE_CODE = 4001;
        int ERR_USERNAME_DUPLICATE = 4002;
        int ERR_PHONE_DUPLICATE = 4003;
        int ERR_INSERT = 4004;
        int ERR_QUESTION_NOT_FOUND = 4005;
        int ERR_PARAMETER_VALIDATION = 4006;
        int ERR_UPLOAD_EMPTY = 4007;
        int ERR_UPLOAD_FILE_SIZE = 4008;
        int ERR_UPLOAD_FILE_TYPE = 4009;
        int ERR_UPLOAD_FILE_IO = 4010;
        int ERR_DELETE = 4011;
        int ERR_NOT_FOUND = 4012;
        int ERR_UNKNOWN = 9999;
    }
}
