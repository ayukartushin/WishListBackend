package su.kartushin.wishlist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import su.kartushin.wishlist.model.User;
import su.kartushin.wishlist.repository.UserRepository;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void shouldCreateUser() {
        User user = User.builder()
                .username("jane_doe")
                .email("jane@example.com")
                .password("securepassword")
                .wishlists(new ArrayList<>())
                .build();

        User savedUser = userRepository.save(user);
        assertThat(savedUser.getId()).isNotNull();
        assertThat(savedUser.getUsername()).isEqualTo("jane_doe");
    }
}
