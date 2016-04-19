package boletin23;

/**
 *
 * @author mgonzalezlorenzo
 */
public class Libro {
    private String nome, autor;
    private float prezo;
    private int numUni;

    public Libro() {
    }

    public Libro(String nome, String autor, float prezo, int numUni) {
        this.nome = nome;
        this.autor = autor;
        this.prezo = prezo;
        this.numUni = numUni;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public float getPrezo() {
        return prezo;
    }

    public void setPrezo(float prezo) {
        this.prezo = prezo;
    }

    public int getNumUni() {
        return numUni;
    }

    public void setNumUni(int numUni) {
        this.numUni = numUni;
    }

    @Override
    public String toString() {
        return "Libro{" + "nome=" + nome + ", autor=" + autor + ", prezo=" + prezo + ", numUni=" + numUni + '}';
    }
    
    
}
