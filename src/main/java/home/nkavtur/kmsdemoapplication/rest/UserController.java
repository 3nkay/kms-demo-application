package home.nkavtur.kmsdemoapplication.rest;

import home.nkavtur.kmsdemoapplication.User;
import home.nkavtur.kmsdemoapplication.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.fromMethodCall;
import static org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.on;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> all() {
        return userService.all();
    }

    @GetMapping(path = "/{uuid}")
    public User get(@PathVariable("uuid") UUID uuid) {
        return userService.byId(uuid).orElse(null);
    }

    @PutMapping(path = "/{uuid}")
    public User update(
            @PathVariable("uuid") UUID uuid,
            @RequestBody User user) {
        return userService.update(uuid, user);
    }

    @PostMapping
    public ResponseEntity<User> product(@RequestBody User user) {
        user = userService.save(user);

        var uriLocation = fromMethodCall(on(UserController.class)
                .get(user.getUuid()))
                .build()
                .toUri();

        return ResponseEntity.created(uriLocation).build();
    }

}
