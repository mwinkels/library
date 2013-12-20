package nl.maartenwinkels.library.books.resources.impl;

import java.util.List;

import javax.ws.rs.PathParam;

import nl.maartenwinkels.library.books.dao.BookRepository;
import nl.maartenwinkels.library.books.model.Book;
import nl.maartenwinkels.library.books.resources.BooksResource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BooksResourceImpl implements BooksResource {
	
	@Autowired
	private BookRepository bookRepository;
	
	public List<Book> all() {
		return bookRepository.all();
	}
	
	public Book create(Book book) {
		return bookRepository.save(book);
	}
	
	public BookResource book(@PathParam("id") Long id) {
		return new BookResourceImpl(id);
	}
	
	public class BookResourceImpl implements BookResource {

		private Long id;

		public BookResourceImpl(Long id) {
			this.id = id;
		}
		
		public Book get() {
			return bookRepository.get(id);
		}
		
		public Book update(Book book) {
			// Force id.
			book.setId(id);
			return bookRepository.save(book);
		}
		
		public Book delete() {
			return bookRepository.delete(id);
		}
		
	}
}
