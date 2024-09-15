public class Filme {

    // Atributos
    private String nome;
    private boolean favorito;
    private String comentarioF;
    private Avaliacao nota;


    // Metodos especiais
    public Filme(String nome, Avaliacao nota, boolean favorito, String comentarioF){
        this.nome = nome;
        this.nota = nota;
        this.favorito = favorito;
        this.comentarioF = comentarioF;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Avaliacao getNota() {
        return nota;
    }

    public void setNota(Avaliacao nota) {
        this.nota = nota;
    }

    public boolean isFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }

    public String getComentarioF() {
        return comentarioF;
    }

    public void setComentarioF(String comentarioF) {
        this.comentarioF = comentarioF;
    }
}
