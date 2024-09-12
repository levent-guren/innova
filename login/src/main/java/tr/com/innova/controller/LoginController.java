package tr.com.innova.controller;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import tr.com.innova.bean.Personel;
import tr.com.innova.dto.login.LoginDTO;
import tr.com.innova.service.LoginService;

@Controller
@RequiredArgsConstructor
public class LoginController {
	private final LoginService loginService;
	private final ModelMapper mapper;

	@GetMapping
	public String loginPage() {
		return "login";
	}

	@PostMapping
	public ModelAndView login(LoginDTO dto, HttpSession session) {
		Personel personel = mapper.map(dto, Personel.class);
		boolean loginResult = loginService.login(personel);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(loginResult ? "menu" : "login");
		if (!loginResult) {
			mav.addObject("message", "Invalid username/password!");
		} else {
			// logged in
			session.setAttribute("loginUsername", dto.getUsername());
		}
		return mav;
	}

}
