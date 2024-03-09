package am.smartcode.ecommerce.controller;

import am.smartcode.ecommerce.model.dto.order.OrderCreateDto;
import am.smartcode.ecommerce.model.dto.order.OrderDto;
import am.smartcode.ecommerce.service.order.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

//    @GetMapping
//    public ResponseEntity<List<OrderDto>> getAll() {
//        return ResponseEntity.ok(orderService.());
//    }


    @PostMapping
    public ResponseEntity<OrderDto> create(@RequestBody @Valid OrderCreateDto orderCreateDto) {
        return ResponseEntity.ok(orderService.create(orderCreateDto));
    }

}
