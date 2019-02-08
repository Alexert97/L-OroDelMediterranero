package bean;

public class Prenotazione {
  private String data;
  private String ora;
  private Cliente cliente;

  public Prenotazione() {
  }

  public Prenotazione(String data, String ora, Cliente cliente) {
    this.ora = ora;
    this.data = data;
    this.cliente = cliente;
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

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }
}
