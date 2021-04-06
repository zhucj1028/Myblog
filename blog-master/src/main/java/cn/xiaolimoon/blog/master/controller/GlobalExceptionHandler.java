package cn.xiaolimoon.blog.master.controller;

import cn.xiaolimoon.blog.master.service.ex.*;
import cn.xiaolimoon.blog.master.vo.R;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Zcj
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public R handleException(Throwable e) {
        if (e instanceof InviteCodeException) {
            return R.failure(R.State.ERR_INVITE_CODE, e);
        } else if (e instanceof UsernameDuplicationException) {
            return R.failure(R.State.ERR_USERNAME_DUPLICATE, e);
        } else if (e instanceof PhoneDuplicateException) {
            return R.failure(R.State.ERR_PHONE_DUPLICATE, e);
        } else if (e instanceof ParameterValidationException) {
            return R.failure(R.State.ERR_PARAMETER_VALIDATION, e);
        } else if (e instanceof FileEmptyException) {
            return R.failure(R.State.ERR_UPLOAD_EMPTY, e);
        } else if (e instanceof FileSizeException) {
            return R.failure(R.State.ERR_UPLOAD_FILE_SIZE, e);
        } else if (e instanceof FileTypeException) {
            return R.failure(R.State.ERR_UPLOAD_FILE_TYPE, e);
        } else if (e instanceof FileIOException) {
            return R.failure(R.State.ERR_UPLOAD_FILE_IO, e);
        } else if (e instanceof QuestionNotFoundException) {
            return R.failure(R.State.ERR_QUESTION_NOT_FOUND, e);
        } else if (e instanceof InsertException) {
            return R.failure(R.State.ERR_INSERT, e);
        } else if (e instanceof DeleteException) {
            return R.failure(R.State.ERR_DELETE, e);
        } else if (e instanceof NotFoundException) {
            return R.failure(R.State.ERR_NOT_FOUND, e);
        } else {
            return R.failure(R.State.ERR_UNKNOWN, e);
        }
    }
}

