package model;

import enums.TipoEmpleado;
import enums.DepartamentoEnum;
import java.time.LocalDate;

/**
 * Builder para crear diferentes tipos de Empleado de forma fluida y legible.
 * 
 * @author ISC Israel de Jesús Mar Parada (MPFx++)
 * @version 2.0.0
 */
public class EmpleadoBuilder {
    
    // Atributos base (comunes a todos los empleados)
    private String nombre;
    private String apellido;
    private String idEmpleado;
    private String email;
    private String telefono;
    private double sueldoBase;
    private LocalDate fechaContratacion;
    private TipoEmpleado tipo;
    private DepartamentoEnum departamento;
    
    // Atributos para ASALARIADO
    private double bonoAnual;
    private String nivelJerarquico;
    private int diasVacaciones;
    
    // Atributos para POR_HORA
    private int horasTrabajadas;
    private double tarifaHora;
    private double tarifaHoraExtra;
    private int horasExtras;
    
    // Atributos para COMISION
    private double ventasDelMes;
    private double porcentajeComision;
    private double metaVentasMensual;
    private double bonoPorMeta;
    
    // Atributos para COMISION_MAS_BASE
    private double salarioBaseGarantizado;
    private double topeComision;
    private int antiguedadMeses;
    
    /**
     * Constructor base con atributos obligatorios.
     */
    public EmpleadoBuilder(String nombre, String apellido, String idEmpleado,
                           double sueldoBase, TipoEmpleado tipo,
                           DepartamentoEnum departamento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.idEmpleado = idEmpleado;
        this.sueldoBase = sueldoBase;
        this.tipo = tipo;
        this.departamento = departamento;
        
        // Valores por defecto
        this.email = "sin.email@empresa.com";
        this.telefono = "000000000";
        this.fechaContratacion = LocalDate.now();
        this.bonoAnual = 0;
        this.nivelJerarquico = "Junior";
        this.diasVacaciones = 15;
        this.horasTrabajadas = 160;
        this.tarifaHora = 5000;
        this.tarifaHoraExtra = 7500;
        this.horasExtras = 0;
        this.ventasDelMes = 0;
        this.porcentajeComision = 10;
        this.metaVentasMensual = 1000000;
        this.bonoPorMeta = 50000;
        this.salarioBaseGarantizado = sueldoBase * 0.8;
        this.topeComision = 300000;
        this.antiguedadMeses = 0;
    }
    
    // ==================== MÉTODOS PARA ATRIBUTOS COMUNES ====================
    
    public EmpleadoBuilder withEmail(String email) {
        this.email = email;
        return this;
    }
    
    public EmpleadoBuilder withTelefono(String telefono) {
        this.telefono = telefono;
        return this;
    }
    
    public EmpleadoBuilder withFechaContratacion(LocalDate fecha) {
        this.fechaContratacion = fecha;
        return this;
    }
    
    // ==================== MÉTODOS PARA ASALARIADO ====================
    
    public EmpleadoBuilder withBonoAnual(double bonoAnual) {
        this.bonoAnual = bonoAnual;
        return this;
    }
    
    public EmpleadoBuilder withNivelJerarquico(String nivel) {
        this.nivelJerarquico = nivel;
        return this;
    }
    
    public EmpleadoBuilder withDiasVacaciones(int dias) {
        this.diasVacaciones = dias;
        return this;
    }
    
    // ==================== MÉTODOS PARA POR_HORA ====================
    
    public EmpleadoBuilder withHorasTrabajadas(int horas) {
        this.horasTrabajadas = horas;
        return this;
    }
    
    public EmpleadoBuilder withTarifaHora(double tarifa) {
        this.tarifaHora = tarifa;
        return this;
    }
    
    public EmpleadoBuilder withTarifaHoraExtra(double tarifa) {
        this.tarifaHoraExtra = tarifa;
        return this;
    }
    
    public EmpleadoBuilder withHorasExtras(int horas) {
        this.horasExtras = horas;
        return this;
    }
    
    // ==================== MÉTODOS PARA COMISION ====================
    
    public EmpleadoBuilder withVentasDelMes(double ventas) {
        this.ventasDelMes = ventas;
        return this;
    }
    
    public EmpleadoBuilder withPorcentajeComision(double porcentaje) {
        this.porcentajeComision = porcentaje;
        return this;
    }
    
    public EmpleadoBuilder withMetaVentasMensual(double meta) {
        this.metaVentasMensual = meta;
        return this;
    }
    
    public EmpleadoBuilder withBonoPorMeta(double bono) {
        this.bonoPorMeta = bono;
        return this;
    }
    
    // ==================== MÉTODOS PARA COMISION_MAS_BASE ====================
    
    public EmpleadoBuilder withSalarioBaseGarantizado(double salario) {
        this.salarioBaseGarantizado = salario;
        return this;
    }
    
    public EmpleadoBuilder withTopeComision(double tope) {
        this.topeComision = tope;
        return this;
    }
    
    public EmpleadoBuilder withAntiguedadMeses(int meses) {
        this.antiguedadMeses = meses;
        return this;
    }
    
    // ==================== MÉTODO BUILD ====================
    
    /**
     * Construye el empleado según el tipo especificado.
     * 
     * @return Empleado del tipo correspondiente
     */
    public Empleado build() {
        switch (tipo) {
            case ASALARIADO:
                return new EmpleadoAsalariado(nombre, apellido, idEmpleado, email, telefono,
                        sueldoBase, fechaContratacion, departamento,
                        bonoAnual, nivelJerarquico, diasVacaciones);
                
            case POR_HORA:
                return new EmpleadoPorHora(nombre, apellido, idEmpleado, email, telefono,
                        sueldoBase, fechaContratacion, departamento,
                        horasTrabajadas, tarifaHora, tarifaHoraExtra, horasExtras);
                
            case COMISION:
                return new EmpleadoComision(nombre, apellido, idEmpleado, email, telefono,
                        sueldoBase, fechaContratacion, departamento,
                        ventasDelMes, porcentajeComision, metaVentasMensual, bonoPorMeta);
                
            case COMISION_MAS_BASE:
                return new EmpleadoComisionMasBase(nombre, apellido, idEmpleado, email, telefono,
                        sueldoBase, fechaContratacion, departamento,
                        ventasDelMes, porcentajeComision, metaVentasMensual, bonoPorMeta,
                        salarioBaseGarantizado, topeComision, antiguedadMeses);
                
            default:
                throw new IllegalArgumentException("Tipo de empleado no soportado: " + tipo);
        }
    }
}
// fin de la clase EmpleadoBuilder