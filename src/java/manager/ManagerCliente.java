package manager;

import bean.Cliente;
import bean.Prenotazione;

import java.util.ArrayList;
import java.util.List;

public class ManagerCliente {
  private static List<Cliente> clienti;

  static void popola() {
    clienti = new ArrayList<>();
    clienti.add(new Cliente());
  }

  public List<Cliente> retrieveAll() {
    return clienti;
  }

  public void addCliente(Cliente c) {
    clienti.add(c);
  }

  public boolean removecliente(Cliente c) {
    return clienti.remove(c);
  }
}
