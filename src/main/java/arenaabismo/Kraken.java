package arenaabismo;

/**
 * Kraken: monstruo marino gigante.
 * - Ataque: sus tentaculos golpean con el DOBLE de fuerza (fuerza * 2).
 * - Defensa: su piel viscosa le quita 2 puntos a cada golpe recibido.
 */
public class Kraken extends Criatura {

    private final int tentaculos; // atributo propio de esta criatura

    public Kraken(String nombre, int salud, int fuerza, int tentaculos) {
        super(nombre, salud, fuerza);
        this.tentaculos = tentaculos;
    }

    @Override
    public void atacar(Criatura objetivo) {
        int dano = getFuerza() * 2; // ataque mas fuerte que el de las demas
        System.out.println(getNombre() + " azota con sus " + tentaculos
                + " tentaculos y causa " + dano + " de dano a " + objetivo.getNombre());
        objetivo.defender(dano);
    }

    @Override
    public void defender(int dano) {
        int danoReal = Math.max(1, dano - 2); // piel viscosa: -2, minimo 1
        perderSalud(danoReal);
        System.out.println("   " + getNombre() + " resiste con su piel viscosa y recibe "
                + danoReal + " de dano.");
    }

    public int getTentaculos() {
        return tentaculos;
    }
}
