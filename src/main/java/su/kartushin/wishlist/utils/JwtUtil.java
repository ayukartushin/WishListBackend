package su.kartushin.wishlist.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {

    private final String SECRET_KEY = "a8f08b6068fe82d1c9570247d91d3d9f5175ee04f3df5366143af99441bff6b0" +
            "ecf4d938cc10f34be4286cb8d59ec98ea8fb2697789eaf898a88fdba1299874f" +
            "e0c8a00691c4d6a943bb15e4798849f35ca17fe2daf4e73fa0303379d250602f" +
            "405eac9f0cef27a5fa644c4b2b95ec1655ca406dcbb925c9cd107e54601a42d1" +
            "fa097889d946dc77d5b0be28c9c183112c6efd0cd93451d0ea612872a7dfaaec" +
            "fac60387b675321f9a64dd1ea2c16b96c6d66a60a17f44480f1d2eea3e3bde6a" +
            "4b67838f0957e2d987d4c1edcd3a18b704e9a59186a35952663edced0beed5d2" +
            "e3e80a33facc49423db899171fa593a68be366b0231e5c9c9d735ac73bcf98a7" +
            "b75ee2dbce7b898e7b001c12c9362239ea2bffc5bcfa186b2f11cac91a1ac9b9" +
            "bdfee56218130bca634c9ebfef851c5e3e90a47e371e6db49e58eed33223a218"; // Секретный ключ для генерации токенов

    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, username);
    }

    private String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 часов
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, java.util.function.Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).build().parseClaimsJws(token).getBody();
    }

    public boolean isTokenExpired(String token) {
        return extractAllClaims(token).getExpiration().before(new Date());
    }

    public boolean validateToken(String token, String username) {
        return (extractUsername(token).equals(username) && !isTokenExpired(token));
    }
}