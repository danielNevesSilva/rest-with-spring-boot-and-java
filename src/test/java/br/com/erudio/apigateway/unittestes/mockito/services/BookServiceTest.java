package br.com.erudio.apigateway.unittestes.mockito.services;

import br.com.erudio.apigateway.exceptions.RequiredObjectIsNullException;
import br.com.erudio.apigateway.model.Book;
import br.com.erudio.apigateway.repositories.BookRepository;
import br.com.erudio.apigateway.services.BookServices;
import br.com.erudio.apigateway.unittestes.mapper.mocks.MockBook;
import br.com.erudio.apigateway.vo.v1.BookVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    MockBook input;

    @InjectMocks
    private BookServices service;

    @Mock
    BookRepository repository;

    @BeforeEach
    void setUpMocks() throws Exception {
        input = new MockBook();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindById() {
        Book entity = input.mockEntity(1);
        entity.setId(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(entity));

        var result = service.findById(1L);
        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());

        assertTrue(result.toString().contains("links: [</api/Book/v1/1>;rel=\"self\"]"));
        assertEquals("Author Test", result.getAuthor());
        assertEquals("Title Name Test", result.getTitle());
        assertEquals(25D, result.getPrice());
        assertNotNull( result.getLaunch_date());
    }

    @Test
    void testCreate() {
        Book entity = input.mockEntity(1);
        entity.setId(1L);

        Book persisted = entity;
        persisted.setId(1L);

        BookVO vo = input.mockVO(1);
        vo.setKey(1L);

        when(repository.save(entity)).thenReturn(persisted);

        var result = service.create(vo);

        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());

        assertTrue(result.toString().contains("links: [</api/Book/v1/1>;rel=\"self\"]"));
        assertEquals("Author Test", result.getAuthor());
        assertEquals("Title Name Test", result.getTitle());
        assertEquals(25D, result.getPrice());
        assertNotNull( result.getLaunch_date());
    }

    @Test
    void testCreateWithNullBook() {
        Exception exception = assertThrows(RequiredObjectIsNullException.class, () -> {
            service.create(null);
        });

        String expectedMessage = "It is not allowed to persist a null object!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }


    @Test
    void testUpdate() {
        Book entity = input.mockEntity(1);

        Book persisted = entity;
        persisted.setId(1L);

        BookVO vo = input.mockVO(1);
        vo.setKey(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(entity));
        when(repository.save(entity)).thenReturn(persisted);

        var result = service.update(vo);

        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());

        assertTrue(result.toString().contains("links: [</api/Book/v1/1>;rel=\"self\"]"));
        assertEquals("Author Test", result.getAuthor());
        assertEquals("Title Name Test", result.getTitle());
        assertEquals(25D, result.getPrice());
        assertNotNull( result.getLaunch_date());
    }


    @Test
    void testUpdateWithNullBook() {
        Exception exception = assertThrows(RequiredObjectIsNullException.class, () -> {
            service.update(null);
        });

        String expectedMessage = "It is not allowed to persist a null object!";
        String actualMessage = exception.getMessage();

        assertFalse(actualMessage.contains(expectedMessage));
    }

    @Test
    void testDelete() {
        Book entity = input.mockEntity(1);
        entity.setId(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(entity));

        service.delete(1L);
    }

    @Test
    void testFindAll() {
        List<Book> list = input.mockEntityList();

        when(repository.findAll()).thenReturn(list);

        var people = service.findAll();

        assertNotNull(people);
        assertEquals(14, people.size());

        var BookOne = people.get(1);

        assertNotNull(BookOne);
        assertNotNull(BookOne.getKey());
        assertNotNull(BookOne.getLinks());

        assertTrue(BookOne.toString().contains("links: [</api/Book/v1/1>;rel=\"self\"]"));
        assertEquals("Author Test1", BookOne.getAuthor());
        assertEquals("Title Name Test1", BookOne.getTitle());
        assertEquals(25D, BookOne.getPrice());
        assertNotNull( BookOne.getLaunch_date());

        var BookFour = people.get(4);

        assertNotNull(BookFour);
        assertNotNull(BookFour.getKey());
        assertNotNull(BookFour.getLinks());

        assertTrue(BookFour.toString().contains("links: [</api/Book/v1/4>;rel=\"self\"]"));
        assertEquals("Author Test4", BookOne.getAuthor());
        assertEquals("Title Name Test4", BookOne.getTitle());
        assertEquals(25D, BookOne.getPrice());
        assertNotNull( BookOne.getLaunch_date());

        var BookSeven = people.get(7);

        assertNotNull(BookSeven);
        assertNotNull(BookSeven.getKey());
        assertNotNull(BookSeven.getLinks());

        assertTrue(BookSeven.toString().contains("links: [</api/Book/v1/7>;rel=\"self\"]"));
        assertEquals("Author Test7", BookOne.getAuthor());
        assertEquals("Title Name Test7", BookOne.getTitle());
        assertEquals(25D, BookOne.getPrice());
        assertNotNull( BookOne.getLaunch_date());

    }
}