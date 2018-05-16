package org.winne.bookstore.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.winne.base.util.UUIDUtil;
import org.winne.bookstore.dao.BookMapper;
import org.winne.bookstore.domain.Book;
import org.winne.bookstore.domain.BookCriteria;
import org.winne.bookstore.service.BookService;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private BookMapper mapper;

    @Override
    public List<Book> books() {
        logger.info("查询书籍");
        BookCriteria criteria = new BookCriteria();
        return mapper.selectByExample(criteria);
    }

    @Override
    @Cacheable(value = "book", key="'BOOK' + #p0")
    public Book book(String id) {
        logger.info("查询书籍，ID：{}", id);
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int insert(Book book) {
        if (StringUtils.isEmpty(book.getId())) {
            book.setId(UUIDUtil.uuid());
        }
        logger.info("书籍入库，ID：{}", book.getId());
        return mapper.insertSelective(book);
    }

    @Override
    @CachePut(value = "book", key="'BOOK' + #p0.id")
    public int update(Book book) {
        logger.info("更新书籍，ID：{}", book.getId());
        return mapper.updateByPrimaryKeySelective(book);
    }

    @Override
    @CacheEvict(value = "book", key="'BOOK' + #p0")
    public int delete(String id) {
        logger.info("删除书籍，ID：{}", id);
        return mapper.deleteByPrimaryKey(id);
    }
}
