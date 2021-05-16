package studentmanager.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentSearchDto extends SearchDto{
    private String username;
    private String fullname;
    private String email;
    private String address;
    private String course;
}
