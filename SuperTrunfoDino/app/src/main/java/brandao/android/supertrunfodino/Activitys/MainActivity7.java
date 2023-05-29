package brandao.android.supertrunfodino.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import brandao.android.supertrunfodino.Model.Carta;
import brandao.android.supertrunfodino.R;

public class MainActivity7 extends AppCompatActivity {

    private ImageView imageColecao;
    private TextView textTamanhoColecao;
    private TextView textNomeColecao;
    private TextView textPesoColecao;
    private TextView textLongevidadeColecao;
    private TextView textAgressividadeColecao;
    private TextView textVelocidadeColecao;

    private ImageButton buttonVoltarColecao;

    private Carta carta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        imageColecao = findViewById(R.id.imageColecao);

        textNomeColecao = findViewById(R.id.textNomeColecao);
        textTamanhoColecao = findViewById(R.id.textTamanhoValorColecao);
        textPesoColecao= findViewById(R.id.textPesoValorColecao);
        textLongevidadeColecao = findViewById(R.id.textLongevidadeValorColecao);
        textAgressividadeColecao = findViewById(R.id.textAgressividadeValorColecao);
        textVelocidadeColecao = findViewById(R.id.textVelocidadeValorColecao);

        buttonVoltarColecao = findViewById(R.id.buttonVoltarColecao);


        //Recuperando objeto carta
        carta = (Carta)getIntent().getExtras().getSerializable("cartaSelecionada");
        int identificar = Math.round(carta.id);

        switch (identificar){
            case 1:
                imageColecao.setImageResource(R.drawable.tiranossauro);

                break;
            case 2:
                imageColecao.setImageResource(R.drawable.sauropode);

                break;
            case 3:
                imageColecao.setImageResource(R.drawable.velociraptor);

                break;
            case 4:
                imageColecao.setImageResource(R.drawable.utahraptor);
                break;
            case 5:
                imageColecao.setImageResource(R.drawable.alossauro);
                break;
            case 6:
                imageColecao.setImageResource(R.drawable.ceratopsia);
                break;
            case 7:
                imageColecao.setImageResource(R.drawable.pachycephalosaurus);

                break;
            case 8:
                imageColecao.setImageResource(R.drawable.stegosaurus);
                break;
        }
                textNomeColecao.setText(carta.nome);
                textTamanhoColecao.setText(String.valueOf(carta.tamanho));
                textPesoColecao.setText(String.valueOf(carta.peso));
                textLongevidadeColecao.setText(String.valueOf(carta.longevidade));
                textAgressividadeColecao.setText(String.valueOf(carta.agressividade));
                textVelocidadeColecao.setText(String.valueOf(carta.velocidade));


                buttonVoltarColecao.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getApplicationContext(), MainActivity6.class);
                        startActivity(intent);
                    }
                });


    }
}