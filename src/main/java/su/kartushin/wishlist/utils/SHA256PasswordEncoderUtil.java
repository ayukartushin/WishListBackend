package su.kartushin.wishlist.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class SHA256PasswordEncoderUtil {

    /**
     * Хеширует пароль с использованием SHA-256
     * @param rawPassword исходный пароль
     * @return захешированный пароль в виде строки
     */
    public static String encodePassword(String rawPassword) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(rawPassword.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(hash); // Возвращаем хеш в формате Base64
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Ошибка: Алгоритм SHA-256 не найден", e);
        }
    }

    /**
     * Проверяет, соответствует ли исходный пароль захешированному паролю
     * @param rawPassword исходный пароль
     * @param encodedPassword захешированный пароль
     * @return true, если пароли совпадают, иначе false
     */
    public static boolean matches(String rawPassword, String encodedPassword) {
        String hashedPassword = encodePassword(rawPassword);
        return hashedPassword.equals(encodedPassword);
    }
}
