# Forme Geometrice în Java

## 🇷🇴 Română

### Descriere

Proiectul implementează patru forme geometrice: cerc, dreptunghi, pătrat și triunghi. Fiecare formă dispune de propriile metode pentru calcularea ariei și perimetrului, iar toate formele respectă un contract comun definit printr-o interfață.

Aplicația evidențiază utilizarea abstracției, moștenirii, încapsulării și polimorfismului într-o structură modulară, în care fiecare clasă este definită într-un fișier Java separat.

## Funcționalități

- Calcularea ariei și perimetrului pentru patru forme geometrice.
- Afișarea numelui și a dimensiunilor fiecărei forme.
- Validarea dimensiunilor introduse prin constructori.
- Verificarea inegalității triunghiului pentru identificarea configurațiilor invalide.
- Formatarea rezultatelor numerice cu două zecimale.
- Demonstrarea polimorfismului prin procesarea formelor folosind o interfață comună.

## Tehnologii utilizate

- **Java** — limbajul de programare.
- **Java Collections Framework** — utilizarea interfeței `List` și a metodei `Arrays.asList()`.
- **Java Math API** — utilizarea constantelor și funcțiilor matematice, precum `Math.PI` și `Math.sqrt()`.
- **Excepții** — utilizarea `IllegalArgumentException` pentru respingerea dimensiunilor invalide.

## Concepte de programare orientată pe obiecte

- Încapsulare – utilizarea câmpurilor și a constructorilor pentru gestionarea datelor obiectelor.

- Abstracție – definirea interfeței Forma și a clasei abstracte FormaGeometrica.

- Moștenire – reutilizarea funcționalităților prin extinderea claselor de bază.

- Polimorfism – tratarea formelor geometrice prin intermediul interfeței comune Forma.

### 1. Abstracție și interfață

Interfața `Forma` definește comportamentul comun tuturor formelor geometrice.

```java
public interface Forma {
    double aria();
    double perimetru();
    String dimensiuni();
    String nume();
}
```

Fiecare clasă concretă implementează metodele interfeței, oferind formulele și comportamentul specifice formei respective.

### 2. Clasă abstractă și moștenire

Clasa abstractă `FormaGeometrica` implementează interfața `Forma` și centralizează proprietățile comune, precum numele formei.

```java
public abstract class FormaGeometrica implements Forma {

    protected final String nume;

    protected FormaGeometrica(String nume) {
        this.nume = nume;
    }

    @Override
    public String nume() {
        return nume;
    }
}
```

Clasele `Cerc`, `Dreptunghi` și `Triunghi` extind această clasă abstractă. Clasa `Patrat` extinde `Dreptunghi` și reutilizează metodele de calcul existente.

### 3. Polimorfism

Formele geometrice sunt stocate într-o listă de tip `Forma` și procesate folosind aceleași metode, indiferent de implementarea concretă.

```java
List<Forma> forme = Arrays.asList(
    new Cerc(5),
    new Dreptunghi(5, 8),
    new Patrat(6),
    new Triunghi(3, 4, 5)
);

for (Forma forma : forme) {
    System.out.printf(
        "%s | Aria: %.2f | Perimetru: %.2f%n",
        forma.nume(),
        forma.aria(),
        forma.perimetru()
    );
}
```

Acest exemplu demonstrează polimorfismul: fiecare obiect execută propria implementare a metodelor `aria()` și `perimetru()`.

### 4. Încapsulare și validarea datelor

Dimensiunile formelor sunt inițializate prin constructori și validate înainte de crearea obiectelor.

Pentru triunghi, fiecare latură trebuie să fie pozitivă, iar suma oricăror două laturi trebuie să fie strict mai mare decât a treia latură.

```java
if (a <= 0 || b <= 0 || c <= 0
        || a + b <= c
        || a + c <= b
        || b + c <= a) {
    throw new IllegalArgumentException(
        "Laturile nu formează un triunghi valid."
    );
}
```

## Formule matematice

| Formă | Arie | Perimetru |
|---|---|---|
| Cerc | \(A = \pi r^2\) | \(P = 2\pi r\) |
| Dreptunghi | \(A = L \cdot l\) | \(P = 2(L+l)\) |
| Pătrat | \(A = a^2\) | \(P = 4a\) |
| Triunghi | Formula lui Heron | \(P = a+b+c\) |

Pentru triunghi, formula lui Heron este:

\[
A = \sqrt{p(p-a)(p-b)(p-c)}
\]

unde \(p = (a+b+c)/2\) este semiperimetrul.

## Structura proiectului

```text
forme-geometrice-java/
├── src/
│   ├── Main.java
│   ├── Forma.java
│   ├── FormaGeometrica.java
│   ├── Cerc.java
│   ├── Dreptunghi.java
│   ├── Patrat.java
│   └── Triunghi.java
└── README.md
```

| Fișier | Responsabilitate |
|---|---|
| `Main.java` | Punctul de intrare și demonstrarea funcționalităților |
| `Forma.java` | Interfața comună |
| `FormaGeometrica.java` | Clasa abstractă de bază |
| `Cerc.java` | Calculul ariei și perimetrului cercului |
| `Dreptunghi.java` | Calculul ariei și perimetrului dreptunghiului |
| `Patrat.java` | Implementarea pătratului prin moștenire |
| `Triunghi.java` | Calculul ariei, perimetrului și validarea laturilor |

## Cerințe

- JDK 8 sau o versiune ulterioară.
- Terminal sau mediu de dezvoltare compatibil cu Java.

## Compilare și rulare

Dacă fișierele sunt în directorul `src` și nu folosesc declarații `package`, execută:

```bash
javac *.java
java Main
```

Aplicația poate fi rulată și dintr-un mediu de dezvoltare precum IntelliJ IDEA sau Eclipse, prin executarea clasei `Main`.

## Exemplu de rezultat

```text
=== FORME GEOMETRICE - OOP ===

Cerc | raza = 5.00 | Aria: 78.54 | Perimetru: 31.42
Dreptunghi | lungime = 5.00, lățime = 8.00 | Aria: 40.00 | Perimetru: 26.00
Pătrat | latură = 6.00 | Aria: 36.00 | Perimetru: 24.00
Triunghi | laturi = 3.00, 4.00, 5.00 | Aria: 6.00 | Perimetru: 12.00

=== POLIMORFISM ===
Cerc -> aria = 78.54 | perimetru = 31.42
Dreptunghi -> aria = 40.00 | perimetru = 26.00
Pătrat -> aria = 36.00 | perimetru = 24.00
Triunghi -> aria = 6.00 | perimetru = 12.00

=== TEST VALIDARE ===
Validare corectă: Laturile nu formează un triunghi valid.
```

## Validare

Aplicația validează dimensiunile geometrice prin intermediul constructorilor. În cazul triunghiurilor, toate lungimile laturilor trebuie să fie pozitive și să respecte inegalitatea triunghiului.

De exemplu, laturile 1, 2 și 10 sunt respinse deoarece nu pot forma un triunghi valid.

---

# Geometric Shapes in Java

## 🇬🇧 English

### Description

The project implements four geometric shapes: circle, rectangle, square, and triangle. Each shape provides its own methods for calculating area and perimeter, while all shapes follow a common contract defined by an interface.

The application demonstrates abstraction, inheritance, encapsulation, and polymorphism in a modular structure where each class is defined in a separate Java source file.

## Features

- Calculates the area and perimeter of four geometric shapes.
- Displays each shape's name and dimensions.
- Validates dimensions through constructors.
- Checks the triangle inequality to reject invalid triangles.
- Formats numerical results to two decimal places.
- Demonstrates polymorphism by processing shapes through a common interface.

## Technologies

- **Java** — programming language.
- **Java Collections Framework** — uses the `List` interface and `Arrays.asList()`.
- **Java Math API** — uses mathematical constants and functions, including `Math.PI` and `Math.sqrt()`.
- **Exception handling** — uses `IllegalArgumentException` to reject invalid dimensions.

## Object-Oriented Programming Concepts

- Encapsulation – uses fields and constructors to manage object data.

- Abstraction – defines the Forma interface and the FormaGeometrica abstract class.

- Inheritance – reuses functionality by extending base classes.

- Polymorphism – handles different geometric shapes through the common Forma interface.

### 1. Abstraction and interfaces

The `Forma` interface defines the common behavior shared by all geometric shapes.

```java
public interface Forma {
    double aria();
    double perimetru();
    String dimensiuni();
    String nume();
}
```

Each concrete class implements the interface methods, providing calculations and behavior specific to its shape.

### 2. Abstract classes and inheritance

The `FormaGeometrica` abstract class implements the `Forma` interface and centralizes shared properties, such as the shape name.

```java
public abstract class FormaGeometrica implements Forma {

    protected final String nume;

    protected FormaGeometrica(String nume) {
        this.nume = nume;
    }

    @Override
    public String nume() {
        return nume;
    }
}
```

The `Cerc`, `Dreptunghi`, and `Triunghi` classes extend the abstract base class. The `Patrat` class extends `Dreptunghi` and reuses its existing calculation methods.

### 3. Polymorphism

Geometric shapes are stored in a `Forma` list and processed through the same methods, regardless of their concrete implementation.

```java
List<Forma> forme = Arrays.asList(
    new Cerc(5),
    new Dreptunghi(5, 8),
    new Patrat(6),
    new Triunghi(3, 4, 5)
);

for (Forma forma : forme) {
    System.out.printf(
        "%s | Aria: %.2f | Perimetru: %.2f%n",
        forma.nume(),
        forma.aria(),
        forma.perimetru()
    );
}
```

This demonstrates polymorphism: each object executes its own implementation of the `aria()` and `perimetru()` methods.

### 4. Encapsulation and validation

Shape dimensions are initialized through constructors and validated before objects are created.

For a triangle, all sides must be positive, and the sum of any two sides must be strictly greater than the third side.

```java
if (a <= 0 || b <= 0 || c <= 0
        || a + b <= c
        || a + c <= b
        || b + c <= a) {
    throw new IllegalArgumentException(
        "Laturile nu formează un triunghi valid."
    );
}
```

## Mathematical Formulas

| Shape | Area | Perimeter |
|---|---|---|
| Circle | \(A = \pi r^2\) | \(P = 2\pi r\) |
| Rectangle | \(A = L \cdot W\) | \(P = 2(L+W)\) |
| Square | \(A = a^2\) | \(P = 4a\) |
| Triangle | Heron's formula | \(P = a+b+c\) |

For a triangle, Heron's formula is:

\[
A = \sqrt{p(p-a)(p-b)(p-c)}
\]

where \(p = (a+b+c)/2\) is the semiperimeter.

## Project Structure

```text
forme-geometrice-java/
├── src/
│   ├── Main.java
│   ├── Forma.java
│   ├── FormaGeometrica.java
│   ├── Cerc.java
│   ├── Dreptunghi.java
│   ├── Patrat.java
│   └── Triunghi.java
└── README.md
```

| File | Responsibility |
|---|---|
| `Main.java` | Application entry point and feature demonstration |
| `Forma.java` | Common interface |
| `FormaGeometrica.java` | Abstract base class |
| `Cerc.java` | Circle area and perimeter calculations |
| `Dreptunghi.java` | Rectangle area and perimeter calculations |
| `Patrat.java` | Square implementation through inheritance |
| `Triunghi.java` | Triangle calculations and side validation |

## Requirements

- JDK 8 or later.
- A terminal or a Java-compatible development environment.

## Build and Run

If the source files are located in the `src` directory and do not use `package` declarations, execute:

```bash
javac *.java
java Main
```

The application can also be run from an IDE such as IntelliJ IDEA or Eclipse by executing the `Main` class.

## Example Output

```text
=== FORME GEOMETRICE - OOP ===

Cerc | raza = 5.00 | Aria: 78.54 | Perimetru: 31.42
Dreptunghi | lungime = 5.00, lățime = 8.00 | Aria: 40.00 | Perimetru: 26.00
Pătrat | latură = 6.00 | Aria: 36.00 | Perimetru: 24.00
Triunghi | laturi = 3.00, 4.00, 5.00 | Aria: 6.00 | Perimetru: 12.00

=== POLIMORFISM ===
Cerc -> aria = 78.54 | perimetru = 31.42
Dreptunghi -> aria = 40.00 | perimetru = 26.00
Pătrat -> aria = 36.00 | perimetru = 24.00
Triunghi -> aria = 6.00 | perimetru = 12.00

=== TEST VALIDARE ===
Validare corectă: Laturile nu formează un triunghi valid.
```

## Validation

The application validates geometric dimensions through constructors. For triangles, all side lengths must be positive and satisfy the triangle inequality.

For example, the sides 1, 2, and 10 are rejected because they cannot form a valid triangle.

---

## 👤 Autor / Author

**IonutD**
