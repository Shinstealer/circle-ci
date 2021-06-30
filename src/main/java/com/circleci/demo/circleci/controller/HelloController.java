package com.circleci.demo.circleci.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HelloController {

  @GetMapping("/")
	private String root() {
		return "403";
	}

  @GetMapping("/main")
  public String mainPage() {
    return "main";
  }

  @GetMapping("/hello")
  public String hello() {
    return "hello";
  }

}
