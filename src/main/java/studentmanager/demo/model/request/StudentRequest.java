package studentmanager.demo.model.request;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;

@Getter
@Setter

public class StudentRequest {
    @Id
    @GeneratedValue
    private long id;

    @Column(unique = true)
    @NotNull
    private String username;

    @NotNull
    private String fullname;

    @NotNull
    @Email
    private String email;

    @NotNull
    private String address;

    @NotNull
    private String password;

    @NotNull
    private String course;
}
