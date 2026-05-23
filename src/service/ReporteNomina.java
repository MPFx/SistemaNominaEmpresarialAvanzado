package service;

import model.Empleado;
import enums.EstadoNomina;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Clase encargada de generar reportes de nómina.
 * Permite generar reportes en texto y exportar a CSV.
 * 
 * @author ISC Israel de Jesús Mar Parada (MPFx++)
 * @version 1.0
 * @since 2023-01-15
 */
public class ReporteNomina {
    
    // ==================== ATRIBUTOS ====================
    
    /** Ruta donde se exportarán los archivos */
    private String rutaExportacion;
    
    /** Nombre base del archivo a exportar */
    private String nombreArchivo;
    
    
    // ==================== CONSTRUCTOR ====================
    
    /**
     * Constructor de ReporteNomina.
     * 
     * @param rutaExportacion Ruta donde guardar los archivos
     * @param nombreArchivo   Nombre base del archivo
     */
    public ReporteNomina(String rutaExportacion, String nombreArchivo) {
        this.rutaExportacion = rutaExportacion;
        this.nombreArchivo = nombreArchivo;
    }
    
    
    // ==================== MÉTODOS ====================
    
    /**
     * Genera un reporte en formato texto mostrando en consola.
     * 
     * @param empleados Lista de empleados a reportar
     * @param nomina    Objeto nómina con información del período
     */
    public void generarReporteTexto(List<Empleado> empleados, Nomina nomina) {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("REPORTE DE NÓMINA - " + nomina.getIdNomina());
        System.out.println("=".repeat(60));
        System.out.printf("Período: %s al %s\n", nomina.getFechaInicio(), nomina.getFechaFin());
        System.out.printf("Estado: %s\n", nomina.getEstado());
        System.out.println("-".repeat(60));
        System.out.printf("%-15s %-20s %-15s\n", "ID", "Empleado", "Paga Mensual");
        System.out.println("-".repeat(60));
        
        for (Empleado e : empleados) {
            System.out.printf("%-15s %-20s $%-14.2f\n", 
                e.getIdEmpleado(), 
                e.getNombreCompleto(), 
                e.calcularPaga());
        }
        
        System.out.println("-".repeat(60));
        System.out.printf("TOTAL GENERAL: $%.2f\n", nomina.getTotalGeneral());
        System.out.println("=".repeat(60));
    }
    
    /**
     * Exporta el reporte a un archivo CSV.
     * 
     * @param empleados Lista de empleados a exportar
     * @param nomina    Objeto nómina con información del período
     */
    public void exportarCSV(List<Empleado> empleados, Nomina nomina) {
        String archivo = rutaExportacion + "/" + nombreArchivo + ".csv";
        try (PrintWriter writer = new PrintWriter(new FileWriter(archivo))) {
            writer.println("ID,Nombre,Apellido,SueldoBase,PagaMensual,Departamento,Tipo");
            for (Empleado e : empleados) {
                writer.printf("%s,%s,%s,%.2f,%.2f,%s,%s\n",
                    e.getIdEmpleado(),
                    e.getNombre(),
                    e.getApellido(),
                    e.getSueldoBase(),
                    e.calcularPaga(),
                    e.getDepartamento(),
                    e.getTipo());
            }
            writer.printf("\nTOTAL NOMINA,%.2f\n", nomina.getTotalGeneral());
            System.out.println("Archivo CSV exportado: " + archivo);
        } catch (IOException ex) {
            System.err.println("Error al exportar CSV: " + ex.getMessage());
        }
    }
    
    /**
     * Imprime un resumen breve de la nómina.
     * 
     * @param nomina Objeto nómina a resumir
     */
    public void imprimirResumen(Nomina nomina) {
        System.out.println("\n--- RESUMEN NÓMINA ---");
        System.out.println("ID: " + nomina.getIdNomina());
        System.out.println("Período: " + nomina.getPeriodo());
        System.out.println("Total empleados: " + nomina.getEmpleados().size());
        System.out.printf("Total a pagar: $%.2f\n", nomina.getTotalGeneral());
        System.out.println("Estado: " + nomina.getEstado());
    }
    
    
    // ==================== GETTERS Y SETTERS ====================
    
    public String getRutaExportacion() { return rutaExportacion; }
    public void setRutaExportacion(String rutaExportacion) { 
        this.rutaExportacion = rutaExportacion; 
    }
    
    public String getNombreArchivo() { return nombreArchivo; }
    public void setNombreArchivo(String nombreArchivo) { 
        this.nombreArchivo = nombreArchivo; 
    }
}//fin de la clase