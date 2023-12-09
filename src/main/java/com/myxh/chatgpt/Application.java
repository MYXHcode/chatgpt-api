package com.myxh.chatgpt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MYXH
 * @date 2023/12/8
 * @description 启动入口
 * @GitHub <a href="https://github.com/MYXHcode">MYXHcode</a>
 */
@RestController
@SpringBootApplication
public class Application
{
    private final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args)
    {
        SpringApplication.run(Application.class, args);
    }

    @GetMapping("/verify")
    public ResponseEntity<String> verify(String token)
    {
        logger.info("验证 token：{}", token);

        if ("success".equals(token))
        {
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        else
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/success")
    public String success()
    {
        return "test success by MYXH";
    }
}
