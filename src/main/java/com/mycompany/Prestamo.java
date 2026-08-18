package com.mycompany;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Prestamo {
    private String idPrestamo;
    private Cliente cliente;
    private Libro libro;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private boolean devuelto;

    // Constructor vacío
    public Prestamo() {
        this.fechaPrestamo = LocalDate.now();
        this.devuelto = false;
    }

    // Constructor con parámetros
    public Prestamo(String idPrestamo, Cliente cliente, Libro libro) {
        this.idPrestamo = idPrestamo;
        this.cliente = cliente;
        this.libro = libro;
        this.fechaPrestamo = LocalDate.now();
        this.fechaDevolucion = null;
        this.devuelto = false;
        // Marcar el libro como no disponible
        if (libro != null) {
            libro.setDisponible(false);
        }
    }

    // ========== GETTERS Y SETTERS ==========

    public String getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(String idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public boolean isDevuelto() {
        return devuelto;
    }

    public void setDevuelto(boolean devuelto) {
        this.devuelto = devuelto;
    }

    // ========== MÉTODOS DE NEGOCIO ==========

    /**
     * Registra la devolución del préstamo
     * Marca el libro como disponible y actualiza la fecha de devolución
     */
    public void registrarDevolucion() {
        this.devuelto = true;
        this.fechaDevolucion = LocalDate.now();
        if (libro != null) {
            libro.setDisponible(true);
        }
    }

    /**
     * Verifica si el préstamo está activo
     * @return true si el préstamo NO ha sido devuelto
     */
    public boolean isActivo() {
        return !devuelto;
    }

    /**
     * Calcula los días transcurridos desde el préstamo
     * @return número de días desde que se realizó el préstamo
     */
    public long getDiasTranscurridos() {
        return java.time.temporal.ChronoUnit.DAYS.between(fechaPrestamo, LocalDate.now());
    }

    // ========== MÉTODOS DE SOBREESCRITURA ==========

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaDev = (fechaDevolucion != null) ? fechaDevolucion.format(formatter) : "No devuelto";
        String estado = devuelto ? "DEVUELTO" : "ACTIVO";

        return "ID Préstamo: " + idPrestamo +
                " | Cliente: " + cliente.getNombre() +
                " | Libro: " + libro.getTitulo() +
                " | Fecha Préstamo: " + fechaPrestamo.format(formatter) +
                " | Fecha Devolución: " + fechaDev +
                " | Estado: " + estado +
                " | Días: " + getDiasTranscurridos();
    }

    /**
     * Versión resumida del toString para listados
     */
    public String toResumen() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaDev = (fechaDevolucion != null) ? fechaDevolucion.format(formatter) : "No devuelto";

        return "ID: " + idPrestamo +
                " | Cliente: " + cliente.getNombre() +
                " | Libro: " + libro.getTitulo() +
                " | Fecha: " + fechaPrestamo.format(formatter) +
                " | Estado: " + (devuelto ? "DEVUELTO" : "ACTIVO");
    }
}