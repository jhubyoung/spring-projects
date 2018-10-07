package org.jhy.booklist;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface BookRepository extends JpaRepository<Book,Long>{
	List<Book> findByTitleContaining(@Param("word") String word);
	List<Book> findByRead(boolean read);
}