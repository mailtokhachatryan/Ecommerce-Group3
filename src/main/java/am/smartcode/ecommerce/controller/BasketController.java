package am.smartcode.ecommerce.controller;

import am.smartcode.ecommerce.model.dto.basket.BasketCreatDto;
import am.smartcode.ecommerce.model.dto.basket.BasketDto;
import am.smartcode.ecommerce.service.basket.BasketService;
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
@RequestMapping("/basket")
@RequiredArgsConstructor
public class BasketController {

    private final BasketService basketService;

    @GetMapping
    public ResponseEntity<List<BasketDto>> getAll() {
        return ResponseEntity.ok(basketService.getBasket());
    }


    @PostMapping
    public ResponseEntity<BasketDto> create(@RequestBody @Valid BasketCreatDto basketCreatDto) {
        return ResponseEntity.ok(basketService.addProduct(basketCreatDto));
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Integer id) {
        basketService.deleteProduct(id);
    }

}
