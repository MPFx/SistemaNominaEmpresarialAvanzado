package model;

import enums.TipoEmpleado;
import enums.DepartamentoEnum;
import java.time.LocalDate;

/**
 * Clase que representa un empleado que cobra comisión por ventas.
 * Hereda de Empleado y sobrescribe el método calcularPaga().
 * 
 * @author ISC Israel de Jesús Mar Parada (MPFx++)
 * @version 1.0
 * @since 2023-01-15
 */
public class EmpleadoComision extends Empleado {
    
    // ==================== ATRIBUTOS ESPECÍFICOS ====================
    
    /** Ventas realizadas en el mes ($) */
    private double ventasDelMes;
    
    /** Porcentaje de comisión sobre ventas */
    private double porcentajeComision;
    
    /** Meta de ventas mensual para obtener bono */
    private double metaVentasMensual;
    
    /** Bono adicional por alcanzar la meta */
    private double bonoPorMeta;
    
    
    // ==================== CONSTRUCTOR ====================
    
    /**
     * Constructor de EmpleadoComision.
     * 
     * @param nombre                Nombre del empleado
     * @param apellido              Apellido del empleado
     * @param idEmpleado            Identificador único
     * @param email                 Correo electrónico
     * @param telefono              Número de teléfono
     * @param sueldoBase            Sueldo base mensual
     * @param fechaContratacion     Fecha de contratación
     * @param departamento          Departamento asignado
     * @param ventasDelMes          Ventas del mes
     * @param porcentajeComision    Porcentaje de comisión
     * @param metaVentasMensual     Meta de ventas
     * @param bonoPorMeta           Bono por alcanzar meta
     */
    public EmpleadoComision(String nombre, String apellido, String idEmpleado,
                            String email, String telefono, double sueldoBase,
                            LocalDate fechaContratacion, DepartamentoEnum departamento,
                            double ventasDelMes, double porcentajeComision, 
                            double metaVentasMensual, double bonoPorMeta) {
        super(nombre, apellido, idEmpleado, email, telefono, sueldoBase, 
              fechaContratacion, TipoEmpleado.COMISION, departamento);
        this.ventasDelMes = ventasDelMes;
        this.porcentajeComision = porcentajeComision;
        this.metaVentasMensual = metaVentasMensual;
        this.bonoPorMeta = bonoPorMeta;
    }
    
    
    // ==================== MÉTODOS SOBRESCRITOS ====================
    
    /**
     * Calcula la paga mensual del empleado por comisión.
     * Incluye sueldo base + comisión por ventas + bono por meta.
     * 
     * @return Paga mensual total
     */
    @Override
    public double calcularPaga() {
        double comision = ventasDelMes * (porcentajeComision / 100);
        double bono = alcanzoMeta() ? bonoPorMeta : 0;
        return getSueldoBase() + comision + bono;
    }
    
    /**
     * Calcula el bono mensual del empleado por comisión.
     * 8% del sueldo base (bonificación por gestión).
     * 
     * @return Bono mensual
     */
    @Override
    public double calcularBono() {
        return getSueldoBase() * 0.08;
    }
    
    
    // ==================== MÉTODOS ESPECÍFICOS ====================
    
    /**
     * Verifica si el empleado alcanzó la meta de ventas mensual.
     * 
     * @return true si las ventas superan o igualan la meta
     */
    public boolean alcanzoMeta() {
        return ventasDelMes >= metaVentasMensual;
    }
    
    
    // ==================== GETTERS Y SETTERS ====================
    
    public double getVentasDelMes() { return ventasDelMes; }
    public void setVentasDelMes(double ventasDelMes) { this.ventasDelMes = ventasDelMes; }
    
    public double getPorcentajeComision() { return porcentajeComision; }
    public void setPorcentajeComision(double porcentajeComision) { this.porcentajeComision = porcentajeComision; }
    
    public double getMetaVentasMensual() { return metaVentasMensual; }
    public void setMetaVentasMensual(double metaVentasMensual) { this.metaVentasMensual = metaVentasMensual; }
    
    public double getBonoPorMeta() { return bonoPorMeta; }
    public void setBonoPorMeta(double bonoPorMeta) { this.bonoPorMeta = bonoPorMeta; }
}//fin de la clase