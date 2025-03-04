package com.crudgestor;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.agendapp.Person;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PersonService {
    private static final String FILE_PATH = "persons.json";
    private Map<Integer, Person> persons;
    private ObjectMapper objectMapper;

    public PersonService() {
        objectMapper = new ObjectMapper();
        persons = cargarPersons();
    }

    // 🔹 Cargar personas desde JSON
    private Map<Integer, Person> cargarPersons() {
        try {
            File file = new File(FILE_PATH);
            if (!file.exists()) return new HashMap<>();
            return objectMapper.readValue(file, new TypeReference<Map<Integer, Person>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return new HashMap<>();
        }
    }

    // 🔹 Guardar la lista en JSON
    private void guardarPersons() {
        try {
            objectMapper.writeValue(new File(FILE_PATH), persons);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 🔹 Crear una nueva persona
    public void crearPerson(String nombre, String telefono, String email) {
        int id = (persons.isEmpty()) ? 1 : persons.keySet().stream().max(Integer::compare).orElse(0) + 1;
        Person nuevaPerson = new Person(nombre, telefono, email);
        persons.put(id, nuevaPerson);
        guardarPersons();
        System.out.println("✅ Persona agregada con ID: " + id);
    }

    // 🔹 Leer todas las personas
    public void listarPersons() {
        if (persons.isEmpty()) {
            System.out.println("📂 No hay personas disponibles.");
            return;
        }
        persons.forEach((id, person) -> System.out.println("ID: " + id + " | " + person));
    }

    // 🔹 Buscar una persona por ID
    public Person buscarPerson(int id) {
        return persons.get(id);
    }

    // 🔹 Actualizar una persona
    public void actualizarPerson(int id, String nombre, String telefono, String email) {
        if (persons.containsKey(id)) {
            Person person = persons.get(id);
            person.setNombre(nombre);
            person.setTelefono(telefono);
            person.setEmail(email);
            guardarPersons();
            System.out.println("✅ Persona actualizada.");
        } else {
            System.out.println("⚠️ Persona no encontrada.");
        }
    }

    // 🔹 Eliminar una persona
    public void eliminarPerson(int id) {
        if (persons.remove(id) != null) {
            guardarPersons();
            System.out.println("🗑 Persona eliminada.");
        } else {
            System.out.println("⚠️ Persona no encontrada.");
        }
    }

}
