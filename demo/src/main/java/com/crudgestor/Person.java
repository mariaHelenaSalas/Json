
package com.crudgestor;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person implements Serializable{
    private static final long serialVersionUID = 1L;

    @JsonProperty("nombre")
    private String nombre;

    @JsonProperty("telefono")
    private String telefono;

    @JsonProperty("email")
    private String email;

    public Person() {}

    public Person(String nombre, String telefono, String email) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        
        return "Nombre: " + nombre + " | Teléfono: " + telefono + " | Email: " + email;
    }
    
}
