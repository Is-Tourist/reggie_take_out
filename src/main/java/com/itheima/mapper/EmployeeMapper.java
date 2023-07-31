package com.itheima.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.entity.Employee;
import org.apache.ibatis.annotations.Mapper;
//@Mepper是mybatis提供的，注解是MyBatis框架提供的注解，
// 用于标识这个接口是一个Mapper接口，即数据访问对象接口。
// 通过这个注解，MyBatis可以扫描并自动创建该接口的实现类，
// 实现类中包含了与数据库交互的SQL语句。

//BaseMapper
//BaseMapper是MyBatis-Plus提供的一个通用Mapper接口，
// 提供了一些常用的数据库操作方法，如插入、更新、删除、查询等。
// 通过继承BaseMapper<Employee>，
// EmployeeMapper接口就可以直接使用这些通用的数据库操作方法，无需手动编写SQL语句。
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee>{
}
