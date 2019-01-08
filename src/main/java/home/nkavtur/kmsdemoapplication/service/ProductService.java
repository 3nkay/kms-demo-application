package home.nkavtur.kmsdemoapplication.service;

import home.nkavtur.kmsdemoapplication.api.domain.Order;
import home.nkavtur.kmsdemoapplication.api.domain.Product;
import home.nkavtur.kmsdemoapplication.entity.OrderEntity;
import home.nkavtur.kmsdemoapplication.entity.ProductEntity;
import home.nkavtur.kmsdemoapplication.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public List<ProductEntity> all() {
        return productRepository.findAll();
    }

    public ProductEntity byId(UUID uuid) {
        return productRepository.findById(uuid).orElse(null);
    }

    public ProductEntity update(String uuid, Product product) {
        ProductEntity existing = productRepository.getOne(UUID.fromString(uuid));

        existing.setName(product.getName());

        return productRepository.save(existing);
    }

    public ProductEntity save(Product product) {
        ProductEntity productEntity = new ProductEntity()
                .setName(product.getName());


        return productRepository.save(productEntity);
    }

    public void remove(String uuid) {
        productRepository.deleteById(UUID.fromString(uuid));
    }

}
