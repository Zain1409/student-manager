package studentmanager.demo.model.request;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentLogin {
    @NotNull
    private String username;
    @NotNull
    private String password;
    private boolean loggedIn;

    public StudentLogin(String username,String password) {
        this.username = username;
        this.password = password;
        this.loggedIn = false;
    }
}
