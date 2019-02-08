package manager;

import bean.Cliente;
import bean.Prenotazione;

import java.util.ArrayList;
import java.util.List;

public class ManagerPrenotazione {
  private static List<Prenotazione> prenotazioni;

  static void popola() {
    prenotazioni = new ArrayList<>();
    Cliente c = new Cliente("Federico", "Ripoli", "01/10/1996");
    prenotazioni.add(new Prenotazione("20/02/2019","10.00", c));
    prenotazioni.add(new Prenotazione("20/02/2019","10.30", c));
    prenotazioni.add(new Prenotazione("20/02/2019","11.00", c));
    prenotazioni.add(new Prenotazione("20/02/2019","11.30", c));
    prenotazioni.add(new Prenotazione("20/02/2019","12.00", c));
  }

  public List<Prenotazione> retrieveAll() {
    return prenotazioni;
  }

  public void addPrenotazione(Prenotazione p) {
    prenotazioni.add(p);
  }

  public boolean removePrenotazione(Prenotazione p) {
    return prenotazioni.remove(p);
  }
}
