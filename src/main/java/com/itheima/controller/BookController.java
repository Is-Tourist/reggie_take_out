package com.itheima.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

import com.itheima.controller.utils.R;
import com.itheima.controller.utils.R1;
import com.itheima.entity.Book;
import com.itheima.entity.Employee;

import com.itheima.service.EmployeeService;
import com.itheima.service.IBookService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private IBookService bookService;


    @GetMapping
    @ApiOperation(value = "得到所有图书信息")
    public R getAll(){
        return new R(true, bookService.list());
    }

    @PostMapping
    @ApiOperation("添加书籍到数据库")
    public R save(@ApiParam(value = "书籍信息",required = true) @RequestBody Book book) throws IOException {
//        R r = new R();
//        boolean flag = bookService.save(book);
//        r.setFlag(flag);
        if (book.getName().equals("123") ) throw new IOException();
        boolean flag = bookService.save(book);
        log.info("数据保存成功");
        return new R(flag, flag ? "添加成功^_^" : "添加失败-_-!");

    }
    @ApiOperation(value = "更新图书信息")
    @PutMapping
    public R update(@ApiParam (value = "详细信息",required = true)@RequestBody Book book) throws IOException {
        if (book.getName().equals("123") ) throw new IOException();
        boolean flag = bookService.modify(book);
        return new R(flag, flag ? "修改成功^_^" : "修改失败-_-!");
    }
    @ApiOperation(value = "根据id删除指定图书")
    @DeleteMapping("{id}")
    public R delete(@ApiParam (value = "图书id",required = true)  @PathVariable Integer id){
        return new R(bookService.delete(id));
    }

    @ApiOperation(value = "根据id获取指定书籍")
    @GetMapping("{id}")
    public R getById(@ApiParam (value = "图书id",required = true)   @PathVariable Integer id){
        return new R(true, bookService.getById(id));
    }

//    @GetMapping("{currentPage}/{pageSize}")
//    public R getPage(@PathVariable int currentPage,@PathVariable int pageSize){
//        IPage<Book> page = bookService.getPage(currentPage, pageSize);
//        //如果当前页码值大于了总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
//        if( currentPage > page.getPages()){
//            page = bookService.getPage((int)page.getPages(), pageSize);
//        }
//        return new R(true, page);
//    }
    @ApiOperation(value = "分页查询图书信息")
    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@ApiParam (value = "当前页",required = true)  @PathVariable int currentPage,@ApiParam (value = "每页显示几条",required = true)@PathVariable int pageSize,Book book){
//        System.out.println("参数==>"+book);

        IPage<Book> page = bookService.getPage(currentPage, pageSize,book);
        //如果当前页码值大于了总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if( currentPage > page.getPages()){
            page = bookService.getPage((int)page.getPages(), pageSize,book);
        }
        return new R(true, page);
    }


}

















