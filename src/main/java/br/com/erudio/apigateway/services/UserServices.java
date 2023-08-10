package br.com.erudio.apigateway.services;

import br.com.erudio.apigateway.controller.PersonController;
import br.com.erudio.apigateway.exceptions.RequiredObjectIsNullException;
import br.com.erudio.apigateway.exceptions.ResourceNotFoundException;
import br.com.erudio.apigateway.mapper.DozerMapper;
import br.com.erudio.apigateway.mapper.custom.PersonMapper;
import br.com.erudio.apigateway.model.Person;
import br.com.erudio.apigateway.repositories.PersonRepository;
import br.com.erudio.apigateway.repositories.UserRepository;
import br.com.erudio.apigateway.vo.v1.PersonVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class UserServices implements UserDetailsService {

    private Logger logger = Logger.getLogger(UserServices.class.getName());

    @Autowired
    UserRepository repository;

    public UserServices(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("Finding one user by name!" + username + "!");
        var user = repository.findByUsername(username);
        if(user != null){

            return user;
        }else{
            throw new UsernameNotFoundException(""+ username + "Not found!");
        }
    }
}