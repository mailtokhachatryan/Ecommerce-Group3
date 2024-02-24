package am.smartcode.ecommerce.controller;

import am.smartcode.ecommerce.model.dto.card.CardCreateDto;
import am.smartcode.ecommerce.model.dto.card.CardDto;
import am.smartcode.ecommerce.service.card.CardService;
import jakarta.validation.Valid;
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
    public ResponseEntity<CardDto> createCard(@RequestBody @Valid CardCreateDto cardCreateDto) {
        return ResponseEntity.ok(cardService.createCard(cardCreateDto));
    }

    @GetMapping
    public ResponseEntity<List<CardDto>> getCards() {
        return ResponseEntity.ok(cardService.getCards());
    }

    @DeleteMapping
    public void deleteCardsByUserId() {
        cardService.deleteAllCards();
    }

    @DeleteMapping("/{id}")
    public void deleteCardByUserId(@PathVariable Integer id) {
        cardService.deleteCardById(id);
    }
}
