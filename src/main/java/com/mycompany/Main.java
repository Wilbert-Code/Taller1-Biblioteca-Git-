package com.mycompany;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Cliente> clientes = new ArrayList<>();
    static ArrayList<Libro> libros = new ArrayList<>();
    static ArrayList<Prestamo> prestamos = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    private static int contadorPrestamos = 1;

    public static void main(String[] args) {
        System.out.println("Sistema de Biblioteca - Gestión de Clientes");
        menuPrincipal();
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

    public static void registrarPrestamo() {
        System.out.println("\n--- REGISTRAR PRÉSTAMO ---");

        // Mostrar clientes disponibles
        if (clientes.isEmpty()) {
            System.out.println("❌ No hay clientes registrados. Primero registre un cliente.");
            return;
        }

        System.out.println("\n--- CLIENTES DISPONIBLES ---");
        for (Cliente c : clientes) {
            System.out.println(c);
        }

        System.out.print("\nIngrese el ID del cliente: ");
        String idCliente = sc.nextLine();
        Cliente cliente = null;
        for (Cliente c : clientes) {
            if (c.getId().equals(idCliente)) {
                cliente = c;
                break;
            }
        }

        if (cliente == null) {
            System.out.println("❌ Cliente no encontrado.");
            return;
        }

        // Mostrar libros disponibles
        System.out.println("\n--- LIBROS DISPONIBLES ---");
        boolean hayDisponibles = false;
        for (Libro l : libros) {
            if (l.isDisponible()) {
                System.out.println(l);
                hayDisponibles = true;
            }
        }

        if (!hayDisponibles) {
            System.out.println("❌ No hay libros disponibles para préstamo.");
            return;
        }

        System.out.print("\nIngrese el código del libro: ");
        String codigoLibro = sc.nextLine();
        Libro libro = null;
        for (Libro l : libros) {
            if (l.getCodigo().equals(codigoLibro) && l.isDisponible()) {
                libro = l;
                break;
            }
        }

        if (libro == null) {
            System.out.println("❌ Libro no encontrado o no disponible.");
            return;
        }

        String idPrestamo = "P" + String.format("%04d", contadorPrestamos++);
        Prestamo prestamo = new Prestamo(idPrestamo, cliente, libro);
        //prestamo.add(prestamos);

        System.out.println("✅ Préstamo registrado exitosamente.");
        System.out.println("📋 ID del préstamo: " + idPrestamo);
        System.out.println("👤 Cliente: " + cliente.getNombre());
        System.out.println("📖 Libro: " + libro.getTitulo());
        System.out.println("📅 Fecha de préstamo: " + LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }

    public static void registrarDevolucion() {
        System.out.println("\n--- REGISTRAR DEVOLUCIÓN ---");

        // Mostrar préstamos activos
        ArrayList<Prestamo> activos = new ArrayList<>();
        for (Prestamo p : prestamos) {
            if (!p.isDevuelto()) {
                activos.add(p);
            }
        }

        if (activos.isEmpty()) {
            System.out.println("❌ No hay préstamos activos para devolver.");
            return;
        }

        System.out.println("\n--- PRÉSTAMOS ACTIVOS ---");
        for (Prestamo p : activos) {
            System.out.println(p.toResumen());
        }

        System.out.print("\nIngrese el ID del préstamo a devolver: ");
        String idPrestamo = sc.nextLine();

        for (Prestamo p : prestamos) {
            if (p.getIdPrestamo().equals(idPrestamo) && !p.isDevuelto()) {
                p.registrarDevolucion();
                System.out.println("✅ Devolución registrada exitosamente.");
                System.out.println("📅 Fecha de devolución: " + LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                System.out.println("📚 Libro devuelto: " + p.getLibro().getTitulo());
                return;
            }
        }
        System.out.println("❌ Préstamo no encontrado o ya fue devuelto.");
    }

    public static void listarPrestamosActivos() {
        System.out.println("\n--- PRÉSTAMOS ACTIVOS ---");
        boolean hayActivos = false;
        for (Prestamo p : prestamos) {
            if (!p.isDevuelto()) {
                System.out.println(p);
                hayActivos = true;
            }
        }
        if (!hayActivos) {
            System.out.println("No hay préstamos activos.");
        }
    }
    public static void menuPrincipal(){
    int opcion;
        do{
        System.out.println("\n╔══════════════════════════════════════════════════════════╗");
        System.out.println("║            SISTEMA DE GESTIÓN DE BIBLIOTECA              ║");
        System.out.println("║               BIBLIOTECA MUNICIPAL DE VALLEDUPAR          ║");
        System.out.println("╠══════════════════════════════════════════════════════════╣");
        System.out.println("║                                                          ║");
        System.out.println("║  📋 1. GESTIÓN DE CLIENTES                              ║");
        System.out.println("║  📚 2. GESTIÓN DE LIBROS                                ║");
        System.out.println("║  📖 3. GESTIÓN DE PRÉSTAMOS                             ║");
        System.out.println("║  🚪 4. SALIR                                            ║");
        System.out.println("║                                                          ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");
        System.out.print("➡️  Seleccione una opción: ");

        opcion = sc.nextInt();
        sc.nextLine();

        switch (opcion) {
            case 1:
                menuClientes();
                break;
            case 2:
                menuLibros();
                break;
            case 3:
                menuPrestamos();
                break;
            case 4:
                System.out.println("\n✅ Saliendo del sistema... ¡Hasta luego!");
                System.out.println("   📚 ¡Gracias por usar la Biblioteca Municipal de Valledupar!");
                break;
            default:
                System.out.println("\n❌ Opción no válida. Intente nuevamente.");
        }
    } while(opcion !=4);}


    public static void menuClientes() {
        int opcion;
        do {
            System.out.println("\n╔════════════════════════════════════════════╗");
            System.out.println("║         GESTIÓN DE CLIENTES                ║");
            System.out.println("╠════════════════════════════════════════════╣");
            System.out.println("║  1. 👤 Crear cliente                       ║");
            System.out.println("║  2. 📋 Listar clientes                     ║");
            System.out.println("║  3. 🔍 Buscar cliente por ID               ║");
            System.out.println("║  4. ✏️  Actualizar cliente                  ║");
            System.out.println("║  5. 🗑️  Eliminar cliente                   ║");
            System.out.println("║  6. ↩️  Volver al menú principal           ║");
            System.out.println("╚════════════════════════════════════════════╝");
            System.out.print("➡️  Seleccione una opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    crearCliente();
                    break;
                case 2:
                    listarClientes();
                    break;
                case 3:
                    buscarCliente();
                    break;
                case 4:
                    actualizarCliente();
                    break;
                case 5:
                    eliminarCliente();
                    break;
                case 6:
                    System.out.println("\n↩️  Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("\n❌ Opción no válida.");
            }
        } while (opcion != 6);
    }

    public static void menuLibros() {
        int opcion;
        do {
            System.out.println("\n╔════════════════════════════════════════════╗");
            System.out.println("║         GESTIÓN DE LIBROS                  ║");
            System.out.println("╠════════════════════════════════════════════╣");
            System.out.println("║  1. 📚 Crear libro                         ║");
            System.out.println("║  2. 📋 Listar libros                       ║");
            System.out.println("║  3. 🔍 Buscar libro por código             ║");
            System.out.println("║  4. ✏️  Actualizar libro                   ║");
            System.out.println("║  5. 🗑️  Eliminar libro                    ║");
            System.out.println("║  6. ↩️  Volver al menú principal           ║");
            System.out.println("╚════════════════════════════════════════════╝");
            System.out.print("➡️  Seleccione una opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    crearLibro();
                    break;
                case 2:
                    listarLibros();
                    break;
                case 3:
                    buscarLibro();
                    break;
                case 4:
                    actualizarLibro();
                    break;
                case 5:
                    eliminarLibro();
                    break;
                case 6:
                    System.out.println("\n↩️  Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("\n❌ Opción no válida.");
            }
        } while (opcion != 6);
    }

    public static void menuPrestamos() {
        int opcion;
        do {
            System.out.println("\n╔════════════════════════════════════════════╗");
            System.out.println("║         GESTIÓN DE PRÉSTAMOS               ║");
            System.out.println("╠════════════════════════════════════════════╣");
            System.out.println("║  1. 📖 Registrar préstamo                  ║");
            System.out.println("║  2. 🔄 Registrar devolución                ║");
            System.out.println("║  3. 📋 Listar préstamos activos            ║");
            System.out.println("║  4. ↩️  Volver al menú principal           ║");
            System.out.println("╚════════════════════════════════════════════╝");
            System.out.print("➡️  Seleccione una opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    registrarPrestamo();
                    break;
                case 2:
                    registrarDevolucion();
                    break;
                case 3:
                    listarPrestamosActivos();
                    break;
                case 4:
                    System.out.println("\n↩️  Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("\n❌ Opción no válida.");
            }
        } while (opcion != 4);
    }

}