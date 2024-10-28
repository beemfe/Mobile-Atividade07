/**
 * @author: Felipe Bernardes Cisilo
 */
package br.edu.fateczl.atividade07.model;

public abstract class ContaBancaria {

    private String cliente;
    private int num_conta;
    private float saldo;

    public ContaBancaria() {
        super();
    }

    public void sacar(float valor) {
        if (saldo >= valor) {
            saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public void depositar(float valor) {
        saldo += valor;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getNum_conta() {
        return num_conta;
    }

    public void setNum_conta(int num_conta) {
        this.num_conta = num_conta;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
}
