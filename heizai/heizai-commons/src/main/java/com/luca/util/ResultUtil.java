
package com.luca.util;


import com.luca.pojo.enums.ResponseStatus;
import com.luca.pojo.vo.ResponseVO;

public class ResultUtil<T> {

    public static ResponseVO error(int code, String message) {
        return vo(code, message, null);
    }

    public static ResponseVO error() {
        return vo(ResponseStatus.FAIL.getCode(),ResponseStatus.FAIL.getMessage(), null);
    }


    public static<T> ResponseVO success(T date) {
        return vo(ResponseStatus.SUCCESS.getCode(), ResponseStatus.SUCCESS.getMessage(), date);
    }

    public static ResponseVO vo(int code, String message, Object data) {
        return new ResponseVO<>(code, message, data);
    }


}
