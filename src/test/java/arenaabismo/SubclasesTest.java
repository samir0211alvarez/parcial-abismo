package arenaabismo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/** Pruebas del ataque y la defensa unicos de cada subclase. */
class SubclasesTest {

    // ---------- Kraken ----------
    @Test
    void krakenAtacaConElDobleDeFuerza() {
        Criatura kraken = new Kraken("Kraken", 100, 10, 8);
        Criatura objetivo = new Nigromante("Sombra", 100, 5, "baston", 3);
        kraken.atacar(objetivo);
        // dano = 10*2 = 20; el escudo de huesos absorbe 5 -> recibe 15
        assertEquals(85, objetivo.getSalud());
    }

    @Test
    void krakenReduceDosPuntosDeDano() {
        Criatura kraken = new Kraken("Kraken", 100, 10, 8);
        kraken.defender(10);
        assertEquals(92, kraken.getSalud()); // 10 - 2 = 8
    }

    // ---------- Nigromante ----------
    @Test
    void nigromanteAtacaConFuerzaMasArma() {
        Criatura nigro = new Nigromante("Sombra", 100, 12, "baston", 3);
        Criatura objetivo = new Kraken("Kraken", 100, 5, 8);
        nigro.atacar(objetivo);
        // dano = 12 (fuerza) + 3 (baston) = 15; el kraken reduce 2 -> recibe 13
        assertEquals(87, objetivo.getSalud());
    }

    @Test
    void nigromanteAbsorbeUnCuartoDelDano() {
        Criatura nigro = new Nigromante("Sombra", 100, 12, "baston", 3);
        nigro.defender(20);
        assertEquals(85, nigro.getSalud()); // 20 - 5 = 15
    }

    @Test
    void nigromanteGuardaSuArma() {
        Nigromante nigro = new Nigromante("Sombra", 100, 12, "baston", 3);
        assertEquals("baston", nigro.getArma());
        assertEquals(3, nigro.getDanoArma());
    }

    // ---------- Samurai ----------
    @Test
    void samuraiAtacaConFuerzaMasArma() {
        Criatura samurai = new Samurai("Akira", 100, 10, "katana", 4);
        Criatura objetivo = new Nigromante("Sombra", 100, 5, "baston", 3);
        samurai.atacar(objetivo);
        // dano = 10 (fuerza) + 4 (katana) = 14; el escudo absorbe 3 -> recibe 11
        assertEquals(89, objetivo.getSalud());
    }

    @Test
    void samuraiReduceTresPuntosDeDano() {
        Criatura samurai = new Samurai("Akira", 100, 10, "katana", 4);
        samurai.defender(10);
        assertEquals(93, samurai.getSalud()); // 10 - 3 = 7
    }

    @Test
    void samuraiGuardaSuArma() {
        Samurai samurai = new Samurai("Akira", 100, 10, "katana", 4);
        assertEquals("katana", samurai.getArma());
        assertEquals(4, samurai.getDanoArma());
    }

    @Test
    void elDanoRecibidoSiempreEsAlMenosUno() {
        Criatura samurai = new Samurai("Akira", 100, 10, "katana", 4);
        samurai.defender(2); // 2 - 3 seria negativo, pero se cobra 1
        assertEquals(99, samurai.getSalud());
    }
}
