package brandao.android.supertrunfodino.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import brandao.android.supertrunfodino.Helper.DbHelper;
import brandao.android.supertrunfodino.Model.Carta;
import brandao.android.supertrunfodino.Model.Jogador;
import brandao.android.supertrunfodino.R;

public class MainActivity extends AppCompatActivity {
    private Button buttonJogar;
    private Button buttonCartas;
    private Button buttonSair;

    public ArrayList<Carta> lista = new ArrayList<>();
    private ArrayList<Carta> cartasJogador1 = new ArrayList<>();
    private ArrayList<Carta> listaCompleta = new ArrayList<>();
    private ArrayList<Carta> cartasJogador2 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonJogar = findViewById(R.id.buttonJogar);
        buttonCartas = findViewById(R.id.buttonCartas);
        buttonSair = findViewById(R.id.buttonSair);


        DbHelper db = new DbHelper(getApplicationContext());

        String sqlDeletarLista = "SELECT * FROM " + DbHelper.TABELA_CARTAS +";";


        Cursor cDeletarLista = db.getReadableDatabase().rawQuery(sqlDeletarLista, null);


        while(cDeletarLista.moveToNext()) {

            float id = cDeletarLista.getFloat(cDeletarLista.getColumnIndexOrThrow("id"));


            try {
                String [] args = {String.valueOf(id)};
                db.getWritableDatabase().delete(DbHelper.TABELA_CARTAS, "id = ?", args);
                Log.i("INFO", "Tabela Cartas deletada");

            } catch (Exception e) {

                Log.i("INFO", "erro ao deletar a tabela cartas!" + e.getMessage());

            }
        }



        String sqldeletar = "SELECT * FROM " + DbHelper.TABELA_CARTAS_JOGADOR1 +";";


        Cursor cDeletar = db.getReadableDatabase().rawQuery(sqldeletar, null);


        while(cDeletar.moveToNext()) {

            float id = cDeletar.getFloat(cDeletar.getColumnIndexOrThrow("id"));


            try {
                String [] args = {String.valueOf(id)};
                db.getWritableDatabase().delete(DbHelper.TABELA_CARTAS_JOGADOR1, "id = ?", args);
                Log.i("INFO", "Tabela Cartas jogador 1 deletada");

            } catch (Exception e) {

                Log.i("INFO", "esso ao deletar a tabela cartas jogador1 !" + e.getMessage());

            }

        }

        String sqldeletar2 = "SELECT * FROM " + DbHelper.TABELA_CARTAS_JOGADOR2 +";";


        Cursor cDeletar2 = db.getReadableDatabase().rawQuery(sqldeletar2, null);


        while(cDeletar2.moveToNext()) {

            float id = cDeletar2.getFloat(cDeletar2.getColumnIndexOrThrow("id"));

            try {
                String [] args = {String.valueOf(id)};
                db.getWritableDatabase().delete(DbHelper.TABELA_CARTAS_JOGADOR2, "id = ?", args);
                Log.i("INFO", "Tabela Cartas jogador 2 deletada");

            } catch (Exception e) {

                Log.i("INFO", "esso ao deletar a tabela cartas jogador 2 !" + e.getMessage());

            }

        }

        criarCarta(lista);
        criarCarta(listaCompleta);


        criarJogador();

        Log.i("INFO ARRAY CARTA", String.valueOf(lista.size()));
        Log.i("INFO ARRAY CARTA", String.valueOf(listaCompleta.size()));

        ContentValues cv = new ContentValues();
        for(int i = 0; i < lista.size(); i++)
        {
            cv.put("nome", lista.get(i).nome);
            cv.put("tamanho", lista.get(i).tamanho);
            cv.put("peso", lista.get(i).peso);
            cv.put("longevidade", lista.get(i).longevidade);
            cv.put("agressividade", lista.get(i).agressividade);
            cv.put("velocidade", lista.get(i).velocidade);
            cv.put("id", lista.get(i).id);

            try {
                db.getWritableDatabase().insert(DbHelper.TABELA_CARTAS, null, cv);

            }catch (Exception e ){

           }}

        //Monstrando tabelaCartas
         String sql = "SELECT * FROM " + DbHelper.TABELA_CARTAS +";";


        Cursor c = db.getReadableDatabase().rawQuery(sql, null);


        while(c.moveToNext()){

            float id = c.getFloat(c.getColumnIndexOrThrow("id"));
            String nomeCarta = c.getString(c.getColumnIndexOrThrow("nome"));
            float tamanho = c.getFloat(c.getColumnIndexOrThrow("tamanho"));
            float peso = c.getFloat(c.getColumnIndexOrThrow("peso"));
            float longevidade = c.getFloat(c.getColumnIndexOrThrow("longevidade"));
            float agressividade = c.getFloat(c.getColumnIndexOrThrow("agressividade"));
            float velocidade = c.getFloat(c.getColumnIndexOrThrow("velocidade"));

            Log.i("INFO CARTAS - nome", nomeCarta + "/ id - " + id  + "/ tamanho - " + tamanho+ "/ peso - " + peso
                    + "/ longevidade - " + longevidade + "/ agressividade - " + agressividade + "/ velocidade - " + velocidade );

        }


        sortearCartas();

        Log.i("INFO ARRAY JOGADOR 1", String.valueOf(cartasJogador1.size()));
        Log.i("INFO ARRAY JOGADOR 2", String.valueOf(cartasJogador2.size()));
        ContentValues cv1 = new ContentValues();

        for (int i = 0; i < cartasJogador1.size(); i++){

            cv1.put("nome", cartasJogador1.get(i).nome);
            cv1.put("tamanho", cartasJogador1.get(i).tamanho);
            cv1.put("peso", cartasJogador1.get(i).peso);
            cv1.put("longevidade", cartasJogador1.get(i).longevidade);
            cv1.put("agressividade", cartasJogador1.get(i).agressividade);
            cv1.put("velocidade", cartasJogador1.get(i).velocidade);
            cv1.put("id", cartasJogador1.get(i).id);

            try {
                db.getWritableDatabase().insert(DbHelper.TABELA_CARTAS_JOGADOR1, null, cv1);

            }catch (Exception e ){

            }
        }
            //Monstrando cartas do jogador 1
            String sql1 = "SELECT * FROM " + DbHelper.TABELA_CARTAS_JOGADOR1 +";";


        Cursor c1 = db.getReadableDatabase().rawQuery(sql1, null);

        //Recuperando valores do Banco. Posso usar para calculos
        while(c1.moveToNext()){

            float id = c1.getFloat(c1.getColumnIndexOrThrow("id"));
            String nomeCarta = c1.getString(c1.getColumnIndexOrThrow("nome"));
            float tamanho = c1.getFloat(c1.getColumnIndexOrThrow("tamanho"));
            float peso = c1.getFloat(c1.getColumnIndexOrThrow("peso"));
            float longevidade = c1.getFloat(c1.getColumnIndexOrThrow("longevidade"));
            float agressividade = c1.getFloat(c1.getColumnIndexOrThrow("agressividade"));
            float velocidade = c1.getFloat(c1.getColumnIndexOrThrow("velocidade"));

            Log.i("INFO JOGADOR 1 - nome", nomeCarta + "/ id - " + id  + "/ tamanho - " + tamanho+ "/ peso - " + peso
                    + "/ longevidade - " + longevidade + "/ agressividade - " + agressividade + "/ velocidade - " + velocidade );

        }


         ContentValues cv2 = new ContentValues();

        for (int i = 0; i < cartasJogador2.size(); i++){



            cv2.put("nome", lista.get(i).nome);
            cv2.put("tamanho", lista.get(i).tamanho);
            cv2.put("peso", lista.get(i).peso);
            cv2.put("longevidade", lista.get(i).longevidade);
            cv2.put("agressividade", lista.get(i).agressividade);
            cv2.put("velocidade", lista.get(i).velocidade);
            cv2.put("id", lista.get(i).id);

            try {
                db.getWritableDatabase().insert(DbHelper.TABELA_CARTAS_JOGADOR2, null, cv2);

            }catch (Exception e ){

            }
        }

        //Monstrando cartas do jogador 2
         String sql2 = "SELECT * FROM " + DbHelper.TABELA_CARTAS_JOGADOR2 +";";


        Cursor c2 = db.getReadableDatabase().rawQuery(sql2, null);

        //Recuperando valores do Banco. Posso usar para calculos
        while(c2.moveToNext()){

            float id = c2.getFloat(c2.getColumnIndexOrThrow("id"));
            String nomeCarta = c2.getString(c2.getColumnIndexOrThrow("nome"));
            float tamanho = c2.getFloat(c2.getColumnIndexOrThrow("tamanho"));
            float peso = c2.getFloat(c2.getColumnIndexOrThrow("peso"));
            float longevidade = c2.getFloat(c2.getColumnIndexOrThrow("longevidade"));
            float agressividade = c2.getFloat(c2.getColumnIndexOrThrow("agressividade"));
            float velocidade = c2.getFloat(c2.getColumnIndexOrThrow("velocidade"));

            Log.i("INFO JOGADOR 2 - nome", nomeCarta + "/ id - " + id  + "/ tamanho - " + tamanho+ "/ peso - " + peso
                    + "/ longevidade - " + longevidade + "/ agressividade - " + agressividade + "/ velocidade - " + velocidade );

        }




        buttonJogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);

                startActivity(intent);

            }

        });

        buttonCartas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity6.class);
                intent.putExtra("lista", listaCompleta);
                Log.i("INFO LISTA COMPLETA", String.valueOf(listaCompleta.size()));
                startActivity(intent);
            }
        });

        buttonSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity();
            }
        });

    }
    public ArrayList<Carta> criarCarta( ArrayList<Carta> lista ){
        Carta carta = new Carta("Tiranossauro", 6, 10, 30, 10, 27, 1);
        lista.add(carta);
        lista.add(new Carta("Saurópode", 20, 58, 55, 2, 20  , 2));
        lista.add(new Carta("Velociraptor", 0.6f, 0.050f, 10, 8, 100, 3  ));
        lista.add(new Carta("Utahraptor", 1.5f, 0.34f, 15, 9, 50  ,4));
        lista.add(new Carta("Alossauro", 5, 4, 20, 7, 43, 5));
        lista.add(new Carta("Ceratopsia", 1.8f, 9, 30, 5, 25, 6));
        lista.add(new Carta("Pachycephalosaurus", 1.8f, 0.33f, 18, 6, 40, 7));
        lista.add(new Carta("Estegossauro", 4, 4, 25, 2, 15, 8));


        return lista;
        //lista.add(new Carta("Tetanurae", 5, 6, 30, 7, 50));

    }
    public void criarJogador(){

        Jogador jogador1 = new Jogador("Danilo", cartasJogador1, 0);
        Jogador jogador2 = new Jogador("app", cartasJogador2, 0);

    }
    public void sortearCartas(){

        for (int i = 0; i < 4; i++){



            int sorteio = new Random().nextInt(lista.size());

            switch (sorteio){
                case 0: cartasJogador1.add(lista.get(0));
                    lista.remove(0);

                    break;
                case 1: cartasJogador1.add(lista.get(1));
                    lista.remove(1);
                    break;
                case 2: cartasJogador1.add(lista.get(2));
                    lista.remove(2);
                    break;
                case 3: cartasJogador1.add(lista.get(3));
                    lista.remove(3);
                    break;
                case 4: cartasJogador1.add(lista.get(4));
                    lista.remove(4);
                    break;
                case 5: cartasJogador1.add(lista.get(5));
                    lista.remove(5);
                    break;
                case 6: cartasJogador1.add(lista.get(6));
                    lista.remove(6);
                    break;
                case 7: cartasJogador1.add(lista.get(7));
                    lista.remove(7);
                    break;

            }

        }

        cartasJogador2 = lista;
    }

}