import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Aplicacao {
    private static Lista sessoes = new Lista(); // Lista de sessões
    private static Scanner teclado = new Scanner(System.in); // Scanner para entrada do usuário

    public static void main(String[] args) {
        int opcao_menu;
        // chamada ao método de classe (método static)
        do {
            System.out.println("\n\n----- Menu principal -----\n");
            System.out.println("0 - Sair do menu");
            System.out.println("1 - Cadastrar filme");
            System.out.println("2 - Mostrar dados do filme");
            System.out.println("3 - Editar filme");
            System.out.println("4 - Listagem de filmes");
            System.out.println("5 - Listagem em ordem alfabética (A-Z)");
            System.out.println("6 - Listagem de ordem alfabética invertida (Z-A)");
            System.out.println("7 - Listagem em ordem de avaliação");
            System.out.println("8 - Listagem em ordem cronológica");
            System.out.println("9 - Listagem dos favoritos");
            System.out.print("\nEscolha alguma opção no menu: ");
            opcao_menu = teclado.nextInt();
            teclado.nextLine(); // remover entre do buffer de teclado
            switch (opcao_menu) {
                case 1:
                    sessoes.append(CadastrarSessao());
                    break;
                case 2:
                    procurarFilme();
                    break;
                case 3:
                    EditarFilme();
                    break;
                case 4:
                    ListarFilme();
                    break;
                case 5:
                    sessoes.sortAZ();
                    ListarFilme();
                    break;
                case 6:
                    sessoes.sortZA();
                    ListarFilme();
                    break;
                case 7:
                    listagemOrdAva();
                    break;
                case 8:
                    listagemOrdCro();
                    break;
                case 9:
                    ListarFavorito();
                    break;
            }
        } while (opcao_menu != 0);
        teclado.close(); // Fechar o Scanner quando terminar de usar
    }

    public static Sessao CadastrarSessao() {
        System.out.println("\n\n>> Incluir Filme <<\n");
        System.out.print("Nome do Filme: ");
        String nome = teclado.nextLine();

        System.out.println("\n---- Escolha uma nota de 1 a 5 ----\n");
        System.out.println("1 - Ruim");
        System.out.println("2 - Regular");
        System.out.println("3 - Bom");
        System.out.println("4 - Muito bom");
        System.out.println("5 - Excelente\n");
        System.out.print("Nota: ");
        int notaInt = teclado.nextInt();
        Avaliacao nota = null;
        switch (notaInt) {
            case 1:
                nota = Avaliacao.RUIM;
                break;
            case 2:
                nota = Avaliacao.REGULAR;
                break;
            case 3:
                nota = Avaliacao.BOM;
                break;
            case 4:
                nota = Avaliacao.MUITO_BOM;
                break;
            case 5:
                nota = Avaliacao.EXCELENTE;
                break;
            default:
                System.out.println("Opção inválida, nota não definida.");
                nota = null;
                break;
        }
        teclado.nextLine();


        System.out.print("Favorito <Sim/Nao>: ");
        String fav = teclado.nextLine();
        boolean favorito = false; // Inicializa como false por padrão
        if (fav.equalsIgnoreCase("S") || fav.equalsIgnoreCase("sim")) {
            favorito = true; // Define como true se o usuário digitou "sim"
        }

        System.out.print("Data (dd/mm/aaa): ");
        String data = teclado.nextLine();
        String dataSplit[] = data.split("/");
        int dia = Integer.valueOf(dataSplit[0]);
        int mes = Integer.valueOf(dataSplit[1]);
        int ano = Integer.valueOf(dataSplit[2]);

        System.out.print("Horário (hh:mm): ");
        String hora = teclado.nextLine();
        String horaSplit[] = hora.split(":");
        int h = Integer.valueOf(horaSplit[0]);
        int min = Integer.valueOf(horaSplit[1]);

        System.out.print("Preço: ");
        float preco = teclado.nextFloat();
        teclado.nextLine();

        System.out.print("Local: ");
        String localfilme = teclado.nextLine();

        System.out.print("Deseja comentar o filme (S/N)? ");
        String coment1 = teclado.nextLine();
        String comfilme = null;
        if (coment1.equalsIgnoreCase("S") || coment1.equalsIgnoreCase("sim")) {
            System.out.print("Comentário do filme: ");
            comfilme = teclado.nextLine();
        }

        System.out.print("Deseja comentar o Sessão (S/N)? ");
        String coment2 = teclado.nextLine();
        String comsessao = null;
        if (coment2.equalsIgnoreCase("S") || coment2.equalsIgnoreCase("sim")) {
            System.out.print("Comentário do Sessão: ");
            comsessao = teclado.nextLine();
        }

        Filme filme = new Filme(nome, nota, favorito, comfilme);
        Local local = new Local(localfilme);

        return new Sessao(filme,local, preco, comsessao,dia, mes, ano, h, min);
    }
/*
    public static Filme procurarFilme(){
        System.out.print("Nome do filme: ");
        String nomefilme = teclado.nextLine();

        // for each disponivel pois Lista implementa iterable (ou seja, método iterator)
        for(Sessao sessao: sessoes){
            if (sessao.getFilme().getNome().toUpperCase().contains(nomefilme.toUpperCase())){
                System.out.print("Encontrei o filme: " + sessao.getFilme().getNome());
                System.out.print("\nÉ o filme procurado <S/N>? \nR: ");
                String opcao = teclado.nextLine();
                if (opcao.equalsIgnoreCase("S") || opcao.equalsIgnoreCase("sim")){
                    System.out.println("\n----- Dados do Filme -----");
                    System.out.println("\nNome do Filme: " + sessao.getFilme().getNome());

                    if(sessao.getFilme().getNota() == Avaliacao.RUIM){
                        System.out.println("Nota: ★");
                    }else if(sessao.getFilme().getNota() == Avaliacao.REGULAR){
                        System.out.println("Nota: ★★");
                    }else if(sessao.getFilme().getNota() == Avaliacao.BOM){
                        System.out.println("Nota: ★★★");
                    }else if(sessao.getFilme().getNota() == Avaliacao.MUITO_BOM){
                        System.out.println("Nota: ★★★★");
                    }else if(sessao.getFilme().getNota() == Avaliacao.EXCELENTE){
                        System.out.println("Nota: ★★★★★");
                    }else {
                        System.out.println("Nota: não declarada!");
                    }

                    if (sessao.getFilme().isFavorito()){
                        System.out.println("Favorito: Sim");
                    } else {
                        System.out.println("Favorito: Não");
                    }

                    System.out.println("Data: " + sessao.getDataStrShort() + " - " + sessao.getData().format(DateTimeFormatter.ofPattern("HH:mm")) );

                    System.out.println("Preço: R$" + sessao.getPreco());

                    System.out.println("Local: " + sessao.getLocal().getNome());

                    if (sessao.getFilme().getComentarioF() == null){
                        System.out.println("Comentário do Filme: Filme não possui comentário.");
                    } else{
                        System.out.println("Comentário do Filme: " + sessao.getFilme().getComentarioF());
                    }

                    if (sessao.getComentario_s() == null){
                        System.out.println("Comentário da Sessão: Sessão não possui comentário.");
                    } else {
                        System.out.println("Comentário da Sessão: " + sessao.getComentario_s());
                    }
                }
            }
        }
        return null;
    }
*/
    // Procura o filme na lista de sessões e exibe os detalhes se encontrado
    public static Filme procurarFilme() {
    System.out.print("Nome do filme: ");
    String nomefilme = teclado.nextLine();

    for (Sessao sessao : sessoes) {
        if (sessao.getFilme().getNome().toUpperCase().contains(nomefilme.toUpperCase())) {
            System.out.print("\nEncontrei o filme: " + sessao.getFilme().getNome());
            System.out.print("\nÉ o filme procurado <S/N>? \nR: ");
            String opcao = teclado.nextLine();

            if (opcao.equalsIgnoreCase("S") || opcao.equalsIgnoreCase("sim")) {
                System.out.println("\n----- Dados do Filme -----\n");
                System.out.println("Nome do Filme: " + sessao.getFilme().getNome());
                if(sessao.getFilme().getNota() == Avaliacao.RUIM){
                        System.out.println("Nota: ★");
                    }else if(sessao.getFilme().getNota() == Avaliacao.REGULAR){
                        System.out.println("Nota: ★★");
                    }else if(sessao.getFilme().getNota() == Avaliacao.BOM){
                        System.out.println("Nota: ★★★");
                    }else if(sessao.getFilme().getNota() == Avaliacao.MUITO_BOM){
                        System.out.println("Nota: ★★★★");
                    }else if(sessao.getFilme().getNota() == Avaliacao.EXCELENTE){
                        System.out.println("Nota: ★★★★★");
                    }else {
                        System.out.println("Nota: não declarada!");
                    }
                System.out.println("Favorito: " + (sessao.getFilme().isFavorito() ? "Sim" : "Não"));
                System.out.println("Data: " + sessao.getDataStrShort() + " - " + sessao.getData().format(DateTimeFormatter.ofPattern("HH:mm")) );
                System.out.println("Preço: R$" + sessao.getPreco());
                System.out.println("Local: " + sessao.getLocal().getNome());
                System.out.println("Comentário do Filme: " + (sessao.getFilme().getComentarioF() == null ? "Filme não possui comentário." : sessao.getFilme().getComentarioF()));
                System.out.println("Comentário da Sessão: " + (sessao.getComentario_s() == null ? "Sessão não possui comentário." : sessao.getComentario_s()));

                // Uma vez que encontramos o filme desejado, podemos retornar aqui
                return sessao.getFilme();
            }
        }
    }
    // Se nenhum filme correspondente for encontrado, retornamos null
    System.out.println("Filme não encontrado!");
    return null;
}

    public static void EditarFilme(){
        System.out.print("Nome do filme para editar: ");
        String nomefilme = teclado.nextLine();

        // for each disponivel pois Lista implementa iterable (ou seja, método iterator)
        for(Sessao sessao: sessoes){
            if (sessao.getFilme().getNome().toUpperCase().contains(nomefilme.toUpperCase())){
                System.out.print("\nEncontrei o filme: " + sessao.getFilme().getNome());
                System.out.print("\nÉ o filme procurado para edição <S/N>? \nR: ");
                String opcao = teclado.nextLine();
                if (opcao.equalsIgnoreCase("S") || opcao.equalsIgnoreCase("sim")) {
                    System.out.println("\n----- Dados do Filme -----");
                    System.out.println("Nome do Filme: " + sessao.getFilme().getNome());
                    if (sessao.getFilme().getNota() == Avaliacao.RUIM) {
                        System.out.println("Nota: ★");
                    } else if (sessao.getFilme().getNota() == Avaliacao.REGULAR) {
                        System.out.println("Nota: ★★");
                    } else if (sessao.getFilme().getNota() == Avaliacao.BOM) {
                        System.out.println("Nota: ★★★");
                    } else if (sessao.getFilme().getNota() == Avaliacao.MUITO_BOM) {
                        System.out.println("Nota: ★★★★");
                    } else if (sessao.getFilme().getNota() == Avaliacao.EXCELENTE) {
                        System.out.println("Nota: ★★★★★");
                    } else {
                        System.out.println("Nota: não declarada!");
                    }
                    System.out.println("Favorito: " + (sessao.getFilme().isFavorito() ? "Sim" : "Não"));
                    System.out.println("Data: " + sessao.getDataStrShort() + " - " + sessao.getData().format(DateTimeFormatter.ofPattern("HH:mm")));
                    System.out.println("Preço: R$" + sessao.getPreco());
                    System.out.println("Local: " + sessao.getLocal().getNome());
                    System.out.println("Comentário do Filme: " + (sessao.getFilme().getComentarioF() == null ? "Filme não possui comentário." : sessao.getFilme().getComentarioF()));
                    System.out.println("Comentário da Sessão: " + (sessao.getComentario_s() == null ? "Sessão não possui comentário." : sessao.getComentario_s()));
                }
                    System.out.print("\nDeseja editar a nota do filme? <S/N>\nR: ");
                    String opeditar = teclado.nextLine();
                    if (opeditar.equalsIgnoreCase("S") || opeditar.equalsIgnoreCase("sim")) {
                        System.out.println("\n---- Escolha uma nota de 1 a 5 ----\n");
                        System.out.println("1 - Ruim");
                        System.out.println("2 - Regular");
                        System.out.println("3 - Bom");
                        System.out.println("4 - Muito bom");
                        System.out.println("5 - Excelente\n");
                        System.out.print("Nota: ");
                        int notaInt = teclado.nextInt();
                        Avaliacao nota = null;
                        switch (notaInt) {
                            case 1:
                                nota = Avaliacao.RUIM;
                                break;
                            case 2:
                                nota = Avaliacao.REGULAR;
                                break;
                            case 3:
                                nota = Avaliacao.BOM;
                                break;
                            case 4:
                                nota = Avaliacao.MUITO_BOM;
                                break;
                            case 5:
                                nota = Avaliacao.EXCELENTE;
                                break;
                            default:
                                System.out.println("Opção inválida, nota não definida.");
                                nota = null;
                                break;
                        }
                        teclado.nextLine();
                        sessao.getFilme().setNota(nota);
                    }

                        System.out.print("\nDeseja editar o comentário do filme (S/N)?\nR: ");
                        String coment1 = teclado.nextLine();
                        String comfilme = null;
                        if (coment1.equalsIgnoreCase("S") || coment1.equalsIgnoreCase("sim")) {
                            System.out.print("Comentário do Filme: ");
                            comfilme = teclado.nextLine();
                            sessao.getFilme().setComentarioF(comfilme);
                        }

                        System.out.print("\nDeseja editar o comentário da sessão (S/N)?\nR: ");
                        String coment2 = teclado.nextLine();
                        String comsessao = null;
                        if (coment2.equalsIgnoreCase("S") || coment2.equalsIgnoreCase("sim")) {
                            System.out.print("Comentário da Sessão: ");
                            comsessao = teclado.nextLine();
                            sessao.setComentario_s(comsessao);
                        }
                    }
                }
    }

    public static void ListarFilme() {
        System.out.println("\n\n>> Listar filmes <<\n");
        Iterator<Sessao> iterator = sessoes.iterator();
        while (iterator.hasNext()) {
            Sessao sessao = iterator.next();
            System.out.println(sessao.getFilme().getNome() + " (" + sessao.getDataStrShort() + ") - " + sessao.getLocal().getNome());

        }
    }

    // Método auxiliar para verificar se há filmes com uma determinada nota na lista
    private static boolean temFilmesComNota(Avaliacao nota) {
        for (Sessao sessao : sessoes) {
            if (sessao.getFilme().getNota() == nota) {
                return true;
            }
        }
        return false;
    }

    public static void listagemOrdAva() {
        sessoes.sortAZ();
        System.out.println("\nListagem dos filmes em ordem de avaliação: \n");
        if (temFilmesComNota(Avaliacao.EXCELENTE)) {
            System.out.println("Nota 5 (★★★★★):");
            for (Sessao sessao : sessoes) {
                if (sessao.getFilme().getNota() == Avaliacao.EXCELENTE) {
                    System.out.println(sessao.getFilme().getNome() + " (" + sessao.getDataStrShort() + ") - " + sessao.getLocal().getNome());
                }
            }
        }
        if (temFilmesComNota(Avaliacao.MUITO_BOM)) {
            System.out.println("\nNota 4 (★★★★):");
            for (Sessao sessao : sessoes) {
                if (sessao.getFilme().getNota() == Avaliacao.MUITO_BOM) {
                    System.out.println(sessao.getFilme().getNome() + " (" + sessao.getDataStrShort() + ") - " + sessao.getLocal().getNome());
                }
            }
        }
        if (temFilmesComNota(Avaliacao.BOM)) {
            System.out.println("\nNota 3 (★★★):");
            for (Sessao sessao : sessoes) {
                if (sessao.getFilme().getNota() == Avaliacao.BOM) {
                    System.out.println(sessao.getFilme().getNome() + " (" + sessao.getDataStrShort() + ") - " + sessao.getLocal().getNome());
                }
            }
        }
        if (temFilmesComNota(Avaliacao.REGULAR)) {
            System.out.println("\nNota 2 (★★):");
            for (Sessao sessao : sessoes) {
                if (sessao.getFilme().getNota() == Avaliacao.REGULAR) {
                    System.out.println(sessao.getFilme().getNome() + " (" + sessao.getDataStrShort() + ") - " + sessao.getLocal().getNome());
                }
            }
        }
        if(temFilmesComNota(Avaliacao.RUIM)) {
            System.out.println("\nNota 1 (★):");
            for (Sessao sessao : sessoes) {
                if (sessao.getFilme().getNota() == Avaliacao.RUIM) {
                    System.out.println(sessao.getFilme().getNome() + " (" + sessao.getDataStrShort() + ") - " + sessao.getLocal().getNome());
                }
            }
        }
    }

    public static void listagemOrdCro() {
        sessoes.sortAZ();
        sessoes.sortOrdCro(); // Ordena a lista original sessoes em ordem cronológica
        System.out.println("\nListagem dos filmes em ordem cronológica: \n");
        for (Sessao sessao : sessoes) {
            System.out.println(sessao.getDataStrShort1());
            System.out.println(sessao.getDataStrShort2() + " - " + sessao.getFilme().getNome() + " - " + sessao.getLocal().getNome()+"\n");
        }
    }

    // Itera sobre a lista de sessões e exibe apenas os filmes marcados como favoritos
    public static void ListarFavorito() {
        sessoes.sortAZ();
        System.out.println("\n\n>> Listar filmes favoritos <<\n");
        Iterator<Sessao> iterator = sessoes.iterator();
        while (iterator.hasNext()) {
            Sessao sessao = iterator.next();
            if(sessao.getFilme().isFavorito() == true){
                System.out.println(sessao.getFilme().getNome() + " (" + sessao.getDataStrShort() + ") - " + sessao.getLocal().getNome());
            }
        }
    }
}