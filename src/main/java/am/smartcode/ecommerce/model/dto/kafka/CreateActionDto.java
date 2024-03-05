package am.smartcode.ecommerce.model.dto.kafka;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public class CreateActionDto implements Serializable {

    private Integer userId;

    private String actionType;

    private String entityType;

    private LocalDateTime actionDate;

}