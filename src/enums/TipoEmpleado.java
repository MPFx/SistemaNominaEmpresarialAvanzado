package enums;

/**
 * Enumeración que define los tipos de empleados disponibles en el sistema.
 * Cada tipo determina la forma de cálculo de sueldo y bonificaciones.
 * 
 * @author ISC Israel de Jesús Mar Parada (MPFx++)
 * @version 1.0
 * @since 2023-01-15
 */
public enum TipoEmpleado {
    /** Empleado con sueldo fijo mensual */
    ASALARIADO,
    
    /** Empleado que cobra por horas trabajadas */
    POR_HORA,
    
    /** Empleado que cobra comisión por ventas */
    COMISION,
    
    /** Empleado con sueldo base más comisión por ventas */
    COMISION_MAS_BASE
}//fin de la clase