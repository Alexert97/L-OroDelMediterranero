package bean;

import java.util.ArrayList;
import java.util.List;

public class Carrello {
  private List<Olio> list;
  private double prezzo;

  public Carrello () {
    list = new ArrayList<>();
    prezzo = 0F;
  }

  public void addOlio(Olio o) {
    list.add(o);
    prezzo += o.getPrezzo();
  }

  public boolean removeOlio(Olio o) {
    if(list.contains(o)) {
      list.remove(o);
      prezzo -= o.getPrezzo();
      return true;
    }
    return false;
  }

  public List<Olio> getCarrello() {
    return list;
  }

  public double getPrezzo() {
    return prezzo;
  }

}
