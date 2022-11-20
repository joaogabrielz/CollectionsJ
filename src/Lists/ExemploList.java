package Lists;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;

public class ExemploList {
    public static void main(String[] args) {

    // List notas = new ArrayList(); // antes java 5

    // List<Double> notas = new ArrayList<>(); // a 'Generics'(jdk 5)  - Diamond(jdk7)

    //ArrayList<Double> notas = new ArrayList<>(); // nao recomendado, somente algumas situaçoes
        // Recomendado progamar voltado para interface, e nao para implementação

        // List<Double> notas = new ArrayList<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));

//  List<Double> notas = Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6); // valida, mas limitada
        //dessa forma nao pode adicionar mais elementos dentro, ou retirar
        // notas.add(10d);


        // List<Double> notas = List.of(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6);
        // imutavel, nao pode adicionar nem remeover
        // notas.add(1d);
        //notas.remove(5d);


        List<Double> notas= new ArrayList<Double>();
        notas.add(7d); // like 7.0
        notas.add(8.5); // like 7.0
        notas.add(9.3); // like 7.0
        notas.add(5.0); // like 7.0
        notas.add(0d); // like 7.0
        notas.add(3.6); // like 7.0

        System.out.println(notas);
        System.out.println(notas.indexOf(5d));
        notas.add(4, 8d);
       // System.out.println(notas.toString());
       // System.out.println(notas.indexOf(5d));
        notas.set(3, 6d);
        System.out.println(notas.toString());
        System.out.println(notas.contains(5d));
        // em ordem q foram informados
       // System.out.println(notas.toString()); ou assim
//        for (Double nota: notas){
//            System.out.println(nota);
//        }
       // System.out.println(notas.get(0));
//        System.out.println(Collections.max(notas));
//        System.out.println(Collections.min(notas));
        //SOma de todos valores:
//        Iterator<Double> iterator = notas.iterator();
//        Double soma = 0d;
//        while(iterator.hasNext()){ // [ comeca antes da posicao 0:, 7.0 ...]
//            Double next = iterator.next();
//            //System.out.println(next);
//            soma += next;
//        }
      //  System.out.println(soma);
    //media:
      //  System.out.println(String.format("%.2f", soma/notas.size()));

//        notas.remove(0); //remove posicao 0
//        notas.remove(0d); //remove elemento 0
//        System.out.println(notas);

        Iterator<Double> iterator = notas.iterator();

        while(iterator.hasNext()){ // Retirar elementos menores q 7
            Double next = iterator.next();
            if(next < 7){
                iterator.remove();
            }
        }
        System.out.println(notas);

        //Limpar todos
     //   notas.clear();
      //  System.out.println(notas);

        // resolva utlizando os metodos da implementacao LInkedList

        //crie uma lista chamada notas2 e coloque todos elementos da list arrayList nessa nova lista

        //soout mostra primeira nota da nova lista sem remove-o

        // sout mostre o primeira nota da nova lista removendo-a

        List<Double> notas2 = new LinkedList<>();
        notas2 = notas;
        System.out.println(notas2);

        System.out.println(notas2.get(0));

        System.out.println(notas2.remove(0));
        System.out.println(notas2);
    }


}