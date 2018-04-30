package com.curd.springbootdemo.service;

import com.curd.springbootdemo.dao.EmployeeRepository;
import com.curd.springbootdemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
/**
 * Created by Liu
 */
@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * 事务管理测试
     * 两条数据同时成功，或者同时不成功
     * 保证数据库数据的完整性和一致性
     */
    @Transactional
    public void insertTwo(){
        Employee employeeA = new Employee();
        employeeA.setId(10);
        employeeA.setName("秋雅");
        employeeA.setAge(19);
        employeeA.setGender("女");
        employeeRepository.save(employeeA);

        System.out.print(1/0);

        Employee employeeB = new Employee();
        employeeB.setId(11);
        employeeB.setName("梦特娇");
        employeeB.setAge(25);
        employeeB.setGender("女");
        employeeRepository.save(employeeB);
    }
}
