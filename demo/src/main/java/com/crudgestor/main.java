package com.crudgestor;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        PersonService servicio = new PersonService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("GESTIÓN DE PERSONAS");
            System.out.println("1. Agregar persona");
            System.out.println("2. Listar personas");
            System.out.println("3. Actualizar persona");
            System.out.println("4. Eliminar persona");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Teléfono: ");
                    String telefono = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    servicio.crearPerson(nombre, telefono, email);
                    break;

                case 2:
                    servicio.listarPersons();
                    break;

                case 3:
                    System.out.print("ID de la persona a actualizar: ");
                    int idActualizar = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nuevo nombre: ");
                    String nuevoNombre = scanner.nextLine();
                    System.out.print("Nuevo teléfono: ");
                    String nuevoTelefono = scanner.nextLine();
                    System.out.print("Nuevo email: ");
                    String nuevoEmail = scanner.nextLine();
                    servicio.actualizarPerson(idActualizar, nuevoNombre, nuevoTelefono, nuevoEmail);
                    break;

                case 4:
                    System.out.print("ID de la persona a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    servicio.eliminarPerson(idEliminar);
                    break;

                case 5:
                    System.out.println("👋 Saliendo del sistema...");
                    scanner.close();
                    return;

                default:
                    System.out.println("⚠️ Opción no válida.");
            }
        }
    }

}
