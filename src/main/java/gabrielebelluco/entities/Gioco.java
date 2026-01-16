package gabrielebelluco.entities;

import java.util.Random;

public abstract class Gioco {
    private long id;
    private String titolo;
    private int annoPubblicazione;
    private double prezzo;

    public Gioco(String titolo, int annoPubblicazione, double prezzo) {
        Random rndm = new Random();
        this.prezzo = rndm.nextLong();
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.prezzo = prezzo;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public String getTitolo() {
        return titolo;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Gioco{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", prezzo=" + prezzo +
                '}';
    }
}
