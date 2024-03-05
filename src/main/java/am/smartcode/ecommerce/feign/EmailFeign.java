package am.smartcode.ecommerce.feign;

import am.smartcode.ecommerce.model.dto.email.SendEmailDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "email", url = "localhost:8082/email")
public interface EmailFeign {

    @PostMapping
    ResponseEntity<Void> sendEmail(@RequestBody SendEmailDto sendEmailDto);

}
