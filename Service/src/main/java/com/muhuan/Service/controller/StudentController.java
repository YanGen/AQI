package com.muhuan.Service.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.muhuan.Service.mapper.StudentMapper;
import com.muhuan.Service.pojo.Student;
import com.muhuan.Service.service.StudentService;
import com.muhuan.Service.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author young
 * @ClassName: StudentController
 * @Description: TODO()
 * @date 2019/3/3 11:27
 */
@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "*", maxAge = 3600)
public class StudentController {

    private Map<String ,Object> dataMap = new HashMap<>();

    @Autowired
    private StudentService studentService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("/allStudent")
    public Map<String, Object> allStudent(Model model) throws Exception{
        dataMap.put("success",true);
        List<Student> studentList = studentService.getAll();
        this.redisUtil.addKey("key1", studentList, 10, TimeUnit.SECONDS);
        dataMap.put("data",studentList);
        return dataMap;
    }

    @RequestMapping("/getStudentList")
    public Map<String, Object> getStudentList(Model model,@RequestParam(value = "start", defaultValue = "0") int start,@RequestParam(value = "size", defaultValue = "5") int size) throws Exception{
        dataMap.put("success",true);
        PageInfo<Student> pageInfo = studentService.getPage(start,size);
        dataMap.put("data",pageInfo);
        return dataMap;
    }

    @RequestMapping("/getStudentById")
    public Map<String, Object> getStudentById(Model model,@RequestParam(value = "id", defaultValue = "0") int id) throws Exception{
        dataMap.put("success",true);
        Student student = studentService.get(id);
        dataMap.put("data",student);
        return dataMap;
    }
}
