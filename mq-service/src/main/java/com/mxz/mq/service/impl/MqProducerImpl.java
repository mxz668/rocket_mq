package com.mxz.mq.service.impl;

import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.SendResult;
import com.aliyun.openservices.ons.api.bean.ProducerBean;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.shade.com.alibaba.fastjson.JSON;
import com.mxz.mq.service.MqProducer;
import com.mxz.mq.service.model.DataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by MABIAO on 2017/3/16 0016.
 */
@Service
public class MqProducerImpl implements MqProducer{

    @Autowired
    private ProducerBean producer;

    @Override
    public SendResult publishMsg(String msg) {
        DataModel model = new DataModel();
        model.setId("26");
        model.setName(msg);
        String jsonString = JSON.toJSONString(model);

        Message message = new Message("test_tianyu_demo","mq_test_tag",jsonString.getBytes());
        SendResult sendResult = producer.send(message);
        if (sendResult != null){
            System.out.println("Success");
        }
        return null;
    }
}
