package com.mine.demo1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo1")

public class Demo1Controller {
	@RequestMapping(path = "/test", method=RequestMethod.GET)
	public String test() {
		return("Mother_Earth!");
	}
}
