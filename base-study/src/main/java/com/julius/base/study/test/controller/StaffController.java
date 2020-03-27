package com.julius.base.study.test.controller;

import com.julius.base.common.test.entity.Staff;
import com.julius.base.common.test.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Package: com.julius.base.common.test.controller
 * @ClassName: StaffController
 * @Author: Julius
 * @Description: ${description}
 * @Date: 2020/1/14 10:43
 * @Version: 1.0
 */
@RestController
public class StaffController {

    @Autowired
    private StaffService staffService;


    @PostMapping(value = "/staff")
    public Staff add(@RequestBody Staff staff){
        return staffService.add(staff);
    }

    @PutMapping(value = "/staff")
    public Staff update(@RequestBody Staff staff){
        return staffService.update(staff);
    }

    @DeleteMapping(value = "/staff/id/{id}")
    public String delete(@PathVariable String id){
        return staffService.delete(id);
    }

    @GetMapping(value = "/staff/all")
    public List<Staff> findAll(){
        return staffService.findAll();
    }

    @GetMapping(value = "/staff/page")
    public List<Staff> findByPage(@RequestParam Integer currentPage,@RequestParam Integer pageSize){
        return staffService.findByPage(currentPage,pageSize);
    }

    /**
     * @Description 按照条件查询
     * @return
     */
    @GetMapping(value = "/staff/condition")
    public List<Staff> findAllByCondition(@RequestParam String name,@RequestParam Integer age,@RequestParam String departmentId){
        return staffService.findAllByCondition(name,age,departmentId);
    }

    @GetMapping(value = "/staff/count/condition")
    public long countByCondition(@RequestParam String name,@RequestParam Integer age,@RequestParam String departmentId){
        return staffService.countByCondition(name,age,departmentId);
    }

}
