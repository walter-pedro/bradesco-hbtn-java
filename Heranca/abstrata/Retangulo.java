public class Retangulo extends FormaGeometrica {

    protected double largura;
    protected double altura;

    public double getLargura() {
        return largura;
    }

    public void setLargura(double largura) {
        if (largura < 0 ) {
            throw new IllegalArgumentException("Largura deve ser maior ou igual a 0");
        }
        this.largura = largura;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        if (altura < 0 ) {
            throw new IllegalArgumentException("Altura deve ser maior ou igual a 0");
        }
        this.altura = altura;
    }

    @Override
    public double area() {
        return this.largura * this.altura;
    }

    public String toString() {
        return String.format("[Retangulo] %f / %f", this.largura, this.altura);
    }
}
