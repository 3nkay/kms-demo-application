package home.nkavtur.kmsdemoapplication.api.rest;

import home.nkavtur.kmsdemoapplication.entity.UserEntity;
import home.nkavtur.kmsdemoapplication.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping
    public List<UserEntity> orders() {
        return userRepository.findAll();
    }
}
