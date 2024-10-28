/**
 * @author: Felipe Bernardes Cisilo
 */
package br.edu.fateczl.atividade07.model;

public class ContaPoupança extends ContaBancaria{

    private int dia_rendimento;
    public ContaPoupança(){
        super();
    }

    public void calcularNovoSaldo(float taxaRendimento) {
        float novoSaldo = getSaldo() + (getSaldo() * taxaRendimento);
        setSaldo(novoSaldo);
    }

    public int getDia_rendimento() {
        return dia_rendimento;
    }

    public void setDia_rendimento(int dia_rendimento) {
        this.dia_rendimento = dia_rendimento;
    }
}
