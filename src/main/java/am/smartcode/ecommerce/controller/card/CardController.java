package am.smartcode.ecommerce.controller.card;

import am.smartcode.ecommerce.model.dto.card.CardDto;
import am.smartcode.ecommerce.service.card.CardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PreAuthorize("hasRole('USER')")
    @PostMapping
    public ResponseEntity<CardDto> createCard(@RequestBody @Valid CardDto cardDto) {
        return ResponseEntity.ok(cardService.createCard(cardDto));
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/{userId}")
    public ResponseEntity<List<CardDto>> getCardsByUserId(@PathVariable Integer userId) {
        return ResponseEntity.ok(cardService.getCardByUserId(userId));
    }

    @PreAuthorize("hasRole('USER')")
    @DeleteMapping("/users/{userId}")
    public void deleteCardsByUserId(@PathVariable Integer userId) {
        cardService.deleteCardsByUserId(userId);
    }

    @PreAuthorize("hasRole('USER')")
    @DeleteMapping("{userId}")
    public void deleteCardByUserId(@PathVariable Integer userId) {
        cardService.deleteCardById(userId);
    }
}
