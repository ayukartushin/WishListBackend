package su.kartushin.wishlist.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import su.kartushin.wishlist.model.WishlistItem;
import su.kartushin.wishlist.service.WishlistItemService;

import java.util.List;

@RestController
@RequestMapping("/api/wishlist-items")
public class WishlistItemController {

    private final WishlistItemService wishlistItemService;

    public WishlistItemController(WishlistItemService wishlistItemService) {
        this.wishlistItemService = wishlistItemService;
    }

    // Получить все элементы списка для списка желаний
    @GetMapping("/wishlist/{wishlistId}")
    public List<WishlistItem> getWishlistItemsByWishlistId(@PathVariable Long wishlistId) {
        return wishlistItemService.getWishlistItemsByWishlistId(wishlistId);
    }

    // Добавить новый элемент в список желаний
    @PostMapping("/wishlist/{wishlistId}")
    public WishlistItem addWishlistItem(@PathVariable Long wishlistId, @RequestBody WishlistItem wishlistItem) {
        return wishlistItemService.addWishlistItem(wishlistId, wishlistItem);
    }

    // Удалить элемент из списка желаний
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWishlistItem(@PathVariable Long id) {
        wishlistItemService.deleteWishlistItem(id);
        return ResponseEntity.noContent().build();
    }
}
