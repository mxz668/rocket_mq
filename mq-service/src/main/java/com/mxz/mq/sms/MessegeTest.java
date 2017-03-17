package com.mxz.mq.sms;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.aliyuncs.sms.model.v20160927.SingleSendSmsRequest;
import com.aliyuncs.sms.model.v20160927.SingleSendSmsResponse;

/**
 * Created by MABIAO on 2017/3/17 0017.
 */
public class MessegeTest {

    private static final String regionId = "cn-hangzhou";
    private static final String accessKeyId = "LTAIHCgkz0SQn4c9";
    private static final String keySecret = "G8I2BpLp9iC5Wx0J6nlmrvkjacqAKt";
    private static final String endpointName = "cn-hangzhou";

    public static void main(String args[]) {
        try {
            IClientProfile profile = DefaultProfile.getProfile(regionId, accessKeyId, keySecret);
            DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", "Sms", "sms.aliyuncs.com");
            IAcsClient client = new DefaultAcsClient(profile);
            SingleSendSmsRequest request = new SingleSendSmsRequest();
            request.setSignName("抛物线");//控制台创建的签名名称
            request.setTemplateCode("SMS_53830360");//控制台创建的模板CODE
            request.setParamString("{\"name\":\"\"}");//短信模板中的变量；数字需要转换为字符串；个人用户每个变量长度必须小于15个字符。"
            //request.setParamString("{}");
            request.setRecNum("13228073350");//接收号码

            SingleSendSmsResponse httpResponse = client.getAcsResponse(request);
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
}
