package com.example.atv4_exrc1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.time.LocalDate;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {


    private EditText etDia;
    private EditText etMes;
    private EditText etAno;
    private Button btnCalc;
    private TextView tvRes;

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

        etDia = findViewById(R.id.etDia);
        etMes= findViewById(R.id.etMes);
        etAno = findViewById(R.id.etAno);
        btnCalc = findViewById(R.id.btnCalc);
        tvRes = findViewById(R.id.tvRes);

        btnCalc.setOnClickListener(op -> calc ());


    }

    public void calc (){

    int diaNiver = Integer.parseInt(etDia.getText().toString());
    int mesNiver = Integer.parseInt(etMes.getText().toString());
    int anoNiver = Integer.parseInt(etAno.getText().toString());

    Calendar hoje = Calendar.getInstance();
    int diaAtual = hoje.get(Calendar.DAY_OF_MONTH);
    int mesAtual = hoje.get(Calendar.MONTH);
    int anoAtual = hoje.get(Calendar.YEAR);


    int idadeDia = diaAtual - diaNiver;
    int idadeMes = mesAtual - mesNiver;
    int idadeAno = anoAtual - anoNiver;

    if (idadeDia <0){
        idadeMes -= 1;
        idadeDia += diasNoMes(mesAtual-1, anoAtual);
    }
    if (idadeMes < 0){
        idadeAno -= 1;
        idadeMes += 12;
        }

    tvRes.setText("Voce tem: "+idadeAno+" anos, "+idadeMes+" meses e "+idadeDia+" dias");
    }

    private int diasNoMes(int mes, int ano){
        switch (mes){
            case 0:
                return 31;
            case 1:
                return anoBissexto(ano)? 29 : 28;
            case 3:
                return 30;
            case 4:
                return 31;
            case 5:
                return 30;
            case 6:
                return 31;
            case 7:
                return 31;
            case 8:
                return 30;
            case 9:
                return 31;
            case 10:
                return 30;
            case 11:
                return 31;
            default:
                return 0;
            }
        }


    private boolean anoBissexto(int ano){
        return (ano % 4 == 0 && ano % 100 !=0) || (ano % 400 == 0);
    }



}