package brandao.android.supertrunfodino.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import brandao.android.supertrunfodino.Helper.DbHelper;
import brandao.android.supertrunfodino.R;

public class MainActivity3 extends AppCompatActivity {

    private TextView textResultado;

    private TextView textAtributo1;
    private TextView textValor1;
    private TextView textNome1;
    private TextView textAtributo2;
    private TextView textValor2;
    private TextView textNome2;

    private ImageView imageAtributo1;
    private ImageView imageAtributo2;

    private Button buttonContinuar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(brandao.android.supertrunfodino.R.layout.activity_main3);

        textResultado = findViewById(R.id.textResultado);

        textAtributo1 = findViewById(R.id.textAtributo1);
        textValor1 = findViewById(R.id.textValor1);
        textNome1 = findViewById(R.id.textNome1);

        textAtributo2 = findViewById(R.id.textAtributo2);
        textValor2 = findViewById(R.id.textValor2);
        textNome2 = findViewById(R.id.textNome2);


        imageAtributo1 = findViewById(R.id.imageAtributo1);
        imageAtributo2 = findViewById(R.id.imageAtributo2);

        buttonContinuar = findViewById(R.id.buttonContinuar);



        Bundle dados = getIntent().getExtras();

       /* //Recebendo todos os dados para adicionar no banco de dados
        float tamanho1 = dados.getFloat("tamanho1");
        float tamanho2 = dados.getFloat("tamanho2");
        float peso1 = dados.getFloat("peso1");
        float peso2 = dados.getFloat("peso2");
        float longevidade1 = dados.getFloat("longevidade1");
        float longevidade2 = dados.getFloat("longevidade2");
        float agressividade1 = dados.getFloat("agressividade1");
        float agressividade2 = dados.getFloat("agressividade2");
        float velocidade1 = dados.getFloat("velocidade2");
        float velocidade2 = dados.getFloat("velocidade2");*/


        int atributoNome = dados.getInt("atributoNome");

        float atributo1 = dados.getFloat("atributo");
        String nome1 = dados.getString("nome");
        float id1 = dados.getFloat("id");

        //Passando id1 para int para usar no switch

        int identificar = Math.round(id1);

        textValor1.setText(String.valueOf(atributo1));
        textNome1.setText(nome1);

        System.out.println(nome1);

        float atributo2 = dados.getFloat("atributo2");
        String nome2 = dados.getString("nome2");
        float id2 = dados.getFloat("id2");

        //Passando id2 para int para usar no switch
        int identificar2 = Math.round(id2);

        textValor2.setText(String.valueOf(atributo2));
        textNome2.setText(nome2);


        //Recuperando os dados do banco de dados
        DbHelper db = new DbHelper(getApplicationContext());

        String sql = "SELECT * FROM " + DbHelper.TABELA_CARTAS_JOGADOR2 +" WHERE id = " + id2 + "; ";


        Cursor c = db.getReadableDatabase().rawQuery(sql, null);

        //Recuperando valores do Banco. Posso usar para calculos
       c.move(1);

            float tamanho2 = c.getFloat(c.getColumnIndexOrThrow("tamanho"));
            float peso2 = c.getFloat(c.getColumnIndexOrThrow("peso"));
            float longevidade2 = c.getFloat(c.getColumnIndexOrThrow("longevidade"));
            float agressividade2 = c.getFloat(c.getColumnIndexOrThrow("agressividade"));
            float velocidade2 = c.getFloat(c.getColumnIndexOrThrow("velocidade"));

            Log.i("INFO - nome", nome2 + "/ id - " + id2  + "/ tamanho - " + tamanho2+ "/ peso - " + peso2
                    + "/ longevidade - " + longevidade2 + "/ agressividade - " + agressividade2 + "/ velocidade - " + velocidade2 );



        String recuperarSql1 = "SELECT * FROM " + DbHelper.TABELA_CARTAS_JOGADOR1 +" WHERE id = " + id1 + "; ";


        Cursor c1 = db.getReadableDatabase().rawQuery(recuperarSql1, null);

        //Chamando os atributos da carta do jogador1
        c1.move(1);
            float tamanho1 = c1.getFloat(c1.getColumnIndexOrThrow("tamanho"));
            float peso1 = c1.getFloat(c1.getColumnIndexOrThrow("peso"));
            float longevidade1 = c1.getFloat(c1.getColumnIndexOrThrow("longevidade"));
            float agressividade1 = c1.getFloat(c1.getColumnIndexOrThrow("agressividade"));
            float velocidade1 = c1.getFloat(c1.getColumnIndexOrThrow("velocidade"));

            Log.i("INFO1 - nome", nome1 + "/ id - " + id1  + "/ tamanho - " + tamanho1+ "/ peso - " + peso1
                    + "/ longevidade - " + longevidade1 + "/ agressividade - " + agressividade1 + "/ velocidade - " + velocidade1 );





        if(atributo1 > atributo2){
            textResultado.setText("Jogador 1 venceu!");


            //Adicionando carta ao banco do vencedor
            ContentValues cv = new ContentValues();

            cv.put("nome", nome2);
            cv.put("tamanho", tamanho2);
            cv.put("peso", peso2);
            cv.put("longevidade", longevidade2);
            cv.put("agressividade",agressividade2);
            cv.put("velocidade", velocidade2);
            cv.put("id", id2);

            try{
                db.getWritableDatabase().insert(DbHelper.TABELA_CARTAS_JOGADOR1,null, cv);
                Log.i("INFO", "Sucesso ao adicionar carta nova no jogador 1");

            }catch(Exception e){

                Log.i("INFO", "Erro ao atualizar a mão do jogador 1" + e.getMessage());


            }

            //Removendo carta do banco do perdedor

            try{
                String [] args = {String.valueOf(id2)};
                db.getWritableDatabase().delete(DbHelper.TABELA_CARTAS_JOGADOR2,"id = ?",args );
                Log.i("INFO", "Sucesso ao remover a carta do jogador 2");

            }catch (Exception e){

                Log.i("INFO", "Erro ao remover a carta do jogador 2" + e.getMessage());

            }

        }else if(atributo1 < atributo2){

            textResultado.setText("Jogador 2 venceu!");

            ContentValues cv = new ContentValues();

            cv.put("nome", nome1);
            cv.put("tamanho", tamanho1);
            cv.put("peso", peso1);
            cv.put("longevidade", longevidade1);
            cv.put("agressividade",agressividade1);
            cv.put("velocidade", velocidade1);
            cv.put("id", id1);

            try{
                db.getWritableDatabase().insert(DbHelper.TABELA_CARTAS_JOGADOR2,null, cv);
                Log.i("INFO", "Sucesso ao adicionar carta nova no jogador 2");

            }catch(Exception e){

                Log.i("INFO", "Erro ao adicionar carta nova no jogador " + e.getMessage());


            }

            //Removendo carta do banco do perdedor

            try{
                String [] args = {String.valueOf(id1)};
                db.getWritableDatabase().delete(DbHelper.TABELA_CARTAS_JOGADOR1,"id = ?",args );
                Log.i("INFO", "Carta do jogador 1 removido com sucesso!");

            }catch (Exception e){

                Log.i("INFO", "Erro ao remover a carta do jogador 1" + e.getMessage());

            }
        }else{

            textResultado.setText("Empate!!!");
            try{
                String [] args = {String.valueOf(id2)};
                db.getWritableDatabase().delete(DbHelper.TABELA_CARTAS_JOGADOR2,"id = ?",args );
                Log.i("INFO", "Sucesso ao remover a carta do jogador 2");

            }catch (Exception e){

                Log.i("INFO", "Erro ao remover a carta do jogador 2" + e.getMessage());

            }

            try{
                String [] args = {String.valueOf(id1)};
                db.getWritableDatabase().delete(DbHelper.TABELA_CARTAS_JOGADOR1,"id = ?",args );
                Log.i("INFO", "Carta do jogador 1 removido com sucesso!");

            }catch (Exception e){

                Log.i("INFO", "Erro ao remover a carta do jogador 1" + e.getMessage());

            }

        }

        //Configura a imangem q ira aparecer
        switch (identificar)
        {
            case 1:
                imageAtributo1.setImageResource(R.drawable.tiranossauro);

                break;
            case 2:
                imageAtributo1.setImageResource(R.drawable.sauropode);

                break;
            case 3:
                imageAtributo1.setImageResource(R.drawable.velociraptor);

                break;
            case 4:
                imageAtributo1.setImageResource(R.drawable.utahraptor);

                break;
            case 5:
                imageAtributo1.setImageResource(R.drawable.alossauro);
                break;
            case 6:
                imageAtributo1.setImageResource(R.drawable.ceratopsia);
                break;
            case 7:
                imageAtributo1.setImageResource(R.drawable.pachycephalosaurus);

                break;
            case 8:
                imageAtributo1.setImageResource(R.drawable.stegosaurus);

                break;
        }

        //Configura a imangem 2 q ira aparecer
        switch (identificar2)
        {
            case 1:
                imageAtributo2.setImageResource(R.drawable.tiranossauro);

                break;
            case 2:
                imageAtributo2.setImageResource(R.drawable.sauropode);

                break;
            case 3:
                imageAtributo2.setImageResource(R.drawable.velociraptor);

                break;
            case 4:
                imageAtributo2.setImageResource(R.drawable.utahraptor);

                break;
            case 5:
                imageAtributo2.setImageResource(R.drawable.alossauro);
                break;
            case 6:
                imageAtributo2.setImageResource(R.drawable.ceratopsia);
                break;
            case 7:
                imageAtributo2.setImageResource(R.drawable.pachycephalosaurus);

                break;
            case 8:
                imageAtributo2.setImageResource(R.drawable.stegosaurus);

                break;
        }

        switch (atributoNome){

            case 1:
                textAtributo1.setText(R.string.fragment_Carta_tamanho);
                break;

            case 2:
                textAtributo1.setText(R.string.fragment_Carta_agressividade);
                break;

            case 3:
                textAtributo1.setText(R.string.fragment_Carta_velocidade);
                break;

            case 4:
                textAtributo1.setText(R.string.fragment_Carta_longevidade);
                break;

            case 5:
                textAtributo1.setText(R.string.fragment_Carta_peso);
                break;
        }

        switch (atributoNome){

            case 1:
                textAtributo2.setText(R.string.fragment_Carta_tamanho);
                break;

            case 2:
                textAtributo2.setText(R.string.fragment_Carta_agressividade);
                break;

            case 3:
                textAtributo2.setText(R.string.fragment_Carta_velocidade);
                break;

            case 4:
                textAtributo2.setText(R.string.fragment_Carta_longevidade);
                break;

            case 5:
                textAtributo2.setText(R.string.fragment_Carta_peso);
                break;
        }
        buttonContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //Utilizando o count para descobrir a quantidade de linhas q há na tabela 2
                String recuperarSql1 = "SELECT count(nome) FROM " + DbHelper.TABELA_CARTAS_JOGADOR2 + " ; ";
                Cursor c1 = db.getReadableDatabase().rawQuery(recuperarSql1, null);
                c1.moveToFirst();
                int count = c1.getInt(0);
                c1.close();
                Log.i("INFO TABELA 2 -",String.valueOf(count));


                //Utilizando o count para descobrir a quantidade de linhas q há na tabela 1
                String recuperarSql2 = "SELECT count(nome) FROM " + DbHelper.TABELA_CARTAS_JOGADOR1 + " ; ";
                Cursor c2 = db.getReadableDatabase().rawQuery(recuperarSql2, null);
                c2.moveToFirst();
                int count2 = c2.getInt(0);
                c2.close();
                Log.i("INFO TABELA 1 -",String.valueOf(count2));


                //Se o count (Tabela 2 ) for igual a 0, o jogador 1 vence
                if(count == 0){
                    Log.i("INFO", "Tabela 2  vazia");
                    Intent intent = new Intent(getApplicationContext(), MainActivity4.class);
                    startActivity(intent);

                }
                //Se o count (Tabela 1 ) for igual a 0, o jogador 2 vence
                else if(count2 == 0){
                    Intent intent = new Intent(getApplicationContext(), MainActivity5.class);
                    Log.i("INFO", "Tabela 2  vazia");
                    startActivity(intent);

                }
                //Se nenhum dos counts for 0, siginifica que os jogadores ainda tem cartas e o jogo continua
                else{
                    Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                    startActivity(intent);

                }
            }
        });


    }
}