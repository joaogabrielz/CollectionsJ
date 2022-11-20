package Map;

import java.util.*;

public class ExemploOrdenacaoMap {

  public static void main(String[] args) {


    Map<String, Livro> meusLivros = new HashMap<>(){{
      put("Hawking, Stephen", new Livro("Uma Breve historia do tempo", 256));
      put("Duhig, Charles", new Livro("O poder do habito", 408));
      put("Harari, Yuval Nahh", new Livro("21 lições para o seculo 21", 432));
    }};

    System.out.println("Ordem aleatoria: ");
    for (Map.Entry<String, Livro> livro : meusLivros.entrySet()){
      System.out.println(livro.getKey() + " - " + livro.getValue().getNOME());
    }



    Map<String, Livro> meusLivros2 = new LinkedHashMap<>(){{
      put("Hawking, Stephen", new Livro("Uma Breve historia do tempo", 256));
      put("Duhig, Charles", new Livro("O poder do habito", 408));
      put("Harari, Yuval Nahh", new Livro("21 lições para o seculo 21", 432));
    }};

    System.out.println("----------------------------------");
    System.out.println("Ordem Inserção: ");
    for (Map.Entry<String, Livro> livro : meusLivros2.entrySet()){
      System.out.println(livro.getKey() + " - " + livro.getValue().getNOME());
    }


    Map<String, Livro> meusLivros3 = new TreeMap<>(meusLivros2);

    System.out.println("----------------------------------");
    System.out.println("Ordem Alfabetica(Natural) dos autores: ");
    for (Map.Entry<String, Livro> livro : meusLivros3.entrySet()){
      System.out.println(livro.getKey() + " - " + livro.getValue().getNOME());
    }


    System.out.println("----------------------------------");
    System.out.println("Ordem Alfabetica Nomes dos livros: ");

    Set<Map.Entry<String, Livro>> meuslivros4 = new TreeSet<>(new ComparatorNome());
    meuslivros4.addAll(meusLivros.entrySet());
    for (Map.Entry<String, Livro> livro : meuslivros4){
      System.out.println(livro.getKey() + " - " + livro.getValue().getNOME());
    }


  }
}

class Livro{
  private String nome;
  private Integer paginas;

  public Livro(String nome, Integer paginas) {
    this.nome = nome;
    this.paginas = paginas;
  }

  //qnd trabalghar com HASH sobrecereve estes!
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Livro livro = (Livro) o;
    return nome.equals(livro.nome) && paginas.equals(livro.paginas);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nome, paginas);
  }

  @Override
  public String toString() {
    return "{" +
            "nome='" + nome + '\'' +
            ", paginas=" + paginas +
            '}';
  }

  public String getNOME() {
    return nome;
  }

  public void setNOME(String nome) {
    this.nome = nome;
  }

  public Integer getPaginas() {
    return paginas;
  }

  public void setPaginas(Integer paginas) {
    this.paginas = paginas;
  }

}

class ComparatorNome implements Comparator<Map.Entry<String, Livro>> {

  @Override
  public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
    return l1.getValue().getNOME().compareToIgnoreCase(l2.getValue().getNOME());
  }
}