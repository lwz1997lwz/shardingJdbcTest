package com.lwz.shardingJdbc.entity;

/**
 * 学生实体
 *
 * @author Linweizhe
 * @date 2021/2/2
 **/
public class Student {
    private Long id;
    private String sname;
    private Long sno;
    private Byte age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Long getSno() {
        return sno;
    }

    public void setSno(Long sno) {
        this.sno = sno;
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }
}