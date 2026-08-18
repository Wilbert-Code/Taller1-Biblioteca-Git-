package com.mycompany;

public class Libro extends Material {
    private String isbn;
    private int numeroPaginas;
    private String genero;

    public Libro() {
        super();
    }

    public Libro(String codigo, String titulo, String autor, int anioPublicacion,
                 String isbn, int numeroPaginas, String genero) {
        super(codigo, titulo, autor, anioPublicacion);
        this.isbn = isbn;
        this.numeroPaginas = numeroPaginas;
        this.genero = genero;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String getTipoMaterial() {
        return "Libro";
    }

    @Override
    public String toString() {
        return super.toString() +
                ", ISBN: " + isbn +
                ", Páginas: " + numeroPaginas +
                ", Género: " + genero;
    }
}