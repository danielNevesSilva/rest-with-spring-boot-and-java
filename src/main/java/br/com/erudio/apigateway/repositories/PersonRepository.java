package br.com.erudio.apigateway.repositories;

import br.com.erudio.apigateway.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository  extends JpaRepository<Person, Long> {
}
