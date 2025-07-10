public class Empregado {

    public Empregado(double salarioFixo) {
        this.salarioFixo = salarioFixo;
    }

    double salarioFixo;

    public double getSalarioFixo() {
        return salarioFixo;
    }

    public double calcularBonus(Departamento departamento) {
        if (departamento.alcancouMeta()) {
            return this.salarioFixo * 0.1;
        }
        return 0;
    }

    double calcularSalarioTotal(Departamento departamento) {
        return this.salarioFixo + calcularBonus(departamento);
    }
}
