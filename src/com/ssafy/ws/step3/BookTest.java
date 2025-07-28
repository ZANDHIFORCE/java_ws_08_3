package com.ssafy.ws.step3;

import java.util.Arrays;

/**
 * 도서 객체를 생성하고 정보를 출력하는 클래스
 */
public class BookTest {
	public static void main(String[] args) {
		
		IBookManager mgr =BookManagerImpl.getInstance();

		mgr.add(new Book("21424", "Java Pro", "김하나","jaen.kr",15000, "Java 기본문법"));
		mgr.add(new Book("21425", "Java Pro2", "김하나", "jaen.kr", 25000, "Java 응용"));
		mgr.add(new Book("35355", "분석설계", "소나무", "jaen.kr", 30000, "SW 모델링"));		
		mgr.add(new Magazine("45678", "월간 알고리즘", "홍길동", "jaen.kr", 10000, "7월 알고리즘",2025,7));		
		System.out.println("************ 도서 전체 목록 ************ ");
		Book [] books = mgr.getList();
		for(Book book: books)
			System.out.println(book); //book.toString() //implicity 객체대표문자열 toString()
		System.out.println("************ 일반 도서 목록 ************ ");
		books = mgr.getBooks();
		for(Book book: books)
			System.out.println(book);		
		System.out.println("************ 잡지 목록 ************ ");
		Magazine [] magazines = mgr.getMagazines();
		for(Magazine magazine: magazines)
			System.out.println(magazine);		
		
		System.out.println("************ 도서 제목 포함 검색: Java ************ ");
		books = mgr.searchByTitle("Java");
		for(Book book: books)
			System.out.println(book);
		System.out.printf("도서 가격 총합 : %d \n", mgr.getTotalPrice());
		System.out.println("도서 가격 평균 : "+ mgr.getPriceAvg());
		
		System.out.println("************ 도서 전체 목록 : 도서 제목 내림차순 정렬************ ");
		books = mgr.getList();
		Arrays.sort(books);
		for(Book book: books)
			System.out.println(book);
		
		System.out.println("************ 도서 전체 목록 : 도서 가격 오름차순 정렬************ ");
		books = mgr.getList();
		Arrays.sort(books, (book1, book2)-> Integer.compare(book1.getPrice(), book2.getPrice()));
		for(Book book: books)
			System.out.println(book);
	}
}
