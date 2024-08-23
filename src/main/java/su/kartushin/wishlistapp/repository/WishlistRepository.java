package su.kartushin.wishlistapp.repository;

import su.kartushin.wishlistapp.entity.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishlistRepository extends JpaRepository<Wishlist, Long> {
    // Дополнительные методы поиска можно добавить здесь
}