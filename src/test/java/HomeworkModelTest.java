import model.*;
import org.junit.Before;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class HomeworkModelTest {

    @Before
    public void setUp() {
        HomeworkModelTest o = new HomeworkModelTest();
    }

    @org.junit.jupiter.api.Test
    void addPolinoms() {
        HomeworkModel  model = new HomeworkModel();
        String polinom1Text = "2x^3 + x^2 + 5x + 1";
        String polinom2Text = "5x^4 + 4x^2 + 2";
        String rezultat = "5x^4+2x^3+5x^2+5x+3";
        String rezultat2 = "";

        Polinom polinomResult = new Polinom();
        Polinom polinom1 = new Polinom();
        Polinom polinom2 = new Polinom();
        try {
            polinom1 = model.extractPolinom(polinom1Text);
            polinom2 = model.extractPolinom(polinom2Text);
            polinomResult = model.addPolinoms(polinom1, polinom2);
            rezultat2 = model.mergeResult(polinomResult);
        }
        catch(IncorrectFormatException | StringIndexOutOfBoundsException a) {
            a.printStackTrace();
        }

        assertEquals(rezultat2, rezultat);
    }

    @org.junit.jupiter.api.Test
    void subPolinoms() {
        HomeworkModel  model = new HomeworkModel();
        String polinom1Text = "5x^4 + 3x^3 + x^2 + 1";
        String polinom2Text = "x^5 + 5x^4 + 2x^3 + 2";
        String rezultat = "-x^5+x^3+x^2-1";
        String rezultat2 = "";

        Polinom polinomResult = new Polinom();
        Polinom polinom1 = new Polinom();
        Polinom polinom2 = new Polinom();
        try {
            polinom1 = model.extractPolinom(polinom1Text);
            polinom2 = model.extractPolinom(polinom2Text);
            polinomResult = model.subPolinoms(polinom1, polinom2);
            rezultat2 = model.mergeResult(polinomResult);
        }
        catch(IncorrectFormatException | StringIndexOutOfBoundsException a) {
            a.printStackTrace();
        }

        assertEquals(rezultat2, rezultat);
    }

    @org.junit.jupiter.api.Test
    void derivatePolinom() {
        HomeworkModel  model = new HomeworkModel();
        String polinom1Text = "3x^6 + 15x^2 + 5";
        String rezultat = "18x^5+30x";
        String rezultat2 = "";

        Polinom polinomResult = new Polinom();
        Polinom polinom1 = new Polinom();
        Polinom polinom2 = new Polinom();
        try {
            polinom1 = model.extractPolinom(polinom1Text);
            polinomResult = model.derivatePolinom(polinom1);
            rezultat2 = model.mergeResult(polinomResult);
        }
        catch(IncorrectFormatException | StringIndexOutOfBoundsException a) {
            a.printStackTrace();
        }
        assertEquals(rezultat2, rezultat);
    }

    @org.junit.jupiter.api.Test
    void integratePolinom() {
        HomeworkModel  model = new HomeworkModel();
        String polinom1Text = "10x^4 + 2x^3 + 15x^2 + 50";
        String rezultat = "2x^5+0.5x^4+5x^3+50x";
        String rezultat2 = "";

        Polinom polinomResult = new Polinom();
        Polinom polinom1 = new Polinom();
        Polinom polinom2 = new Polinom();
        try {
            polinom1 = model.extractPolinom(polinom1Text);
            polinomResult = model.integratePolinom(polinom1);
            rezultat2 = model.mergeResult(polinomResult);
        }
        catch(IncorrectFormatException | StringIndexOutOfBoundsException a) {
            a.printStackTrace();
        }

        assertEquals(rezultat2, rezultat);
    }

    @org.junit.jupiter.api.Test
    void multiplicationPolinom() {
        HomeworkModel  model = new HomeworkModel();
        String polinom1Text = "2x^3 + 2x + 2";
        String polinom2Text = "-x^5 + x^4 + 1";
        String rezultat = "-2x^8+2x^7-2x^6+2x^4+2x^3+2x+2";
        String rezultat2 = "";

        Polinom polinomResult = new Polinom();
        Polinom polinom1 = new Polinom();
        Polinom polinom2 = new Polinom();
        try {
            polinom1 = model.extractPolinom(polinom1Text);
            polinom2 = model.extractPolinom(polinom2Text);
            polinomResult = model.multiplicationPolinom(polinom1, polinom2);
            rezultat2 = model.mergeResult(polinomResult);
        }
        catch(IncorrectFormatException | StringIndexOutOfBoundsException a) {
            a.printStackTrace();
        }

        assertEquals(rezultat2, rezultat);
    }

    @org.junit.jupiter.api.Test
    void polinomDivide() {
        HomeworkModel  model = new HomeworkModel();
        String polinom1Text = "2x^3 - 3x^2 + 1";
        String polinom2Text = "x^2 - 2x";
        String rezultat = "2x+1";
        String rezultatRest = "2x+1";
        String rezultat2 = "";
        String rezultat3 = "";

        ArrayList <Polinom> polinomResults = new ArrayList<Polinom>();
        Polinom polinom1 = new Polinom();
        Polinom polinom2 = new Polinom();
        try {
            polinom1 = model.extractPolinom(polinom1Text);
            polinom2 = model.extractPolinom(polinom2Text);
            polinomResults = model.dividePolinom(polinom1, polinom2);
            rezultat2 = model.mergeResult(polinomResults.get(0));
            rezultat3 = model.mergeResult(polinomResults.get(1));
        }
        catch(IncorrectFormatException | StringIndexOutOfBoundsException | BadDivideException a) {
            a.printStackTrace();
        }

        assertEquals(rezultat2, rezultat);
        assertEquals(rezultat3, rezultatRest);
    }
}