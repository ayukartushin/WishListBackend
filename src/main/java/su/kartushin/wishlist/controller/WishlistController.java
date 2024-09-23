package su.kartushin.wishlist.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import su.kartushin.wishlist.model.Wishlist;
import su.kartushin.wishlist.service.WishlistService;

import java.util.List;

@RestController
@RequestMapping("/api/wishlists")
public class WishlistController {

    private final WishlistService wishlistService;

    public WishlistController(WishlistService wishlistService) {
        this.wishlistService = wishlistService;
    }

    // Получить все списки желаний для пользователя
    @GetMapping("/user/{userId}")
    public List<Wishlist> getWishlistsByUserId(@PathVariable Long userId) {
        return wishlistService.getWishlistsByUserId(userId);
    }

    // Создать новый список желаний для пользователя
    @PostMapping("/user/{userId}")
    public Wishlist createWishlist(@PathVariable Long userId, @RequestBody Wishlist wishlist) {
        return wishlistService.createWishlist(userId, wishlist);
    }

    // Удалить список желаний
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWishlist(@PathVariable Long id) {
        wishlistService.deleteWishlist(id);
        return ResponseEntity.noContent().build();
    }
}
