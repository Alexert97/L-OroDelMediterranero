package bean;

public class Prenotazione {
  private String data;
  private String ora;

  public Prenotazione() {
  }

  public Prenotazione(String data, String ora) {
    this.ora = ora;
    this.data = data;
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

}
