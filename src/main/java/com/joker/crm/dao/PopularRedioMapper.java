package com.joker.crm.dao;

import java.util.List;

import com.joker.crm.entity.Book;
import com.joker.crm.entity.Chapter;
import com.joker.crm.vo.PopularRedio;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface PopularRedioMapper {
    
    @Select("select * from books")
    List<PopularRedio> queryPopularRedioList();

    @Select("select id as chapterId, name, audio_url as audioUrl from chapters where id in (select chapter_id from book_chapter_relation where book_id = #{id} order by orderNumber)")
    List<Chapter> queryChaptersByBookId(@Param("id") Integer id);

    @Select("select * from books where id = #{id}")
    Book queryBookInfoByBookId(@Param("id") Integer id);

    @Update("update chapters set audio_url = #{audioUrl} where id = #{id}")
    void updateAudioUrlByChapterId(@Param("id") Integer id, @Param("audioUrl") String audioUrl);

    @Select("select * from books where name like CONCAT('%', #{name})")
    List<PopularRedio> queryBooksByBookName(@Param("name") String bookName);

    @Select("select * from books where author like CONCAT('%', #{author})")
    List<PopularRedio> queryBooksByAuthor(@Param("author") String author);


    @Select("select * from books where author like CONCAT('%', #{condition}) or name like CONCAT('%', #{condition})")
    List<PopularRedio> queryBooksByAuthorOrBookName(@Param("condition") String condition);
}
