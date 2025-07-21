import exceptions.OperacaoInvalidaException;

public class ContaBancariaBasica {

    public ContaBancariaBasica(String numeracao, double taxaJurosAnual) {
        this.numeracao = numeracao;
        this.taxaJurosAnual = taxaJurosAnual;
        this.saldo = 0;
    }

    private String numeracao;
    private double saldo;
    private double taxaJurosAnual;

    public String getNumeracao() {
        return numeracao;
    }

    public void setNumeracao(String numeracao) {
        this.numeracao = numeracao;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }

    public void setTaxaJurosAnual(double taxaJurosAnual) {
        this.taxaJurosAnual = taxaJurosAnual;
    }

    public void depositar(double valor) throws OperacaoInvalidaException {
        if (valor <= 0) {
            throw new OperacaoInvalidaException("Valor para deposito deve ser maior que 0");
        }
        this.saldo += valor;
    }

    public void sacar(double valor) throws OperacaoInvalidaException {
        if (valor <= 0) {
            throw new OperacaoInvalidaException("Valor de saque deve ser maior que 0");
        }

        if (valor > this.saldo) {
            throw new OperacaoInvalidaException("Valor de saque deve ser menor que o saldo atual");
        }

        this.saldo -= valor;
    }

    public double calcularTarifaMensal() {
        if (this.saldo * 0.1 < 10) {
            return this.saldo * 0.1;
        }
        return 10;
    }

    public double calcularJurosMensal() {
        if (this.saldo < 0) {
            return 0;
        }
        return saldo * (taxaJurosAnual / 12 / 100);
    }

    public void aplicarAtualizacaoMensal() {
        this.saldo = this.saldo - calcularTarifaMensal() + calcularJurosMensal();
    }

}
