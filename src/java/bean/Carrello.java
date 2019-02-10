package bean;

import java.util.ArrayList;
import java.util.List;

public class Carrello {
  private List<Olio> list;
  private Float prezzo;

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

  public Float getPrezzo() {
    return prezzo;
  }

}
