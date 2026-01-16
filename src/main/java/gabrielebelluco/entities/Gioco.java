package gabrielebelluco.entities;

import gabrielebelluco.Exceptions.ValidationException;

public abstract class Gioco {
    private int id;
    private String titolo;
    private int annoPubblicazione;
    private double prezzo;

    public Gioco(int id, String titolo, int annoPubblicazione, double prezzo) {
        this.id = id;
        this.prezzo = prezzo;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;


        if (prezzo <= 0) {
            throw new ValidationException("Il prezzo deve essere maggiore di 0");
        }
    }

    public int getId() {
        return id;
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
