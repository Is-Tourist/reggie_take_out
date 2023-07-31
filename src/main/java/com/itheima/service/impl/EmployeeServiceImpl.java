package com.itheima.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.entity.Employee;
import com.itheima.mapper.EmployeeMapper;
import com.itheima.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
//ServiceImpl是MyBatis-Plus框架提供的一个通用服务实现类，
// 用于实现常用的服务层操作方法。通过继承ServiceImpl<EmployeeMapper, Employee>，EmployeeServiceImpl
// 类就可以直接使用这些通用的服务层操作方法，无需手动实现。
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper,Employee> implements EmployeeService {


}
