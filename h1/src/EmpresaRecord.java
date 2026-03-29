/**
 * Record moderno (Java 17/21): datos básicos de la compañía (Nombre, NIT, Año Fundación)
 * Inmutable por diseño.
 */
public record EmpresaRecord(String nombre, String nit, int anoFundacion) {}
