package com.soaps.serverg;

//import https.www_howtodoinjava_com.xml.school.Student;
import localhost._8080.xml.school.Student;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
//import com.howtodoinjava.xml.school.Student;

@Component
public class StudentRepository {
    private static final Map<String, Student> students = new HashMap<>();
 
    @PostConstruct
    public void initData() {
         
        Student student = new Student();
        student.setName("Dharmik");
        student.setGender("Male");
        student.setClazz(4);
        student.setAddress("Nairobi");
        students.put(student.getName(), student);
         
        student = new Student();
        student.setName("Kelly");
        student.setGender("Male");
        student.setClazz(5);
        student.setAddress("Nairobi");
        students.put(student.getName(), student);
         
        student = new Student();
        student.setName("Elinor");
        student.setGender("Female");
        student.setClazz(6);
        student.setAddress("Nairobi");
        students.put(student.getName(), student);
         
        student = new Student();
        student.setName("Lucia");
        student.setGender("Female");
        student.setClazz(7);
        student.setAddress("Nairobi");
        students.put(student.getName(), student);
    }
 
    public Student findStudent(String name) {
        Assert.notNull(name, "The Student's name must not be null");
        return students.get(name);
    }
}