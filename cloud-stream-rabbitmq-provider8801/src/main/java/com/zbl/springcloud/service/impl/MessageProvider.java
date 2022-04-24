package com.zbl.springcloud.service.impl;

import com.zbl.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author zbl
 * @version 1.0
 * @since 2022/4/24 17:16
 */
//定义消息推送管道
@EnableBinding(Source.class)
public class MessageProvider implements IMessageProvider {

    @Resource
    private MessageChannel output; //消息发送管道

    @Override
    public String send() {
        String str = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(str).build());
        System.out.println("发送的消息：" + str);
        return null;
    }
}
