package nl.maartenwinkels.library.books.dao;

import java.util.List;

import nl.maartenwinkels.library.books.model.Book;

public interface BookRepository {

	List<Book> all();
	
	Book get(Long id);
	
	Book delete(Long id);
	
	Book save(Book book);
}
