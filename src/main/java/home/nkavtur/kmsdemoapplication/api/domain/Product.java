package home.nkavtur.kmsdemoapplication.api.domain;

import lombok.Data;

import java.util.Set;

@Data
public class Product {

    private String uuid;

    private String name;

    private Set<Order> orders;
}
