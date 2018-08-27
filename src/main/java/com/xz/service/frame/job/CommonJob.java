package com.xz.service.frame.job;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.springframework.stereotype.Component;

/**
 * XXLJOB
 */
@JobHandler(value="commonJob")
@Component
public class CommonJob extends IJobHandler {

    public ReturnT<String> execute(String param) throws Exception {
        System.out.println("run job"+System.currentTimeMillis());
        return null;
    }
}
