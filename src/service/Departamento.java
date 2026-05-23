package service;

import model.Empleado;
import enums.DepartamentoEnum;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un departamento de la empresa.
 * Gestiona los empleados asignados al departamento.
 * 
 * @author ISC Israel de Jesús Mar Parada (MPFx++)
 * @version 1.0
 * @since 2023-01-15
 */
public class Departamento {
    
    // ==================== ATRIBUTOS ====================
    
    /** Nombre del departamento */
    private String nombre;
    
    /** Código identificador del departamento */
    private String codigo;
    
    /** Tipo de departamento (desde el enum) */
    private DepartamentoEnum tipo;
    
    /** Ubicación física de la oficina */
    private String ubicacionOficina;
    
    /** Teléfono de contacto del departamento */
    private String telefonoOficina;
    
    /** Capacidad máxima de empleados */
    private int capacidadMaxima;
    
    /** Lista de empleados asignados al departamento */
    private List<Empleado> empleados;
    
    
    // ==================== CONSTRUCTOR ====================
    
    /**
     * Constructor de Departamento.
     * 
     * @param nombre           Nombre del departamento
     * @param codigo           Código identificador
     * @param tipo             Tipo de departamento (enum)
     * @param ubicacionOficina Ubicación física
     * @param telefonoOficina  Teléfono de contacto
     * @param capacidadMaxima  Capacidad máxima de empleados
     */
    public Departamento(String nombre, String codigo, DepartamentoEnum tipo, 
                        String ubicacionOficina, String telefonoOficina, 
                        int capacidadMaxima) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.tipo = tipo;
        this.ubicacionOficina = ubicacionOficina;
        this.telefonoOficina = telefonoOficina;
        this.capacidadMaxima = capacidadMaxima;
        this.empleados = new ArrayList<>();
    }
    
    
    // ==================== MÉTODOS ====================
    
    /**
     * Agrega un empleado al departamento.
     * Verifica que no se exceda la capacidad máxima.
     * 
     * @param e Empleado a agregar
     */
    public void agregarEmpleado(Empleado e) {
        if (empleados.size() < capacidadMaxima) {
            empleados.add(e);
            System.out.println("Empleado " + e.getNombreCompleto() + 
                               " agregado a " + nombre);
        } else {
            System.out.println("No hay capacidad en el departamento " + nombre);
        }
    }
    
    /**
     * Calcula el total de nómina del departamento.
     * Suma la paga de todos los empleados asignados.
     * 
     * @return Suma total de pagas del departamento
     */
    public double calcularTotalNomina() {
        double total = 0;
        for (Empleado e : empleados) {
            total += e.calcularPaga();
        }
        return total;
    }
    
    /**
     * Calcula el sueldo promedio del departamento.
     * 
     * @return Promedio de pagas de los empleados
     */
    public double calcularPromedioSueldo() {
        if (empleados.isEmpty()) return 0;
        return calcularTotalNomina() / empleados.size();
    }
    
    /**
     * Obtiene la cantidad de empleados en el departamento.
     * 
     * @return Número de empleados
     */
    public int getCantidadEmpleados() {
        return empleados.size();
    }
    
    
    // ==================== GETTERS Y SETTERS ====================
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    
    public DepartamentoEnum getTipo() { return tipo; }
    public void setTipo(DepartamentoEnum tipo) { this.tipo = tipo; }
    
    public String getUbicacionOficina() { return ubicacionOficina; }
    public void setUbicacionOficina(String ubicacionOficina) { 
        this.ubicacionOficina = ubicacionOficina; 
    }
    
    public String getTelefonoOficina() { return telefonoOficina; }
    public void setTelefonoOficina(String telefonoOficina) { 
        this.telefonoOficina = telefonoOficina; 
    }
    
    public int getCapacidadMaxima() { return capacidadMaxima; }
    public void setCapacidadMaxima(int capacidadMaxima) { 
        this.capacidadMaxima = capacidadMaxima; 
    }
    
    public List<Empleado> getEmpleados() { return empleados; }
}//fin de la clase