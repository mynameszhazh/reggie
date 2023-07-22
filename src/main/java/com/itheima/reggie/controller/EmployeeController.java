package com.itheima.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.itheima.reggie.common.R;
import com.itheima.reggie.entity.Employee;
import com.itheima.reggie.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/login")
    public R<Employee> login(HttpServletRequest request, @RequestBody Employee emp) {
        // 1.将用户名md5加密
        String password = emp.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());

        // 2.查询数据库
        LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapper.eq(Employee::getUsername, emp.getUsername());
        Employee empI = employeeService.getOne(queryWrapper);

        // 不存在用户
        if(empI == null) {
            return R.error("登录失败");
        }

        if(!empI.getPassword().equals(password)) {
            return R.error("密码错误");
        }

        if(empI.getStatus() == 0) {
            return R.error("账号已经禁用");
        }

        request.getSession().setAttribute("employee", empI.getId());
        return R.success(empI);
    }
}
