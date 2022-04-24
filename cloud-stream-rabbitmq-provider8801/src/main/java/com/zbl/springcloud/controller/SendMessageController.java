package com.zbl.springcloud.controller;

import com.zbl.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author zbl
 * @version 1.0
 * @since 2022/4/24 17:25
 */
@RestController
public class SendMessageController {

    @Resource
    private IMessageProvider messageProvider;

    @GetMapping("/send")
    public String send() {
        messageProvider.send();
        return "success" + UUID.randomUUID();
    }
}
