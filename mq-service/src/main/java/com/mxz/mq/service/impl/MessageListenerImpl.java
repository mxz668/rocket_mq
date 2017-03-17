/**
 * Copyright (C) 2010-2016 Alibaba Group Holding Limited
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.mxz.mq.service.impl;

import com.aliyun.openservices.ons.api.Action;
import com.aliyun.openservices.ons.api.ConsumeContext;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.MessageListener;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.shade.com.alibaba.fastjson.JSON;
import com.mxz.mq.service.model.DataModel;

import java.util.Date;

/**
 * MQ消息处理类
 */
public class MessageListenerImpl implements MessageListener {
    @Override
    public Action consume(Message message, ConsumeContext consumeContext) {

        DataModel model = new DataModel();
        String mBody = new String(message.getBody());

        model = JSON.parseObject(mBody, DataModel.class);
        System.out.println(new Date() + " Receive message, Topic is:" +
                message.getTopic() + ", MsgId is:" + message.getMsgID() + ",MsgBody:" + new String(message.getBody()));
        //如果想测试消息重投的功能,可以将Action.CommitMessage 替换成Action.ReconsumeLater
        return Action.CommitMessage;
    }
}
