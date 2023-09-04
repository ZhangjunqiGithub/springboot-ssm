package com.springtest05.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.springtest05.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceTestCase {

    @Autowired
    private BookService bookService;

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
        bookService.getAll();
    }

    @Test
    void testGetPage() {
        IPage<Book> page = bookService.getPage(2, 5);
        System.out.println("Current：" + page.getCurrent());
        System.out.println("Size：" + page.getSize());
        System.out.println("Total：" + page.getTotal());
        System.out.println("Pages：" + page.getPages());
        System.out.println("Records：" + page.getRecords());
    }
}
