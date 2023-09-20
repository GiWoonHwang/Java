package io.dustin.api.usecase;

import com.auth0.jwt.interfaces.DecodedJWT;
import io.dustin.api.query.UserQuery;
import io.dustin.common.model.JwtClaim;
import io.dustin.common.properties.JwtProperties;
import io.dustin.domain.user.model.entity.User;
import io.dustin.domain.user.model.entity.dto.SignInDto;
import io.dustin.domain.user.service.ReadUserService;
import io.dustin.domain.user.service.WriteUserService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static io.dustin.common.utils.JwtUtils.*;

@Service
@RequiredArgsConstructor
public class ReadUserUseCase {
    private final ReadUserService readUserService;
    private final WriteUserService writeUserService;
    private final JwtProperties props;

    public SignInDto execute(UserQuery query) {
        User user = readUserService.getUser(query.id());
        if(user.getPwd().equals(query.pwd())) {
            JwtClaim jwtClaim = new JwtClaim(user.getId(), user.getEmail());
            String token = generateAuthToken(jwtClaim, props);
            //TODO
            // redis -> props.expiredAt() 값으로
            // token - user 정보를 cached한다.
            writeUserService.cachedUser(token, user, props.expiredAt());
            return new SignInDto(token);
        } else {
            throw new RuntimeException("not matching");
        }
    }

    public String validationToken(String token) {

        DecodedJWT decodedJwt = decodedAuthToken(token, props);
        String id = idFromJWT(decodedJwt);
        String email = emailFromJWT(decodedJwt);

        User user = readUserService.getCachedUser(token);
        if(user.getEmail().equals(email)) {
            return "성공!";
        } else {
            throw new RuntimeException("not matching");
        }
    }

}
