package org.winne.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.winne.base.ResponseStatus;
import org.winne.base.RestResponse;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: leesia
 * @Date: 2018/5/5 13:42
 * @Description: 全局异常处理
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 全局异常处理
     *
     * @param request
     * @param exception
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public RestResponse<Object> exceptionHandler(HttpServletRequest request, Exception exception) {
        logger.error("捕获异常：" + exception);

        RestResponse<Object> result = new RestResponse<>();
        result.setStatus(ResponseStatus.EXCEPTION);
        Map<String, Object> msg = new HashMap<>();
        msg.put("exception", exception.getMessage());
        result.setMsg(msg);
        return result;
    }
}
