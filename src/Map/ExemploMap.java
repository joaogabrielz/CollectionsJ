package Map;

import java.util.*;

public class ExemploMap {
  public static void main(String[] args) {

  //Map carrosPop = new HashMap(); // antes java 5
    //Map<String, Double> carrosPop = new HashMap<>(); // generics jd5 e diamond operador jd7

  //  HashMap<String, Double> carrosPop = new HashMap<>();
   // Map<String , Double> carros Pop = Map.of("gol", 14.4, "Uno", 15.6, "mobi,", 16.1, "hb20", 14.5, "kwid", 15.6);


    //Crie dicionario que relacione os modelos e seus respectioss valores
  Map<String, Double> carrosPop = new HashMap<>(){{
    put("gol", 14.4);
    put("uno", 15.6);
    put("mobi", 16.1);
    put("hb20", 14.5);
    put("kwid", 15.6);

  }};

    System.out.println(carrosPop);
  //  System.out.println(carrosPop.toString());

    //Substituia Cosumo do gol por 15,2km/l
    System.out.println("---substituia consumo gol---");
    carrosPop.put("gol", 15.2);
    System.out.println(carrosPop.toString());

    //confira se modelo(chave) tucson foi adicionado
    System.out.println("---confira se modelo tucson foi adicinado---");
    System.out.println(carrosPop.containsKey("tucson"));

    //exbia consumo uno
    System.out.println("---exiba consumo uno---");
    System.out.println(carrosPop.get("uno"));

    //exbia 3 modelo adicionado, -> nao tem metodo pra isso X

    //exiba modelos
    System.out.println("---exiba Modelos(chaves)---");
    Set<String> modelos = carrosPop.keySet();
    System.out.println(modelos);

    //exiba values
    System.out.println("---exiba value---");
    Collection<Double> valores = carrosPop.values();
    System.out.println(valores);

    //modelo mais economico
    System.out.println("---exiba modelo mais economico---");
    Double consumoMaisEficiente =  Collections.max(carrosPop.values());

    //INterface Entry(getKey , getValue) dentro da interface MAP
    Set<Map.Entry<String, Double>> entries = carrosPop.entrySet();

    String modeloMaisEficiente = "";

  //  carrosPop.put("gol", 16.1);

    for (Map.Entry<String, Double> entry : entries ){
      if(entry.getValue().equals(consumoMaisEficiente)){
        modeloMaisEficiente = entry.getKey();
        System.out.println("Modelo mais eficiente: " + modeloMaisEficiente + " - " + consumoMaisEficiente);
      }
    }
    System.out.println(" ------------- ");
    //Modelo menos economico e seu consumo
    System.out.println("---exiba modelo Menos economico--");
    Double consumoMenosEficiente = Collections.min(carrosPop.values());

    String modeloMenosEficiente = "";
    for (Map.Entry<String, Double> entry : carrosPop.entrySet()) {
      if(entry.getValue().equals(consumoMenosEficiente)){
        modeloMenosEficiente = entry.getKey();
        System.out.println("Modelo Menos eficiente: " + modeloMenosEficiente + " - " + consumoMenosEficiente);
      }
    }


    //exiba soma dos consumos
    System.out.println(" ------------- ");

    System.out.println("--- soma consumos--");
    Iterator<Double> iterator =  carrosPop.values().iterator();
    Double soma = 0d;
    while(iterator.hasNext()){
      soma  += iterator.next();
    }
    System.out.println("Soma consumos: " + soma);


    //media consumos disicionario
    System.out.println(" ------------- ");

    System.out.println("--- media consumos--");
    System.out.println("media: " + ( String.format("%.1f" ,soma/carrosPop.size())));


    //remova modelos consumo = 15,6km/l
    System.out.println(" ------------- ");

    System.out.println("--- remova modelos consumo = 15,6km/l--"); // kwid e uno
    Iterator<Double> iterator2 =  carrosPop.values().iterator();
    while(iterator2.hasNext()){
      if(iterator2.next() == 15.6) iterator2.remove();
    }
    System.out.println(carrosPop);

    //exbia todos carros na ordem q foram informados
    // linked hash map
    System.out.println(" ------------- ");

    System.out.println("---exbia todos carros na ordem q foram informados--");
    Map<String, Double> carrosPop2 = new LinkedHashMap<>(){{
      put("gol", 14.4);
      put("uno", 15.6);
      put("mobi", 16.1);
      put("hb20", 14.5);
      put("kwid", 15.6);
    }};
    System.out.println(carrosPop2);

    //exbia dicionario ordenado pelo modelo(chave) //string neste caso
    // treemap
    System.out.println(" ------------- ");

    System.out.println("---exbia dicionario ordenado pelo modelo(chave)--");
    Map<String, Double> carrosPop3 = new TreeMap<>(carrosPop2);
    System.out.println(carrosPop3);

    //apague discionario de carros
    System.out.println(" ------------- ");

    System.out.println("---apague discionario de carros--");
    carrosPop.clear();

    System.out.println("ta vazio: " + carrosPop.isEmpty());



  }
}
