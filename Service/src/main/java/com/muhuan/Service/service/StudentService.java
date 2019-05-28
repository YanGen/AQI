package com.muhuan.Service.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.muhuan.Service.mapper.StudentMapper;
import com.muhuan.Service.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author young
 * @ClassName: StudentService
 * @Description: TODO()
 * @date 2019/3/3 23:25
 */
@Service
@CacheConfig(cacheNames="student")
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;

    public List<Student> getAll()
    {
        return studentMapper.findAll();
    }

    @Cacheable(key = "#p0")
    public Student get(Integer id)
    {
        return studentMapper.get(id);
    }
    @CacheEvict(allEntries=true)
    public void insert(Student student)
    {
        studentMapper.save(student);
    }

    @CachePut(key = "#p0.sid")
    public Student update(Student student)
    {
        studentMapper.update(student);
        return student;
    }

    @CacheEvict(allEntries=true)
    public void delete(Integer id)
    {
        studentMapper.delete(id);
    }

    @Cacheable(key = "#p0-#p1")
    public PageInfo<Student> getPage(int start, int size) {
        List<Student> studentList = studentMapper.findAll();
        PageHelper.startPage(start,size,"sid desc");
        PageInfo<Student> pageInfo = new PageInfo<>(studentList);
        return pageInfo;
    }
}
