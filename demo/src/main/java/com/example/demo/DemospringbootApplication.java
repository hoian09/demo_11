package com.example.demo;

import com.example.demo.demo1.entity.BookEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class DemospringbootApplication {
	static String url = "http://localhost:8085/book";
	public static void main(String[] args) {
		SpringApplication.run(DemospringbootApplication.class, args);
		printAllBook();
		insertNewBook();
		updateExistingBook();
		deleteBook();
	}
	static void printAllBook() {
		RestTemplate restTemplate = new RestTemplate();
		BookEntity[] bookArray = restTemplate.getForObject(url, BookEntity[].class);
		List<BookEntity> bookEntityList = Arrays.asList(bookArray);
		System.out.println("Fetched" + bookEntityList.size() + "from REST API");
		for (BookEntity book: bookEntityList){
			System.out.println(book.getName() + "of" + book.getAuthor());
		}
	}
	static void insertNewBook() {
		RestTemplate restTemplate = new RestTemplate();
		BookEntity newBook = new BookEntity();
		newBook.setId(9);
		newBook.setName("Roz A-Z");
		newBook.setAuthor("Eric");
		newBook.setPrice(12.3);
		BookEntity result = restTemplate.postForObject(url, newBook, BookEntity.class);
		System.out.println("A new book named : '" + result.getName() + "'has been inserted successfully.");
	}
	static void updateExistingBook() {
		RestTemplate restTemplate = new RestTemplate();
		BookEntity updatedBook = new BookEntity();
		updatedBook.setId(1);
		updatedBook.setName("RoR A-Z");
		updatedBook.setAuthor("Markus");
		updatedBook.setPrice(99.9);
		restTemplate.put(url, updatedBook);
	}
	static void deleteBook(){
		RestTemplate restTemplate = new RestTemplate();
		String bookID = "1";
		String deleteURL = url + "/" + bookID;
		restTemplate.delete(deleteURL);
	}
}
