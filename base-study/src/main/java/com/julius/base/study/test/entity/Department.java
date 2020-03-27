package com.julius.base.study.test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @Package: com.julius.base.common.test.entity
 * @ClassName: Department
 * @Author: Julius
 * @Description: 部门表
 * @Date: 2020/1/14 9:35
 * @Version: 1.0
 */
//@Entity(name = "department")
public class Department {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
