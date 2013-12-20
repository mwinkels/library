package nl.maartenwinkels.library.books.resources;

import java.util.List;

import javax.ws.rs.*;

import nl.maartenwinkels.library.books.model.Book;

import org.springframework.security.access.prepost.PreAuthorize;

@Path("books")
@Consumes("application/json")
@Produces("application/json")
public interface BooksResource {

	@GET
	List<Book> all();

	@POST
	@PreAuthorize("hasRole('BookAdmin')")
	Book create(Book book);

	@PathParam("{id}")
	BookResource book(@PathParam("id") Long id);

	interface BookResource {

		@GET
		Book get();

		@PUT
		@PreAuthorize("hasRole('BookAdmin')")
		Book update(Book book);

		@DELETE
		@PreAuthorize("hasRole('BookAdmin')")
		Book delete();

	}
}