package su.kartushin.wishlistapp.repository;

import su.kartushin.wishlistapp.entity.WishlistItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishlistItemRepository extends JpaRepository<WishlistItem, Long> {
    // Дополнительные методы поиска можно добавить здесь
}