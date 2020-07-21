package com.emmanuel.plumas.p7JavaLibrarEasyWEB.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emmanuel.plumas.p7JavaLibrarEasyWEB.model.BookEntity;
import com.emmanuel.plumas.p7JavaLibrarEasyWEB.model.BookEntityAvailable;
import com.emmanuel.plumas.p7JavaLibrarEasyWEB.proxies.BookProxy;

@Service
public class BookService {

	@Autowired
	private BookProxy bookProxy;
	
	public List<BookEntity> getAllBooks(){
		return bookProxy.getAllBooks();
	}

	public List<BookEntityAvailable> getBookByTitle(BookEntity bookEntity) {
		return bookProxy.getBooksByTitle(bookEntity.getBookTitle());
	}
	
	
	
}
