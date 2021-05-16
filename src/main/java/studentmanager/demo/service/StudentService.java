package studentmanager.demo.service;

import org.springframework.data.domain.Page;
import studentmanager.demo.dto.SearchDto;
import studentmanager.demo.dto.StudentSearchDto;
import studentmanager.demo.exception.BusinessException;
import studentmanager.demo.model.request.StudentLogin;
import studentmanager.demo.model.request.StudentRequest;
import studentmanager.demo.model.request.UpdateStudent;
import studentmanager.demo.model.response.StudentResponse;

import java.util.List;

public interface StudentService {
    StudentResponse getById(long id) throws BusinessException;
    Page<StudentResponse> search(StudentSearchDto dto) throws BusinessException;
    StudentResponse insert(StudentRequest student) throws BusinessException;
    StudentResponse update(UpdateStudent student) throws BusinessException;
    void delete(long id) throws BusinessException;

    String login(StudentLogin login);
    //test getAll
    Page<StudentResponse> getAll(SearchDto dto) throws BusinessException;
}
