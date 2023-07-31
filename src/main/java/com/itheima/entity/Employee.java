package com.itheima.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 员工实体
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ApiModel("员工实体类=用户")
public class Employee implements Serializable{

    private static final long serialVersionUID = 1L;
    @ApiModelProperty("用户id")
    private Long id;
    @ApiModelProperty("用户名")
    private String username;
    @ApiModelProperty("姓名")
    private String name;
    @ApiModelProperty("密码")
    private String password;
    @ApiModelProperty("联系电话")
    private String phone;
    @ApiModelProperty("性别")
    private String sex;
    @ApiModelProperty("身份证号")
    private String idNumber;//身份证号码
    @ApiModelProperty("状态")
    private Integer status;

    //@TableField是mybatis plus 中的注解，  用于指定数据库表字段的填充策略。有如下用的几种
    @TableField(fill = FieldFill.INSERT) //插入时填充字段
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE) //插入和更新时填充字段
    private LocalDateTime updateTime;

    @TableField(fill = FieldFill.INSERT) //插入时填充字段
    private Long createUser;

    @TableField(fill = FieldFill.INSERT_UPDATE) //插入和更新时填充字段
    private Long updateUser;

}
