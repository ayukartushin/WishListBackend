package su.kartushin.wishlist.service;

import org.springframework.stereotype.Service;
import su.kartushin.wishlist.model.User;
import su.kartushin.wishlist.repository.UserRepository;

import java.util.List;
import java.util.Optional;

import static su.kartushin.wishlist.utils.SHA256PasswordEncoderUtil.encodePassword;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        user.setPassword(encodePassword(user.getPassword()));
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public boolean checkPassword(String expected, String actual) {
        return expected.equals(actual);
    }
}
