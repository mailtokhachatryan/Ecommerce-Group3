package am.smartcode.ecommerce.event.listener;

import am.smartcode.ecommerce.event.RegistrationEvent;
import am.smartcode.ecommerce.service.email.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@Component
@RequiredArgsConstructor
public class RegistrationEventListener {

    private final EmailService emailService;

    @Async
    @TransactionalEventListener
    public void handleRegistrationEvent(RegistrationEvent registrationEvent) {
        log.info(registrationEvent.toString());
        emailService.sendEmail(registrationEvent.getEmail(), "Verification", "Your code is " + registrationEvent.getCode());
    }

}
