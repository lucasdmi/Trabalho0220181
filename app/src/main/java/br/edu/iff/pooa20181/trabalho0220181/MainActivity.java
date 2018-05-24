package br.edu.iff.pooa20181.trabalho0220181;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private Spinner cargo;
    private EditText edtHora;
    private EditText edtFalta;
    private EditText edtFilho;
    private Button btCalcular;
    private TextView tMensagem;

    private String item;
    private int hora;
    private int filho;
    private int falta;
    private float salarioBase;
    private float INSS;
    private float proventos;
    private float descontos;
    private float salarioLiquido;
    private float vHora;
    private float vFalta;
    private float vFilho;

    DecimalFormat df = new DecimalFormat("0.00");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        cargo = (Spinner) findViewById(R.id.spCargo);
        edtHora = (EditText) findViewById(R.id.edtHora);
        edtFalta = (EditText) findViewById(R.id.edtFalta);
        edtFilho = (EditText) findViewById(R.id.edtFilho);
        tMensagem = (TextView) findViewById(R.id.tMensagem);
        btCalcular = (Button) findViewById(R.id.btCalcular);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,R.array.a_cargo, R.layout.support_simple_spinner_dropdown_item);
        cargo.setAdapter(adapter);

        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calcular();
                tMensagem.setText("Total de proventos: R$" + df.format(proventos)   +
                        "\nDescontos: R$ " + df.format(descontos) + "\nSalario Liquido: R$ " + df.format(salarioLiquido));
            }
        });


    }

    public void calcular(){

        item = cargo.getSelectedItem().toString();

        if(item.equals("Gerente"))
        {
            salarioBase = 2000;
            vHora = (salarioBase / 240) * 2;
            vFalta = salarioBase / 30;
            vFilho = (float) (salarioBase * 0.03);

            hora = Integer.parseInt(edtHora.getText().toString());
            falta = Integer.parseInt(edtFalta.getText().toString());
            filho = Integer.parseInt(edtFilho.getText().toString());

            vHora = vHora * hora;
            vFalta = vFalta * falta;
            vFilho = vFilho * filho;

            proventos = (salarioBase + vHora + vFilho);
            INSS =  (float) (proventos * 0.1);
            descontos = vFalta + INSS;
            salarioLiquido = proventos - INSS;


        }
        else{
            if(item.equals("Supervisor"))
            {
                salarioBase = 900;
                vHora = (salarioBase / 240) * 2;
                vFalta = salarioBase / 30;
                vFilho = (float) (salarioBase * 0.03);

                hora = Integer.parseInt(edtHora.getText().toString());
                falta = Integer.parseInt(edtFalta.getText().toString());
                filho = Integer.parseInt(edtFilho.getText().toString());

                vHora = vHora * hora;
                vFalta = vFalta * falta;
                vFilho = vFilho * filho;

                proventos = (salarioBase + vHora + vFilho);
                INSS =  (float) (proventos * 0.1);
                descontos = vFalta + INSS;
                salarioLiquido = proventos - INSS;
            }
            else{
                if(item.equals("Servente"))
                {
                    salarioBase = 300;
                    vHora = (salarioBase / 240) * 2;
                    vFalta = salarioBase / 30;
                    vFilho = (float) (salarioBase * 0.03);

                    hora = Integer.parseInt(edtHora.getText().toString());
                    falta = Integer.parseInt(edtFalta.getText().toString());
                    filho = Integer.parseInt(edtFilho.getText().toString());

                    vHora = vHora * hora;
                    vFalta = vFalta * falta;
                    vFilho = vFilho * filho;

                    proventos = (salarioBase + vHora + vFilho);
                    INSS =  (float) (proventos * 0.1);
                    descontos = vFalta + INSS;
                    salarioLiquido = proventos - INSS;
                }
            }
        }
    }
}
