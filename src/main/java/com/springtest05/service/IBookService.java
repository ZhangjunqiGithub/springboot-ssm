package com.springtest05.service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.springtest05.domain.Book;

public interface IBookService extends IService<Book> {
    boolean saveBook(Book book);
    boolean modify(Book book);
    boolean delete(Integer id);

    IPage<Book> getPage(int currentPage, int pageSize);
    IPage<Book> getPage(int currentPage, int pageSize, Book book);
}
