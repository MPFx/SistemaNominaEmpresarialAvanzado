package model;

import enums.TipoEmpleado;
import enums.DepartamentoEnum;
import java.time.LocalDate;

/**
 * Clase que representa un empleado que cobra por horas trabajadas.
 * Hereda de Empleado y sobrescribe el método calcularPaga().
 * 
 * @author ISC Israel de Jesús Mar Parada (MPFx++)
 * @version 1.0
 * @since 2023-01-15
 */
public class EmpleadoPorHora extends Empleado {
    
    // ==================== ATRIBUTOS ESPECÍFICOS ====================
    
    /** Horas trabajadas en el mes */
    private int horasTrabajadas;
    
    /** Tarifa por hora normal */
    private double tarifaHora;
    
    /** Tarifa por hora extra (1.5x o 2x la normal) */
    private double tarifaHoraExtra;
    
    /** Horas extras trabajadas en el mes */
    private int horasExtras;
    
    
    // ==================== CONSTRUCTOR ====================
    
    /**
     * Constructor de EmpleadoPorHora.
     * 
     * @param nombre             Nombre del empleado
     * @param apellido           Apellido del empleado
     * @param idEmpleado         Identificador único
     * @param email              Correo electrónico
     * @param telefono           Número de teléfono
     * @param sueldoBase         Sueldo base mensual
     * @param fechaContratacion  Fecha de contratación
     * @param departamento       Departamento asignado
     * @param horasTrabajadas    Horas trabajadas en el mes
     * @param tarifaHora         Tarifa por hora normal
     * @param tarifaHoraExtra    Tarifa por hora extra
     * @param horasExtras        Horas extras trabajadas
     */
    public EmpleadoPorHora(String nombre, String apellido, String idEmpleado,
                           String email, String telefono, double sueldoBase,
                           LocalDate fechaContratacion, DepartamentoEnum departamento,
                           int horasTrabajadas, double tarifaHora, 
                           double tarifaHoraExtra, int horasExtras) {
        super(nombre, apellido, idEmpleado, email, telefono, sueldoBase, 
              fechaContratacion, TipoEmpleado.POR_HORA, departamento);
        this.horasTrabajadas = horasTrabajadas;
        this.tarifaHora = tarifaHora;
        this.tarifaHoraExtra = tarifaHoraExtra;
        this.horasExtras = horasExtras;
    }
    
    
    // ==================== MÉTODOS SOBRESCRITOS ====================
    
    /**
     * Calcula la paga mensual del empleado por hora.
     * Incluye paga por horas normales y horas extras.
     * 
     * @return Paga mensual total
     */
    @Override
    public double calcularPaga() {
        double pagaNormal = horasTrabajadas * tarifaHora;
        double pagaExtra = horasExtras * tarifaHoraExtra;
        return pagaNormal + pagaExtra;
    }
    
    /**
     * Calcula el bono mensual del empleado por hora.
     * 3% del sueldo base (menor que otros tipos).
     * 
     * @return Bono mensual
     */
    @Override
    public double calcularBono() {
        return getSueldoBase() * 0.03;
    }
    
    
    // ==================== MÉTODOS ESPECÍFICOS ====================
    
    /**
     * Registra horas extras adicionales para el empleado.
     * 
     * @param horas Cantidad de horas extras a agregar
     */
    public void registrarHorasExtras(int horas) {
        this.horasExtras += horas;
    }
    
    
    // ==================== GETTERS Y SETTERS ====================
    
    public int getHorasTrabajadas() { return horasTrabajadas; }
    public void setHorasTrabajadas(int horasTrabajadas) { this.horasTrabajadas = horasTrabajadas; }
    
    public double getTarifaHora() { return tarifaHora; }
    public void setTarifaHora(double tarifaHora) { this.tarifaHora = tarifaHora; }
    
    public double getTarifaHoraExtra() { return tarifaHoraExtra; }
    public void setTarifaHoraExtra(double tarifaHoraExtra) { this.tarifaHoraExtra = tarifaHoraExtra; }
    
    public int getHorasExtras() { return horasExtras; }
    public void setHorasExtras(int horasExtras) { this.horasExtras = horasExtras; }
}//fin de la clase