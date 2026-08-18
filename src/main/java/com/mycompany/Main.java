package com.mycompany;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Cliente> clientes = new ArrayList<>();
    static ArrayList<Libro> libros = new ArrayList<>();
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

    public static void crearLibro() {
        System.out.println("\n--- CREAR LIBRO ---");
        System.out.print("Código: ");
        String codigo = sc.nextLine();
        System.out.print("Título: ");
        String titulo = sc.nextLine();
        System.out.print("Autor: ");
        String autor = sc.nextLine();
        System.out.print("Año de publicación: ");
        int anio = sc.nextInt();
        sc.nextLine(); // Limpiar buffer
        System.out.print("ISBN: ");
        String isbn = sc.nextLine();
        System.out.print("Número de páginas: ");
        int paginas = sc.nextInt();
        sc.nextLine();
        System.out.print("Género: ");
        String genero = sc.nextLine();

        Libro nuevo = new Libro(codigo, titulo, autor, anio, isbn, paginas, genero);
        libros.add(nuevo);
        System.out.println("✅ Libro registrado exitosamente.");
    }

    public static void listarLibros() {
        System.out.println("\n--- LISTA DE LIBROS ---");
        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados.");
            return;
        }
        for (Libro l : libros) {
            System.out.println(l);
        }
    }

    public static void buscarLibro() {
        System.out.println("\n--- BUSCAR LIBRO ---");
        System.out.print("Ingrese el código del libro: ");
        String codigo = sc.nextLine();

        for (Libro l : libros) {
            if (l.getCodigo().equals(codigo)) {
                System.out.println("Libro encontrado: " + l);
                return;
            }
        }
        System.out.println("Libro no encontrado.");
    }

    public static void actualizarLibro() {
        System.out.println("\n--- ACTUALIZAR LIBRO ---");
        System.out.print("Ingrese el código del libro a actualizar: ");
        String codigo = sc.nextLine();

        for (Libro l : libros) {
            if (l.getCodigo().equals(codigo)) {
                System.out.print("Nuevo título (dejar vacío para no cambiar): ");
                String titulo = sc.nextLine();
                if (!titulo.isEmpty()) l.setTitulo(titulo);

                System.out.print("Nuevo autor (dejar vacío para no cambiar): ");
                String autor = sc.nextLine();
                if (!autor.isEmpty()) l.setAutor(autor);

                System.out.print("Nuevo año de publicación (0 para no cambiar): ");
                int anio = sc.nextInt();
                sc.nextLine();
                if (anio != 0) l.setAnioPublicacion(anio);

                System.out.print("Nuevo ISBN (dejar vacío para no cambiar): ");
                String isbn = sc.nextLine();
                if (!isbn.isEmpty()) l.setIsbn(isbn);

                System.out.print("Nuevo número de páginas (0 para no cambiar): ");
                int paginas = sc.nextInt();
                sc.nextLine();
                if (paginas != 0) l.setNumeroPaginas(paginas);

                System.out.print("Nuevo género (dejar vacío para no cambiar): ");
                String genero = sc.nextLine();
                if (!genero.isEmpty()) l.setGenero(genero);

                System.out.println("✅ Libro actualizado correctamente.");
                return;
            }
        }
        System.out.println("Libro no encontrado.");
    }

    public static void eliminarLibro() {
        System.out.println("\n--- ELIMINAR LIBRO ---");
        System.out.print("Ingrese el código del libro a eliminar: ");
        String codigo = sc.nextLine();

        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getCodigo().equals(codigo)) {
                Libro libroEliminado = libros.remove(i);
                System.out.println("✅ Libro eliminado.");
                return;
            }
        }
        System.out.println("Libro no encontrado.");
    }
}