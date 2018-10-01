package com.kaneko.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HokkaidoController {

	@RequestMapping("/hokkaido")
	private ModelAndView hokkaido(ModelAndView mav) {
		// TODO 自動生成されたメソッド・スタブ
         return mav;
	}
}
