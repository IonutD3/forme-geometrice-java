
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * Clasa principală a aplicației.
 * Creează forme geometrice, afișează rezultatele
 * și demonstrează polimorfismul și validarea.
 */
public class Main {

    public static void main(String[] args) {

        // Creăm o listă cu diferite forme geometrice.
        // Toate obiectele sunt tratate prin interfața Forma.
        List<Forma> forme = Arrays.asList(
            new Cerc(5),
            new Dreptunghi(5, 8),
            new Patrat(6),
            new Triunghi(3, 4, 5)
        );

        // Afișăm dimensiunile, aria și perimetrul fiecărei forme.
        System.out.println("=== FORME GEOMETRICE - OOP ===\n");

        for (Forma forma : forme) {
            System.out.printf(
                Locale.US,
                "%s | %s | Aria: %.2f | Perimetru: %.2f%n",
                forma.nume(),
                forma.dimensiuni(),
                forma.aria(),
                forma.perimetru()
            );
        }

        // Demonstrăm polimorfismul:
        // aceeași interfață este folosită pentru forme diferite.
        System.out.println("\n=== POLIMORFISM ===");

        for (Forma forma : forme) {
            System.out.printf(
                Locale.US,
                "%s -> aria = %.2f | perimetru = %.2f%n",
                forma.nume(),
                forma.aria(),
                forma.perimetru()
            );
        }

        // Verificăm dacă este respins un triunghi invalid.
        System.out.println("\n=== TEST VALIDARE ===");

        try {
            new Triunghi(1, 2, 10);
        } catch (IllegalArgumentException exceptie) {
            System.out.println(
                "Validare corectă: " + exceptie.getMessage()
            );
        }
    }
}
