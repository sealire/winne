package org.winne.bookstore.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.winne.bookstore.domain.Book;
import org.winne.bookstore.domain.BookCriteria;

public interface BookMapper {
    long countByExample(BookCriteria example);

    int deleteByExample(BookCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(Book record);

    int insertSelective(Book record);

    List<Book> selectByExample(BookCriteria example);

    Book selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Book record, @Param("example") BookCriteria example);

    int updateByExample(@Param("record") Book record, @Param("example") BookCriteria example);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);
}