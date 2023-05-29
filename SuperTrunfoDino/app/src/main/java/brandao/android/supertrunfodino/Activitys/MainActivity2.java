package brandao.android.supertrunfodino.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import brandao.android.supertrunfodino.Helper.DbHelper;
import brandao.android.supertrunfodino.Model.Carta;
import brandao.android.supertrunfodino.Model.Jogador;
import brandao.android.supertrunfodino.R;

public class MainActivity2 extends AppCompatActivity {

    //Textos que mudam de valor dependendo da carta
    private TextView textNome;
    private TextView textTamanhoValor;
    private TextView textPesoValor;
    private TextView textLongevidadeValor;
    private TextView textAgressividadeValor;
    private TextView textVelocidadeValor;

    //Imagem que mudam de valor dependendo da carta
    private ImageView image;

    //Textos que não mudam de valor
    private TextView textTamanho;
    private TextView textPeso;
    private TextView textLongevidade;
    private TextView textAgressividade;
    private TextView textVelocidade;

    //Layou que mudam a cor quando selecionados (não sebemos se manteremos)
    private LinearLayout layoutTamanho;
    private LinearLayout layoutPeso;
    private LinearLayout layoutLongevidade;
    private LinearLayout layoutAgressividade;
    private LinearLayout layoutVelocidade;

    //Listas
    private ArrayList<Carta> lista = new ArrayList<>();
    private ArrayList<Carta> cartasJogador1 = new ArrayList<>();
    private ArrayList<Carta> cartasJogador2 = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Identificando textos dependentes
        textNome = findViewById(R.id.textNome);
        textTamanhoValor = findViewById(R.id.textTamanhoValor);
        textPesoValor = findViewById(R.id.textPesoValor);
        textLongevidadeValor = findViewById(R.id.textLongevidadeValor);
        textAgressividadeValor = findViewById(R.id.textAgressividadeValor);
        textVelocidadeValor = findViewById(R.id.textVelocidadeValor);

        //Idendificando imagem
        image = findViewById(R.id.image);

        //Identificando textos independentes
        textTamanho = findViewById(R.id.textTamanho);
        textPeso = findViewById(R.id.textPeso);
        textLongevidade = findViewById(R.id.textLongevidade);
        textAgressividade = findViewById(R.id.textAgressividade);
        textVelocidade = findViewById(R.id.textVelocidade);

        //Identificando Layouts
        layoutTamanho = findViewById(R.id.layoutTamanho);
        layoutPeso = findViewById(R.id.layoutPeso);
        layoutLongevidade = findViewById(R.id.layoutLongevidade);
        layoutAgressividade = findViewById(R.id.layoutAgressividade);
        layoutVelocidade = findViewById(R.id.layoutVelocidade);

        DbHelper db = new DbHelper(getApplicationContext());

      /* String sql = "SELECT * FROM " + DbHelper.TABELA_CARTAS +";";


        Cursor c = db.getReadableDatabase().rawQuery(sql, null);

        //Recuperando valores do Banco. Posso usar para calculos
        while(c.moveToNext()){

            float id = c.getFloat(c.getColumnIndexOrThrow("id"));
            String nomeCarta = c.getString(c.getColumnIndexOrThrow("nome"));
            float tamanho = c.getFloat(c.getColumnIndexOrThrow("tamanho"));
            float peso = c.getFloat(c.getColumnIndexOrThrow("peso"));
            float longevidade = c.getFloat(c.getColumnIndexOrThrow("longevidade"));
            float agressividade = c.getFloat(c.getColumnIndexOrThrow("agressividade"));
            float velocidade = c.getFloat(c.getColumnIndexOrThrow("velocidade"));

            Log.i("INFO - nome", nomeCarta + "/ id - " + id  + "/ tamanho - " + tamanho+ "/ peso - " + peso
                    + "/ longevidade - " + longevidade + "/ agressividade - " + agressividade + "/ velocidade - " + velocidade );

        }*/


        //Adicionando ao banco as cartas do jogador 1

        DbHelper db1 = new DbHelper(getApplicationContext());


        String sqlJogador1 = "SELECT * FROM " + DbHelper.TABELA_CARTAS_JOGADOR1 +";";

            Cursor c1 = db1.getReadableDatabase().rawQuery(sqlJogador1, null);

        //Recuperando valores do Banco. Posso usar para calculos

            c1.move(1);
            String nomeCarta1 = c1.getString(c1.getColumnIndexOrThrow("nome"));
            float tamanho1 = c1.getFloat(c1.getColumnIndexOrThrow("tamanho"));
            float peso1 = c1.getFloat(c1.getColumnIndexOrThrow("peso"));
            float longevidade1 = c1.getFloat(c1.getColumnIndexOrThrow("longevidade"));
            float agressividade1 = c1.getFloat(c1.getColumnIndexOrThrow("agressividade"));
            float velocidade1 = c1.getFloat(c1.getColumnIndexOrThrow("velocidade"));
            float id = c1.getFloat(c1.getColumnIndexOrThrow("id"));

            Log.i("INFO J1 - tamanho", nomeCarta1 );
            Log.i("INFO J1 - nome", String.valueOf(tamanho1));




        //Passando dados para tabela de cartas do jogador 2

        Log.i("INFO", String.valueOf(lista.size()));



        String sqlJogador2 = "SELECT * FROM " + DbHelper.TABELA_CARTAS_JOGADOR2 +";";

        Cursor c2 = db1.getReadableDatabase().rawQuery(sqlJogador2, null);

        //Recuperando valores do Banco. Posso usar para calculos

            c2.move(1);
            String nomeCarta2 = c2.getString(c2.getColumnIndexOrThrow("nome"));
            float tamanho2 = c2.getFloat(c2.getColumnIndexOrThrow("tamanho"));
            float peso2 = c2.getFloat(c2.getColumnIndexOrThrow("peso"));
            float longevidade2 = c2.getFloat(c2.getColumnIndexOrThrow("longevidade"));
            float agressividade2 = c2.getFloat(c2.getColumnIndexOrThrow("agressividade"));
            float velocidade2 = c2.getFloat(c2.getColumnIndexOrThrow("velocidade"));
            float id2 = c2.getFloat(c2.getColumnIndexOrThrow("id"));


            Log.i("INFO J2 - nome", nomeCarta2 );
            Log.i("INFO J2 - tamanho", String.valueOf(tamanho2));

            //Imprimir a tabela cartasJogador2

        String sqlJogador3 = "SELECT * FROM " + DbHelper.TABELA_CARTAS_JOGADOR2 +";";

        Cursor c3 = db1.getReadableDatabase().rawQuery(sqlJogador2, null);

        //Recuperando valores do Banco. Posso usar para calculos

        c3.move(1);
        String nomeCarta3 = c3.getString(c3.getColumnIndexOrThrow("nome"));
        float tamanho3 = c3.getFloat(c3.getColumnIndexOrThrow("tamanho"));
        float peso3 = c3.getFloat(c3.getColumnIndexOrThrow("peso"));
        float longevidade3 = c3.getFloat(c3.getColumnIndexOrThrow("longevidade"));
        float agressividade3 = c3.getFloat(c3.getColumnIndexOrThrow("agressividade"));
        float velocidade3 = c3.getFloat(c3.getColumnIndexOrThrow("velocidade"));
        float id3 = c3.getFloat(c3.getColumnIndexOrThrow("id"));


        Log.i("INFO J2 - nome", nomeCarta3 );
        Log.i("INFO J2 - tamanho", String.valueOf(tamanho3));


        //Passando o id(float) para int

        int identificar = Math.round(id);

        //Configura a imangem q ira aparecer
            switch (identificar)
            {
                case 1:
                    image.setImageResource(R.drawable.tiranossauro);

                    break;
                case 2:
                    image.setImageResource(R.drawable.sauropode);

                    break;
                case 3:
                    image.setImageResource(R.drawable.velociraptor);

                    break;
                case 4:
                    image.setImageResource(R.drawable.utahraptor);

                    break;
                case 5:
                    image.setImageResource(R.drawable.alossauro);
                    break;
                case 6:
                    image.setImageResource(R.drawable.ceratopsia);
                    break;
                case 7:
                    image.setImageResource(R.drawable.pachycephalosaurus);

                    break;
                case 8:
                    image.setImageResource(R.drawable.stegosaurus);
                    break;
            }

            //Mostra os valores das cartas
            textNome.setText(nomeCarta1);
            textTamanhoValor.setText(String.valueOf(tamanho1));
            textPesoValor.setText(String.valueOf(peso1));
            textLongevidadeValor.setText(String.valueOf(longevidade1));
            textAgressividadeValor.setText(String.valueOf(agressividade1));
            textVelocidadeValor.setText(String.valueOf(velocidade1));

            //Escolha do jogador

            textTamanho.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    layoutTamanho.setBackgroundColor(getResources().getColor(R.color.vermelho));
                    Intent intent = new Intent(getApplicationContext(), MainActivity3.class);
                    intent.putExtra("atributo", tamanho1);

                    //Passando as informações id e nome
                    intent.putExtra("id", id);
                    intent.putExtra("id2", id2);
                    intent.putExtra("nome", nomeCarta1);
                    intent.putExtra("nome2", nomeCarta2);
                    intent.putExtra("atributoNome", 1);


                    //cartasJogador1.remove(0);
                    intent.putExtra("atributo2", tamanho2);
                    //cartasJogador2.remove(0);
                    startActivity(intent);
                }
            });


            textAgressividade.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    layoutAgressividade.setBackgroundColor(getResources().getColor(R.color.vermelho));
                    Intent intent = new Intent(getApplicationContext(), MainActivity3.class);
                    intent = new Intent(getApplicationContext(), MainActivity3.class);
                    intent.putExtra("atributo", agressividade1);
                    //cartasJogador1.remove(0);

                    //Passando as informações id e nome
                    intent.putExtra("id", id);
                    intent.putExtra("id2", id2);
                    intent.putExtra("nome", nomeCarta1);
                    intent.putExtra("nome2", nomeCarta2);
                    intent.putExtra("atributoNome", 2);

                    intent.putExtra("atributo2", agressividade2);
                    //cartasJogador2.remove(0);
                    startActivity(intent);

                }
            });

                textVelocidade.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        layoutVelocidade.setBackgroundColor(getResources().getColor(R.color.vermelho));
                        Intent intent = new Intent(getApplicationContext(), MainActivity3.class);
                        intent = new Intent(getApplicationContext(), MainActivity3.class);
                        intent.putExtra("atributo", velocidade1);
                        //cartasJogador1.remove(0);

                        //Passando as informações id e nome
                        intent.putExtra("id", id);
                        intent.putExtra("id2", id2);
                        intent.putExtra("nome", nomeCarta1);
                        intent.putExtra("nome2", nomeCarta2);
                        intent.putExtra("atributoNome", 3);


                        intent.putExtra("atributo2", velocidade2);
                        //cartasJogador2.remove(0);
                        startActivity(intent);

                    }
                });
                textLongevidade.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        layoutLongevidade.setBackgroundColor(getResources().getColor(R.color.vermelho));
                        Intent intent = new Intent(getApplicationContext(), MainActivity3.class);
                        intent = new Intent(getApplicationContext(), MainActivity3.class);
                        intent.putExtra("atributo", longevidade1);
                        //cartasJogador1.remove(0);

                        //Passando as informações id e nome
                        intent.putExtra("id", id);
                        intent.putExtra("id2", id2);
                        intent.putExtra("nome", nomeCarta1);
                        intent.putExtra("nome2", nomeCarta2);
                        intent.putExtra("atributoNome", 4);


                        intent.putExtra("atributo2", longevidade2);
                        //cartasJogador2.remove(0);
                        startActivity(intent);

                    }
                });

                textPeso.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        layoutPeso.setBackgroundColor(getResources().getColor(R.color.vermelho));
                        Intent intent = new Intent(getApplicationContext(), MainActivity3.class);
                        intent = new Intent(getApplicationContext(), MainActivity3.class);
                        intent.putExtra("atributo", peso1);
                        //cartasJogador1.remove(0);

                        //Passando as informações id e nome
                        intent.putExtra("id", id);
                        intent.putExtra("id2", id2);
                        intent.putExtra("nome", nomeCarta1);
                        intent.putExtra("nome2", nomeCarta2);
                        intent.putExtra("atributoNome", 5);


                        intent.putExtra("atributo2", peso2);
                        //cartasJogador2.remove(0);
                        startActivity(intent);

                            }
                        });


        }
}
