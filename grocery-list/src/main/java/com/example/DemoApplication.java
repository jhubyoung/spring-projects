package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import java.util.*;

@Controller
@SpringBootApplication
public class DemoApplication {

	@RequestMapping("/")
	// @ResponseBody
	String home(Model model){
		//return "hello there";
		List items = new ArrayList();
		// items = {"bananas","salmon","yogurt"};
		items.add("salmon");
		items.add("yogurt");
		items.add("dog shampoo");
		model.addAttribute("items",items);
		return "grocerylist";
	}
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
