package bean;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
  private String nome;
  private String cognome;
  private String dataNascita;
  private List<Prenotazione> prenotazioni;

  public Cliente() {
    prenotazioni = new ArrayList<>();
  }

  public Cliente(String nome, String cognome, String dataNascita) {
    this.nome = nome;
    this.cognome = cognome;
    this.dataNascita = dataNascita;
  }

  public String getCognome() {
    return cognome;
  }

  public void setCognome(String cognome) {
    this.cognome = cognome;
  }

  public String getDataNascita() {
    return dataNascita;
  }

  public void setDataNascita(String dataNascita) {
    this.dataNascita = dataNascita;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public List<Prenotazione> getPrenotazioni() {
    return prenotazioni;
  }

  public void addPrenotazione(Prenotazione prenotazione) {
    this.prenotazioni.add(prenotazione);
  }

  public boolean removePrenotazione(Prenotazione prenotazione) {
    return this.prenotazioni.remove(prenotazione);
  }
}
