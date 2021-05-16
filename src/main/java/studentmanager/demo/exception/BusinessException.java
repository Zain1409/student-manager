package studentmanager.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BusinessException extends Exception{
    private final Integer status;
    private final String messageCode;
    private final String message;
}
