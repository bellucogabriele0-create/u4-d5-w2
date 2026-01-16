package gabrielebelluco;

import gabrielebelluco.Exceptions.IdNotFound;
import gabrielebelluco.Exceptions.ValidationException;
import gabrielebelluco.entities.*;

import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Collezione collezione = new Collezione();

        boolean dalloScanner = true;

        while (dalloScanner) {
            System.out.println("1) aggiungi videogioco");
            System.out.println("2) aggiungi hioco da gavolo");
            System.out.println("3) ricerca per ID");
            System.out.println("4) ricerca per prezzo massimo");
            System.out.println("5) ricerca per numero di giocatori");
            System.out.println("6) rimuovi gioco per ID");
            System.out.println("7) mostra statistiche");
            System.out.println("8) aggiorna gioco per ID");
            System.out.println("0) esci");
            System.out.print("Scegli un'opzione: ");

            int click = -1;
            try {
                click = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("numero non valido, inserisci un altro numero");
                continue;
            }

            switch (click) {
                case 1 -> aggiungiVideogioco(scanner, collezione);
                case 2 -> aggiungiGiocoDaTavolo(scanner, collezione);
                case 3 -> ricercaPerId(scanner, collezione);
                case 4 -> ricercaPerPrezzo(scanner, collezione);
                case 5 -> ricercaPerNumeroGiocatori(scanner, collezione);
                case 6 -> rimuoviPerId(scanner, collezione);
                case 7 -> collezione.;
                case 8 -> aggiornaGioco(scanner, collezione);
                case 0 -> {
                    dalloScanner = false;
                    System.out.println("arrivederci");
                }
                default -> System.out.println("opzione non valida");
            }
        }
        scanner.close();
    }

    private static void aggiungiVideogioco(Scanner scanner, Collezione collezione) {
        try {
            System.out.print("ID: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("titolo: ");
            String titolo = scanner.nextLine();
            System.out.print("anno pubblicazione ");
            int anno = Integer.parseInt(scanner.nextLine());
            System.out.print("prezzo");
            double prezzo = Double.parseDouble(scanner.nextLine());
            System.out.print("piattaforma scgli tra (pc ps5 e nintendo)");
            String piattaforma = scanner.nextLine();
            System.out.print("Durata di gioco (ore) ");
            int durata = Integer.parseInt(scanner.nextLine());
            System.out.print("genere scegli tra (AZIONE, STRATEGIA, SPORT, GUERRA) ");
            Genere genere = Genere.valueOf(scanner.nextLine().toUpperCase());

            Videogioco videogioco = new Videogioco(piattaforma, durata, genere, id, titolo, anno, prezzo);
            collezione.addGioco(videogioco);
        } catch (ValidationException | IllegalArgumentException e) {
            System.out.println("errore: " + e.getMessage());
        }
    }

    private static void aggiungiGiocoDaTavolo(Scanner scanner, Collezione collezione) {
        try {
            System.out.print("ID: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("titolo: ");
            String titolo = scanner.nextLine();
            System.out.print("anno pubblicazione: ");
            int anno = Integer.parseInt(scanner.nextLine());
            System.out.print("prezzo: ");
            double prezzo = Double.parseDouble(scanner.nextLine());
            System.out.print("numero di giocatori: ");
            int numGiocatori = Integer.parseInt(scanner.nextLine());
            System.out.print("durata media di una partita (minuti): ");
            int durataPartita = Integer.parseInt(scanner.nextLine());

            GiochiDaTavolo tavolo = new GiochiDaTavolo(durataPartita, numGiocatori, id, titolo, anno, prezzo);
            collezione.addGioco(tavolo);
        } catch (ValidationException | NumberFormatException e) {
            System.out.println("errore: " + e.getMessage());
        }
    }

    private static void ricercaPerId(Scanner scanner, Collezione collezione) {
        try {
            System.out.print("inserisci ID da cercare: ");
            int id = Integer.parseInt(scanner.nextLine());
            Gioco gioco = collezione.ricercaPerId(id);
            System.out.println("trovato: " + gioco);
        } catch (IdNotFound e) {
            System.out.println("errore: " + e.getMessage());
        }
    }

    private static void ricercaPerPrezzo(Scanner scanner, Collezione collezione) {
        System.out.print("prezzo massimo: ");
        try {
            double prezzo = Double.parseDouble(scanner.nextLine());
            List<Gioco> lista = collezione.ricercaPerPrezzo(prezzo);
            if (lista.isEmpty()) System.out.println("nessun gioco trovato sotto questo prezzo");
            else lista.forEach(System.out::println);
        } catch (NumberFormatException e) {
            System.out.println("prezzo non valido.");
        }
    }

    private static void ricercaPerNumeroGiocatori(Scanner scanner, Collezione collezione) {
        System.out.print("numero di giocatori: ");
        try {
            int num = Integer.parseInt(scanner.nextLine());
            List<GiochiDaTavolo> lista = collezione.ricercaNumGioc(num);
            if (lista.isEmpty()) System.out.println("nessun gioco da tavolo con questo numero di giocatori.");
            else lista.forEach(System.out::println);
        } catch (NumberFormatException e) {
            System.out.println("numero non valido.");
        }
    }

    private static void rimuoviPerId(Scanner scanner, Collezione collezione) {
        try {
            System.out.print("ID da rimuovere: ");
            int id = Integer.parseInt(scanner.nextLine());
            collezione.rimuoviPerId(id);
        } catch (IdNotFound | NumberFormatException e) {
            System.out.println("errore: " + e.getMessage());
        }
    }

    private static void aggiornaGioco(Scanner scanner, Collezione collezione) {
        try {
            System.out.print("ID da aggiornare: ");
            int id = Integer.parseInt(scanner.nextLine());
            Gioco gioco = collezione.ricercaPerId(id);

            System.out.println("titolo corrente: " + gioco.getTitolo());
            System.out.print("nuovo titolo (enter per mantenere): ");
            String titolo = scanner.nextLine();
            if (!titolo.isEmpty()) {
                // usa reflection o setter se disponibile, qui semplifico creando un nuovo oggetto
                if (gioco instanceof Videogioco v) {
                    Videogioco nuovo = new Videogioco(v.getPiattaforma(), v.getDurataDiGioco(), v.getGenere(),
                            v.getId(), titolo, v.getAnnoPubblicazione(), v.getPrezzo());
                    collezione.rimuoviPerId(id);
                    collezione.addGioco(nuovo);
                } else if (gioco instanceof GiochiDaTavolo g) {
                    GiochiDaTavolo nuovo = new GiochiDaTavolo(g.getDurataMediaDiUnaPartita(), g.getNumeroDiGiocatori(),
                            g.getId(), titolo, g.getAnnoPubblicazione(), g.getPrezzo());
                    collezione.rimuoviPerId(id);
                    collezione.addGioco(nuovo);
                }
            }
            System.out.println("aggiornamento completato.");
        } catch (IdNotFound | ValidationException e) {
            System.out.println("errore: " + e.getMessage());
        }
    }
}
