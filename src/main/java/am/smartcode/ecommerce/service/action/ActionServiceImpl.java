package am.smartcode.ecommerce.service.action;

import am.smartcode.ecommerce.model.dto.kafka.CreateActionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ActionServiceImpl implements ActionService {


    private final KafkaTemplate<String, CreateActionDto> actionKafkaTemplate;

    @Value("${kafka.activity.topic.name}")
    private String topicName;

    @Override
//    @Async
    public void create(Integer userId, String actionType, String entityType) {
        CreateActionDto actionDto = new CreateActionDto();
        actionDto.setUserId(userId);
        actionDto.setActionType(actionType);
        actionDto.setEntityType(entityType);
        actionDto.setActionDate(LocalDateTime.now());
        actionKafkaTemplate.send(topicName, actionDto);
    }

}
