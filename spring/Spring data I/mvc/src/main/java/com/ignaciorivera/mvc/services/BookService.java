package com.ignaciorivera.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ignaciorivera.mvc.models.Book;
import com.ignaciorivera.mvc.repositories.BookRepository;



@Service

public class BookService {
	
	private final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository=bookRepository;
	}
	
	  //Devolviendo todos los libros.
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    //Creando un libro.
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    //Obteniendo la información de un libro
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    
    //Actualizando un libro
    public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
    	
    	 Optional<Book> optionalBook = bookRepository.findById(id);
    	 if(optionalBook.isPresent()) {
    		Book book= optionalBook.get();
            book.setTitle(title);
            book.setDescription(desc);
            book.setLanguage(lang);
            book.setNumberOfPages(numOfPages);
            
            
            return bookRepository.save(book);
            
         }
    	 else {
    		 return null;
    	 }
    }
    
    //Borrar un libro
    public void deleteBook(Long id) {
    	bookRepository.deleteById(id);
    }

}
    
