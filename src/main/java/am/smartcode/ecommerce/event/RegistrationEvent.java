package am.smartcode.ecommerce.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class RegistrationEvent extends ApplicationEvent {
    private final String code;
    private final String email;

    public RegistrationEvent(Object source, String code, String email) {
        super(source);
        this.code = code;
        this.email = email;
    }
}
