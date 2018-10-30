package com.lgs.AOP;

import com.lgs.beans.ResultBean;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ControllerAop {
    private static final Logger logger = LoggerFactory.getLogger(ControllerAop.class);

    public Object handlerControllerMethod(ProceedingJoinPoint point) {
        long startTime = System.currentTimeMillis();

        ResultBean<?> resultBean;

        try {
            resultBean = (ResultBean)point.proceed();
            logger.info(point.getSignature() + "user time " + (System.currentTimeMillis()-startTime));
        } catch (Throwable e) {
            resultBean = this.handlerException(point, e);
        }
        return resultBean;
    }

    private ResultBean<?> handlerException(ProceedingJoinPoint point, Throwable e) {
        ResultBean<?> resultBean = new ResultBean<>();

        logger.error(point.getSignature() + "error: " + e);
        resultBean.setMsg(e.toString());
        resultBean.setCode(ResultBean.FAIL);

        return resultBean;
    }
}
