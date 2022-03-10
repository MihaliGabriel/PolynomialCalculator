package controller;
import model.*;
import View.*;
import java.util.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeworkController {
    private HomeworkModel model;
    private HomeworkView view;

    public HomeworkController(HomeworkModel model, HomeworkView view) {
        this.model = model;
        this.view = view;

        view.addAdunareListener(new AdunareListener());
        view.addScadereListener(new ScadereListener());
        view.addInmultireListener(new InmultireListener());
        view.addIntegrareListener(new IntegrareListener());
        view.addDerivareListener(new DerivareListener());
        view.addImpartireListener(new ImpartireListener());
    }

    class AdunareListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String userInput = "";
            String userInput2 = "";

            Polinom p = new Polinom();
            Polinom p2 = new Polinom();
            Polinom rezultat = new Polinom();

            userInput = view.getPolinom1();
            userInput2 = view.getPolinom2();
            try {
                p = model.extractPolinom(userInput);
                p2 = model.extractPolinom(userInput2);
                rezultat = model.addPolinoms(p, p2);
                if(model.emptyPolinom(rezultat) == 1) {
                    view.setResult("0");
                }
                else {
                    view.setResult(model.mergeResult(rezultat));
                }
            }
            catch (IncorrectFormatException | StringIndexOutOfBoundsException b) {
                view.errorMessage("Ai introdus un polinom gresit!");
            }
        }
    }

    class ScadereListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String userInput = "";
            String userInput2 = "";

            Polinom p = new Polinom();
            Polinom p2 = new Polinom();
            Polinom rezultat = new Polinom();

            userInput = view.getPolinom1();
            userInput2 = view.getPolinom2();
            try {
                p = model.extractPolinom(userInput);
                p2 = model.extractPolinom(userInput2);
                rezultat = model.subPolinoms(p, p2);
                if(model.emptyPolinom(rezultat) == 1) {
                    view.setResult("0");
                }
                else {
                    view.setResult(model.mergeResult(rezultat));
                }
            }
            catch(IncorrectFormatException | StringIndexOutOfBoundsException b) {
                view.errorMessage("Ai introdus un polinom gresit!");
            }

        }
    }

    class DerivareListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String userInput = "";
            Polinom p = new Polinom();
            Polinom rezultat = new Polinom();

            userInput = view.getPolinom1();
            try {
                p = model.extractPolinom(userInput);
                rezultat = model.derivatePolinom(p);
                int emptyPolinom = 1;
                for(int i = 0; i < p.getMonoms().size(); i++) {
                    if(p.getMonoms().get(i).getCoefficient() != 0)
                        emptyPolinom = 0;
                }
                if(emptyPolinom == 1) {
                    view.setResult("0");
                }
                else view.setResult(model.mergeResult(rezultat));
            }
            catch (IncorrectFormatException | StringIndexOutOfBoundsException b) {
                view.errorMessage("Ai introdus un polinom gresit!");
            }
        }
    }

    class IntegrareListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String userInput = "";
            Polinom p = new Polinom();
            Polinom rezultat = new Polinom();

            userInput = view.getPolinom1();
            try {
                p = model.extractPolinom(userInput);
            }
            catch(IncorrectFormatException | StringIndexOutOfBoundsException b) {
                view.errorMessage("Ai introdus un polinom gresit!");
            }

            rezultat = model.integratePolinom(p);
            view.setResult(model.mergeResult(rezultat));
        }
    }

    class InmultireListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String userInput = "";
            String userInput2 = "";

            Polinom p = new Polinom();
            Polinom p2 = new Polinom();
            Polinom rezultat = new Polinom();

            userInput = view.getPolinom1();
            userInput2 = view.getPolinom2();
            try {
                if(userInput.equals("0") || userInput2.equals("0"))
                    view.setResult("0");
                else {
                    p = model.extractPolinom(userInput);
                    p2 = model.extractPolinom(userInput2);
                    rezultat = model.multiplicationPolinom(p, p2);
                    view.setResult(model.mergeResult(rezultat));
                }
            }
            catch (IncorrectFormatException | StringIndexOutOfBoundsException b) {
                view.errorMessage("Ai introdus un polinom gresit!");
            }
        }
    }

    class ImpartireListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String userInput = "";
            String userInput2 = "";

            Polinom p = new Polinom();
            Polinom p2 = new Polinom();
            ArrayList <Polinom> rezultat = new ArrayList <Polinom>();

            userInput = view.getPolinom1();
            userInput2 = view.getPolinom2();
            try {
                if(userInput2.equals("0"))
                    view.errorMessage("Nu se poate imparti cu 0!");
                p = model.extractPolinom(userInput);
                p2 = model.extractPolinom(userInput2);
                if(!userInput.equals("0")) {
                    rezultat = model.dividePolinom(p, p2);
                    view.setResult(model.mergeResult(rezultat.get(0)));
                    if(model.emptyPolinom(rezultat.get(1)) == 0)
                        view.infoMessage("Rest: " + model.mergeResult(rezultat.get(1)));
                    else view.infoMessage("Rest: " + "0");
                }
                else {
                    view.setResult("0");
                }
            }
            catch (IncorrectFormatException | StringIndexOutOfBoundsException a) {
                view.errorMessage("Ai introdus un polinom gresit!");
            }
            catch (BadDivideException a) {
                view.errorMessage("Impartire gresita!");
            }
        }
    }
    public static void main(String[] args) {
        HomeworkView view1 = new HomeworkView();
        HomeworkModel model1 = new HomeworkModel();
        HomeworkController controller1 = new HomeworkController(model1, view1);
    }

}
