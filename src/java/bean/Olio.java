package bean;

public class Olio {
  private int id;
  private String nome;
  private String categoria;
  private Float prezzo;
  private int centilitri;

  public Olio(int id, String nome, String categoria, Float prezzo, int cl) {
    this.id = id;
    this.categoria = categoria;
    this.nome = nome;
    this.prezzo = prezzo;
    centilitri = cl;
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

  public Float getPrezzo() {
    return prezzo;
  }

  public void setPrezzo(Float prezzo) {
    this.prezzo = prezzo;
  }

  public int getCentilitri() {
    return centilitri;
  }

  public void setCentilitri(int centilitri) {
    this.centilitri = centilitri;
  }
}
