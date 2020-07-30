package com.emmanuel.plumas.p7JavaLibrarEasyWEB.proxies;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.emmanuel.plumas.p7JavaLibrarEasyWEB.model.BookEntityAvailable;
import com.emmanuel.plumas.p7JavaLibrarEasyWEB.model.BookEntity;


@FeignClient(name="p7JavaLibrarEasy-API1",url="localhost:9001")
@Qualifier("BookProxy")
public interface BookProxy {
	
	
	
	@GetMapping(value="books")
	List<BookEntity> getAllBooks();
	
	/*
	@GetMapping(value="book/{bookId}")
	BookEntity getBooksById(@PathVariable("bookId") Long bookId);
	*/
	
	@GetMapping(value="book/{bookTitle}")
	List<BookEntityAvailable> getBooksByTitle(@PathVariable String bookTitle);

}
