# Arena del Abismo

**Parcial II - Parte Práctica - Programación II - G411**

Simulador de batallas entre criaturas hecho en Java, usando **clases abstractas y polimorfismo**.

## Integrantes

| Nombre | Responsabilidad |
|---|---|
| **SAMIR CORREA ALVAREZ Y DEIBY ALEXANDER VELASCO CORAL** | Clase abstracta `Criatura`, clase `Kraken`, `Main` con la simulación de batalla y README |
| **DEIBY APELLIDO** | Clases `Nigromante` y `Samurai` y pruebas unitarias (JUnit) |

## Descripción

Criaturas de distintos tipos pelean por turnos hasta que una muere. Todas se manejan como
`Criatura`, pero cada tipo ataca y se defiende de forma diferente.

## Diseño (UML)

```
          Main
            |  utiliza
            v
     <<abstract>> Criatura
     - nombre: String
     - salud: int
     - fuerza: int
     + atacar(Criatura objetivo)   (abstracto)
     + defender(int daño)          (abstracto)
     + estaViva(): boolean
        ^           ^            ^
        |           |            |
     Kraken     Nigromante    Samurai
  - tentaculos  - arma        - arma
                - danoArma    - danoArma
```

## Criaturas

| Criatura | Arma | Ataque | Defensa |
|---|---|---|---|
| **Kraken** | Tentáculos (sin arma extra) | `fuerza * 2` | Reduce 2 puntos de daño (piel viscosa) |
| **Nigromante** | Bastón maldito (+3 de daño) | `fuerza + daño del arma` | Absorbe 25 % del daño (escudo de huesos) |
| **Samurai** | Katana (+4 de daño) | `fuerza + daño del arma` | Reduce 3 puntos de daño (armadura) |

En todas, el daño recibido nunca es menor a 1 (así la batalla siempre termina).

## Conceptos aplicados

- **Clase abstracta:** `Criatura` define atributos, `estaViva()` y los métodos abstractos `atacar` y `defender`.
- **Polimorfismo:** `Main.simularBatalla(Criatura, Criatura)` funciona con cualquier subclase sin saber cuál es.
- **Encapsulamiento:** atributos privados con getters.

## Estructura del proyecto

```
parcial-abismo/
├── pom.xml
├── README.md
├── .gitignore
└── src/
    ├── main/java/arenaabismo/
    │   ├── Criatura.java
    │   ├── Kraken.java
    │   ├── Nigromante.java
    │   ├── Samurai.java
    │   └── Main.java
    └── test/java/arenaabismo/
        ├── CriaturaTest.java
        ├── SubclasesTest.java
        └── BatallaTest.java
```

## Requisitos

- Java JDK 17 o superior
- Apache Maven 3.8 o superior

## Cómo compilar, probar y ejecutar

```bash
# Compilar
mvn compile

# Ejecutar las pruebas unitarias
mvn test

# Ejecutar el juego
mvn exec:java
```

## Pruebas unitarias (JUnit 5)

- `CriaturaTest`: `estaViva()`, salud nunca negativa, getters.
- `SubclasesTest`: ataque (con armas) y defensa únicos de cada criatura.
- `BatallaTest`: la batalla termina con un ganador y el polimorfismo.

## Flujo de trabajo en Git

Trabajo en pareja: cada integrante desarrolló sus partes en ramas propias y las fusionó a `main`
mediante Pull Requests **aprobados por el otro integrante**.

| Rama | Autor | Contenido | Aprobó |
|---|---|---|---|
| `feature/criatura` | TU NOMBRE | `Criatura` y `Kraken` | Deiby |
| `feature/nigromante-samurai` | Deiby | `Nigromante` y `Samurai` | TU NOMBRE |
| `feature/batalla` | TU NOMBRE | `Main` y `simularBatalla` | Deiby |
| `feature/tests` | Deiby | Pruebas unitarias | TU NOMBRE |
| `docs/readme` | TU NOMBRE | Documentación final | Deiby |
