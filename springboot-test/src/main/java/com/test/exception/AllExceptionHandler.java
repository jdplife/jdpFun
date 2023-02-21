package com.test.exception;

import com.test.util.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ClassName AllExceptionHandler
 * @Description 全局异常处理
 * @Author jdp
 * @Date 15:11 2023/2/21
 * @Version 1.0
 **/
@Slf4j
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class AllExceptionHandler {
    /**
     * 处理自定义异常
     *
     * @param exception 错误信息集合
     * @return com.nj.zking.common.core.util.R<java.lang.String>
     * @author 马达
     * @date 2021/3/19 15:08
     */
    @ExceptionHandler(BusinessException.class)
    public R<String> handleBusinessException(BusinessException exception){
        return R.failed(exception.getMsg());
    }
}
