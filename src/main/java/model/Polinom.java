package model;
import java.util.*;

public class Polinom {
    private ArrayList <Monom> monoms = new ArrayList <Monom> ();

    public ArrayList<Monom> getMonoms() {
        return monoms;
    }
    public void addMonom (Monom m) {
        monoms.add(m);
    }

    public void setMonoms(ArrayList<Monom> monoms) {
        this.monoms = monoms;
    }
    public void printPolinom() {
        for(Monom m : monoms) {
            if(m.getPow() != 0 || m.getCoefficient() != 0)
                System.out.println("Coeficient: " + m.getCoefficient() + "Putere " + m.getPow());
        }
    }
}
