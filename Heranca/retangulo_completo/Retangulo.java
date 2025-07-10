public class Retangulo extends FormaGeometrica {

    private double largura;
    private double altura;

    public double getLargura() {
        return largura;
    }

    public void setLargura(double largura) {
        if (largura < 0 ) {
            throw new java.lang.IllegalArgumentException("Largura deve ser maior ou igual a 0");
        }
        this.largura = largura;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        if (altura < 0 ) {
            throw new java.lang.IllegalArgumentException("Altura deve ser maior ou igual a 0");
        }
        this.altura = altura;
    }

    @Override
    public double area() {
        return this.largura * this.altura;
    }

    public String toString() {
        return String.format("[Retangulo] %.2f / %.2f", this.largura, this.altura);
    }
}