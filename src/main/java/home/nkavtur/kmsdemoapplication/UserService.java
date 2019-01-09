package home.nkavtur.kmsdemoapplication;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public List<User> all() {
        return userRepository.findAll();
    }

    public Optional<User> byId(UUID uuid) {
        return userRepository.findById(uuid);
    }

    public User update(UUID uuid, User user) {
        var existingUser = userRepository.getOne(uuid);

        existingUser.setName(user.getName());
        existingUser.setCreditCard(user.getCreditCard());

        return userRepository.save(existingUser);
    }

    public User save(User user) {
        AWSK

        return userRepository.save(user);
    }

}
