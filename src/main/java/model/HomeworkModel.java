package model;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.*;
import java.text.DecimalFormat;
import java.lang.Math;

public class  HomeworkModel{

    public Polinom addPolinoms(Polinom p1, Polinom p2) {
        ArrayList <Monom> monomList1 = p1.getMonoms();
        ArrayList <Monom> monomList2 = p2.getMonoms();
        ArrayList <Monom> monomList3 = new ArrayList <Monom> ();
        Polinom p3 = new Polinom();
        for(int i = 0; i < monomList1.size(); i++) {
            if(monomList1.get(i).getPow() == monomList2.get(i).getPow()) {
                monomList1.get(i).setCoefficient(monomList1.get(i).getCoefficient() + monomList2.get(i).getCoefficient());
            }
            else {
                monomList1.get(i).setCoefficient(monomList1.get(i).getCoefficient() + monomList2.get(i).getCoefficient());
                monomList1.get(i).setPow(monomList1.get(i).getPow() + monomList2.get(i).getPow());
            }
        }
        p3.setMonoms(monomList1);
        return p3;
    }

    public Polinom subPolinoms(Polinom p1, Polinom p2) {
        ArrayList <Monom> monomList1 = p1.getMonoms();
        ArrayList <Monom> monomList2 = p2.getMonoms();
        Polinom p3 = new Polinom();
        for(int i = 0; i < monomList1.size(); i++) {
            if(monomList1.get(i).getPow() == monomList2.get(i).getPow()) {
                monomList1.get(i).setCoefficient(monomList1.get(i).getCoefficient() - monomList2.get(i).getCoefficient());
            }
            else {
                monomList1.get(i).setCoefficient(monomList1.get(i).getCoefficient() - monomList2.get(i).getCoefficient());
                monomList1.get(i).setPow(Math.abs(monomList1.get(i).getPow() - monomList2.get(i).getPow()));
            }
        }
        p3.setMonoms(monomList1);
        return p3;
    }

    public Polinom derivatePolinom(Polinom p1) {
        ArrayList <Monom> monomList = p1.getMonoms();
        Polinom p2 = new Polinom();

        for(int i = 0; i < monomList.size(); i++) {
            if(monomList.get(i).getPow() > 0 && i > 0) {
                if(monomList.get(i - 1).getCoefficient() != 0) {
                    monomList.get(i - 1).setCoefficient(monomList.get(i).getCoefficient() * monomList.get(i - 1).getCoefficient()* monomList.get(i).getPow());
                    monomList.get(i).setCoefficient(0);
                }
                else  {
                    monomList.get(i - 1).setCoefficient(monomList.get(i).getCoefficient() * monomList.get(i).getPow());
                    monomList.get(i - 1).setPow(i - 1);
                    monomList.get(i).setCoefficient(0);
                }
            }
            else {
                monomList.get(i).setCoefficient(0);
            }
        }
        p2.setMonoms(monomList);
        return p2;
    }

    public Polinom integratePolinom(Polinom p1) {
        ArrayList <Monom> monomList = p1.getMonoms();
        ArrayList <Monom> monomResult = new ArrayList <Monom>(1000);
        Polinom p2 = new Polinom();

        for(int i = 0 ; i < 1000;i++) {
            Monom monomGol = new Monom(0,0);
            monomResult.add(monomGol);
        }

        for(int i = 0 ; i < monomList.size(); i++) {
            if(monomList.get(i).getCoefficient() != 0) {
                if(monomResult.get(i + 1).getCoefficient() != 0) {
                    monomResult.get(i + 1).setCoefficient(monomResult.get(i + 1).getCoefficient() * (monomList.get(i).getCoefficient() / (monomList.get(i).getPow() + 1)));
                    monomResult.get(i + 1).setPow(monomList.get(i).getPow() + 1);
                }
                else  {
                    monomResult.get(i + 1).setCoefficient(monomList.get(i).getCoefficient() / (monomList.get(i).getPow() + 1));
                    monomResult.get(i + 1).setPow(monomList.get(i).getPow() + 1);
                }
            }
            }
        p2.setMonoms(monomResult);
        return p2;
    }

    public Polinom multiplicationPolinom(Polinom p1, Polinom p2) {
        ArrayList <Monom> monomList1 = p1.getMonoms();
        ArrayList <Monom> monomList2 = p2.getMonoms();
        ArrayList <Monom> monomResult = new ArrayList<Monom>(3000);

        Polinom polinomResult = new Polinom();

        for(int i = 0; i < 3000; i++) {
            Monom monomGol = new Monom(0, 0);
            monomResult.add(monomGol);
        }

        for(int i = 0; i < monomList1.size(); i++) {
            for (int j = 0; j < monomList2.size(); j++) {
                if (monomList1.get(i).getCoefficient() != 0) {
                    if (monomList2.get(j).getCoefficient() != 0) {
                        monomResult.get(i + j).setCoefficient(monomResult.get(i + j).getCoefficient() + (monomList1.get(i).getCoefficient() * monomList2.get(j).getCoefficient()));
                        monomResult.get(i + j).setPow(i + j);
                    }
                }
            }
        }
        polinomResult.setMonoms(monomResult);
        return polinomResult;
    }

    public Monom polinomDegree(Polinom p) {
        Monom monomMaxim = new Monom(0, 0);
        ArrayList <Monom> listaMonoame = p.getMonoms();
        for(int i = listaMonoame.size() - 1; i >= 0; i--) {
            if(listaMonoame.get(i).getCoefficient() != 0) {
                monomMaxim.setCoefficient(listaMonoame.get(i).getCoefficient());
                monomMaxim.setPow(listaMonoame.get(i).getPow());
                break;
            }
        }
        return monomMaxim;
    }

    public ArrayList<Polinom> dividePolinom(Polinom p1, Polinom p2) throws BadDivideException{
        ArrayList<Polinom> catRest = new ArrayList<Polinom>();
        Monom gradPolinom1 = new Monom(0,0);
        Monom gradPolinom2 = new Monom(0, 0);
        Polinom polinomRezultat = new Polinom();
        Polinom polinomInmultit = new Polinom();
        Polinom polinomAux = new Polinom();
        ArrayList <Monom> listaAux = new ArrayList<Monom>();

        ArrayList <Monom> listaMonom1 = p1.getMonoms();
        ArrayList <Monom> listaMonom2 = p2.getMonoms();
        ArrayList <Monom> listaResult = new ArrayList<Monom>(1000);

        gradPolinom1 = polinomDegree(p1);
        System.out.println(gradPolinom1.getCoefficient() + " " + gradPolinom2.getPow());
        gradPolinom2 = polinomDegree(p2);
        System.out.println(gradPolinom2.getCoefficient() + " " + gradPolinom2.getPow());
        for(int i = 0; i < 1000; i++) {
            Monom monomGol = new Monom(0, 0);
            listaAux.add(monomGol);
        }
        for(int i = 0; i < 1000; i++) {
            Monom monomGol = new Monom(0,0);
            listaResult.add(monomGol);
        }

        if(gradPolinom1.getPow() < gradPolinom2.getPow() && gradPolinom1.getCoefficient() != 0)
            throw new BadDivideException("Impartire incorecta");
        else {
            while(Math.abs(polinomDegree(p1).getCoefficient() / polinomDegree(p2).getCoefficient()) >= 1 && polinomDegree(p1).getPow() >= polinomDegree(p2).getPow()) {
                listaResult.get(polinomDegree(p1).getPow() - polinomDegree(p2).getPow()).setCoefficient(polinomDegree(p1).getCoefficient() / polinomDegree(p2).getCoefficient());
                listaResult.get(polinomDegree(p1).getPow() - polinomDegree(p2).getPow()).setPow(polinomDegree(p1).getPow() - polinomDegree(p2).getPow());
                polinomRezultat.setMonoms(listaResult);
                listaAux.get(polinomDegree(p1).getPow() - polinomDegree(p2).getPow()).setCoefficient(polinomDegree(p1).getCoefficient() / polinomDegree(p2).getCoefficient());
                listaAux.get(polinomDegree(p1).getPow() - polinomDegree(p2).getPow()).setPow(polinomDegree(p1).getPow() - polinomDegree(p2).getPow());
                polinomAux.setMonoms(listaAux);
                polinomInmultit = multiplicationPolinom(polinomAux, p2);
                listaAux.get(polinomDegree(p1).getPow() - polinomDegree(p2).getPow()).setCoefficient(0);
                listaAux.get(polinomDegree(p1).getPow() - polinomDegree(p2).getPow()).setPow(0);
                p1 = subPolinoms(p1, polinomInmultit);
            }
        }
        polinomRezultat.setMonoms(listaResult);
        catRest.add(polinomRezultat);
        catRest.add(p1);
        return catRest;
    }

    public static int emptyGroup(String group) {
        if(group == null)
            return 1;
        else if(group.isEmpty())
            return 1;
        return 0;
    }

    public Polinom extractPolinom(String data) throws IncorrectFormatException, StringIndexOutOfBoundsException{
        int error = 0;
        Polinom poli = new Polinom();
        Pattern p = Pattern.compile("([+-]?) *([\\d]*)([a-zA-Z]?)(?:\\^(\\d+))?");
        Matcher m =  p.matcher(data);
        ArrayList <String> listaCoeficienti = new ArrayList<String>();
        ArrayList <String> listaPuteri = new ArrayList<String>();

        for(int i = 0; i < data.length(); i++) {
            if(data.length() == 1) {
                if(Character.isDigit(data.charAt(i))) {
                }
                else {
                    if(data.charAt(i) != 'x' || data.charAt(i) == '^')
                        throw new IncorrectFormatException("Ai introdus un polinom gresit!");
                    }
            }
            else {
                if (i == 0 && data.charAt(i) == '0')
                    throw new IncorrectFormatException("Ai introdus un polinom gresit!");
                if (i == data.length() - 1 && !Character.isDigit(data.charAt(i - 1)) && data.charAt(i) == '0') {
                    throw new IncorrectFormatException("Ai introdus un polinom gresit!");
                }
                if ((i < data.length() - 1 && i > 0) && data.charAt(i) == '0' && (!Character.isDigit(data.charAt(i-1)) && data.charAt(i + 1) != '.'))
                    throw new IncorrectFormatException("Ai introdus un polinom gresit!");
                if (Character.isAlphabetic(data.charAt(i)) && data.charAt(i) != 'x')
                    throw new IncorrectFormatException("Ai introdus un polinom gresit!");
                if (Character.isAlphabetic(data.charAt(i)) && i < data.length() - 1) {
                    if (data.charAt(i) != 'x')
                        throw new IncorrectFormatException("Ai introdus un polinom gresit!");
                    if (Character.isAlphabetic(data.charAt(i + 1)) || Character.isDigit(data.charAt(i + 1)))
                        throw new IncorrectFormatException("Ai introdus un polinom gresit!");
                }
                if (data.charAt(i) == '^' && i == data.length() - 1)
                    throw new IncorrectFormatException("Ai introdus un polinom gresit!");

                if (data.charAt(i) == '^' && i < data.length() - 1) {
                    if (!Character.isDigit(data.charAt(i + 1)))
                        throw new IncorrectFormatException("Ai introdus un polinom gresit!");
                }
                if (Character.isDigit(data.charAt(i)) && i < data.length() - 1) {
                    if (data.charAt(i + 1) == '^')
                        throw new IncorrectFormatException("Ai introdus un polinom gresit!");
                }
            }
        }
        while (m.find()) {
            String coeficient = "";
            String putere = "";
            if(HomeworkModel.emptyGroup(m.group(1)) == 0 || HomeworkModel.emptyGroup(m.group(2)) == 0 || HomeworkModel.emptyGroup(m.group(3)) == 0 || HomeworkModel.emptyGroup(m.group(4)) == 0) {
                if(m.group(1).equals("-")) {
                    coeficient = coeficient + "-";
                }
                if(HomeworkModel.emptyGroup(m.group(2)) == 1)
                    coeficient = coeficient + "1";
                else
                    coeficient = coeficient + m.group(2);
                if(HomeworkModel.emptyGroup(m.group(3)) == 1) {
                    putere = "0";
                }
                else {
                    if(HomeworkModel.emptyGroup(m.group(4)) == 1)
                        putere = "1";
                    else {
                        putere = m.group(4);
                    }
                }
                listaCoeficienti.add(coeficient);
                listaPuteri.add(putere);
            }
        }
        for(int i = 0; i < listaCoeficienti.size(); i++) {
            Monom monom = new Monom(Integer.parseInt(listaCoeficienti.get(i)),Integer.parseInt(listaPuteri.get(i)));
            poli.addMonom(monom);
        }
        ArrayList<Monom> monoameOrdonate = new ArrayList<Monom>(10);

        for(int j = 0; j < 1000; j++) {
            Monom monomGol = new Monom(0,0);
            monoameOrdonate.add(monomGol);
        }

        for(int i = 0; i < poli.getMonoms().size(); i++) {
            monoameOrdonate.get(poli.getMonoms().get(i).getPow()).setPow(poli.getMonoms().get(i).getPow());
            monoameOrdonate.get(poli.getMonoms().get(i).getPow()).setCoefficient(poli.getMonoms().get(i).getCoefficient());
        }
        poli.setMonoms(monoameOrdonate);
        return poli;
    }
    public int emptyPolinom(Polinom p) {
        ArrayList <Monom> monomList = p.getMonoms();
        for(Monom i: monomList) {
            if(i.getPow() != 0 && i.getCoefficient() == 0)
                return 1;
        }
        return 0;
    }
    public String mergeResult(Polinom p) {
        String s = "";
        ArrayList <Monom> monoame = new ArrayList<Monom> ();
        monoame = p.getMonoms();
        int j = 0;
        int firstElement = 1;
        DecimalFormat format = new DecimalFormat("0.#");
        for(j = monoame.size() - 1; j >= 0; j--) {
            if(monoame.get(j).getCoefficient() != 0 || monoame.get(j).getPow() != 0) {
                if(monoame.get(j).getCoefficient() != 0) {
                    if(j > 0) {
                        if(monoame.get(j).getPow() != 0 && monoame.get(j).getPow() != 1) {
                            if(monoame.get(j).getCoefficient() != 1 && monoame.get(j).getCoefficient() != (-1)) {
                                if(monoame.get(j).getCoefficient() < 0) {
                                    s = s + format.format(monoame.get(j).getCoefficient()) + "x" + "^" + monoame.get(j).getPow();
                                }
                                else {
                                    s = s + "+" + format.format(monoame.get(j).getCoefficient()) + "x" + "^" + monoame.get(j).getPow();
                                }
                            }
                            else {
                                if(monoame.get(j).getCoefficient() == -1)
                                    s = s + "-" + "x" + "^" + monoame.get(j).getPow();
                                else if(monoame.get(j).getCoefficient() == 1) s = s + "+" + "x" + "^" + monoame.get(j).getPow();
                            }
                        }
                        if(monoame.get(j).getPow() == 1)  {
                            if(monoame.get(j).getCoefficient() != 1 && monoame.get(j).getCoefficient() != (-1)) {
                                if(monoame.get(j).getCoefficient() < 0)
                                    s = s + format.format(monoame.get(j).getCoefficient()) + "x";
                                else s = s + "+" + format.format(monoame.get(j).getCoefficient()) + "x";
                            }
                            else {
                                if(monoame.get(j).getCoefficient() == -1)
                                    s = s + "-" + "x";
                                else if(monoame.get(j).getCoefficient() == 1) s = s + "+" + "x";
                            }
                        }
                    }
                    if(j == 0) {
                        if(monoame.get(j).getCoefficient() != 1 && monoame.get(j).getCoefficient() != (-1)) {
                            if(monoame.get(j).getCoefficient() < 0)
                                s = s + format.format(monoame.get(j).getCoefficient());
                            else s = s + "+" + format.format(monoame.get(j).getCoefficient());
                        }
                        else {
                            if(monoame.get(j).getCoefficient() == -1)
                                s = s + "-1";
                            else if(monoame.get(j).getCoefficient() == 1) s = s + "+" + "1";
                        }
                    }
                }
            }
        }
        if(s != null) {
            if(s.charAt(0) == '+') {
                s = s.substring(1);
            }
        }
        return s;
    }
}
