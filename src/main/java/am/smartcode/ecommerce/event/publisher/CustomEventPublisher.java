package am.smartcode.ecommerce.event.publisher;

import am.smartcode.ecommerce.event.RegistrationEvent;
import am.smartcode.ecommerce.model.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomEventPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;

    public void publishRegistrationEvent(UserEntity userEntity) {
        RegistrationEvent registrationEvent = new RegistrationEvent(
                this,
                userEntity.getCode(),
                userEntity.getEmail()
        );

        applicationEventPublisher.publishEvent(registrationEvent);
    }
}
