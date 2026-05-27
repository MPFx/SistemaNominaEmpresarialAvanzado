# Sistema de Nómina Empresarial - Versión Avanzada (Java)

# Sistema de Nómina Empresarial - Versión Avanzada (Java)

> 📌 **Esta es la VERSIÓN 2.0 (avanzada)**  
> 👉 ¿Buscas la versión base (1.0)? → [SistemaNominaEmpresarialJava](https://github.com/MPFx/SistemaNominaEmpresarialJava)


## Versión
**2.0.0**

## Descripción
Versión avanzada del Sistema de Nómina Empresarial desarrollado en Java. Incorpora mejoras técnicas profesionales como Logger (java.util.logging) y Builder Pattern, manteniendo la demostración de herencia y polimorfismo con diferentes tipos de empleados (Asalariado, Por Hora, Comisión, Comisión+Base).

## Alcance

### ✅ Qué hace (versión avanzada)
- Gestionar diferentes tipos de empleados usando herencia
- Calcular pagas mensuales según el tipo de empleado
- Procesar nóminas y generar reportes en CSV
- **Registrar todos los eventos en archivo de log (nomina.log)**
- **Crear empleados usando Builder Pattern (código más legible)**
- Validar datos de empleados
- Demostrar polimorfismo con lista de tipo `Empleado`

### ❌ Qué NO hace
- No tiene interfaz gráfica (solo consola)
- No tiene pruebas unitarias (próximamente)
- No tiene persistencia en archivos (próximamente)

## Novedades de esta versión (2.0.0)

| Característica      |     Versión 1.0.0    |       Versión 2.0.0        |
|---------------------|----------------------|----------------------------|
| Registro de eventos |  System.out.println  |  java.util.logging.Logger  |
| Creación de objetos | Constructores largos | Builder Pattern fluido     |
| Trazabilidad        | Ninguna              | Archivo  nomina.log        |
| Mantenibilidad      | Baja                 | Alta                       |

## Justificación de las mejoras

### 1. Logger profesional (java.util.logging)

**Problema en versión original:**
- Los mensajes se perdían al cerrar la consola
- No había niveles de severidad (INFO, WARNING, SEVERE)
- No se podía rastrear el flujo de ejecución

**Solución implementada:**
- Todos los System.out.println reemplazados por LOGGER.log()
- Archivo nomina.log persistente
- Niveles de log: INFO, WARNING, SEVERE

**Beneficio:** Trazabilidad completa y depuración profesional.

### 2. Builder Pattern

**Problema en versión original:**

Código java

// Constructor con 10+ parámetros - difícil de leer

new EmpleadoAsalariado("Ana", "García", "EMP-0001", "ana@empresa.com", 
    "912345678", 1500000, LocalDate.of(2020,1,15), DepartamentoEnum.TI,
    500000, "Senior", 15);## Solución implementada

Código java

// Builder fluido - fácil de leer y modificar

new EmpleadoBuilder("Ana", "García", "EMP-0001", 1500000,
                    TipoEmpleado.ASALARIADO, DepartamentoEnum.TI)
    .withEmail("ana@empresa.com")
    .withTelefono("912345678")
    .withFechaContratacion(LocalDate.of(2020, 1, 15))
    .withBonoAnual(500000)
    .withNivelJerarquico("Senior")
    .withDiasVacaciones(15)
    .build();
**Beneficio:** Código más legible, mantenible y menos propenso a errores.

## Jerarquía de Clases

|         Clase            |          Tipo             |          Descripción             |
|--------------------------|---------------------------|----------------------------------|
| Empleado                 | Abstracta                 | Clase base con atributos comunes |
| EmpleadoAsalariado       | Hija                      | Sueldo fijo mensual + bono anual |
| EmpleadoPorHora | Hija   | Paga por horas trabajadas                                    |
| EmpleadoComision | Hija  | Sueldo base + comisión por ventas                            |
| EmpleadoComisionMasBase  | Hija                      | Garantía de sueldo mínimo + comisión tope |
| EmpleadoBuilder          | **NUEVO**                 | Builder para creación fluida de empleados |

## Tipos de Empleado

| Tipo | Descripción |
|------|-------------|
| ASALARIADO | Sueldo fijo mensual + bono anual |
| POR_HORA | Paga por horas trabajadas + horas extras |
| COMISION | Sueldo base + comisión por ventas |
| COMISION_MAS_BASE | Sueldo base garantizado + comisión con tope |

## Departamentos

| Departamento | Descripción |
|--------------|-------------|
| VENTAS | Departamento de ventas y atención al cliente |
| MARKETING | Departamento de marketing y publicidad |
| TI | Departamento de tecnologías de información |
| FINANZAS | Departamento de finanzas y contabilidad |
| RRHH | Departamento de recursos humanos |
| OPERACIONES | Departamento de operaciones y logística |

## Ejemplo de Builder Pattern

Código java

// Forma tradicional (versión 1.0.0)

Empleado emp = new EmpleadoAsalariado("Ana", "García", "EMP-0001", 
    "ana@empresa.com", "912345678", 1500000, LocalDate.of(2020,1,15),
    DepartamentoEnum.TI, 500000, "Senior", 15);

// Forma con Builder (versión 2.0.0)

Empleado emp = new EmpleadoBuilder("Ana", "García", "EMP-0001", 1500000,
                                    TipoEmpleado.ASALARIADO, DepartamentoEnum.TI)
                    .withEmail("ana@empresa.com")
                    .withTelefono("912345678")
                    .withFechaContratacion(LocalDate.of(2020, 1, 15))
                    .withBonoAnual(500000)
                    .withNivelJerarquico("Senior")
                    .withDiasVacaciones(15)
                    .build();
## Ejemplo de Logger

Código java

// En lugar de System.out.println
LOGGER.log(Level.INFO, "Empleado creado: {0}", nombre);
LOGGER.log(Level.WARNING, "Empleado desactivado: {0}", nombre);
## Documentación Javadoc

[https://mpfx.github.io/SistemaNominaEmpresarialJava_Avanzado/](https://mpfx.github.io/SistemaNominaEmpresarialJava_Avanzado/)

## Tecnologías

- Java 17+
- java.util.logging
- Builder Pattern
- Javadoc
- GitHub Pages

## Modo de uso

**Este proyecto NO es una aplicación visual/gráfica.**
Funciona exclusivamente por consola (CLI - Command Line Interface).

## Propósito

**Educativo / Pedagógico - Nivel Avanzado**

- Programación orientada a objetos en Java
- Herencia y polimorfismo
- Builder Pattern (creación fluida de objetos)
- Logger profesional (trazabilidad)
- Buenas prácticas de desarrollo
- Documentación técnica con Javadoc
- Control de versiones con Git y GitHub Pages

## Autor

**ISC Israel de Jesús Mar Parada (MPFx++)**

## Derechos de autor

**© 2024 ISC Israel de Jesús Mar Parada (MPFx++)**
Todos los derechos reservados.

Este proyecto ha sido desarrollado exclusivamente con fines educativos.
