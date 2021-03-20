package com.joker.crm.common.config;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.Serializable;

import com.joker.crm.entity.User;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class RedisTemplateTest {

    @Autowired
    private RedisTemplate<String, String> strRedisTemplate;

    @Autowired
    private RedisTemplate<String, Serializable> serializableRedisTemplate;

    @Test
    public void testString() {
        strRedisTemplate.opsForValue().set("strKey", "joker");
        assertEquals("joker", strRedisTemplate.opsForValue().get("strKey"));
    }

    @Test
    public void testSerializable() {
        User user = new User();
        user.setId(1L);
        user.setUserName("mr.joker");
        user.setUserSex("男");
        serializableRedisTemplate.opsForValue().set("user", user);
        User user2 = (User) serializableRedisTemplate.opsForValue().get("user");
        assertEquals(user.getUserSex(), user2.getUserSex());
    }
    
}
