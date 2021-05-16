package studentmanager.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import studentmanager.demo.dto.SearchDto;
import studentmanager.demo.dto.StudentSearchDto;
import studentmanager.demo.exception.BusinessException;
import studentmanager.demo.model.request.StudentLogin;
import studentmanager.demo.model.request.StudentRequest;
import studentmanager.demo.model.request.UpdateStudent;
import studentmanager.demo.service.StudentService;

@RestController
@RequestMapping("api/student")
public class StudentController {
    @Autowired
    public StudentService service;

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable(name = "id") long id){
        try {
            return ResponseEntity.ok(service.getById(id));
        } catch (BusinessException e) {
            return ResponseEntity.ok(e.getMessage());
        }
    }
    @PostMapping("/search")
    public ResponseEntity getAll(@RequestBody StudentSearchDto dto){
        try {
            return ResponseEntity.ok(service.search(dto));
        } catch (BusinessException e) {
            return ResponseEntity.ok(e.getMessage());
        }
    }
    @PostMapping("/getAll")
    public ResponseEntity getAllStudent(@RequestBody SearchDto dto){
        try {
            return ResponseEntity.ok(service.getAll(dto));
        } catch (BusinessException e) {
            return ResponseEntity.ok(e.getMessage());
        }
    }
    @PostMapping("")
    public ResponseEntity insert(@RequestBody StudentRequest student){
        try {
            return ResponseEntity.ok(service.insert(student));
        } catch (BusinessException e) {
            return ResponseEntity.ok(e.getMessage());
        }
    }
    @PutMapping("")
    public ResponseEntity update(@RequestBody UpdateStudent student){
        try {
            return ResponseEntity.ok(service.update(student));
        } catch (BusinessException e) {
            return ResponseEntity.ok(e.getMessage());
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(name = "id") long id){
        try {
            service.delete(id);
            return ResponseEntity.ok().body("success");
        } catch (BusinessException e) {
            return ResponseEntity.ok(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody StudentLogin login){
        return ResponseEntity.ok(service.login(login));
    }
}
