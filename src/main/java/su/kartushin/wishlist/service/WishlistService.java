package su.kartushin.wishlist.service;

import org.springframework.stereotype.Service;
import su.kartushin.wishlist.model.User;
import su.kartushin.wishlist.model.Wishlist;
import su.kartushin.wishlist.repository.UserRepository;
import su.kartushin.wishlist.repository.WishlistRepository;

import java.util.List;
import java.util.Optional;

@Service
public class WishlistService {

    private final WishlistRepository wishlistRepository;
    private final UserRepository userRepository;

    public WishlistService(WishlistRepository wishlistRepository, UserRepository userRepository) {
        this.wishlistRepository = wishlistRepository;
        this.userRepository = userRepository;
    }

    public List<Wishlist> getWishlistsByUserId(Long userId) {
        return wishlistRepository.findByUserId(userId);
    }

    public Wishlist createWishlist(Long userId, Wishlist wishlist) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            wishlist.setUser(user.get());
            return wishlistRepository.save(wishlist);
        } else {
            throw new RuntimeException("User not found");
        }
    }

    public void deleteWishlist(Long id) {
        wishlistRepository.deleteById(id);
    }
}
