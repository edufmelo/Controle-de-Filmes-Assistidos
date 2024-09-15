import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Lista implements Iterable<Sessao> {
    private ArrayList<Sessao> lista;

    public Lista(){
        lista = new ArrayList<>();
        SessionList(); // Chamar lista de sessoes
    }

    // Método para inicializar a lista de sessões com alguns exemplos
    public void SessionList() {
        Filme filme01 = new Filme("Todos Menos Voce", Avaliacao.MUITO_BOM,false, "Filme romântico muito bom e " +
                "engraçado, uma comedia romântica que vale a pena ver.");
        Filme filme02 = new Filme("Homem-Aranha: Sem Volta para Casa", Avaliacao.EXCELENTE,true, "Um dos melhores filmes que ja vi na minha vida, " +
                "tem muitas referencias e traz muita nostalgia.");
        Filme filme03 = new Filme("Elementos", Avaliacao.BOM,false, "Filme de animação muito fofo que mostra que os opostos também podem se atrair.");
        Filme filme04 = new Filme("Kung Fu Panda 4", Avaliacao.BOM,false, "Filme divertido, porem o quarto filme da saga na minha opinião e o mais “fraco” de todos, " +
                "mas esta opiniao nao e apenas formada por aspectos técnicos, mas também por aspectos sentimentais");
        Filme filme05 = new Filme("Barbie", Avaliacao.REGULAR, false, "Achei interessante a pegada de mostrar o feminismo, mas acho que o filme exagerou e focou só nisso.");
        Local local01 = new Local("Shopping São José");
        Local local02 = new Local("Shopping Palladium");
        Local local03 = new Local("Shopping & Sports");
        Local local04 = new Local("Shopping Estação");

        // Criacao dos objetos Sessao (com filme e local) dentro da lista para o arraylist lista nao ficar vazio
        lista.add(new Sessao(filme01, local01, 12.99f, "Fui com duas amigas e pedimos pipoca.", 25, 2, 2024, 16, 30));
        lista.add(new Sessao(filme02, local01, 15.00f, "A sessao fazia muito barulho toda vez que tinha algo nostalgico.", 22, 12, 2022,21,20));
        lista.add(new Sessao(filme03, local03, 21.99f, "Ficamos sentados perto de uma criança que nos incomodou.",  23, 6, 2023, 17,0));
        lista.add(new Sessao(filme04, local02, 44.00f, "A sessao estava tranquila.", 30, 3, 2024,15,40));
        lista.add(new Sessao(filme05, local04, 39.90f, "Muitas crianças gritando, no qual, atrapalharam a sessão.", 29, 7, 2023, 18,10));
    }
    // Métodos para ordenar a lista de sessões
    public void sortAZ(){
        Collections.sort(lista);
    }
    public void sortZA(){
        Collections.sort(lista, Collections.reverseOrder());
    }
    public void sortOrdCro() {
        Collections.sort(lista, new Sessao.ListagemOrdCro());
    }
    public void sortOrdAva() {
        Collections.sort(lista, new Sessao.ListagemOrdAva());
    }
    // Implementação do método iterator para permitir a iteração sobre a lista de sessões
    @Override
    public Iterator<Sessao> iterator() {
        return lista.iterator();
    }

    public void append(Sessao sessao) {
        lista.add(sessao);
    }
}