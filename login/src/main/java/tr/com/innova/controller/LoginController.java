package tr.com.innova.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import tr.com.innova.dto.login.LoginDTO;

@Controller
public class LoginController {

	@GetMapping
	public String loginPage() {
		return "login";
	}

	@PostMapping
	public String login(LoginDTO dto) {
		System.out.println(dto);
		return "login";
	}
}
