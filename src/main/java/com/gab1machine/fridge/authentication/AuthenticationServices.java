package com.gab1machine.fridge.authentication;

import com.gab1machine.fridge.user.UserDto;
import com.gab1machine.fridge.user.UserEntity;
import com.gab1machine.fridge.user.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Base64;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class AuthenticationServices {
    private static final SecureRandom secureRandom = new SecureRandom(); //threadsafe
    private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder(); //threadsafe
    private final TokenRepository tokenRepository;
    private final UserServices userServices;

    public void createNewTokenAndPercist(String id, UUID ownerId) {
        TokenEntity tokenEntity = new TokenEntity();
        tokenEntity.setId(id);
        tokenEntity.setOwnerId(ownerId);
        tokenEntity.setCreatedAt(new Date());
        tokenEntity.setEndAt(Date.from(LocalDateTime.from(new Date().toInstant()).plusDays(1).toInstant(OffsetDateTime.now().getOffset())));
        this.tokenRepository.save(tokenEntity);
    }

    public boolean isTokenValid(String id) {
        Optional<TokenEntity> otokenEntity = this.tokenRepository.findById(id);
        if (otokenEntity.isEmpty())
            return false;
        Date now = new Date();
        TokenEntity tokenEntity = otokenEntity.get();
        if (tokenEntity.getCreatedAt().before(now)  && tokenEntity.getEndAt().after(now)) {
            return true;
        }
        return false;
    }

    public Optional<TokenDto> authenticate(UserAuthenticationDto dto) {
        Optional<UserDto> ouserDto = this.userServices.getUser(dto.id());
        if(ouserDto.isEmpty())
            return Optional.empty();
        UserDto userDto = ouserDto.get();
        return Optional.empty();
    }

}
