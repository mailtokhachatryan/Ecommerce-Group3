package am.smartcode.ecommerce.controller;

import am.smartcode.ecommerce.model.dto.card.CardDto;
import am.smartcode.ecommerce.service.card.CardService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cards")
public class CardController {
    private final CardService cardService;

    @PostMapping
    public ResponseEntity<CardDto> createCard(@RequestBody @Valid CardDto cardDto) {
        return ResponseEntity.ok(cardService.createCard(cardDto));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<CardDto>> getCardsByUserId(@PathVariable Integer userId) {
        return ResponseEntity.ok(cardService.getCardByUserId(userId));
    }

    @DeleteMapping("/users/{userId}")
    public void deleteCardsByUserId(@PathVariable Integer userId) {
        cardService.deleteCardsByUserId(userId);
    }

    @DeleteMapping("{userId}")
    public void deleteCardByUserId(@PathVariable Integer userId) {
        cardService.deleteCardById(userId);
    }
}
