package arenaabismo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/** Pruebas de lo que comparten todas las criaturas (clase abstracta). */
class CriaturaTest {

    @Test
    void criaturaConSaludPositivaEstaViva() {
        Criatura c = new Samurai("Akira", 50, 10, "katana", 4);
        assertTrue(c.estaViva());
    }

    @Test
    void criaturaConSaludCeroEstaMuerta() {
        Criatura c = new Samurai("Akira", 10, 10, "katana", 4);
        c.defender(1000); // golpe enorme
        assertFalse(c.estaViva());
    }

    @Test
    void laSaludNuncaEsNegativa() {
        Criatura c = new Nigromante("Sombra", 5, 10, "baston", 3);
        c.defender(1000);
        assertEquals(0, c.getSalud());
    }

    @Test
    void gettersDevuelvenLosDatosDelConstructor() {
        Criatura c = new Kraken("Kraken", 100, 10, 8);
        assertEquals("Kraken", c.getNombre());
        assertEquals(100, c.getSalud());
        assertEquals(10, c.getFuerza());
    }
}
