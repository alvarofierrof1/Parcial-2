// ...existing code...
import java.util.Scanner;

public class SistemaGestionEmpleados {

    public static void main(String[] args) {
        Empleados empleados = new Empleados(3);

        // dar de alta los tres empleados usando Empleados.darAlta(...)
    empleados.darAlta(new Empleado("Juan", Cargo.DESARROLLADOR, 50000));
    empleados.darAlta(new Empleado("María", Cargo.DISEÑADORA, 45000));
    empleados.darAlta(new Empleado("Pedro", Cargo.GERENTE, 60000));

    Scanner scanner = new Scanner(System.in);
    System.out.print(Constantes.PROMPT_PORCENTAJE);
        double porcentaje = scanner.nextDouble();

        // usar el método de la nueva clase para aumentar salarios
        empleados.aumentarSalario(porcentaje);

    System.out.println(Constantes.LISTA_EMPLEADOS);
        // usar el método de la nueva clase para mostrar el listado
        empleados.mostrarListado();

        scanner.close();
    }
}
// ...existing code...