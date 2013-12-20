package nl.maartenwinkels.library.books.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import nl.maartenwinkels.library.books.dao.BookRepository;
import nl.maartenwinkels.library.books.model.Book;

@Component("bookRepositoryMemoryImpl")
public class BookRepositoryMemoryImpl implements BookRepository {
	
	private final Map<Long, Book> books = new HashMap<>();
	
	private long nextId = 1;

	@Override
	public List<Book> all() {
		return new ArrayList<>(books.values());
	}

	@Override
	public Book get(Long id) {
		return books.get(id);
	}

	@Override
	public Book delete(Long id) {
		return books.remove(id);
	}

	@Override
	public Book save(Book book) {
		if (book.getId() == null) {
			book.setId(nextId++);
		} else {
			if (book.getId() >= nextId) {
				nextId = book.getId() + 1;
			}
		}
		books.put(book.getId(), book);
		return book;
	}

}
