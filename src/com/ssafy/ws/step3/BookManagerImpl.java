package com.ssafy.ws.step3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 도서리스트를 배열로 유지하며 관리하는 클래스
 */
public class BookManagerImpl implements IBookManager{ //extends Object
//	private final static int  MAX_SIZE = 100;
//	private Book [] books;
	private List<Book> books;
//	private int size;
	private static IBookManager instance =new BookManagerImpl();
	
	/**
	 * books 배열 생성 및 초기화 -> List 객체로 수정
	 */
	private BookManagerImpl() {
//		books = new Book[MAX_SIZE];
		books = new ArrayList<>();
	}

	public static IBookManager getInstance() {
		return instance;
	}
	/**
	 * books배열에 book 등록 -> books 자료구조에 book 등록
	 * @param book
	 */
	@Override
	public void add(Book book) {
//		books[size++] = book;
		books.add(book);
	}
	
	/**
	 * books배열에서 isbn 찾아서 삭제
	 * @param isbn
	 */
	
	@Override
	public void remove(String isbn) {
//		for(int i=0; i < size; i++) {
//			if(books[i].getIsbn().equals(isbn)) {
//				books[i] = books[size-1]; //배열의 마지막 ref를 삭제할 위치에 할당
//				books[size-1] = null;	  //마지막 ref null 할당	
//				size--;					  // index 감소
//			    break;	
//			}
//		}
		
		for(int i=0; i <books.size(); i++) {
			if(books.get(i).getIsbn().equals(isbn)) {
				books.remove(i);
				break;
			}
		}
	}
	
	/**
	 * 도서목록 리턴
	 * @return books : Book[]
	 */
	public Book[] getList() {
		Book[] result = new Book[books.size()];
		
		return books.toArray(result);
	}
	
	/**
	 * 도서배열에서 isbn 검색해서 리턴
	 * @param isbn
	 * @return book:Book
	 */
	@Override
	public Book searchByIsbn(String isbn) {
//		for(int i=0; i < size; i++) {
//			if(books[i].getIsbn().equals(isbn)) 
//				return books[i];
//		}
		for(int i=0; i <books.size(); i++) {
			if(books.get(i).getIsbn().equals(isbn)) {
				return books.get(i);
			}
		}
		
		return null;
	}
	/**
	 * 도서제목 검색
	 * @param title
	 * @return
	 */
	@Override
	public Book[] searchByTitle(String title) {
//		int count=0; //local variable은 명시적으로 초기화 필요
//		for(int i=0; i < size; i++) {
//			if(books[i].getTitle().contains(title))
//				count++;
//		}
//		
//		Book [] result = new Book[count];
//		count=0;
//		for(int i=0; i < size; i++) {
//			if(books[i].getTitle().contains(title))
//					result[count++] = books[i];
//		}	
		List<Book> result = new ArrayList<>();
		for(int i=0; i <books.size(); i++) {
			if(books.get(i).getTitle().contains(title)) {
				result.add(books.get(i));
			}
		}
		Book [] bookList = new Book[result.size()];
		return result.toArray(bookList);
	}
	/**
	 * 잡지 목록
	 * @return
	 */
	@Override
	public Magazine[] getMagazines() {
//		int count=0; //local variable은 명시적으로 초기화 필요
//		for(int i=0; i < size; i++) {
//			if(books[i] instanceof Magazine)
//					count++;
//		}
//		Magazine []result = new Magazine[count];
//		count=0;
//		for(int i=0; i < size; i++) {
//			if(books[i] instanceof Magazine) 
//					result[count] =(Magazine)books[i] ; //cast down-명시적 타입 캐스팅
//			
//		}
		List<Magazine> result = new ArrayList<>();
		for(int i=0; i <books.size(); i++) {
			if(books.get(i) instanceof Magazine) {
				result.add((Magazine)books.get(i));
			}
		}		
		Magazine [] magazineList = new Magazine[result.size()];
		return result.toArray(magazineList);
	}
	/**
	 * 잡지를 제외한 도서목록
	 * @return
	 */
	@Override
	public Book[] getBooks() {
//		int count=0; //local variable은 명시적으로 초기화 필요
//		for(int i=0; i < size; i++) {
//			if(!(books[i] instanceof Magazine))
//					count++;
//		}
//		Book []result = new Book[count];
//		count=0;
//		for(int i=0; i < size; i++) {
//			if(!(books[i] instanceof Magazine) )
//					result[count++] =books[i] ; 
//			
//		}	
		List<Book> result = new ArrayList<>();
		for(int i=0; i <books.size(); i++) {
			if(!(books.get(i) instanceof Magazine)) {
				result.add(books.get(i));
			}
		}		
		Book [] bookList = new Book[result.size()];
		return result.toArray(bookList);
	}
	/**
	 * 도서 총 가격
	 */
	@Override
	public int getTotalPrice() {
		int totalPrice=0;
//		for(int i=0; i < size; i++) {
//			totalPrice += books[i].getPrice();
//		}
		for(int i=0; i < books.size(); i++)
			totalPrice += books.get(i).getPrice();
		
		return totalPrice;
	}
	/**
	 * 도서 평균 가격
	 */
	@Override
	public double getPriceAvg() {
		return getTotalPrice()/books.size();
	}
}



















