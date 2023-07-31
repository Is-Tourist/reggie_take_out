package com.itheima.entity;
//lombok

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ApiModel("图书实体类")
public class Book {

    @ApiModelProperty("主键")
    private Integer id;
    @ApiModelProperty("类别")
    private String type;
    @ApiModelProperty("书名")
    private String name;
    @ApiModelProperty("描述")
    private String description;
}
