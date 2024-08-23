package su.kartushin.wishlistapp.repository;

import su.kartushin.wishlistapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // Дополнительные методы поиска можно добавить здесь
}