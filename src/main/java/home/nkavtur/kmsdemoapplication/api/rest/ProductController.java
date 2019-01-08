package home.nkavtur.kmsdemoapplication.api.rest;

import home.nkavtur.kmsdemoapplication.api.domain.Product;
import home.nkavtur.kmsdemoapplication.entity.ProductEntity;
import home.nkavtur.kmsdemoapplication.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.fromMethodCall;
import static org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.on;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<ProductEntity> products() {
        return productService.all();
    }

    @GetMapping(path = "/{uuid}")
    public ProductEntity getProduct(@PathVariable("uuid") String id) {
        return productService.byId(UUID.fromString(id)).orElse(null);
    }

    @PutMapping(path = "/{uuid}")
    public ProductEntity updateProduct(
            @PathVariable("uuid") String uuid,
            @RequestBody Product product) {

        return productService.update(uuid, product);
    }

    @PostMapping
    public ResponseEntity product(@RequestBody Product product) {
        ProductEntity saved = productService.save(product);

        var uriLocation = fromMethodCall(on(ProductController.class)
                .getProduct(saved.getUuid().toString()))
                .build()
                .toUri();

        return ResponseEntity.created(uriLocation).build();
    }

}
