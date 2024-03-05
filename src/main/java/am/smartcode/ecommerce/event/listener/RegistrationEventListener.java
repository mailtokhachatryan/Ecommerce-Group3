package am.smartcode.ecommerce.event.listener;

import am.smartcode.ecommerce.event.RegistrationEvent;
import am.smartcode.ecommerce.feign.EmailFeign;
import am.smartcode.ecommerce.model.dto.email.SendEmailDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@Component
@RequiredArgsConstructor
public class RegistrationEventListener {

    private final EmailFeign emailFeign;

    @Async
    @TransactionalEventListener
    public void handleRegistrationEvent(RegistrationEvent registrationEvent) {
        log.info(registrationEvent.toString());
        emailFeign.sendEmail(
                new SendEmailDto(
                        registrationEvent.getEmail(),
                        "Verification",
                        "Your code is " + registrationEvent.getCode()
                ))
        ;
    }

}
