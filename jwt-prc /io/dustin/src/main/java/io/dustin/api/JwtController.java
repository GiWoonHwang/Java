package io.dustin.api;

import com.auth0.jwt.interfaces.DecodedJWT;
import io.dustin.api.usecase.ReadUserUseCase;
import io.dustin.common.annotations.AuthToken;
import io.dustin.common.model.JwtClaim;
import io.dustin.common.properties.JwtProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static io.dustin.common.utils.JwtUtils.decodedAuthToken;
import static io.dustin.common.utils.JwtUtils.generateAuthToken;

@RestController
@RequestMapping("/api/jwt")
@RequiredArgsConstructor
public class JwtController {

    private final ReadUserUseCase readUserUseCase;



    @GetMapping("/tokenValidation")
    public String validation(@AuthToken String token) {
        return readUserUseCase.validationToken(token);
    }









}
