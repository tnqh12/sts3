package springmvc3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/exception")
public class CommonExcepionController {

	@RequestMapping(value = "/arithmeticException.do")
	public void handleArithmaticException(Exception ex) {
		int i =100 / 0;
	}
	
	
}
