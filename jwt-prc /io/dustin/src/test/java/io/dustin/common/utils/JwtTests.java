package io.dustin.common.utils;

import com.auth0.jwt.interfaces.DecodedJWT;
import io.dustin.common.model.JwtClaim;
import io.dustin.common.properties.JwtProperties;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static io.dustin.common.utils.JwtUtils.*;

@SpringBootTest
class JwtTests {

	@Autowired
	private JwtProperties props;

	@Test
	@DisplayName("JwtProperties load")
	void props_TEST() {
		System.out.println(props);
	}

	@Test
	@DisplayName("generateAuthToken 테스트")
	void generateAuthToken_TEST() {
		String id = "dustin";
		String email = "dustin@dustin.com";
		JwtClaim jwtClaim = new JwtClaim(id, email);
		System.out.println(generateAuthToken(jwtClaim, props));
	}

	@Test
	@DisplayName("decodedAuthToken 테스트")
	void decodedAuthToken_TEST() {
		String id = "dustin";
		String email = "dustin@dustin.com";
		JwtClaim jwtClaim = new JwtClaim(id, email);
		String token = generateAuthToken(jwtClaim, props);
		System.out.println(decodedAuthToken(token, props)); // com.auth0.jwt.JWTDecoder@652a1a17
	}

	@Test
	@DisplayName("idAndEmailFromJWT 테스트")
	void idAndEmailFromJWT() {
		String id = "dustin";
		String email = "dustin@dustin.com";
		JwtClaim jwtClaim = new JwtClaim(id, email);
		String token = generateAuthToken(jwtClaim, props);
		DecodedJWT decodedToken = decodedAuthToken(token, props);

		System.out.println(idFromJWT(decodedToken));
		System.out.println(emailFromJWT(decodedToken));

	}


}
