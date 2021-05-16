package studentmanager.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue
    private long id;
    private String username;
    private String password;
    private String fullname;
    private String course;
    private String email;
    private String address;
    private int flag;
}
