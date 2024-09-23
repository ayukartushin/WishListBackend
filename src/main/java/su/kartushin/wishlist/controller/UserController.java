package su.kartushin.wishlist.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import su.kartushin.wishlist.model.User;
import su.kartushin.wishlist.service.UserService;
import su.kartushin.wishlist.utils.JwtUtil;

import java.util.List;
import java.util.Optional;

import static su.kartushin.wishlist.utils.SHA256PasswordEncoderUtil.encodePassword;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Получить всех пользователей
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Получить пользователя по ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Создать нового пользователя
    @PostMapping("/register")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    // Удалить пользователя
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    // Аутентификация пользователя
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user, HttpServletResponse response) {
        Optional<User> existingUser = userService.findByUsername(user.getUsername());

        if (existingUser.isPresent()
                && userService.checkPassword(encodePassword(user.getPassword()), existingUser.get().getPassword())) {
            // Генерация JWT токена
            JwtUtil jwtUtil = new JwtUtil();
            String token = jwtUtil.generateToken(existingUser.get().getUsername());
            Cookie cookie = new Cookie("auth", token);
            cookie.setMaxAge(10 * 60 * 60); // Кука живет 10 часов
            cookie.setPath("/");
            response.addCookie(cookie);
            return ResponseEntity.ok(token);  // Возвращаем токен
        } else {
            return ResponseEntity.status(401).body("Неверные имя пользователя или пароль");
        }
    }
}
