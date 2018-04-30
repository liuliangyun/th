package com.curd.springbootdemo.dao;

import com.curd.entity.Employee;
import com.curd.springbootdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Liu
 */
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    /**
     *  通过年龄来查询
     *  方法名固定
     * @param age
     * @return
     */
    public List<Employee> findByAge(Integer age);
}