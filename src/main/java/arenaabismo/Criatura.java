package arenaabismo;

/**
 * Clase abstracta que representa a cualquier criatura de la Arena del Abismo.
 *
 * Es abstracta porque no existe una "criatura generica": solo existen
 * Kraken, Nigromante y Samurai. Esta clase define lo que TODAS tienen en comun
 * y obliga a las hijas a implementar atacar() y defender().
 */
public abstract class Criatura {

    // ---------- Atributos (privados, segun el diagrama UML) ----------
    private final String nombre; // nombre de la criatura
    private int salud;           // puntos de vida (si llega a 0 o menos, muere)
    private final int fuerza;    // base para calcular el dano que causa

    /**
     * Constructor: lo usan las subclases con super(...).
     */
    protected Criatura(String nombre, int salud, int fuerza) {
        this.nombre = nombre;
        this.salud = salud;
        this.fuerza = fuerza;
    }

    // ---------- Metodos abstractos (cada hija los implementa a su manera) ----------

    /** La criatura ataca a su objetivo. */
    public abstract void atacar(Criatura objetivo);

    /** La criatura se defiende de un ataque que causa "dano" puntos. */
    public abstract void defender(int dano);

    // ---------- Metodo concreto (igual para todas las criaturas) ----------

    /** Una criatura esta viva mientras su salud sea mayor que 0. */
    public boolean estaViva() {
        return salud > 0;
    }

    // ---------- Metodos de apoyo ----------

    /**
     * Resta salud. Lo llaman las subclases dentro de defender().
     * La salud nunca baja de 0 para que no se vean numeros negativos.
     */
    protected void perderSalud(int cantidad) {
        salud = Math.max(0, salud - cantidad);
    }

    public String getNombre() {
        return nombre;
    }

    public int getSalud() {
        return salud;
    }

    public int getFuerza() {
        return fuerza;
    }

    @Override
    public String toString() {
        return nombre + " (salud: " + salud + ")";
    }
}
