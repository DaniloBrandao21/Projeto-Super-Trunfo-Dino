package brandao.android.supertrunfodino.Activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;

import brandao.android.supertrunfodino.Helper.DbHelper;
import brandao.android.supertrunfodino.Helper.RecycleItemClickListener;
import brandao.android.supertrunfodino.Model.Carta;
import brandao.android.supertrunfodino.R;
import brandao.android.supertrunfodino.adaptador.Adapter;

public class MainActivity6 extends AppCompatActivity {

    private RecyclerView recyclerView;

    private ImageButton buttonVoltarCartas;
    private ArrayList<Carta> lista = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        recyclerView = findViewById(R.id.recyclerView);
        buttonVoltarCartas = findViewById(R.id.buttonVoltarCartas);


        //Adicionando evento de click no RecycleView

        recyclerView.addOnItemTouchListener(
                new RecycleItemClickListener(
                        getApplicationContext(),
                        recyclerView,
                        new RecycleItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {

                                //Recuperando o item clicado

                                Carta cartaSelecionada = lista.get(position);
                                Intent intent = new Intent(getApplicationContext(), MainActivity7.class);
                                intent.putExtra("cartaSelecionada", cartaSelecionada);

                                startActivity(intent);

                            }

                            @Override
                            public void onLongItemClick(View view, int position) {

                            }

                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            }
                        }
                )
        );

        DbHelper db = new DbHelper(getApplicationContext());

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

            lista.add(new Carta(nomeCarta, tamanho, peso, longevidade, agressividade, velocidade, id));

        }

        //configurar adapter
        Adapter adapter = new Adapter(lista);

        //Configurar recycleView


        //LayoutManager

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);

        buttonVoltarCartas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

    }
}