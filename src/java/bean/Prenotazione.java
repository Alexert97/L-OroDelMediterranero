package bean;

public class Prenotazione {
  private int id;
  private String data;
  private String ora;
  private int quantita;

  public Prenotazione() {
  }

  public Prenotazione(int id, String data, String ora, int quantita) {
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

  public int getQuantita() {
    return quantita;
  }

  public void setQuantita(int quantita) {
    this.quantita = quantita;
  }
}
