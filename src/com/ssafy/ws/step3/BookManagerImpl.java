package com.ssafy.ws.step3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Iterator;

public class BookManagerImpl implements IBookManager{
	
	private static IBookManager isntance;
	List<Book> books = new ArrayList<>();
	
	private BookManagerImpl() {
		
	}
	
	public static IBookManager getInstance(){
		if(isntance==null)
			isntance = new BookManagerImpl();
		return isntance;
	}

	@Override
	public void add(Book book) {
		// TODO Auto-generated method stub
		for(Book b:books) {
			if(b.getIsbn().equals(book.getIsbn()))
				return;
		}
		books.add(book);
	}

	@Override
	public void remove(String isbn) {
		// TODO Auto-generated method stub
		Iterator<Book> iter = books.iterator();
		while(iter.hasNext()) {
			Book book = iter.next();
			if(book.getIsbn().equals(isbn)) {
				iter.remove();
				break;
			}
		}
	}

	@Override
	public Book[] getList() {
		return books.toArray(new Book[books.size()]);
	}

	@Override
	public Book searchByIsbn(String isbn) {
		Iterator<Book> iter = books.iterator();
		while(iter.hasNext()) {
			Book b = iter.next();
			if(b.getIsbn().equals(isbn))
				return b;
		}
		return null;
	}

	@Override
	public Book[] searchByTitle(String title) {
		List<Book> bs = new ArrayList<>();
		Iterator<Book> iter = books.iterator();
		while(iter.hasNext()) {
			Book b = iter.next();
			if(b.getTitle().equals(title))
				bs.add(b);
		}
		return bs.toArray(new Book[bs.size()]);
	}

	@Override
	public Magazine[] getMagazines() {
		List<Magazine> ms = new ArrayList<>();
		Iterator<Book> iter = books.iterator();
		while(iter.hasNext()) {
			Book b = iter.next();
			if(b instanceof Magazine m)
				ms.add(m);
		}
		return ms.toArray(new Magazine[ms.size()]);
	}

	@Override
	public Book[] getBooks() {
		List<Book> bs = new ArrayList<>();
		Iterator<Book> iter = books.iterator();
		while(iter.hasNext()) {
			Book b = iter.next();
			if(!(b instanceof Magazine))
				bs.add(b);
		}
		return bs.toArray(new Book[bs.size()]);
	}

	@Override
	public int getTotalPrice() {
		Iterator<Book> iter = books.iterator();
		int total = 0;
		while(iter.hasNext()) {
			Book b = iter.next();
			total+=b.getPrice();
		}
		return total;
	}

	@Override
	public double getPriceAvg() {
		
		return this.getTotalPrice()/(double)this.books.size();
	}

	@Override
	public void sortByIsbnAsc() {
		Collections.sort(books, (a,b)->a.getIsbn().compareTo(b.getIsbn()));
	}

	@Override
	public void sortByIsbnDesc() {
		Collections.sort(books, (a,b)->-1*a.getIsbn().compareTo(b.getIsbn()));
	}

	@Override
	public void sortByTitleAsc() {
		Collections.sort(books, (a,b)->a.getTitle().compareTo(b.getTitle()));
	}

	@Override
	public void sortByTitleDesc() {
		Collections.sort(books, (a,b)->-1*a.getTitle().compareTo(b.getTitle()));
	}

	@Override
	public void sortByPriceAsc() {
		Collections.sort(books, (a,b)->a.getPrice()-b.getPrice());
	}

	@Override
	public void sortByPriceDesc() {
		Collections.sort(books, (a,b)->b.getPrice()-a.getPrice());
	}

	
}