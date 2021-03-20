package com.joker.crm.service.impl;

import java.util.List;

import com.joker.crm.dao.PopularRedioMapper;
import com.joker.crm.entity.Book;
import com.joker.crm.entity.Chapter;
import com.joker.crm.service.RedioStationService;
import com.joker.crm.vo.PopularRedio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedioStationServiceImpl implements RedioStationService {

    @Autowired
    private PopularRedioMapper mapper;

    @Override
    public List<PopularRedio> queryPopularRedioList() {
        return mapper.queryPopularRedioList();
    }

    @Override
    public Book queryBookInfoByBookId(Integer id) throws IllegalArgumentException {
        Book book = mapper.queryBookInfoByBookId(id);
        if (book == null) {
            throw new IllegalArgumentException("未找到该本书");
        }
        List<Chapter> chapters = mapper.queryChaptersByBookId(id);
        book.setChapters(chapters);
        return book;
    }

    @Override
    public void updateAudioUrlByChapterId(Integer id, String url) {
        mapper.updateAudioUrlByChapterId(id, url);
    }

    @Override
    public List<PopularRedio> queryBooksByBookName(String bookName) {
        return mapper.queryBooksByBookName(bookName);
    }

    @Override
    public List<PopularRedio> queryBooksByAuthor(String author) {
        return mapper.queryBooksByAuthor(author);
    }

    @Override
    public List<PopularRedio> queryBooksByAuthorOrBookName(String condition) {
        return mapper.queryBooksByAuthorOrBookName(condition);
    }
    
}
