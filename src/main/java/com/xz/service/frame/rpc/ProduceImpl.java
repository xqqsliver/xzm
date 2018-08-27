package com.xz.service.frame.rpc;


import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;

public class ProduceImpl {
    public void outLogError(Boolean result,String message,Logger LOG){
        if(!result){
            if(StringUtils.isNotBlank(message)){
                LOG.error(message);
            }else{
                LOG.error("调用方法失败");
            }
        }
    }
}
