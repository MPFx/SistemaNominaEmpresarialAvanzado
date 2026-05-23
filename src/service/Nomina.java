package service;

import model.Empleado;
import enums.EstadoNomina;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa el proceso de nómina de la empresa.
 * Gestiona el cálculo y pago de sueldos.
 * 
 * @author ISC Israel de Jesús Mar Parada (MPFx++)
 * @version 1.0
 * @since 2023-01-15
 */
public class Nomina {
    
    // ==================== ATRIBUTOS ====================
    
    /** Identificador único de la nómina */
    private String idNomina;
    
    /** Período de la nómina (ej: "Enero 2024") */
    private String periodo;
    
    /** Fecha de inicio del período */
    private LocalDate fechaInicio;
    
    /** Fecha de fin del período */
    private LocalDate fechaFin;
    
    /** Fecha programada para el pago */
    private LocalDate fechaPago;
    
    /** Estado actual de la nómina */
    private EstadoNomina estado;
    
    /** Lista de empleados incluidos en la nómina */
    private List<Empleado> empleados;
    
    /** Total general a pagar */
    private double totalGeneral;
    
    
    // ==================== CONSTRUCTOR ====================
    
    /**
     * Constructor de Nomina.
     * 
     * @param idNomina    Identificador único de la nómina
     * @param periodo     Período de la nómina
     * @param fechaInicio Fecha de inicio del período
     * @param fechaFin    Fecha de fin del período
     * @param fechaPago   Fecha programada para pago
     */
    public Nomina(String idNomina, String periodo, LocalDate fechaInicio, 
                  LocalDate fechaFin, LocalDate fechaPago) {
        this.idNomina = idNomina;
        this.periodo = periodo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.fechaPago = fechaPago;
        this.estado = EstadoNomina.PENDIENTE;
        this.empleados = new ArrayList<>();
        this.totalGeneral = 0;
    }
    
    
    // ==================== MÉTODOS ====================
    
    /**
     * Agrega un empleado a la nómina.
     * 
     * @param e Empleado a agregar
     */
    public void agregarEmpleado(Empleado e) {
        empleados.add(e);
    }
    
    /**
     * Procesa la nómina calculando el total general.
     * Cambia el estado de PENDIENTE a PROCESADA.
     */
    public void procesarNomina() {
        totalGeneral = calcularTotalGeneral();
        estado = EstadoNomina.PROCESADA;
        System.out.println("Nómina " + idNomina + " procesada. Total: $" + totalGeneral);
    }
    
    /**
     * Calcula el total general de la nómina.
     * Suma la paga de todos los empleados.
     * 
     * @return Suma total de todas las pagas
     */
    public double calcularTotalGeneral() {
        double total = 0;
        for (Empleado e : empleados) {
            total += e.calcularPaga();
        }
        return total;
    }
    
    /**
     * Ejecuta el pago de la nómina.
     * Cambia el estado de PROCESADA a PAGADA.
     * Solo se puede pagar si está procesada.
     */
    public void pagarNomina() {
        if (estado == EstadoNomina.PROCESADA) {
            estado = EstadoNomina.PAGADA;
            System.out.println("Nómina " + idNomina + " pagada a " + 
                               empleados.size() + " empleados");
        } else {
            System.out.println("Debe procesar la nómina antes de pagar");
        }
    }
    
    
    // ==================== GETTERS Y SETTERS ====================
    
    public String getIdNomina() { return idNomina; }
    public void setIdNomina(String idNomina) { this.idNomina = idNomina; }
    
    public String getPeriodo() { return periodo; }
    public void setPeriodo(String periodo) { this.periodo = periodo; }
    
    public LocalDate getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }
    
    public LocalDate getFechaFin() { return fechaFin; }
    public void setFechaFin(LocalDate fechaFin) { this.fechaFin = fechaFin; }
    
    public LocalDate getFechaPago() { return fechaPago; }
    public void setFechaPago(LocalDate fechaPago) { this.fechaPago = fechaPago; }
    
    public EstadoNomina getEstado() { return estado; }
    public void setEstado(EstadoNomina estado) { this.estado = estado; }
    
    public List<Empleado> getEmpleados() { return empleados; }
    
    public double getTotalGeneral() { return totalGeneral; }
}//fin de la clase