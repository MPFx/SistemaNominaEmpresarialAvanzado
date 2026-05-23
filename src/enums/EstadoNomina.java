package enums;

/**
 * Enumeración que representa los estados posibles del proceso de nómina.
 * 
 * @author ISC Israel de Jesús Mar Parada (MPFx++)
 * @version 1.0
 * @since 2023-01-15
 */
public enum EstadoNomina {
    /** Nómina creada pero aún no procesada */
    PENDIENTE,
    
    /** Nómina calculada y lista para pago */
    PROCESADA,
    
    /** Nómina pagada a los empleados */
    PAGADA,
    
    /** Nómina anulada por error o cambio de período */
    CANCELADA
}//fin de la clase