package com.itheima.uselessNow;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itheima.entity.Book;

import java.util.List;

public interface BookService {
    Boolean save(Book book);
    Boolean update(Book book);
    Boolean delete(Integer id);
    Book getById(Integer id);
    List<Book> getAll();
    IPage<Book> getPage(int currentPage,int pageSize);
}
