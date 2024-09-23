package su.kartushin.wishlist.service;

import org.springframework.stereotype.Service;
import su.kartushin.wishlist.model.Wishlist;
import su.kartushin.wishlist.model.WishlistItem;
import su.kartushin.wishlist.repository.WishlistItemRepository;
import su.kartushin.wishlist.repository.WishlistRepository;

import java.util.List;
import java.util.Optional;

@Service
public class WishlistItemService {

    private final WishlistItemRepository wishlistItemRepository;
    private final WishlistRepository wishlistRepository;

    public WishlistItemService(WishlistItemRepository wishlistItemRepository, WishlistRepository wishlistRepository) {
        this.wishlistItemRepository = wishlistItemRepository;
        this.wishlistRepository = wishlistRepository;
    }

    public List<WishlistItem> getWishlistItemsByWishlistId(Long wishlistId) {
        return wishlistItemRepository.findByWishlistId(wishlistId);
    }

    public WishlistItem addWishlistItem(Long wishlistId, WishlistItem wishlistItem) {
        Optional<Wishlist> wishlist = wishlistRepository.findById(wishlistId);
        if (wishlist.isPresent()) {
            wishlistItem.setWishlist(wishlist.get());
            return wishlistItemRepository.save(wishlistItem);
        } else {
            throw new RuntimeException("Wishlist not found");
        }
    }

    public void deleteWishlistItem(Long id) {
        wishlistItemRepository.deleteById(id);
    }
}
