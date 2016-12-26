package org.jhy.grocerylist;

import javax.validation.Valid;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import java.util.*;

@Controller
@SpringBootApplication
public class GroceryListApplication {
	
	@Autowired
	GroceryListRepository repo;

	@RequestMapping(value="/", method = RequestMethod.GET)
	String home(ModelMap model){
		model.addAttribute("items",repo.findAll());
		model.addAttribute("insertItem", new GroceryList());
		return "grocerylist";
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public String insertData(ModelMap model, 
						@ModelAttribute("insertItem") @Valid GroceryList item, 
						BindingResult result){
		if (!result.hasErrors()) {
			repo.save(item);			
		}
		return home(model);
	}
	
	@RequestMapping(value="/item/{id}", method=RequestMethod.GET)
	public String deleteData(@PathVariable("id") Long id, ModelMap model){
		repo.delete(id);
		return home(model);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(GroceryListApplication.class, args);
	}
	
	/*
	@Bean
	InitializingBean saveData(GroceryListRepository rep){
		return () -> {
			rep.save(new GroceryList("apples"));
		};
	}
	*/
	
}
