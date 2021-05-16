package studentmanager.demo.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentResponse {
    private long id;
    private String username;
    private String fullname;
    private String email;
    private String address;
    private String course;
}
