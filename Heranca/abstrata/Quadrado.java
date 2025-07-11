public class Quadrado extends FormaGeometrica {

    private double lado;

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        if (lado < 0) {
            throw new IllegalArgumentException("Lado deve ser maior ou igual a 0");
        }
        this.lado = lado;
    }

    @Override
    public double area() {
        return this.lado * this.lado;
    }

    @Override
    public String toString() {
        return "[Quadrado] " + lado;
    }
}