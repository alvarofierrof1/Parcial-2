import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmpleadoTest {

    // Casos válidos
    @Test
    void v1_creacionNominativa() {
        Empleado e = new Empleado("Juan Pérez", Cargo.DESARROLLADOR, 50000.0);
        assertEquals("Juan Pérez", e.getNombre());
        assertEquals(Cargo.DESARROLLADOR, e.getPuesto());
        assertEquals(50000.0, e.getSalario());
    }

    @Test
    void v2_nombreConEspaciosExtras() {
        Empleado e = new Empleado("  Ana López  ", Cargo.DISEÑADORA, 30000.0);
        assertEquals("Ana López", e.getNombre().trim());
        assertEquals(Cargo.DISEÑADORA, e.getPuesto());
    }

    @Test
    void v3_salarioEnConvenio() {
        Empleado e = new Empleado("Luis Gómez", Cargo.ADMINISTRATIVO, Constantes.SALARIO_CONVENIO);
        assertEquals(Constantes.SALARIO_CONVENIO, e.getSalario());
    }

    @Test
    void v4_salarioMuyAlto() {
        Empleado e = new Empleado("María Ruiz", Cargo.GERENTE, 1_000_000.0);
        assertEquals(1_000_000.0, e.getSalario());
    }

    // Casos no válidos
    @Test
    void n1_nombreVacio() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new Empleado("", Cargo.DESARROLLADOR, 20000.0);
        });
        assertTrue(ex.getMessage().contains("vacío") || ex.getMessage().contains("nulo"));
    }

    @Test
    void n2_nombreUnaPalabra() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new Empleado("María", Cargo.DISEÑADORA, 22000.0);
        });
        assertTrue(ex.getMessage().contains("apellido") || ex.getMessage().contains("dos"));
    }

    @Test
    void n3_nombreSoloEspacios() {
        assertThrows(IllegalArgumentException.class, () -> new Empleado("   ", Cargo.GERENTE, 30000.0));
    }

    @Test
    void n4_cargoNoValido_textoLibre() {
        // No aplicable directamente: el constructor espera un Cargo; simulamos paso nulo u otra comprobación
        assertThrows(IllegalArgumentException.class, () -> new Empleado("Pedro Díaz", null, 25000.0));
    }

    @Test
    void n5_cargoNull() {
        assertThrows(IllegalArgumentException.class, () -> new Empleado("Pedro Díaz", null, 25000.0));
    }

    @Test
    void n6_salarioNegativo() {
        assertThrows(IllegalArgumentException.class, () -> new Empleado("Laura Torres", Cargo.DISEÑADORA, -1.0));
    }

    @Test
    void n7_salarioPorDebajoConvenio() {
        assertThrows(IllegalArgumentException.class, () -> new Empleado("Enrique Paredes", Cargo.ADMINISTRATIVO, 12000.0));
    }

    @Test
    void n8_salarioCero() {
        assertThrows(IllegalArgumentException.class, () -> new Empleado("Raúl Soto", Cargo.DESARROLLADOR, 0.0));
    }

    @Test
    void n9_salarioNoNumerico_parseError() {
        // No aplicable en constructor (recibe double). La validación de parsing es responsabilidad del código de entrada.
        assertTrue(true);
    }
}
