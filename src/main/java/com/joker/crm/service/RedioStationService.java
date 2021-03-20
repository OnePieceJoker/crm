package com.joker.crm.service;

import java.util.List;

import com.joker.crm.entity.Book;
import com.joker.crm.vo.PopularRedio;

public interface RedioStationService {
    
    List<PopularRedio> queryPopularRedioList();
    
    Book queryBookInfoByBookId(Integer id) throws IllegalArgumentException;

    void updateAudioUrlByChapterId(Integer id, String url);

    List<PopularRedio> queryBooksByBookName(String bookName);

    List<PopularRedio> queryBooksByAuthor(String author);

    List<PopularRedio> queryBooksByAuthorOrBookName(String condition);
}
