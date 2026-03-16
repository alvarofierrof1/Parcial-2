
# Sistema de Gestión de Empleados — Proyecto de práctica

## Descripción
Pequeña aplicación Java para gestionar empleados: definición de empleados, lista de cargos (enum), gestión de una colección de empleados (alta, listado, aumento salarial) y validaciones básicas.

## Autoría y versión
- Autor: (rellena tu nombre aquí)
- Versión: 1.0.0

## Estructura del proyecto
- `Empleado.java` — clase que representa un empleado (nombre, cargo, salario) con validaciones.
- `Cargo.java` — enumeración con los cargos profesionales permitidos.
- `Empleados.java` — gestor de la colección de empleados (atributo `lista`, métodos `darAlta`, `aumentarSalario`, `mostrarListado`).
- `SistemaGestionEmpleados.java` — clase con el `main` que inicializa el ejemplo y solicita un porcentaje para aumentar salarios.
- `Constantes.java` — constantes usadas en la aplicación (mensajes, valores por defecto, convenio salarial).
- `test/EmpleadoTest.java` — tests JUnit 5 que cubren casos válidos y no válidos para `Empleado`.
- `TESTING.md` — análisis de caja negra con tablas de casos válidos/no válidos.
- `bin/` — salida de los archivos compilados (.class).
- `lib/` — dependencias externas (por ejemplo `junit-platform-console-standalone.jar`).

## Cómo compilar y ejecutar
1) Abrir PowerShell en la carpeta del proyecto:

```powershell
cd 'C:\Users\315572\Desktop\examen\Examen'
```

2) Compilar las clases Java:

```powershell
javac -d bin Empleado.java Empleados.java SistemaGestionEmpleados.java Cargo.java Constantes.java
```

3) Ejecutar la aplicación principal (ejemplo enviando 10 como porcentaje):

```powershell
echo 10 | java -cp bin SistemaGestionEmpleados
```

## Tests (JUnit 5)
El proyecto incluye pruebas JUnit 5 en `test\EmpleadoTest.java`. Puedes ejecutar los tests usando el JAR standalone de JUnit Platform Console.

1) Coloca el JAR en `lib\` (por ejemplo `lib\junit-platform-console-standalone-1.9.4.jar`).
2) Compila incluyendo el JAR en el classpath:

```powershell
javac -d bin -cp .;lib\junit-platform-console-standalone-1.9.4.jar Empleado.java Empleados.java SistemaGestionEmpleados.java Cargo.java Constantes.java test\EmpleadoTest.java
```

3) Ejecuta los tests:

```powershell
java -jar .\lib\junit-platform-console-standalone-1.9.4.jar -cp bin --scan-class-path
```

## Notas y mejoras posibles
- Encapsular `lista` en `Empleados` haciéndola `private` y exponer sólo métodos seguros.
- Implementar internacionalización (I18N) usando `Constantes` o recursos externos.
- Añadir un sistema de persistencia (ficheros o base de datos) para almacenar empleados.
- Integrar el proyecto con Maven o Gradle para manejo de dependencias y ejecución de tests más sencilla.

## Contacto
Si quieres que agilice alguna de las mejoras (migración a Maven, ejecución automática de tests, generación de JavaDoc), dime cuál y lo implemento.
