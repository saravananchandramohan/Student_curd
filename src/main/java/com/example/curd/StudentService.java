package com.example.curd;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;
    public Student createStudent(Student student){
        return studentRepo.save(student);
    }
    public List<Student> createStudents(List<Student> student){
        return studentRepo.saveAll(student);
    }
    public Student getStudentById(int id){
        return studentRepo.findById(id).orElse(null);
    }
    public List<Student> getStudent(){
        return studentRepo.findAll();
    }
    //update
    public Student updateStudent(Student student){
        Student oldStudent=null;
        Optional<Student>optionalStu=studentRepo.findById(student.getId());
        if(optionalStu.isPresent()){
            oldStudent=optionalStu.get();
            oldStudent.setName(student.getName());
            studentRepo.save(oldStudent);
        }else{
            return new Student();
        }
        return oldStudent;
    }
    //delete
    public String deleteStudentById(int id){
        studentRepo.deleteById(id);
        return"Student data deleted";
    }

    public List<Student> getAllStudentsSortedById() {
        return studentRepo.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

}
