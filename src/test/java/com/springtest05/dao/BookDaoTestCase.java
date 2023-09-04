package com.springtest05.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springtest05.dao.BookDao;
import com.springtest05.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookDaoTestCase {

    @Autowired
    private BookDao bookDao;

    @Test
    void testGetById() {
        System.out.println(bookDao.selectById(1));
    }

    @Test
    void testSave() {
        Book book = new Book();
        book.setType("测试数据123");
        book.setName("测试数据123");
        book.setDescription("测试数据123");
        bookDao.insert(book);
    }

    @Test
    void testUpdate() {

    }

    @Test
    void testDelete() {

    }

    @Test
    void testGetAll() {
        bookDao.selectList(null);
    }

    @Test
    void testGetPage() {
        IPage page = new Page(1,5);
        bookDao.selectPage(page,null);
        System.out.println(page.getRecords());
    }

    @Test
    void testGetPage2() {
        //按条件查询
        QueryWrapper<Book> qw = new QueryWrapper<>();
        //设置条件
        qw.like("name","Spring");
        IPage page = new Page(1,3);
        bookDao.selectPage(page, qw);
    }

    @Test
    void testGetBy() {
        //按条件查询
        QueryWrapper<Book> qw = new QueryWrapper<>();
        //设置条件
        qw.like("name","Spring");
        bookDao.selectList(qw);
    }

    //更常用
    @Test
    void testGetBy2() {
        String name = "Spring";
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
        lqw.like(name != null, Book::getName, name);
        bookDao.selectList(lqw);
    }
}
