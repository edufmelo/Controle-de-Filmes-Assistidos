import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Locale;

public class Sessao implements Comparable<Sessao> {
    private float preco;
    private String comentario_s;
    private Local local;
    private Filme filme;
    private LocalDateTime data;

    public Sessao(Filme filme, Local local, float preco, String comentario_s, int dia, int mes, int ano, int hora, int minuto) {
        this.filme = filme;
        this.local = local;
        this.preco = preco;
        this.comentario_s = comentario_s;
        this.data = LocalDateTime.of(ano, mes, dia, hora, minuto); // Inicializa a data e hora da sessão
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getComentario_s() {
        return comentario_s;
    }

    public void setComentario_s(String comentario_s) {
        this.comentario_s = comentario_s;
    }

    // Método para comparar duas sessões com base no nome do filme
    public int compareTo(Sessao sessao) {
        return this.filme.getNome().compareToIgnoreCase(sessao.getFilme().getNome());
    }

    // Método 0 para obter uma representação formatada da data da sessão
    public String getDataStrShort() {
        LocalDateTime date = getData();
        Locale locale = new Locale("pt", "BR");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy, EEE", locale);
        String text = date.format(formatter);
        // Removendo o ponto após a abreviação do mês
        text = text.replace(".", "");
        return text;
    }
    // Método 1 para obter uma representação formatada da data da sessão
    public String getDataStrShort1() {
        LocalDateTime date = getData();
        Locale locale = new Locale("pt", "BR");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM/yyyy", locale);
        String text = date.format(formatter);
        // Removendo o ponto após a abreviação do mês
        text = text.replace(".", "");
        return text;
    }
    // Método 2 para obter uma representação formatada da data da sessão
    public String getDataStrShort2() {
        LocalDateTime date = getData();
        Locale locale = new Locale("pt", "BR");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd(EEE, HH:mm)", locale);
        String text = date.format(formatter);
        // Removendo o ponto após a abreviação do mês
        text = text.replace(".", "");
        return text;
    }
    // Classe anônima para comparar sessões com base na avaliação do filme
    public static class ListagemOrdAva implements Comparator<Sessao> {
        @Override
        public int compare(Sessao sessao1, Sessao sessao2) {
            return sessao1.getFilme().getNota().compareTo(sessao2.getFilme().getNota());
        }
    }

    // Classe anônima para comparar sessões com base na data
    public static class ListagemOrdCro implements Comparator<Sessao> {
        @Override
        public int compare(Sessao sessao1, Sessao sessao2) {
            return sessao1.getData().compareTo(sessao2.getData());
        }
    }
}