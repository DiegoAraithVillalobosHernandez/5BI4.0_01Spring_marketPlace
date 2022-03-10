package mx.edu.utez.erielit.security.jwt;

import io.jsonwebtoken.*;
import mx.edu.utez.erielit.security.model.AuthUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtProvider {
    private final static Logger LOGGER = LoggerFactory.getLogger(JwtProvider.class);

    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private int expiration;

    public String generateToken(Authentication authentication){
        AuthUser authUser = (AuthUser) authentication.getPrincipal();
        return Jwts.builder().setSubject(authUser.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime()+expiration+1000L))
                .signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    public String getUsernameFromToken(String token){
        return Jwts.parser().setSigningKey(secret)
                .parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToker(String token){
        try {
            Jwts.parser().setSigningKey(secret)
                    .parseClaimsJws(token);
            return true;
        }catch (MalformedJwtException e){
            LOGGER.error("Token mal formado");
        }catch (UnsupportedJwtException e){
            LOGGER.error("Token no soportado");
        }catch (ExpiredJwtException e){
            LOGGER.error("Token expirado");
        }catch (IllegalArgumentException e){
            LOGGER.error("Token no provisto");
        }catch (SignatureException e){
            LOGGER.error("Token con error en la firma");
        }
        return false;
    }
}
