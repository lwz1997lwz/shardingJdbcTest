package com.lwz.shardingJdbc.dao;

import com.lwz.shardingJdbc.entity.Student;
import org.apache.ibatis.annotations.Mapper;

/**
 * 学生dao层
 *
 * @author Linweizhe
 * @date 2021/2/2
 **/

@Mapper
public interface StudentDao {

    int addStudent(Student student);
}