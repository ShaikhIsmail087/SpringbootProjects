package com.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	
	@RequestMapping("/test")
	@ResponseBody
	public String test() 
	{
		int a=31;
		int b=20;
		int c=90;
		int d=2000;
		return "this is just testing /t sum of a and b is "+(a+b+c+d);
	}
}
