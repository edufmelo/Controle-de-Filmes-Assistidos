# Projeto - Filmes Assistidos  <img width = "30" height = "30" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/java/java-plain.svg" />
          
          
**O projeto apresenta funcionalidade como:**


1) *cadastrar filme*: efetua o cadastro de um novo filme assistido em uma determinada sessão. Para tal cadastra o objeto filme, com nome, nota, se é um dos favoritos e eventualmente comentários (o usuário opta se quer ou não comentar o filme) e/ou outros opcionais. Conclui o cadastro da sessão com a data/hora, preço e local, sendo
apresentado para uma lista de locais já existentes (ArrayList locais) para escolher um já armazendao ou cadastrar um
novo local (que passa a integrar a lista). O usuário também pode incluir os comentários sobre a sessão. Ou seja, são
dois comentários, filme e sessão, mas são atributos opcionais para o usuário.

2) *mostrar dados do filme*: solicita o nome ou parte de um nome de um filme, percorre a lista de filmes (usando a variável lista, da classe Lista) e mostra o resultado da busca pelo nome, um a um, caso o filme desejado seja encontrado, mostra todos os detalhes daquele filme e de sua respectiva sessão (exibe todos os atributos envolvidos).

3) *edita filme*: idem à opção 2 na parte de procurar, porém depois de encontrar o filme, permite a edição da nota (usuário resolveu alterar a nota daquele filme) e dos comentários (do filme, da sessão ou de ambos, conforme implementação).

4) *listagem de filmes*: imprime todos os filmes assistidos, com suas respectivas sessões, com data, dia da semana e local.
   
5) *listagem em ordem alfabética (A-Z)*: o sistema ordena a lista de filmes pela ordem natural (atributo nome, implementando a interface Comparable).
   
6) *listagem em ordem alfabética invertida (Z-A)*: O sistema ordena a lista de filmes de forma invertida em relação à ordem natural (atributo nome), utilizando um comparator que inverte a ordem natural.
    
7) *listagem em ordem de avaliação*: o sistema ordena a lista de filmes pela ordem das notas atribuídas (atributo nota, usando Comparator) e, dentro da mesma nota, por ordem alfabética.

8) *listagem em ordem cronológica*: o sistema ordena a lista de filmes pela ordem cronológica (atributo data, usando Comparator), do mais antigo para o mais recente.
    
9) *listagem dos favoritos*: o sistema mostra apenas os filmes que foram cadastrados como favoritos, apresenta a lista em ordem alfabética.

*Linguagem utilizada: Java*
