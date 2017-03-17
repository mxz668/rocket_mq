package com.mxz.mq.service;

import com.aliyun.openservices.ons.api.SendResult;

/**
 * Created by MABIAO on 2017/3/16 0016.
 */
public interface MqProducer {

    public SendResult publishMsg(String msg);
}
