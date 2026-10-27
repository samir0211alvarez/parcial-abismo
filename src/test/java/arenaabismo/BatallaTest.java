package arenaabismo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/** Pruebas de la simulacion de batalla y del polimorfismo. */
class BatallaTest {

    @Test
    void laBatallaTerminaConUnGanadorVivoYUnPerdedorMuerto() {
        Criatura a = new Kraken("Kraken", 50, 10, 8);
        Criatura b = new Samurai("Akira", 50, 5, "katana", 4);

        Criatura ganador = Main.simularBatalla(a, b);

        assertTrue(ganador.estaViva());
        assertFalse(a.estaViva() && b.estaViva()); // no pueden quedar las dos vivas
    }

    @Test
    void laCriaturaMasFuerteGana() {
        Criatura fuerte = new Kraken("Kraken", 50, 10, 8);
        Criatura debil = new Samurai("Akira", 50, 5, "katana", 4);

        Criatura ganador = Main.simularBatalla(fuerte, debil);

        assertSame(fuerte, ganador);
        assertEquals(0, debil.getSalud());
    }

    @Test
    void polimorfismoTodasSeTratanComoCriatura() {
        // Un solo arreglo de tipo Criatura guarda las tres subclases
        Criatura[] criaturas = {
            new Kraken("K", 100, 10, 8),
            new Nigromante("N", 100, 10, "baston", 3),
            new Samurai("S", 100, 10, "katana", 4)
        };
        Criatura objetivo = new Samurai("Dummy", 1000, 1, "palo", 0);

        for (Criatura c : criaturas) {
            int antes = objetivo.getSalud();
            c.atacar(objetivo); // cada una ataca a su manera
            assertTrue(objetivo.getSalud() < antes);
        }
    }
}
