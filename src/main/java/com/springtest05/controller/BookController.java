package com.springtest05.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.springtest05.controller.utils.R;
import com.springtest05.domain.Book;
import com.springtest05.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private IBookService bookService;

    @GetMapping
    public R getAll() {
        return new R(true, bookService.list());
    }

    @PostMapping
    public R save(@RequestBody Book book) {
        return new R(bookService.save(book));
    }

    @PutMapping
    public R update(@RequestBody Book book) {
        return new R(bookService.modify(book));
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id) {
        return new R(bookService.delete(id));
    }

    @GetMapping("{id}")
    public R getById(@PathVariable Integer id) {
        return new R(true, bookService.getById(id));
    }

//    @GetMapping("{currentPage}/{pageSize}")
//    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize) {
//        IPage<Book> page = bookService.getPage(currentPage, pageSize);
//        //如果当前页码值大于了总页码数，就重新执行查询操作，使用最大页码值作为当前页码值
//        if(currentPage > page.getPages()) {
//            page = bookService.getPage(currentPage, pageSize);
//        }
//        return new R(true, page);
//    }

    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize, Book book) {
        IPage<Book> page = bookService.getPage(currentPage, pageSize, book);
        //如果当前页码值大于了总页码数，就重新执行查询操作，使用最大页码值作为当前页码值
        if(currentPage > page.getPages()) {
            page = bookService.getPage((int)page.getPages(), pageSize, book);
        }
        return new R(true, page);
    }
}
