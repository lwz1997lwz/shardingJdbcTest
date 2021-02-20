package com.lwz.shardingJdbc;

import com.lwz.shardingJdbc.dao.StudentDao;
import com.lwz.shardingJdbc.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Linweizhe
 * @date 2021/2/2
 **/
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/mrp/lwz/test", produces = {"application/json;charset=utf-8"})
public class TestController {

    @Autowired
    private StudentDao studentDao;


    /**
     * 测试接口
     *
     * @return 1
     * @throws Exception ex
     */
    @RequestMapping(value = "/add/student", method = RequestMethod.GET)
    public String test(Long startSno) throws Exception {

        Student student = new Student();
        student.setSname("lwz");
        student.setSno(startSno);
        student.setAge((byte) 1);
        studentDao.addStudent(student);
        return "1";
    }
}