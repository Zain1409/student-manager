package studentmanager.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import studentmanager.demo.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student getStudentByUsername(String username);
    Student getStudentById(long id);

    @Query(value = "select  * from student s where s.flag = 1 order by s.id", nativeQuery = true)
    Page<Student> getAllStudent(Pageable pageable);

    @Query(value = "select * from student s where s.username like %:username% and s.email like %:email% and s.address " +
            "like %:address% and s.course like %:course% and s.fullname like %:fullname% and s.flag = 1 order by s.id", nativeQuery = true)
    Page<Student> getStudent(@Param("username") String username,
                             @Param("email") String email,
                             @Param("address") String address,
                             @Param("course") String course,
                             @Param("fullname") String fullname,
                             Pageable pageable);

    @Query(value = "select * from  student s where s.username = :username and s.password = :password and flag  = 1", nativeQuery = true)
    Student login(@Param("username") String username, @Param("password") String password);
}
