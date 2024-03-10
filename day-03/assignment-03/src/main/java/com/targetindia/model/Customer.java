package com.targetindia.model;

import com.targetindia.exceptions.*;
import com.targetindia.utils.EmailValidator;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Customer {
    private int id;
    private String name;
    private String city;
    private String email;
    private String number;

    public Customer(int id, String name, String city, String email, String number) {
        setId(id);
        setName(name);
        setCity(city);
        setEmail(email);
        setNumber(number);
    }

    public void setId(int id) throws InvalidIdException {
        if(id < 0) {
            throw new InvalidIdException("Id must be >= 0.");
        }

        this.id = id;
    }

    public void setName(String name) throws InvalidNameException {
        if(name == null) {
            throw new InvalidNameException("Name cannot be null.");
        }

        name = name.trim();

        if(name.isEmpty()) {
            throw new InvalidNameException("Name cannot be blank.");
        }

        if(name.length() < 3 || name.length() > 25) {
            throw new InvalidNameException("Length of name must be between 3 and 25 characters.");
        }

        this.name = name;
    }

    public void setCity(String city) throws InvalidCityException {
        if(city == null) {
            throw new InvalidCityException("City cannot be null.");
        }

        city = city.trim();

        if(city.isEmpty()) {
            throw new InvalidCityException("City cannot be blank.");
        }

        if(city.length() < 3 || city.length() > 25) {
            throw new InvalidCityException("Length of city must be between 3 and 25 characters.");
        }

        this.city = city;
    }

    public void setEmail(String email) throws InvalidEmailException {
        if(email == null) {
            throw new InvalidEmailException("Email cannot be null.");
        }

        email = email.trim();

        if(email.isEmpty()) {
            throw new InvalidEmailException("Email cannot be blank.");
        }

        if(!EmailValidator.isValidEmail(email)) {
            throw new InvalidEmailException("Entered email is not a valid email id.");
        }

        this.email = email;
    }

    public void setNumber(String number) throws InvalidNumberException {
        if(number == null) {
            throw new InvalidNumberException("number cannot be null.");
        }

        number = number.trim();

        if(number.length() != 10) {
            throw new InvalidNumberException("Length of number must be 10 characters.");
        }

        this.number = number;
    }
}
