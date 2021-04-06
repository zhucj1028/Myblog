package cn.xiaolimoon.blog.master.service.ex;

/**
 * 用户名异常
 * @author Zcj
 */
public class UsernameDuplicationException extends ServiceException {
    public UsernameDuplicationException() {
    }

    public UsernameDuplicationException(String message) {
        super(message);
    }

    public UsernameDuplicationException(String message, Throwable cause) {
        super(message, cause);
    }

    public UsernameDuplicationException(Throwable cause) {
        super(cause);
    }

    public UsernameDuplicationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
