package Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ExemploOrdenacaoList {

  //gato 1 nome jon, idade 18, cor preto
  // gato 2 simba, idade 6 cor tigrado
  //gato 3 nome jon, idade 12, cor amarelo

  public static void main(String[] args) {

  List<Gato> meusGatos = new ArrayList<>(){{
    add(new Gato("Jon", 18,"preto"));
    add(new Gato("Simba",6, "tigrado"));
    add(new Gato( "Jon",12, "amarelo"));
  }};

    //Ordem de inserção
    System.out.println("------insercao-----");
    System.out.println(meusGatos);

    // Ordem aleatorio
    System.out.println("------aleatorio-----");
    Collections.shuffle(meusGatos);
    System.out.println(meusGatos);

    // Ordem Natural (Nome)
    System.out.println("------natural-----");
    Collections.sort(meusGatos);
    System.out.println(meusGatos);

    //Ordem de idade
    System.out.println("------idade-----");
   // Collections.sort(meusGatos, new Lists.ComparatorIdade());
    meusGatos.sort(new ComparatorIdade());
    System.out.println(meusGatos);

    // Ordem de cor
    System.out.println("------cor-----");
    meusGatos.sort(new ComparatorCor());
    System.out.println(meusGatos);

    // Ordem nome/cor/idade
    System.out.println("------cor/Nome/Idade-----");
    Collections.sort(meusGatos, new ComparatorNomeCorIdade());
   // meusGatos.sort(new Lists.ComparatorNomeCorIdade());
    System.out.println(meusGatos);
  }
}

class Gato implements Comparable<Gato>{
  private String nome;
  private Integer idade;
  private String cor;

  public Gato(String nome, Integer idade, String cor) {
    this.nome = nome;
    this.idade = idade;
    this.cor = cor;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Integer getIdade() {
    return idade;
  }

  public void setIdade(Integer idade) {
    this.idade = idade;
  }

  public String getCor() {
    return cor;
  }

  public void setCor(String cor) {
    this.cor = cor;
  }

// Sobrescreve toString() senao escreve endereco de memoria


  @Override
  public String toString() {
    return "{" +
            "nome='" + nome + '\'' +
            ", idade=" + idade +
            ", cor='" + cor + '\'' +
            '}';
  }

  @Override
  public int compareTo(Gato gato) {
    return this.getNome().compareToIgnoreCase(gato.getNome());
  }
  // 0 sao iguais
  // 1 gato comparado é maior
  // -1 gato comparado e menor
}

class ComparatorIdade implements Comparator<Gato>{

  @Override
  public int compare(Gato g1, Gato g2) {
    return Integer.compare(g1.getIdade(), g2.getIdade());
  }
}

class ComparatorCor implements Comparator<Gato>{
  @Override
  public int compare(Gato g1, Gato g2) {
    return g1.getNome().compareToIgnoreCase(g2.getNome());
  }
  // 0 sao iguais
  // 1 gato comparado é maior
  // -1 gato comparado e menor
}

class ComparatorNomeCorIdade implements Comparator<Gato>{

  @Override
  public int compare(Gato g1, Gato g2) {
    int nome = g1.getNome().compareToIgnoreCase(g2.getNome());
    if(nome != 0) return nome; // nao iguais(Diferentes)

    int cor = g1.getCor().compareToIgnoreCase(g2.getCor());
    if(cor != 0) return cor; // nao iguais(Diferentes)

    //Senao
    return Integer.compare(g1.getIdade(), g2.getIdade());
  }
}
