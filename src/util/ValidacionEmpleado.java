package util;

import model.Empleado;
import java.time.LocalDate;
import java.time.Period;

/**
 * Clase utilitaria para validar datos de empleados.
 * Contiene métodos estáticos para validar ID, email, sueldo, etc.
 * 
 * @author ISC Israel de Jesús Mar Parada (MPFx++)
 * @version 1.0
 * @since 2023-01-15
 */
public class ValidacionEmpleado {
    
    // ==================== CONSTANTES ====================
    
    /** Edad mínima para trabajar (18 años) */
    private static final int EDAD_MINIMA = 18;
    
    /** Sueldo mínimo legal */
    private static final double SUELDO_MINIMO = 5000;
    
    /** Patrón para ID de empleado (EMP-0000) */
    private static final String PATRON_ID = "^EMP-[0-9]{4}$";
    
    /** Patrón para email válido */
    private static final String PATRON_EMAIL = "^[A-Za-z0-9+_.-]+@(.+)$";
    
    
    // ==================== MÉTODOS ====================
    
    /**
     * Valida el formato del ID de empleado.
     * El formato debe ser EMP- seguido de 4 dígitos.
     * 
     * @param id ID a validar
     * @return true si el formato es correcto
     */
    public static boolean validarId(String id) {
        return id != null && id.matches(PATRON_ID);
    }
    
    /**
     * Valida que el sueldo sea mayor al mínimo legal.
     * 
     * @param sueldo Sueldo a validar
     * @return true si el sueldo es válido
     */
    public static boolean validarSueldo(double sueldo) {
        return sueldo >= SUELDO_MINIMO;
    }
    
    /**
     * Valida el formato del email.
     * 
     * @param email Email a validar
     * @return true si el formato es válido
     */
    public static boolean validarEmail(String email) {
        return email != null && email.matches(PATRON_EMAIL);
    }
    
    /**
     * Valida que el teléfono tenga entre 9 y 12 dígitos.
     * 
     * @param telefono Teléfono a validar
     * @return true si el teléfono es válido
     */
    public static boolean validarTelefono(String telefono) {
        return telefono != null && telefono.matches("^[0-9]{9,12}$");
    }
    
    /**
     * Genera un ID único para un nuevo empleado.
     * El formato es EMP- seguido de 4 dígitos aleatorios.
     * 
     * @return ID generado
     */
    public static String generarIdUnico() {
        int numero = (int)(Math.random() * 10000);
        return String.format("EMP-%04d", numero);
    }
    
    /**
     * Valida todos los datos de un empleado.
     * Lanza una excepción si algún dato es inválido.
     * 
     * @param e Empleado a validar
     * @throws IllegalArgumentException si algún dato es inválido
     */
    public static void validarEmpleado(Empleado e) throws IllegalArgumentException {
        if (!validarId(e.getIdEmpleado())) {
            throw new IllegalArgumentException("ID inválido. Formato: EMP-0000");
        }
        if (!validarSueldo(e.getSueldoBase())) {
            throw new IllegalArgumentException("Sueldo mínimo: $" + SUELDO_MINIMO);
        }
        if (!validarEmail(e.getEmail())) {
            throw new IllegalArgumentException("Email inválido");
        }
    }
}//fin de la clase