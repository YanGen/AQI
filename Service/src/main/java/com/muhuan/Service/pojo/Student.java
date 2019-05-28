package com.muhuan.Service.pojo;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * @author young
 * @ClassName: Student
 * @Description: TODO()
 * @date 2019/3/2 14:54
 */

@Table(name = "school_student")
public class Student implements Serializable {
    @Column(name = "sid" ,type = MySqlTypeConstant.VARCHAR , length = 24,isKey = true)
    @Id
    private Integer sid;
    @Column(name = "grade", type = MySqlTypeConstant.VARCHAR , length = 24, isNull = false)
    private String grade;
    @Column(name = "name",type = MySqlTypeConstant.VARCHAR)
    private String name;
    @Column(name = "password",type = MySqlTypeConstant.VARCHAR)
    private String password;
    @Column(name = "sex",type = MySqlTypeConstant.VARCHAR)
    private String sex;
    @Column(name = "student_code",type = MySqlTypeConstant.VARCHAR)
    private String studentCode;
    @Column(name = "unit",type = MySqlTypeConstant.VARCHAR)
    private String unit;


    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
