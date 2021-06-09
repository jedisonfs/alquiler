package com.example.edu.compraventa.registration;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;

@Service
public class EmailValidator implements Predicate<String> {


    @Override
    public boolean test(String s) {
        //TODO ESTA BIEN CON REGEX
        return true;
    }
}
