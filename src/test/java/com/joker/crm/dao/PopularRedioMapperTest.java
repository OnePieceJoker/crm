package com.joker.crm.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import com.joker.crm.vo.PopularRedio;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PopularRedioMapperTest {
    
    @Autowired
    private PopularRedioMapper mapper;

    @Test
    public void testQueryPopularRedioList() {
        List<PopularRedio> result = mapper.queryPopularRedioList();
        assertEquals(result, null);
    }
}
