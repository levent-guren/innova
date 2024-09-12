package tr.com.innova.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GirisController {

	@GetMapping
	public ModelAndView anaSayfa() {
		ModelAndView mav = new ModelAndView("index.html");
		// mav.setViewName("index.html");
		mav.addObject("mesaj", "Hoşgeldiniz");
		return mav;
	}
}
