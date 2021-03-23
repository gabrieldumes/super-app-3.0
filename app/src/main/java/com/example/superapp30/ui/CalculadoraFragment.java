package com.example.superapp30.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.superapp30.R;

public class CalculadoraFragment extends Fragment {

    private EditText editPrimeiroValor, editSegundoValor;
    private TextView textSelecioneOperacao, textResultado;
    private RadioGroup radioGroupOperacao;
    private Button buttonCalcular;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calculadora, container, false);

        editPrimeiroValor = view.findViewById(R.id.editPrimeiroValor);
        editSegundoValor = view.findViewById(R.id.editSegundoValor);
        textSelecioneOperacao = view.findViewById(R.id.textSelecioneOperacao);
        textResultado = view.findViewById(R.id.textResultadoCalc);
        radioGroupOperacao = view.findViewById(R.id.radioGroupOperacao);
        buttonCalcular = view.findViewById(R.id.buttonCalcular);

        textResultado.setVisibility(View.INVISIBLE);

        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textResultado.setVisibility(View.INVISIBLE);
                textSelecioneOperacao.setTextColor(getResources().getColor(android.R.color.tab_indicator_text));

                String valor1String = editPrimeiroValor.getText().toString();
                String valor2String = editSegundoValor.getText().toString();

                if (valor1String.equals("") || valor1String.equals(".")) {
                    Toast.makeText(getActivity(), "Primeiro valor INVÁLIDO!", Toast.LENGTH_SHORT).show();
                } else if (valor2String.equals("") || valor2String.equals(".")) {
                    Toast.makeText(getActivity(), "Segundo valor INVÁLIDO!", Toast.LENGTH_SHORT).show();
                } else {
                    double valor1 = Double.parseDouble(valor1String);
                    double valor2 = Double.parseDouble(valor2String);
                    Double resultado = null;

                    switch (radioGroupOperacao.getCheckedRadioButtonId()) {
                        case R.id.radioSomar:
                            resultado = valor1 + valor2;
                            break;
                        case R.id.radioSubtrair:
                            resultado = valor1 - valor2;
                            break;
                        case R.id.radioMultiplicar:
                            resultado = valor1 * valor2;
                            break;
                        case R.id.radioDividir:
                            resultado = valor1 / valor2;
                            break;
                        case R.id.radioMedia:
                            resultado = (valor1 + valor2) / 2;
                            break;
                        default:
                            textSelecioneOperacao.setTextColor(getResources().getColor(R.color.design_default_color_error));
                            Toast.makeText(getActivity(), "Selecione uma operação!", Toast.LENGTH_SHORT).show();
                    }
                    if (resultado != null) {
                        textResultado.setVisibility(View.VISIBLE);
                        textResultado.setText(String.format("%.2f", resultado));
                    }
                }
            }
        });

        return view;
    }
}