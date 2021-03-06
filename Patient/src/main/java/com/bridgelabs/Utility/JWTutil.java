package com.bridgelabs.Utility;

import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

@Component
public class JWTutil
{
private static final String SECRET = "9886002418";
	
     /* Method to generate the token for the particular userId */
	public String jwtToken(long l) {
		String token = null;
		try {
			token = JWT.create().withClaim("id", l).sign(Algorithm.HMAC512(SECRET));
		} catch (IllegalArgumentException | JWTCreationException e) {

			e.printStackTrace(); 
		}
		return token;
	}

	/*
	 * method to parse the jwt token into integer
	 * */
	public int parseJWT(String jwt) {

		Integer userId = 0;
		if (jwt != null) {
			try {
				userId = JWT.require(Algorithm.HMAC512(SECRET)).build().verify(jwt).getClaim("id").asInt();
			} catch (JWTVerificationException | IllegalArgumentException e) {
				e.printStackTrace();
			}
		}
		return userId;
	}

}
