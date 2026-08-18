package com.mycompany;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Cliente> clientes = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Sistema de Biblioteca - Gestión de Clientes");
    }


    public static void crearCliente() {
        System.out.println("\n--- CREAR CLIENTE ---");
        System.out.print("ID: ");
        String id = sc.nextLine();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Teléfono: ");
        String telefono = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();

        Cliente nuevo = new Cliente(id, nombre, telefono, email);
        clientes.add(nuevo);
        System.out.println("Cliente registrado exitosamente.");
    }

    public static void listarClientes() {
        System.out.println("\n--- LISTA DE CLIENTES ---");
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }
        for (Cliente c : clientes) {
            System.out.println(c);
        }
    }

    public static void buscarCliente() {
        System.out.println("\n--- BUSCAR CLIENTE ---");
        System.out.print("Ingrese el ID del cliente: ");
        String id = sc.nextLine();
        for (Cliente c : clientes) {
            if (c.getId().equals(id)) {
                System.out.println("Cliente encontrado: " + c);
                return;
            }
        }
        System.out.println("Cliente no encontrado.");
    }

    public static void actualizarCliente() {
        System.out.println("\n--- ACTUALIZAR CLIENTE ---");
        System.out.print("Ingrese el ID del cliente a actualizar: ");
        String id = sc.nextLine();

        for (Cliente c : clientes) {
            if (c.getId().equals(id)) {
                System.out.print("Nuevo nombre (dejar vacío para no cambiar): ");
                String nombre = sc.nextLine();
                if (!nombre.isEmpty()) c.setNombre(nombre);

                System.out.print("Nuevo teléfono (dejar vacío para no cambiar): ");
                String telefono = sc.nextLine();
                if (!telefono.isEmpty()) c.setTelefono(telefono);

                System.out.print("Nuevo email (dejar vacío para no cambiar): ");
                String email = sc.nextLine();
                if (!email.isEmpty()) c.setEmail(email);

                System.out.println("Cliente actualizado correctamente.");
                return;
            }
        }
        System.out.println("Cliente no encontrado.");
    }

    public static void eliminarCliente() {
        System.out.println("\n--- ELIMINAR CLIENTE ---");
        System.out.print("Ingrese el ID del cliente a eliminar: ");
        String id = sc.nextLine();

        for (Cliente c : clientes) {
            if (c.getId().equals(id)) {
                clientes.remove(c);
                System.out.println("Cliente eliminado.");
                return;
            }
        }
        System.out.println("Cliente no encontrado.");
    }
}