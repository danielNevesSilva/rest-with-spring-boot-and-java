package br.com.eudio.apigateway.vo.v1;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;


public class PersonVO {

    private Long id;
    private String firtName;
    private String lastName;
    private String address;
    private String gender;

    public PersonVO(){}

    public PersonVO(Long id, String firtName, String lastName, String address, String gender) {
        this.id = id;
        this.firtName = firtName;
        this.lastName = lastName;
        this.address = address;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirtName() {
        return firtName;
    }

    public void setFirtName(String firtName) {
        this.firtName = firtName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonVO PersonVO = (PersonVO) o;
        return Objects.equals(id, PersonVO.id) && Objects.equals(firtName, PersonVO.firtName) && Objects.equals(lastName, PersonVO.lastName) && Objects.equals(address, PersonVO.address) && Objects.equals(gender, PersonVO.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firtName, lastName, address, gender);
    }
}
