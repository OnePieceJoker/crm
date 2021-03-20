package com.joker.crm.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import com.joker.crm.entity.Book;
import com.joker.crm.entity.Chapter;
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
        assertEquals(result.size(), 1);
    }

    @Test
    public void testQueryChaptersByBookId() {
        List<Chapter> result = mapper.queryChaptersByBookId(1);
        System.out.println(result.toString());
        assertEquals(result.size(), 2);
    }

    @Test
    public void testQueryBookInfoByBookId() {
        Book result = mapper.queryBookInfoByBookId(1);
        System.out.println(result.toString());
        assertEquals(result.getId(), 1);
    }

    @Test
    public void testUpdateAudioUrlByChapterId() {
        mapper.updateAudioUrlByChapterId(1, "http://demo.url");
        assertTrue( true );
    }
}
