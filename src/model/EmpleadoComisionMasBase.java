package model;

import enums.TipoEmpleado;
import enums.DepartamentoEnum;
import java.time.LocalDate;

/**
 * Clase que representa un empleado con sueldo base más comisión.
 * Hereda de EmpleadoComision y agrega garantías y topes.
 * 
 * @author ISC Israel de Jesús Mar Parada (MPFx++)
 * @version 1.0
 * @since 2023-01-15
 */
public class EmpleadoComisionMasBase extends EmpleadoComision {
    
    // ==================== ATRIBUTOS ESPECÍFICOS ====================
    
    /** Sueldo mínimo garantizado (aunque no venda) */
    private double salarioBaseGarantizado;
    
    /** Tope máximo de comisión que puede recibir */
    private double topeComision;
    
    /** Meses de antigüedad en la empresa */
    private int antiguedadMeses;
    
    
    // ==================== CONSTRUCTOR ====================
    
    /**
     * Constructor de EmpleadoComisionMasBase.
     * 
     * @param nombre                    Nombre del empleado
     * @param apellido                  Apellido del empleado
     * @param idEmpleado                Identificador único
     * @param email                     Correo electrónico
     * @param telefono                  Número de teléfono
     * @param sueldoBase                Sueldo base mensual
     * @param fechaContratacion         Fecha de contratación
     * @param departamento              Departamento asignado
     * @param ventasDelMes              Ventas del mes
     * @param porcentajeComision        Porcentaje de comisión
     * @param metaVentasMensual         Meta de ventas
     * @param bonoPorMeta               Bono por alcanzar meta
     * @param salarioBaseGarantizado    Sueldo mínimo garantizado
     * @param topeComision              Tope máximo de comisión
     * @param antiguedadMeses           Meses de antigüedad
     */
    public EmpleadoComisionMasBase(String nombre, String apellido, String idEmpleado,
                                   String email, String telefono, double sueldoBase,
                                   LocalDate fechaContratacion, DepartamentoEnum departamento,
                                   double ventasDelMes, double porcentajeComision, 
                                   double metaVentasMensual, double bonoPorMeta,
                                   double salarioBaseGarantizado, double topeComision, 
                                   int antiguedadMeses) {
        super(nombre, apellido, idEmpleado, email, telefono, sueldoBase, 
              fechaContratacion, departamento, ventasDelMes, porcentajeComision, 
              metaVentasMensual, bonoPorMeta);
        this.salarioBaseGarantizado = salarioBaseGarantizado;
        this.topeComision = topeComision;
        this.antiguedadMeses = antiguedadMeses;
    }
    
    
    // ==================== MÉTODOS SOBRESCRITOS ====================
    
    /**
     * Calcula la paga mensual del empleado con garantía y tope.
     * La comisión tiene tope y se garantiza un sueldo mínimo.
     * Además incluye bono por antigüedad.
     * 
     * @return Paga mensual total
     */
    @Override
    public double calcularPaga() {
        double pagaNormal = super.calcularPaga();
        double comisionCalculada = getVentasDelMes() * (getPorcentajeComision() / 100);
        double comisionFinal = Math.min(comisionCalculada, topeComision);
        double extraAntiguedad = (antiguedadMeses / 12.0) * getSueldoBase() * 0.02;
        return Math.max(pagaNormal, salarioBaseGarantizado) + extraAntiguedad;
    }
    
    
    // ==================== GETTERS Y SETTERS ====================
    
    public double getSalarioBaseGarantizado() { return salarioBaseGarantizado; }
    public void setSalarioBaseGarantizado(double salarioBaseGarantizado) { 
        this.salarioBaseGarantizado = salarioBaseGarantizado; 
    }
    
    public double getTopeComision() { return topeComision; }
    public void setTopeComision(double topeComision) { this.topeComision = topeComision; }
    
    public int getAntiguedadMeses() { return antiguedadMeses; }
    public void setAntiguedadMeses(int antiguedadMeses) { this.antiguedadMeses = antiguedadMeses; }
}//fin de la clase