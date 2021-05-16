package studentmanager.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import studentmanager.demo.dto.SearchDto;
import studentmanager.demo.dto.StudentSearchDto;
import studentmanager.demo.entity.Student;
import studentmanager.demo.exception.BusinessException;
import studentmanager.demo.mapper.StudentMapper;
import studentmanager.demo.model.request.SearchStudent;
import studentmanager.demo.model.request.StudentLogin;
import studentmanager.demo.model.request.StudentRequest;
import studentmanager.demo.model.request.UpdateStudent;
import studentmanager.demo.model.response.StudentResponse;
import studentmanager.demo.repository.StudentRepository;
import studentmanager.demo.service.StudentService;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository repository;
    @Autowired
    private StudentMapper mapper;

    @Override
    public StudentResponse getById(long id) throws BusinessException {
        Student student = new Student();
        student = repository.getStudentById(id);
        if(student == null){
            throw new BusinessException(10,"error.student.id","Student id not exit");
        }else{
            return mapper.mapperStudentToStudentResponse(student);
        }
    }

    @Override
    public Page<StudentResponse> search(StudentSearchDto dto) throws BusinessException {
        if(dto == null){
            throw  new BusinessException(10,"error.search.page","please enter page");
        }else {
            int pageNo = dto.getPageNo();
            int pageSize = dto.getPageSize();
            String username = dto.getUsername();
            String email = dto.getEmail();
            String address = dto.getAddress();
            String fullname = dto.getFullname();
            String course = dto.getCourse();
            if(username == null){
                username = "";
            }
            if(email == null){
                email = "";
            }
            if(address == null){
                address = "";
            }
            if(fullname == null){
                fullname = "";
            }
            if(course == null){
                course = "";
            }
            Page<Student> result = repository.getStudent(username,email,address,course,fullname, PageRequest.of(pageNo, pageSize));

            System.out.println(result);
            Page<StudentResponse> responses = result.map(student -> {
                StudentResponse result1 = new StudentResponse();
                result1 = mapper.mapperStudentToStudentResponse(student);
                return result1;
            });
            return responses;
        }
    }


    @Override
    public StudentResponse insert(StudentRequest student) throws BusinessException {
        Student result = new Student();
        result = repository.getStudentByUsername(student.getUsername());
        if(result != null){
            throw new BusinessException(1,"error.student.username", "Student username already");
        }else{
            result = mapper.mapperStudentRequestToStudent(student);
            result.setFlag(1);
            repository.save(result);
            StudentResponse student1 = mapper.mapperStudentToStudentResponse(result);
            return student1;
        }
    }

    @Override
    public StudentResponse update(UpdateStudent student) throws BusinessException {
        String username = student.getUsername();
        Student student1 = repository.getStudentByUsername(username);
        if(student1 == null){
            throw new BusinessException(2,"error.student.username", "Student username not exit");
        }else{
            student1.setFullname(student.getFullname());
            student1.setCourse(student.getCourse());
            student1.setEmail(student.getEmail());
            student1.setAddress(student.getAddress());
            repository.save(student1);
            return mapper.mapperStudentToStudentResponse(student1);
        }
    }

    @Override
    public void delete(long id) throws BusinessException {
        Student student = new Student();
        student = repository.getStudentById(id);
        if(student == null){
            throw new BusinessException(404,"error.student","student not exit");
        }else{
            repository.deleteById(id);
        }

    }

    @Override
    public String login(StudentLogin login) {
        Student student = repository.login(login.getUsername(), login.getPassword());
        if(student == null){
            login.setLoggedIn(false);
            return "FAILED";
        }
        login.setLoggedIn(true);
        return "SUCCESS";

    }

    @Override
    public Page<StudentResponse> getAll(SearchDto dto) throws BusinessException {
        if(dto == null){
            throw new BusinessException(404,"error.page","not find pageNo, pageSize");
        }else{
            Page<Student> students = repository.getAllStudent(PageRequest.of(dto.getPageNo(), dto.getPageSize()));
            Page<StudentResponse> result = students.map(student -> {
                return mapper.mapperStudentToStudentResponse(student);
            });
            return result;
        }

    }

//    @Override
//    public List<StudentResponse> getAll() throws BusinessException {
//        List<Student> students = repository.findAll();
//        List<StudentResponse> result = new ArrayList<>();
//        if(students == null){
//            throw new BusinessException(404,"404 not found", "null");
//        } else {
//            for(Student student : students){
//                StudentResponse result1 = mapper.mapperStudentToStudentResponse(student);
//                result.add(result1);
//            }
//            return result;
//        }
//    }


}
