package com.agendapp;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) {
        Person persona = new Person("Carlos", 30, "ana@gmail.com");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File("persona.json"), persona);
            System.out.println("Objeto guardado en JSON.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}  