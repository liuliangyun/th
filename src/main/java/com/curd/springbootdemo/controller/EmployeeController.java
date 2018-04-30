package com.curd.springbootdemo.controller;

import com.curd.springbootdemo.dao.EmployeeRepository;
import com.curd.springbootdemo.entity.Employee;
import com.curd.springbootdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Created by Liu
 */
@RestController
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    EmployeeService employeeService;

    /**
     * 查询所有人员列表
     *
     * @return
     */
    @GetMapping(value = "/employees")
    private List<Employee> employeeList() {
        return employeeRepository.findAll();
    }

    /**
     * 添加一个人员
     *
     * @param id
     * @param name
     * @param age
     * @param gender
     * @return
     */
    @PostMapping(value = "/addEmployee")
    public Employee employeeAdd(@RequestParam("id") Integer id,
                                @RequestParam("name") String name,
                                @RequestParam("age") Integer age,
                                @RequestParam("gender") String gender) {
        Employee employee = new Employee();
        employee.setId(id);
        employee.setName(name);
        employee.setAge(age);
        employee.setGender(gender);

        return employeeRepository.save(employee);
    }

    /**
     * 查询一个人员
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/findEmployeeById/{id}")
    public Optional<Employee> employeeFindOne(@PathVariable("id") Integer id) {
        return employeeRepository.findById(id);
    }

    /**
     * 删除一个人员
     *
     * @param id
     */
    @DeleteMapping(value = "/deleteEmployeeById/{id}")
    public void employeeDelete(@PathVariable("id") Integer id) {
        employeeRepository.deleteById(id);
    }

    /**
     * 更新一个人员
     *
     * @param id
     * @param name
     * @param age
     * @param gender
     * @return
     */
    @PutMapping(value = "/updateEmployeeById/{id}")
    public Employee employeeUpdate(@PathVariable("id") Integer id,
                                   @RequestParam("name") String name,
                                   @RequestParam("age") Integer age,
                                   @RequestParam("gender") String gender) {
        Employee employee = new Employee();
        employee.setId(id);
        employee.setName(name);
        employee.setAge(age);
        employee.setGender(gender);
        return employeeRepository.save(employee);
    }

    /**
     * 通过年龄来查询
     * @param age
     * @return
     */
    @GetMapping(value = "/employees/age/{age}")
    public List<Employee> employeeListByAge(@PathVariable("age") Integer age) {
        return employeeRepository.findByAge(age);
    }

    /**
     * 事务测试
     */
    @PostMapping("/employee/two")
    public void employeeTwo(){
        employeeService.insertTwo();
    }
}
