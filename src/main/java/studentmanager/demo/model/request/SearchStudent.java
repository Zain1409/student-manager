package studentmanager.demo.model.request;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
@Getter
@Setter
public class SearchStudent {
    private String username;
    private String fullname;
    private String password;
    private String course;
}
