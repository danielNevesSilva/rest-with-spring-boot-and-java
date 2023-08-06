package br.com.erudio.apigateway.services;

import br.com.erudio.apigateway.controller.BookController;
import br.com.erudio.apigateway.exceptions.RequiredObjectIsNullException;
import br.com.erudio.apigateway.exceptions.ResourceNotFoundException;
import br.com.erudio.apigateway.mapper.DozerMapper;
import br.com.erudio.apigateway.model.Book;
import br.com.erudio.apigateway.repositories.BookRepository;
import br.com.erudio.apigateway.vo.v1.BookVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class BookServices {

    private Logger logger = Logger.getLogger(BookServices.class.getName());


    @Autowired
    BookRepository repository;
    public List<BookVO> findAll() {

        logger.info("Finding all book!");

        var Books = DozerMapper.parseListObjects(repository.findAll(), BookVO.class);
        Books.stream().forEach(p ->p.add(linkTo(methodOn(BookController.class).findById(p.getKey())).withSelfRel()));
        return Books;
    }

    public BookVO findById(Long id) {

        logger.info("Finding one Book!");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        var vo = DozerMapper.parseObject(entity, BookVO.class);
        vo.add(linkTo(methodOn(BookController.class).findById(id)).withSelfRel());
        return vo;
    }

    public BookVO create(BookVO Book) {

        if(Book == null) throw new RequiredObjectIsNullException();
        logger.info("Creating one Book!");
        var entity = DozerMapper.parseObject(Book, Book.class);
        var vo =  DozerMapper.parseObject(repository.save(entity), BookVO.class);
        vo.add(linkTo(methodOn(BookController.class).findById(vo.getKey())).withSelfRel());
        return vo;
    }


    public BookVO update(BookVO Book) {

        if(Book == null) throw new RequiredObjectIsNullException();
        logger.info("Updating one Book!");

        var entity = repository.findById(Book.getKey())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setAuthor(Book.getAuthor());
        entity.setLaunch_date(Book.getLaunch_date());
        entity.setPrice(Book.getPrice());
        entity.setTitle(Book.getTitle());

        var vo =  DozerMapper.parseObject(repository.save(entity), BookVO.class);
        vo.add(linkTo(methodOn(BookController.class).findById(vo.getKey())).withSelfRel());
        return vo;
    }

    public void delete(Long id) {

        logger.info("Deleting one Book!");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        repository.delete(entity);
    }
}