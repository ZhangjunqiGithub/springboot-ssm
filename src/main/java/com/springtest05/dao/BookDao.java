package com.springtest05.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springtest05.domain.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookDao extends BaseMapper<Book> {

}
