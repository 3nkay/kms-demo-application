package home.nkavtur.kmsdemoapplication.api.domain;

import lombok.Data;

import java.util.List;

@Data
public class Order {

    private String uuid;

    private List<Product> products;

    private List<Order> orders;
}
