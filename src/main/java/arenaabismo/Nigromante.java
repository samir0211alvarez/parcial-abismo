package arenaabismo;

/**
 * Nigromante: invocador de espiritus.
 * - Arma: baston maldito que SUMA dano extra al golpe.
 * - Ataque: dano = fuerza + dano del arma.
 * - Defensa: un escudo de huesos absorbe 25% del dano (el resultado se
 *   redondea hacia abajo, pero siempre recibe al menos 1).
 */
public class Nigromante extends Criatura {

    private final String arma;   // atributo propio: nombre del arma
    private final int danoArma;  // dano extra que suma el arma

    public Nigromante(String nombre, int salud, int fuerza, String arma, int danoArma) {
        super(nombre, salud, fuerza);
        this.arma = arma;
        this.danoArma = danoArma;
    }

    @Override
    public void atacar(Criatura objetivo) {
        int dano = getFuerza() + danoArma; // fuerza base + arma
        System.out.println(getNombre() + " golpea con su " + arma
                + " y causa " + dano + " de dano a " + objetivo.getNombre());
        objetivo.defender(dano);
    }

    @Override
    public void defender(int dano) {
        int danoReal = Math.max(1, dano - dano / 4); // el escudo absorbe 25%
        perderSalud(danoReal);
        System.out.println("   " + getNombre() + " se cubre con su escudo de huesos y recibe "
                + danoReal + " de dano.");
    }

    public String getArma() {
        return arma;
    }

    public int getDanoArma() {
        return danoArma;
    }
}
