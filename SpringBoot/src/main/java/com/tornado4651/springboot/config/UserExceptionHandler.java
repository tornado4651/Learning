package com.tornado4651.springboot.config;

import com.tornado4651.springboot.exception.LoginException;
import com.tornado4651.springboot.vo.ResultInfo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class UserExceptionHandler {
    /**
     * 处理指定异常
     *
     * @param loginException
     * @return
     */
    @ExceptionHandler(value = LoginException.class)
    public ResultInfo loginException(LoginException loginException) {
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setCode(loginException.getCode());
        resultInfo.setMsg(loginException.getMsg());
        return resultInfo;
    }

    /**
     * 处理其他所有异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public ResultInfo totalException(Exception e) {
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setMsg(e.getMessage());
        return resultInfo;
    }
}
