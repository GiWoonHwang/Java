package io.dustin;

import com.auth0.jwt.interfaces.DecodedJWT;
import io.dustin.common.annotations.AuthToken;
import io.dustin.common.model.JwtClaim;
import io.dustin.common.properties.JwtProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static io.dustin.common.utils.JwtUtils.decodedAuthToken;
import static io.dustin.common.utils.JwtUtils.generateAuthToken;

@RestController
@RequestMapping("/api/test")
@RequiredArgsConstructor
public class TestController {

    @Autowired
    private JwtProperties props;

    /**
     * 테스트니까 그냥 여기에 코딩할게요
     */

    @GetMapping("/generateAuthToken")
    public String generate() {
            String id = "dustin";
            String email = "dustin@dustin.com";
            JwtClaim jwtClaim = new JwtClaim(id, email);
        return generateAuthToken(jwtClaim, props);
    }

    @GetMapping("/tokenValidation")
    public DecodedJWT validation() {
        String id = "dustin";
        String email = "dustin@dustin.com";
        JwtClaim jwtClaim = new JwtClaim(id, email);
        String token = generateAuthToken(jwtClaim, props);
        return decodedAuthToken(token, props);
    }


    @GetMapping("/resolverTest")
    public Object resolverTest(@AuthToken String token) {
        return token;
    }








}
