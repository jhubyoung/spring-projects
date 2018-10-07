package org.jhy.booklist;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BooklistApplication {

	/*
	@Bean
	InitializingBean saveData(BookRepository repo){
		return()->{
			repo.save(new Book("Think Like a Freak"));
			repo.save(new Book("Learning AngularJS"));
			repo.save(new Book("The Voyage of the Dawn Treader"));
		};
	}
	*/

	public static void main(String[] args) {
		SpringApplication.run(BooklistApplication.class, args);
	}
}
