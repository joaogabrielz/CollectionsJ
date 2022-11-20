package Set;

import java.util.*;

public class ExemplOrdenacaoSet {

  public static void main(String[] args) {


    Set<Serie> minhasSeries = new HashSet<>(){{
      add(new Serie("got", "fantasia", 60));
      add(new Serie("dark", "drama", 60));
      add(new Serie("that 70s show", "comédia", 25));
    }};

    System.out.println("Aleatorios");
    for (Serie serie : minhasSeries){
      System.out.println("> " + serie.getNome() + " - " +
              serie.getGenero() + " - " +
              serie.getDuracaoEpisodeo());
    }

    System.out.println("---------------");

    Set<Serie> minhasSeries2 = new LinkedHashSet<>(){{
      add(new Serie("got", "fantasia", 60));
      add(new Serie("dark", "drama", 60));
      add(new Serie("that 70s show", "comédia", 25));
    }};

    System.out.println("Ordem insercao");
    for (Serie serie : minhasSeries2){
      System.out.println("> " + serie.getNome() + " - " +
              serie.getGenero() + " - " +
              serie.getDuracaoEpisodeo());
    }

    System.out.println("---------------");

    Set<Serie> minhasSeries3 = new TreeSet<>(){{
      add(new Serie("got", "fantasia", 60));
      add(new Serie("dark", "drama", 60));
      add(new Serie("that 70s show", "comédia", 25));
    }};

    System.out.println("Ordem Natural (tempo episodeo)");
    for (Serie serie : minhasSeries3){
      System.out.println("> " + serie.getNome() + " - " +
              serie.getGenero() + " - " +
              serie.getDuracaoEpisodeo());
    }
    // Nao mostrou dark pq tempo ta igual, e no Set nao recebe objetos iguais, entao tem q ter
    // criterio de desempate no matodo CompareTo



    System.out.println("---------------");
    Set<Serie> minhasSeries4 = new TreeSet<>(new ComparatorNomeGeneroTempoEpisodeo());
    minhasSeries4.addAll(minhasSeries);

    System.out.println("Ordem Nome/Genero/TempoEpisodeo");
    for (Serie serie : minhasSeries4){
      System.out.println("> " + serie.getNome() + " - " +
              serie.getGenero() + " - " +
              serie.getDuracaoEpisodeo());
    }
  }

  // Ordenar por genero
  // ordenar por tempo espisodeo
}

class Serie implements Comparable<Serie>{
  private String nome;
  private String genero;
  private Integer duracaoEpisodeo;

  public Serie(String nome, String genero, Integer duracaoEpisodeo) {
    this.nome = nome;
    this.genero = genero;
    this.duracaoEpisodeo = duracaoEpisodeo;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Serie serie = (Serie) o;
    return nome.equals(serie.nome) && genero.equals(serie.genero) && duracaoEpisodeo.equals(serie.duracaoEpisodeo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nome, genero, duracaoEpisodeo);
  }

  @Override
  public String toString() {
    return "{" +
            "nome='" + nome + '\'' +
            ", genero='" + genero + '\'' +
            ", duracaoEpisodeo=" + duracaoEpisodeo +
            '}';
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getGenero() {
    return genero;
  }

  public void setGenero(String genero) {
    this.genero = genero;
  }

  public Integer getDuracaoEpisodeo() {
    return duracaoEpisodeo;
  }

  public void setDuracaoEpisodeo(Integer duracaoEpisodeo) {
    this.duracaoEpisodeo = duracaoEpisodeo;
  }


  @Override
  public int compareTo(Serie serie) {
    int tempoEpisodeo = Integer.compare(this.getDuracaoEpisodeo(), serie.getDuracaoEpisodeo());
    if(tempoEpisodeo != 0) return tempoEpisodeo;

    return this.getGenero().compareTo(serie.getGenero());
  }
}

class ComparatorNomeGeneroTempoEpisodeo implements Comparator<Serie>{

  @Override
  public int compare(Serie s1, Serie s2) {
    int nome = s1.getNome().compareTo(s2.getNome());
    if(nome != 0) return nome;

    int genero = s1.getGenero().compareTo(s2.getGenero());
    if(genero != 0) return genero;

    return Integer.compare(s1.getDuracaoEpisodeo(), s2.getDuracaoEpisodeo());



  }
}