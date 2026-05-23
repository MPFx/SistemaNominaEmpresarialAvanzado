package principal;

import model.*;
import service.*;
import util.*;
import enums.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase principal del Sistema de Nómina Empresarial.
 * Demuestra el uso de herencia y polimorfismo con diferentes tipos de empleados.
 * 
 * @author ISC Israel de Jesús Mar Parada (MPFx++)
 * @version 2.0.0
 */
public class Main {
    
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    
    /**
     * Método principal que ejecuta la demostración del sistema.
     * 
     * @param args Argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        LOGGER.log(Level.INFO, "INICIANDO SISTEMA DE NÓMINA EMPRESARIAL");
        
        System.out.println("=".repeat(60));
        System.out.println("SISTEMA DE NÓMINA EMPRESARIAL - DEMOSTRACIÓN");
        System.out.println("=".repeat(60));
        
        // ========== POLIMORFISMO EN ACCIÓN ==========
        List<Empleado> empleados = new ArrayList<>();
        
        System.out.println("\n1. CREANDO EMPLEADOS DE DIFERENTES TIPOS...");
        
        // ========== FORMA TRADICIONAL (constructores largos) ==========
        Empleado emp1 = new EmpleadoAsalariado(
            "Ana", "García", "EMP-0001", "ana@empresa.com", "912345678",
            1500000, LocalDate.of(2020, 1, 15), DepartamentoEnum.TI,
            500000, "Senior", 15
        );
        
        // ========== FORMA CON BUILDER (más legible) ==========
        Empleado emp2 = new EmpleadoBuilder("Luis", "Pérez", "EMP-0002", 800000,
                                            TipoEmpleado.POR_HORA, DepartamentoEnum.VENTAS)
                            .withEmail("luis@empresa.com")
                            .withTelefono("987654321")
                            .withFechaContratacion(LocalDate.of(2022, 3, 10))
                            .withHorasTrabajadas(160)
                            .withTarifaHora(5000)
                            .withTarifaHoraExtra(7500)
                            .withHorasExtras(10)
                            .build();
        
        Empleado emp3 = new EmpleadoBuilder("Carlos", "López", "EMP-0003", 1000000,
                                            TipoEmpleado.COMISION, DepartamentoEnum.VENTAS)
                            .withEmail("carlos@empresa.com")
                            .withTelefono("976543210")
                            .withFechaContratacion(LocalDate.of(2021, 6, 20))
                            .withVentasDelMes(2000000)
                            .withPorcentajeComision(15)
                            .withMetaVentasMensual(1500000)
                            .withBonoPorMeta(200000)
                            .build();
        
        Empleado emp4 = new EmpleadoBuilder("Marta", "Rodríguez", "EMP-0004", 1200000,
                                            TipoEmpleado.COMISION_MAS_BASE, DepartamentoEnum.VENTAS)
                            .withEmail("marta@empresa.com")
                            .withTelefono("965432109")
                            .withFechaContratacion(LocalDate.of(2019, 9, 5))
                            .withVentasDelMes(2500000)
                            .withPorcentajeComision(15)
                            .withMetaVentasMensual(2000000)
                            .withBonoPorMeta(300000)
                            .withSalarioBaseGarantizado(1100000)
                            .withTopeComision(500000)
                            .withAntiguedadMeses(36)
                            .build();
        
        empleados.add(emp1);
        empleados.add(emp2);
        empleados.add(emp3);
        empleados.add(emp4);
        
        // ========== DEMOSTRACIÓN DE POLIMORFISMO ==========
        System.out.println("\n2. DEMOSTRACIÓN DE POLIMORFISMO:");
        System.out.println("   (Recorriendo lista de Empleados y llamando a calcularPaga())");
        System.out.println("-".repeat(60));
        
        for (Empleado e : empleados) {
            System.out.printf("Empleado: %-15s | Tipo: %-12s | Paga: $%,.0f\n",
                e.getNombreCompleto(),
                e.getTipo(),
                e.calcularPaga());
            
            // Log con nivel INFO
            LOGGER.log(Level.INFO, "Empleado {0} - Paga: ${1}", 
                       new Object[]{e.getNombreCompleto(), e.calcularPaga()});
        }
        
        // ========== DEPARTAMENTOS ==========
        System.out.println("\n3. CREANDO DEPARTAMENTOS...");
        Departamento deptoTI = new Departamento(
            "Tecnologías de Información", "D001", 
            DepartamentoEnum.TI, "Piso 3", "221234567", 10
        );
        
        Departamento deptoVentas = new Departamento(
            "Ventas", "D002", 
            DepartamentoEnum.VENTAS, "Piso 2", "221234568", 15
        );
        
        deptoTI.agregarEmpleado(emp1);
        deptoVentas.agregarEmpleado(emp2);
        deptoVentas.agregarEmpleado(emp3);
        deptoVentas.agregarEmpleado(emp4);
        
        System.out.println("Departamento TI: " + deptoTI.getCantidadEmpleados() + " empleados");
        System.out.println("Departamento Ventas: " + deptoVentas.getCantidadEmpleados() + " empleados");
        
        // ========== NÓMINA ==========
        System.out.println("\n4. PROCESANDO NÓMINA...");
        Nomina nomina = new Nomina(
            "NOM-2024-01", 
            "Enero 2024",
            LocalDate.of(2024, 1, 1),
            LocalDate.of(2024, 1, 31),
            LocalDate.of(2024, 2, 5)
        );
        
        for (Empleado e : empleados) {
            nomina.agregarEmpleado(e);
        }
        
        nomina.procesarNomina();
        LOGGER.log(Level.INFO, "Nómina procesada. Total: ${0}", nomina.getTotalGeneral());
        
        // ========== REPORTE ==========
        System.out.println("\n5. GENERANDO REPORTE...");
        ReporteNomina reporte = new ReporteNomina(".", "nomina_enero_2024");
        reporte.generarReporteTexto(empleados, nomina);
        reporte.exportarCSV(empleados, nomina);
        
        // ========== VALIDACIONES ==========
        System.out.println("\n6. VALIDACIONES...");
        System.out.println("Validar ID EMP-0001: " + ValidacionEmpleado.validarId("EMP-0001"));
        System.out.println("Validar ID INV-001: " + ValidacionEmpleado.validarId("INV-001"));
        System.out.println("ID generado: " + ValidacionEmpleado.generarIdUnico());
        
        // ========== ESTADÍSTICAS ==========
        System.out.println("\n7. ESTADÍSTICAS DE DEPARTAMENTOS:");
        System.out.printf("Total nómina TI: $%,.0f\n", deptoTI.calcularTotalNomina());
        System.out.printf("Promedio sueldo Ventas: $%,.0f\n", deptoVentas.calcularPromedioSueldo());
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("DEMOSTRACIÓN DE POLIMORFISMO COMPLETADA");
        System.out.println("=".repeat(60));
        
        LOGGER.log(Level.INFO, "SISTEMA FINALIZADO CORRECTAMENTE");
    }
}
// fin de la clase Main