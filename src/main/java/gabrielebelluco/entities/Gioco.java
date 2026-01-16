package gabrielebelluco.entities;

public abstract class Gioco {
    private int id;
    private String titolo;
    private int annoPubblicazione;
    private double prezzo;

    public Gioco(String titolo, int annoPubblicazione, double prezzo) {
        this.id = id;
        this.prezzo = prezzo;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;


        if (prezzo <= 0)
            System.out.println("il prezzo deve essere maggiore di 0");

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
