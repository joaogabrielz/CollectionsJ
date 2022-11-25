package Stream;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class exerciciosStreamAPI {

  public static void main(String[] args) {

    List<String> numerosAleatorios =
            Arrays.asList("1", "0", "4", "1", "2", "3", "9", "9", "6", "5");


//    numerosAleatorios.stream().forEach(new Consumer<String>() {
//      @Override
//      public void accept(String s) {
//        System.out.println(s);
//      }
//    });

    // LAMBDA
    //numerosAleatorios.stream().forEach(s -> System.out.println(s));

    // List tem foreach sem precisar do Stream
    //numerosAleatorios.forEach(s -> System.out.println(s));

    // reference Metod
    // numerosAleatorios.forEach(System.out::println);


    // 5 primeiros numeros e coloque em um Set

    numerosAleatorios.stream()
            .limit(5) // limita em 5
            .collect(Collectors.toSet()) // coleta os 5 primeiros em um set, Set nao aceita numeros repetidos
            .forEach(System.out::println);

    Set<String> collectSet =  numerosAleatorios.stream()
                              .limit(5) // limita em 5
                              .collect(Collectors.toSet());


    // Transforma lista de strings em Inteiros

//    numerosAleatorios.stream()
//            .map(new Function<String, Integer>() {
//              @Override
//              public Integer apply(String s) {
//                return Integer.parseInt(s);
//              }
//            });

    //numerosAleatorios.stream().map(s -> Integer.parseInt(s));


    // Ref metod
    //numerosAleatorios.stream().map(Integer::parseInt);

//    List<Integer> numerosAlet = numerosAleatorios.stream()
//                .map(Integer::parseInt).collect(Collectors.toList());
//
    List<Integer> numerosAlet1Inte = numerosAleatorios.stream()
            .map(Integer::parseInt).collect(Collectors.toList());

    // Pegue numeros pares e maiores que 2 e colqoue em uma lista
    System.out.println("----------------------");
//
//    List<Integer> paresMaiorQue2 = numerosAleatorios.stream()
//            .map(Integer::parseInt)
//            .filter(new Predicate<Integer>() {
//              @Override
//              public boolean test(Integer i) {
//                if (i % 2 == 0 && i > 2) return true;
//                return false;
//              }
//            }).collect(Collectors.toList());


    List<Integer> paresMaiorQue2 = numerosAleatorios.stream()
            .map(Integer::parseInt)
            .filter(i -> (i % 2 == 0 && i > 2)).collect(Collectors.toList());

    System.out.println(paresMaiorQue2);

    // mostrarr media
    System.out.println("--------------------");
    System.out.println("----------mostrarr media dos numeros------------");

//    numerosAleatorios.stream().mapToInt(new ToIntFunction<String>() {
//      @Override
//      public int applyAsInt(String s) {
//        return Integer.parseInt(s);
//      }
//    });

    //numerosAleatorios.stream().mapToInt(s -> Integer.parseInt(s));

//    numerosAleatorios.stream()
//            .mapToInt(Integer::parseInt)
//            .average().ifPresent(new DoubleConsumer() {
//              @Override
//              public void accept(double v) {
//                System.out.println(v);
//              }
//            });

    numerosAleatorios.stream()
            .mapToInt(Integer::parseInt)
            .average().ifPresent(System.out::println);


    // remover os impares
    System.out.println("--------------------");
    System.out.println("----------remover impares------------");

    List<Integer> numerosAleatoriosInteger = numerosAleatorios.stream()
            .map(Integer::parseInt).collect(Collectors.toList());

//    numerosAlet1Integers.removeIf(new Predicate<Integer>() {
//      @Override
//      public boolean test(Integer i) {
//        if(i % 2 != 0) return true;
//        return false;
//      }
//    });

    numerosAleatoriosInteger.removeIf(i -> (i % 2 != 0));

    System.out.println(numerosAleatoriosInteger);


    System.out.println("Ignore os 3 primeiros elementos da lista e imprima o restante:");
    numerosAleatoriosInteger.stream()
            .skip(3)
            .forEach(System.out::println);

    long countNumerosUnicos = numerosAleatoriosInteger.stream()
            .distinct()
            .count();
    System.out.println("Retirando os números repetidos da lista, quantos números ficam? " + countNumerosUnicos);

    System.out.print("Mostre o menor valor da lista: ");
    numerosAleatoriosInteger.stream()
            .mapToInt(Integer::intValue)
            .min()
            .ifPresent(System.out::println);

    System.out.print("Mostre o maior valor da lista: ");
    numerosAleatoriosInteger.stream()
            .mapToInt(Integer::intValue)
            .max()
            .ifPresent(System.out::println);;

    int somaDosNumerosPares = numerosAleatoriosInteger.stream()
            .filter(i -> (i % 2 == 0))
            .mapToInt(Integer::intValue)
            .sum();
    System.out.println("Pegue apenas os números pares e some: " + somaDosNumerosPares);

    System.out.println("Mostre a lista na ordem númerica: ");
    List<Integer> numerosOrdemNatural = numerosAleatoriosInteger.stream()
            .sorted(Comparator.naturalOrder())
            .collect(Collectors.toList());
    System.out.println(numerosOrdemNatural);

    System.out.println("Agrupe os valores ímpares múltiplos de 3 ou de 5:");
//        dica: collect(Collectors.groupingBy(new Function())
    Map<Boolean, List<Integer>> collectNumerosMultiplosDe3E5 = numerosAleatoriosInteger.stream()
            .collect(Collectors.groupingBy(i -> (i % 3 == 0 || i % 5 == 0)));
    System.out.println(collectNumerosMultiplosDe3E5);


  }
}
