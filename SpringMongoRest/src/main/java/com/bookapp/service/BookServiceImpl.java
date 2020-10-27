package com.bookapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookapp.dao.BookRepository;
import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;


@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookRepository bookRepository;
	
	@Override
	public Book addBook(Book book) {
	  Book newbook = bookRepository.save(book);
		return newbook;
	}

	
	@Override
	public boolean deleteBook(Integer bookid) throws BookNotFoundException {
		bookRepository.deleteById(bookid);
		return true;
	}

	@Override
	public Book getBookById(Integer bookid) throws BookNotFoundException {
		return bookRepository.findById(bookid)
		.orElseThrow(()->new BookNotFoundException("id not available"));
		
	}

	@Override
	public Book updateBook(Book book) {
		
		return bookRepository.save(book);
	}

	@Override
	public List<Book> getAllBooks() {
		
		return bookRepository.findAll();
	}

	@Override
	public List<Book> getBookByAuthor(String author) throws BookNotFoundException {
		List<Book> bookList= bookRepository.findByAuthor(author);
		if(bookList.isEmpty()) {
			throw new BookNotFoundException("Author not available");
		}
		return bookList;
	}

	private List<Book> isEmpty() {
		// TODO Auto-generated method stub
		return null;
	}


	private void findByAuthor(String author) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<Book> getBookByCategory(String category) throws BookNotFoundException {
		
		List<Book> bookList= bookRepository.findByCategoryOrderByTitleAsc(category);
		if(bookList.isEmpty()) {
			throw new BookNotFoundException("Category  not available");
		}
		return bookList;
	}


	@Override
	public List<Book> findByTitleAndAuthor(String title, String author) {
		// TODO Auto-generated method stub
		return bookRepository.findByTitleAndAuthor(title, author);
	}


	@Override
	public List<Book> findByTitleAndPrice(String title, Double price) {
		
		return bookRepository.findByTitleAndPrice(title, price);
	}

}
