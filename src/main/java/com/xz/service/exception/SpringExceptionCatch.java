package com.xz.service.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 处理捕获全局异常
 */
public class SpringExceptionCatch  extends AbstractHandlerExceptionResolver {
    private final static Logger rootLogger = LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);

    @Override
    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        try{
            //异常封装方法；
        }catch (Exception e){
            if (logger.isWarnEnabled()) {
                logger.warn("Handling of [" + ex.getClass().getName() + "] resulted in Exception", e);
            }

        }
        return null;
    }
}
