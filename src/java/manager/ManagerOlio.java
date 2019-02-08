package manager;

import bean.Olio;

import java.util.ArrayList;
import java.util.List;

public class ManagerOlio {
  private static List<Olio> oli;


  static void popola() {
    oli = new ArrayList<>();
    oli.add(new Olio("extravergine d'oliva in bottiglia ad anfora", "extravergine", 9.00F, 750));
    oli.add(new Olio("extravergine d'oliva in bottiglia ad anfora", "extravergine", 6.30F, 500));
    oli.add(new Olio("extravergine d'oliva in bottiglia ad anfora", "extravergine", 3.50F, 250));
  }

  public List<Olio> retrieveAll(){
    return oli;
  }

  public void addOlio(Olio o) {
    oli.add(o);
  }

  public boolean removeOlio(Olio o) {
    return oli.remove(o);
  }
}
