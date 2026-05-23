package model;

import enums.TipoEmpleado;
import enums.DepartamentoEnum;
import java.time.LocalDate;

/**
 * Clase que representa un empleado con sueldo fijo mensual.
 * Hereda de Empleado y sobrescribe el método calcularPaga().
 * 
 * @author ISC Israel de Jesús Mar Parada (MPFx++)
 * @version 1.0
 * @since 2023-01-15
 */
public class EmpleadoAsalariado extends Empleado {
    
    // ==================== ATRIBUTOS ESPECÍFICOS ====================
    
    /** Bono anual del empleado (pagado en 12 cuotas) */
    private double bonoAnual;
    
    /** Nivel jerárquico del empleado (Junior, Senior, etc.) */
    private String nivelJerarquico;
    
    /** Días de vacaciones disponibles */
    private int diasVacaciones;
    
    
    // ==================== CONSTRUCTOR ====================
    
    /**
     * Constructor de EmpleadoAsalariado.
     * 
     * @param nombre           Nombre del empleado
     * @param apellido         Apellido del empleado
     * @param idEmpleado       Identificador único
     * @param email            Correo electrónico
     * @param telefono         Número de teléfono
     * @param sueldoBase       Sueldo base mensual
     * @param fechaContratacion Fecha de contratación
     * @param departamento     Departamento asignado
     * @param bonoAnual        Bono anual total
     * @param nivelJerarquico  Nivel jerárquico
     * @param diasVacaciones   Días de vacaciones
     */
    public EmpleadoAsalariado(String nombre, String apellido, String idEmpleado,
                              String email, String telefono, double sueldoBase,
                              LocalDate fechaContratacion, DepartamentoEnum departamento,
                              double bonoAnual, String nivelJerarquico, int diasVacaciones) {
        super(nombre, apellido, idEmpleado, email, telefono, sueldoBase, 
              fechaContratacion, TipoEmpleado.ASALARIADO, departamento);
        this.bonoAnual = bonoAnual;
        this.nivelJerarquico = nivelJerarquico;
        this.diasVacaciones = diasVacaciones;
    }
    
    
    // ==================== MÉTODOS SOBRESCRITOS ====================
    
    /**
     * Calcula la paga mensual del empleado asalariado.
     * Incluye sueldo base más la parte proporcional del bono anual.
     * 
     * @return Paga mensual total
     */
    @Override
    public double calcularPaga() {
        return getSueldoBase() + (bonoAnual / 12);
    }
    
    /**
     * Calcula el bono mensual del empleado asalariado.
     * 10% del sueldo base (supera al bono base de 5%).
     * 
     * @return Bono mensual
     */
    @Override
    public double calcularBono() {
        return getSueldoBase() * 0.10;
    }
    
    
    // ==================== GETTERS Y SETTERS ====================
    
    public double getBonoAnual() { return bonoAnual; }
    public void setBonoAnual(double bonoAnual) { this.bonoAnual = bonoAnual; }
    
    public String getNivelJerarquico() { return nivelJerarquico; }
    public void setNivelJerarquico(String nivelJerarquico) { this.nivelJerarquico = nivelJerarquico; }
    
    public int getDiasVacaciones() { return diasVacaciones; }
    public void setDiasVacaciones(int diasVacaciones) { this.diasVacaciones = diasVacaciones; }
}//fin de la clase