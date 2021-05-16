package studentmanager.demo.mapper;

import org.springframework.stereotype.Component;
import studentmanager.demo.entity.Student;
import studentmanager.demo.model.request.StudentRequest;
import studentmanager.demo.model.response.StudentResponse;

@Component
public class StudentMapper {
    public Student mapperStudentRequestToStudent(StudentRequest student){
        Student result = new Student();
        result.setUsername(student.getUsername());
        result.setPassword(student.getPassword());
        result.setFullname(student.getFullname());
        result.setCourse(student.getCourse());
        result.setEmail(student.getEmail());
        result.setAddress(student.getAddress());
        return result;
    }

    public StudentResponse mapperStudentToStudentResponse(Student student){
        StudentResponse result = new StudentResponse();
        result.setId(student.getId());
        result.setUsername(student.getUsername());;
        result.setFullname(student.getFullname());
        result.setCourse(student.getCourse());
        result.setEmail(student.getEmail());
        result.setAddress(student.getAddress());
        return result;
    }
}
