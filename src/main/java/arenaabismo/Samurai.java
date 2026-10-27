package arenaabismo;

/**
 * Samurai: guerrero disciplinado.
 * - Arma: katana que SUMA dano extra al golpe.
 * - Ataque: dano = fuerza + dano del arma.
 * - Defensa: su armadura reduce 3 puntos a cada golpe recibido (minimo 1).
 */
public class Samurai extends Criatura {

    private final String arma;   // atributo propio: nombre del arma
    private final int danoArma;  // dano extra que suma el arma

    public Samurai(String nombre, int salud, int fuerza, String arma, int danoArma) {
        super(nombre, salud, fuerza);
        this.arma = arma;
        this.danoArma = danoArma;
    }

    @Override
    public void atacar(Criatura objetivo) {
        int dano = getFuerza() + danoArma; // fuerza base + arma
        System.out.println(getNombre() + " corta con su " + arma
                + " y causa " + dano + " de dano a " + objetivo.getNombre());
        objetivo.defender(dano);
    }

    @Override
    public void defender(int dano) {
        int danoReal = Math.max(1, dano - 3); // armadura: -3, minimo 1
        perderSalud(danoReal);
        System.out.println("   " + getNombre() + " bloquea con su armadura y recibe "
                + danoReal + " de dano.");
    }

    public String getArma() {
        return arma;
    }

    public int getDanoArma() {
        return danoArma;
    }
}
