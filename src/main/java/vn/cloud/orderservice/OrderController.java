package vn.cloud.orderservice;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderRepository orderRepository;

    @GetMapping("/{id}")
    public Order findById(@PathVariable Long id) {
        return this.orderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid id: %d".formatted(id)));
    }
}
