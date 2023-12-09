package com.myxh.chatgpt.test;

import com.myxh.chatgpt.domain.security.service.JwtUtil;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author MYXH
 * @date 2023/12/8
 * @description 单元测试
 * @GitHub <a href="https://github.com/MYXHcode">MYXHcode</a>
 */
public class ApiTest
{
    @Test
    public void testJwt()
    {
        JwtUtil util = new JwtUtil("MYXH", SignatureAlgorithm.HS256);

        // 以 MYXH 作为秘钥，以 HS256 加密
        Map<String, Object> map = new HashMap<>();
        map.put("username", "MYXH");
        map.put("password", "520.ILY!");
        map.put("age", 21);

        String jwtToken = util.encode("MYXH", 30000, map);

        util.decode(jwtToken).forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
