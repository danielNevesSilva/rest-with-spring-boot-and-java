package br.com.erudio.apigateway.vo.v2;

import java.util.Date;
import java.util.Objects;


public class PersonVOV2 {

    private Long id;
    private String firtName;
    private String lastName;
    private String address;
    private String gender;

    private Date birthDay;

    public PersonVOV2(){}

    public PersonVOV2(Long id, String firtName, String lastName, String address, String gender) {
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

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonVOV2 personVO = (PersonVOV2) o;
        return Objects.equals(id, personVO.id) && Objects.equals(firtName, personVO.firtName) && Objects.equals(lastName, personVO.lastName) && Objects.equals(address, personVO.address) && Objects.equals(gender, personVO.gender) && Objects.equals(birthDay, personVO.birthDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firtName, lastName, address, gender, birthDay);
    }
}
