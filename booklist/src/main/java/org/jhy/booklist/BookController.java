package org.jhy.booklist;

import java.util.List;
import java.util.Date;
import java.util.Calendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin // HY 02.09.17, for angular site on github to hit these REST api's
@CrossOrigin(origins = "https://jhubyoung.github.io")
@RestController
public class BookController{
	
	@Autowired
	BookRepository repo;

	@RequestMapping("/")
	String index(){
		return "hi there";
	}
	
	@RequestMapping(value="/allbooks",produces={MediaType.APPLICATION_JSON_UTF8_VALUE})
	public @ResponseBody List<Book> getBooks(){
		return repo.findAll();
	}
	
	@RequestMapping(value="/unreadbooks",produces={MediaType.APPLICATION_JSON_UTF8_VALUE})
	public @ResponseBody List<Book> getUnreadBooks(){
		return repo.findByRead(false);
	}

	@RequestMapping(value="/readbooks",produces={MediaType.APPLICATION_JSON_UTF8_VALUE})
	public @ResponseBody List<Book> getReadBooks(){
		return repo.findByRead(true);
	}
	
	// HY 02.12.2017
	//@RequestMapping(value="/addbook/{title}",produces={MediaType.APPLICATION_JSON_UTF8_VALUE})
	//public @ResponseBody List<Book> saveBook(@PathVariable("title") String title){
	@RequestMapping(value="/addbook",produces={MediaType.APPLICATION_JSON_UTF8_VALUE})
	public @ResponseBody List<Book> saveBook(@RequestParam("title") String title){
		repo.save(new Book(title));
		//return repo.findAll();
		return getUnreadBooks();
	}
	
	@RequestMapping(value="/deletebook/{bookID}",produces={MediaType.APPLICATION_JSON_UTF8_VALUE})
	public @ResponseBody List<Book> deleteBook(@PathVariable("bookID") Long bookID){
		repo.delete(bookID);
		//return repo.findAll();
		return getUnreadBooks();
	}
	
	@RequestMapping(value="/readbook/{bookID}",produces={MediaType.APPLICATION_JSON_UTF8_VALUE})
	public @ResponseBody List<Book> readBook(@PathVariable("bookID") Long bookID){
		Date today = Calendar.getInstance().getTime();
		Book b = repo.findOne(bookID);
		b.setRead(true);
		b.setDate(today);
		repo.save(b);
		//return repo.findAll();
		return getUnreadBooks();
	}
	
	/*
	@RequestMapping(value="/books",produces={MediaType.APPLICATION_JSON_UTF8_VALUE})
	public @ResponseBody List<Book> getBooks(){
		return repo.findAll();
	}
	*/
}