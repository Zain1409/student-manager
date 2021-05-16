package studentmanager.demo.model.request;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.Email;

@Getter
@Setter
public class UpdateStudent {
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
