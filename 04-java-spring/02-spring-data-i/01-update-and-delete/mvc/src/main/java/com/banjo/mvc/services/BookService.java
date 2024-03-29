package com.banjo.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.banjo.mvc.models.Book;
import com.banjo.mvc.repositories.BookRepository;

@Service
public class BookService {
	private final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }    
    
    // updates a book
    public Book updateBook(Long id, String title, String desc, String lang, Integer pages) {
    	Book book = findBook(id);
    	book.setNumberOfPages(pages);
    	book.setTitle(title);
    	book.setLanguage(lang);
    	book.setDescription(desc);
    	return update(book);
    }
    
    public Book update(Book book) {
    	return bookRepository.save(book);
    }
    
    // deletes a book
    public void deleteBook(Long id) {
    	Book book = findBook(id);
    	bookRepository.delete(book);    	
    }

}
