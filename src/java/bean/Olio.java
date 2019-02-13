package bean;

public class Olio {
  private int id;
  private String nome;
  private String categoria;
  private double prezzo;
  private int centilitri;
  private int numeroBottiglie;

  public Olio(int id, String nome, String categoria, double prezzo, int cl, int numeroBottiglie) {
    this.id = id;
    this.categoria = categoria;
    this.nome = nome;
    this.prezzo = prezzo;
    centilitri = cl;
    this.numeroBottiglie = numeroBottiglie;
  }

  public Olio() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getCategoria() {
    return categoria;
  }

  public void setCategoria(String categoria) {
    this.categoria = categoria;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public double getPrezzo() {
    return prezzo;
  }

  public void setPrezzo(double prezzo) {
    this.prezzo = prezzo;
  }

  public int getCentilitri() {
    return centilitri;
  }

  public void setCentilitri(int centilitri) {
    this.centilitri = centilitri;
  }

  public int getNumeroBottiglie() {
    return numeroBottiglie;
  }

  public void setNumeroBottiglie(int numeroBottiglie) {
    this.numeroBottiglie = numeroBottiglie;
  }
}
