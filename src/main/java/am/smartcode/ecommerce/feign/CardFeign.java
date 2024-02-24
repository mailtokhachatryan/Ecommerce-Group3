package am.smartcode.ecommerce.feign;

import am.smartcode.ecommerce.model.dto.card.CardDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "card", url = "localhost:8081/cards")
public interface CardFeign {

    @PostMapping
    ResponseEntity<CardDto> createCard(@RequestBody CardDto cardDto);

    @GetMapping("/{userId}")
    ResponseEntity<List<CardDto>> getCardsByUserId(@PathVariable Integer userId);

    @DeleteMapping("/users/{userId}")
    void deleteAllCardsByUserId(@PathVariable Integer userId);

    @DeleteMapping("/{id}/{userId}")
    void deleteCardById(@PathVariable Integer id, @PathVariable Integer userId);

}
