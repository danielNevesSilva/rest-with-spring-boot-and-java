package br.com.erudio.apigateway.mapper.custom;

import br.com.erudio.apigateway.model.Person;
import br.com.erudio.apigateway.vo.v2.PersonVOV2;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonMapper {

    public PersonVOV2 convertEntityToVo(Person person){
        PersonVOV2 vo = new PersonVOV2();
        vo.setId(person.getId());
        vo.setAddress(person.getAddress());
        vo.setBirthDay(new Date());
        vo.setFirtName(person.getFirtName());
        vo.setLastName(person.getLastName());
        vo.setGender(person.getGender());
        return vo;
    }
    public Person convertVoToEntity(PersonVOV2 person){
        Person entity = new Person();
        entity.setId(person.getId());
        entity.setAddress(person.getAddress());
       // entity.setBirthDay(new Date());
        entity.setFirtName(person.getFirtName());
        entity.setLastName(person.getLastName());
        entity.setGender(person.getGender());
        return entity;
    }

}
