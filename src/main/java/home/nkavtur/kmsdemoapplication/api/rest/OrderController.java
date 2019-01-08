package home.nkavtur.kmsdemoapplication.api.rest;

import home.nkavtur.kmsdemoapplication.entity.OrderEntity;
import home.nkavtur.kmsdemoapplication.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderRepository orderRepository;

    @GetMapping
    public List<OrderEntity> orders() {
        return orderRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public OrderEntity order(String id) {
        return orderRepository.findById(UUID.fromString(id)).orElse(null);
    }

    @PostMapping
    public OrderEntity order(@RequestBody OrderEntity order) {
        return orderRepository.save(order);
    }

}
