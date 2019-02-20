package bean;

public class Prenotazione {
  private int id;
  private String data;
  private String ora;
  private int quantita;
  private String nome;
  private String cognome;

  public Prenotazione() {
  }

  public Prenotazione(int id, String nome, String cognome, String data, String ora, int quantita) {
    this.nome = nome;
    this.cognome = cognome;
    this.ora = ora;
    this.data = data;
    this.quantita = quantita;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public String getOra() {
    return ora;
  }

  public void setOra(String ora) {
    this.ora = ora;
  }

  public double getQuantita() {
    return quantita;
  }

  public void setQuantita(int quantita) {
    this.quantita = quantita;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCognome() {
    return cognome;
  }

  public void setCognome(String cognome) {
    this.cognome = cognome;
  }
}
