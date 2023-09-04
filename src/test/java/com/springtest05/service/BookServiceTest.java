package com.springtest05.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springtest05.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceTest {

    @Autowired
    private IBookService bookService;

    @Test
    void testGetBYId() {
        System.out.println(bookService.getById(4));;
    }

    @Test
    void testSave() {
        Book book = new Book();
        book.setType("测试数据123");
        book.setName("测试数据123");
        book.setDescription("测试数据123");
        bookService.save(book);
    }

    @Test
    void testUpdate() {

    }

    @Test
    void testDelete() {

    }

    @Test
    void testGetAll() {
        bookService.list();
    }

    @Test
    void testGetPage() {
        IPage<Book> page = new Page<Book>(2, 5);
        bookService.page(page);
        System.out.println("Current：" + page.getCurrent());
        System.out.println("Size：" + page.getSize());
        System.out.println("Total：" + page.getTotal());
        System.out.println("Pages：" + page.getPages());
        System.out.println("Records：" + page.getRecords());
    }
}
