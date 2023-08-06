package br.com.erudio.apigateway.repositories;

import br.com.erudio.apigateway.model.Book;
import br.com.erudio.apigateway.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
