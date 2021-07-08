package com.espazo.wiki.mapper;

import com.espazo.wiki.domain.Category;
import com.espazo.wiki.domain.CategoryExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CategoryMapper {
    long countByExample(CategoryExample example);

    int deleteByExample(CategoryExample example);

    int insert(Category record);

    int insertSelective(Category record);

    List<Category> selectByExample(CategoryExample example);

    int updateByExampleSelective(@Param("record") Category record, @Param("example") CategoryExample example);

    int updateByExample(@Param("record") Category record, @Param("example") CategoryExample example);
}