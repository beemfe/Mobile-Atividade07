/**
 * @author: Felipe Bernardes Cisilo
 */
package br.edu.fateczl.atividade07.model;

public class ContaEspecial extends ContaBancaria{

    private float limite;
    public ContaEspecial() {
        super();
    }

    public void sacar(float valor) {
        if (getSaldo() + limite >= valor) {
            setSaldo(getSaldo() - valor);
        } else {
            System.out.println("Limite excedido.");
        }
    }

    public float getLimite() {
        return limite;
    }

    public void setLimite(float limite) {
        this.limite = limite;
    }
}
