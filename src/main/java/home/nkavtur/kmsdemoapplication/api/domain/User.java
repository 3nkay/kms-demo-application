package home.nkavtur.kmsdemoapplication.api.domain;

import lombok.Data;

import java.util.List;

@Data
public class User {

    private String uuid;

    private String name;

    private String creditCard;

    private List<Order> orders;
}
