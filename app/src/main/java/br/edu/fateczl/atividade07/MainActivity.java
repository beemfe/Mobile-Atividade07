/**
 * Nome: Felipe Bernardes Cisilo
 * RA: 1110482413017
 */
package br.edu.fateczl.atividade07;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import br.edu.fateczl.atividade07.model.ContaBancaria;
import br.edu.fateczl.atividade07.model.ContaEspecial;
import br.edu.fateczl.atividade07.model.ContaPoupança;

public class MainActivity extends AppCompatActivity {

    private ContaBancaria conta;
    private EditText etValor;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        etValor = findViewById(R.id.etValor);
        tvResultado = findViewById(R.id.tvResultado);
        RadioGroup radioGroup = findViewById(R.id.radioGroup);

        RadioButton rbContaPoupanca = findViewById(R.id.rbContaPoupança);
        RadioButton rbContaEspecial = findViewById(R.id.rbContaEspecial);

        rbContaPoupanca.setOnClickListener(v -> {
            conta = new ContaPoupança();
            incluirDadosConta("Cliente Poupança", 12345, 1000.00f);
        });

        rbContaEspecial.setOnClickListener(v -> {
            conta = new ContaEspecial();
            incluirDadosConta("Cliente Especial", 67890, 2000.00f);
        });

        Button btnSacar = findViewById(R.id.btnSacar);
        btnSacar.setOnClickListener(this::sacarValor);

        Button btnDepositar = findViewById(R.id.btnDepositar);
        btnDepositar.setOnClickListener(this::depositarValor);

        Button btnMostrarSaldo = findViewById(R.id.btnMostrarSaldo);
        btnMostrarSaldo.setOnClickListener(this::mostrarNovoSaldo);
    }

    private void incluirDadosConta(String cliente, int num_conta, float saldo) {
        conta.setCliente(cliente);
        conta.setNum_conta(num_conta);
        conta.setSaldo(saldo);
        tvResultado.setText("Conta de " + cliente + " incluída com saldo inicial de " + saldo);
    }

    public void sacarValor(View view) {
        float valor = Float.parseFloat(etValor.getText().toString());
        conta.sacar(valor);
        tvResultado.setText("Valor sacado: " + valor + "\nSaldo atual: " + conta.getSaldo());
    }

    public void depositarValor(View view) {
        float valor = Float.parseFloat(etValor.getText().toString());
        conta.depositar(valor);
        tvResultado.setText("Valor depositado: " + valor + "\nSaldo atual: " + conta.getSaldo());
    }

    public void mostrarNovoSaldo(View view) {
        if (conta instanceof ContaPoupança) {
            ((ContaPoupança) conta).calcularNovoSaldo(0.05f);
            tvResultado.setText("Novo saldo calculado para Conta Poupança\nSaldo atual: " + conta.getSaldo());
        } else {
            tvResultado.setText("Saldo atual: " + conta.getSaldo());
        }
    }
}