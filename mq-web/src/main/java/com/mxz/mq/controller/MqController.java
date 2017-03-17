package com.mxz.mq.controller;

import com.mxz.mq.service.MqProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by MABIAO on 2017/3/16 0016.
 */

@RestController
@RequestMapping(value = "/mqService")
public class MqController {

    @Autowired
    private MqProducer mqProducer;

    @RequestMapping(value = "testController",method = RequestMethod.POST)
    public void testController(){
        System.out.println("123");
    }

    @RequestMapping(value = "publishMsg",method = RequestMethod.POST)
    public void publishMsg(@RequestBody String messege){
        mqProducer.publishMsg(messege);
    }
}
