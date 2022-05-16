package com.germanorangel_dev.calculadora_de_gorjetas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

  private TextView textTotal, textGorjeta, textPorcentagem;
  private TextInputEditText editValor;
  private SeekBar seekBarGorjeta;

  private double porcentagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textTotal = findViewById(R.id.textTotal);
        textGorjeta = findViewById(R.id.textGorjeta);
        textPorcentagem = findViewById(R.id.textPorcentagem);
        editValor = findViewById(R.id.editValor);
        seekBarGorjeta = findViewById(R.id.seekBarGorjeta);

        // Adicionar listener SeekBar
        seekBarGorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                porcentagem = progress;
                textPorcentagem.setText( Math.round(porcentagem) + "%");
                calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public void calcular(){
        String valorRecuperado = editValor.getText().toString();
        if(valorRecuperado == null || valorRecuperado.equals("")){
            Toast.makeText(
                    getApplicationContext(),
                     "Digite um valor primeiro!",
                    Toast.LENGTH_LONG
            ).show();
        }else{
            //Converter String para double
            double valorDigitado = Double.parseDouble(valorRecuperado);

            // calcular Gorjeta total
            double gorjeta = valorDigitado * (porcentagem/100);
            double total = valorDigitado + gorjeta;

            // exibir a gorjeta e total
            textGorjeta.setText("R$ " + Math.round(gorjeta));
            textTotal.setText("R$ " + total);
        }
    }
}