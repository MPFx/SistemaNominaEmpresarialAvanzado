package model;

import enums.TipoEmpleado;
import enums.DepartamentoEnum;
import java.time.LocalDate;
import java.time.Period;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.LoggerUtil;

/**
 * Clase abstracta que representa a un empleado genérico de la empresa.
 * Contiene los atributos y métodos comunes a todos los tipos de empleados.
 * 
 * @author ISC Israel de Jesús Mar Parada (MPFx++)
 * @version 2.0.0
 */
public abstract class Empleado {
    
    // ==================== ATRIBUTOS ====================
    
    private String nombre;
    private String apellido;
    private String idEmpleado;
    private String email;
    private String telefono;
    private double sueldoBase;
    private LocalDate fechaContratacion;
    private TipoEmpleado tipo;
    private DepartamentoEnum departamento;
    private boolean activo;
    
    // ==================== LOGGER ====================
    private static final Logger LOGGER = Logger.getLogger(Empleado.class.getName());
    
    
    // ==================== CONSTRUCTOR ====================
    
    public Empleado(String nombre, String apellido, String idEmpleado, 
                    String email, String telefono, double sueldoBase, 
                    LocalDate fechaContratacion, TipoEmpleado tipo, 
                    DepartamentoEnum departamento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.idEmpleado = idEmpleado;
        this.email = email;
        this.telefono = telefono;
        this.sueldoBase = sueldoBase;
        this.fechaContratacion = fechaContratacion;
        this.tipo = tipo;
        this.departamento = departamento;
        this.activo = true;
        
        // CORREGIDO: usar log(Level.INFO, mensaje)
        LOGGER.log(Level.INFO, "Empleado creado: {0} ({1})", 
                   new Object[]{getNombreCompleto(), idEmpleado});
    }
    
    
    // ==================== MÉTODOS ABSTRACTOS ====================
    
    public abstract double calcularPaga();
    
    
    // ==================== MÉTODOS CONCRETOS ====================
    
    public double calcularBono() {
        return sueldoBase * 0.05;
    }
    
    public double calcularRetencion() {
        return calcularPaga() * 0.1;
    }
    
    public double calcularSueldoNeto() {
        return calcularPaga() - calcularRetencion();
    }
    
    public int calcularAntiguedad() {
        return Period.between(fechaContratacion, LocalDate.now()).getYears();
    }
    
    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }
    
    
    // ==================== GETTERS Y SETTERS ====================
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    
    public String getIdEmpleado() { return idEmpleado; }
    public void setIdEmpleado(String idEmpleado) { this.idEmpleado = idEmpleado; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    
    public double getSueldoBase() { return sueldoBase; }
    public void setSueldoBase(double sueldoBase) { this.sueldoBase = sueldoBase; }
    
    public LocalDate getFechaContratacion() { return fechaContratacion; }
    public void setFechaContratacion(LocalDate fechaContratacion) { this.fechaContratacion = fechaContratacion; }
    
    public TipoEmpleado getTipo() { return tipo; }
    public void setTipo(TipoEmpleado tipo) { this.tipo = tipo; }
    
    public DepartamentoEnum getDepartamento() { return departamento; }
    public void setDepartamento(DepartamentoEnum departamento) { this.departamento = departamento; }
    
    public boolean isActivo() { return activo; }
    
    public void setActivo(boolean activo) { 
        this.activo = activo;
        if (!activo) {
            // CORREGIDO: usar log(Level.WARNING, mensaje)
            LOGGER.log(Level.WARNING, "Empleado desactivado: {0}", getNombreCompleto());
        }
    }
}
// fin de la clase Empleado