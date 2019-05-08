package com.prosmv.service;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.prosmv.domain.AuthenticationToken;
import com.prosmv.domain.User;
import com.prosmv.dto.LoginResponseDTO;
import com.prosmv.form.LoginForm;
import com.prosmv.repositories.AuthenticationTokenRepository;
import com.prosmv.repositories.UserRepository;

@Service
public class LoginService {

	@Autowired
	private AuthenticationTokenRepository authenticationTokenRepository;
	@Autowired
	UserRepository userRepository;

	public LoginResponseDTO logIn(LoginForm loginForm) {
		LoginResponseDTO loginResponseDTO = null;
		User user = userRepository.findByUsername(loginForm.getUsername());
		if (user != null) {
			if (new BCryptPasswordEncoder().matches(loginForm.getPassword(), user.getPassword())) {
				String token = UUID.randomUUID().toString();
				AuthenticationToken authToken = authenticationTokenRepository.findByUser(user);
				if (authToken != null) {
					authenticationTokenRepository.delete(authToken);
				}
				authToken = new AuthenticationToken();
				authToken.setToken(token);
				authToken.setUser(user);
				authenticationTokenRepository.save(authToken);
				loginResponseDTO =  new LoginResponseDTO(token, user, "success");				
			} else {
				loginResponseDTO = new LoginResponseDTO("wrong password");
			}
		} else {
			loginResponseDTO = new LoginResponseDTO("please enter valid username");
		}
		return loginResponseDTO;
	}

	public String logOut(String token) {
		String response = null;
		AuthenticationToken authenticationToken = authenticationTokenRepository.findByToken(token);
		if (authenticationToken != null) {
			authenticationTokenRepository.delete(authenticationToken);
			response = "log out successfully";
		} else {
			response = "invalid request";
		}
		return response;
	}

}
