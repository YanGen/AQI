package com.muhuan.Service.mapper;

import com.muhuan.Service.pojo.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author young
 * @ClassName: StudentMapper
 * @Description: TODO()
 * @date 2019/3/2 14:53
 */
@Mapper
public interface StudentMapper {
    @Select("select * from school_student ")
    List<Student> findAll();

    @Insert("insert into school_student ( name ) values (#{name}) ")
    public int save(Student student);

    @Delete("delete from school_student where sid= #{id} ")
    public void delete(int id);

    @Select("select * from school_student where sid= #{id} ")
    public Student get(int id);

    @Update("update school_student set name=#{name} where sid=#{id} ")
    public int update(Student student);
}
