package com.example.edu.compraventa.registration;

import org.springframework.stereotype.Service;

import com.example.edu.compraventa.service.UserServiceSecurity;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RegistrationService {

	private final UserServiceSecurity userServiceSecurity;
	private final EmailValidator emailValidator;

	public String register(RegistrationRequest request) {
		boolean isValidEmail = emailValidator.test(request.getEmail());
		if (!isValidEmail) {
			throw new IllegalStateException("email not valid");
		}

		return null;
	}
}
