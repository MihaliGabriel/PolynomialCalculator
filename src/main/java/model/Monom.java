package model;

public class Monom {
    private float coefficient;
    private int pow;

    public Monom(float coefficient, int pow) {
        this.coefficient = coefficient;
        this.pow = pow;
    }

    public float getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(float coefficient) {
        this.coefficient = coefficient;
    }

    public int getPow() {
        return pow;
    }

    public void setPow(int pow) {
        this.pow = pow;
    }
}
