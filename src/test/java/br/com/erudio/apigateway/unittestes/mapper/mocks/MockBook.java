package br.com.erudio.apigateway.unittestes.mapper.mocks;

import br.com.erudio.apigateway.model.Book;
import br.com.erudio.apigateway.vo.v1.BookVO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MockBook {


    public Book mockEntity() {
        return mockEntity(0);
    }

    public BookVO mockVO() {
        return mockVO(0);
    }

    public List<Book> mockEntityList() {
        List<Book> Books = new ArrayList<Book>();
        for (int i = 0; i < 14; i++) {
            Books.add(mockEntity(i));
        }
        return Books;
    }

    public List<BookVO> mockVOList() {
        List<BookVO> Books = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            Books.add(mockVO(i));
        }
        return Books;
    }

    public Book mockEntity(Integer number) {
        Book Book = new Book();
        Book.setId(number.longValue());
        Book.setAuthor("Author Test" + number);
        Book.setLaunch_date(new Date());
        Book.setTitle("Title Name Test" + number);
        Book.setPrice(25D);
        return Book;
    }

    public BookVO mockVO(Integer number) {
        BookVO Book = new BookVO();
        Book.setKey(number.longValue());
        Book.setAuthor("Author Test" + number);
        Book.setLaunch_date(new Date());
        Book.setPrice(25D);
        Book.setTitle("Last Name Test" + number);
        return Book;
    }
}
