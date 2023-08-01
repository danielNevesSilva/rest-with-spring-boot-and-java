package br.com.eudio.apigateway.repositories;

import br.com.eudio.apigateway.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository  extends JpaRepository<Person, Long> {
}
