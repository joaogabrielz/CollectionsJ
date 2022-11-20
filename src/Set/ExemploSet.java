package Set;

import java.util.*;

public class ExemploSet {

  public static void main(String[] args) {
    // lista notas

    // Set<Double> notas = new HashSet(); // antes java 5

    // HashSet<Double> notas = new HashSet<>();

    //  Set<Double> notas = new HashSet<>(); // Generics(jdk 5) - diamong operador(jdk7)

    // Set<Double> notas = Set.of(7d, 8.5, 9.3, 5d, 0d, 3.6);
    //Erro fica fixo sem poder remover ou adiiocnar, IMUTAVEL
    //  notas.add(1d);
    //  notas.remove(5d);
    //  System.out.println(notas);

    //Criando conjunto e adicionando notas
    Set<Double> notas = new HashSet<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
    // nao é ordenado, elementos repetidos, so entra 1 vez
    System.out.println(notas);

    // não tem posicao, nao se pode trabalhar com posicao dentro do Set
    // {
    // pegue posicao da nota 5 - X
    // adiciona nota8 na posicao 4 - X
    // substitua nota 5 pela nota 6 - X
    // exiba 3 nota adicionada - X
    //Remove Posicao 0 - X

    // }

    //COnfira se a nota 5 esta no conjunto
    System.out.println("---Nota esta no conjunto----");
    System.out.println(notas.contains(5d));

    // Menor nota
    System.out.println("---Menor nota----");
    System.out.println(Collections.min(notas));

    // Maior nota
    System.out.println("---Maior nota----");
    System.out.println(Collections.max(notas));

    // Soma dos valores
    System.out.println("---Soma valores nota----");
    Iterator<Double> iterator = notas.iterator();
    Double soma = 0d;
    while(iterator.hasNext()){
      Double num = iterator.next();
      soma += num;
    }
    System.out.println(String.format("%.2f", soma));


    //Media das notas
    System.out.println("---Media----");
    System.out.println(String.format("%.2f", soma/notas.size()));

    //Remove nota 0
    System.out.println("---remove nota 0----");
    notas.remove(0d);
    System.out.println(notas.toString());

    //notas < 7
    System.out.println("---notas < 7----");
    Iterator<Double> iterator2 = notas.iterator();
    while(iterator2.hasNext()){
      Double num = iterator2.next();
      if(num < 7)
        iterator2.remove();
    }
    System.out.println(notas.toString());


    //Notas na ordem q foram informadas
    System.out.println("Notas na ordem q forma informados");
    // so com linkedhashset para saber ordem insercao
    Set<Double> notas2 = new LinkedHashSet<>();
    notas2.add(7d);
    notas2.add(8.5);
    notas2.add(9.3);
    notas2.add(5d);
    notas2.add(0d);
    notas2.add(7d);
    notas2.add(3.6);
    System.out.println(notas2);

    //Ordem crescente
    System.out.println("Ordem de forma crescente(Natural)");
    // usar tree set pois ele adiciona na forma natural(crescebnte)

    Set<Double> notas3 = new TreeSet<>(notas2);// so pode isso, pois notas2 tem comparator
    System.out.println(notas3);

    //Apague todo cojunto
    System.out.println("Apague todo cojunto");
    notas.clear();
    System.out.println(notas);
    System.out.println(notas.isEmpty());

  }
}
