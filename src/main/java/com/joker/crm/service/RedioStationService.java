package com.joker.crm.service;

import java.util.List;

import com.joker.crm.entity.Book;
import com.joker.crm.vo.PopularRedio;

public interface RedioStationService {
    
    List<PopularRedio> queryPopularRedioList();
    
    Book queryBookInfoByBookId(Integer id);
}
