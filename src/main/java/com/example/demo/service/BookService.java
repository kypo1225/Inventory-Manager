package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Book;
import com.example.demo.repository.BookRepository;


@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;
	
	public List<Book> findAll(){
		return bookRepository.findAll();
	}
	public Book findOne(Long id) {
		// Optionalを返す為、取得できなかった場合の処理`.orElse(null)`を追加
		return bookRepository.findById(id).orElse(null);
	}
	
	public Book save(Book book) {
		return bookRepository.save(book);
	}
	
	public void delete(Long id) {
		bookRepository.deleteById(id);
	}
	
	

}
