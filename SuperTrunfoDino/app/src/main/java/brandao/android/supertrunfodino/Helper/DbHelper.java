package brandao.android.supertrunfodino.Helper;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    public static int VERSION = 7;
    public static String NOME_DB = "DB_TRUNFODINO";
    public static String TABELA_CARTAS = "cartas";
    public static String TABELA_CARTAS_JOGADOR1 = "cartas_jogador1";
    public static String TABELA_CARTAS_JOGADOR2 = "cartas_jogador2";

    public DbHelper(@Nullable Context context) {
        super(context, NOME_DB, null, VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //Criando tabelas
        String sql = "CREATE TABLE IF NOT EXISTS " + TABELA_CARTAS
                + "(nome TEXT NOT NULL, "
                + "tamanho FLOAT NOT NULL," +
                "peso FLOAT NOT NULL, " +
                "longevidade FLOAT NOT NULL," +
                "agressividade FLOAT NOT NULL," +
                "velocidade FLOAT NOT NULL, " +
                "id FLOAT NOT NULL);";

        String sqlcartasjogador1= "CREATE TABLE IF NOT EXISTS " + TABELA_CARTAS_JOGADOR1 +
                "(nome TEXT NOT NULL," +
                "tamanho FLOAT NOT NULL," +
                "peso FLOAT NOT NULL," +
                "longevidade FLOAT NOT NULL," +
                "agressividade FLOAT NOT NULL," +
                "velocidade FLOAT NOT NULL, " +
                "id FLOAT NOT NULL);";

        String sqlcartasjogador2= "CREATE TABLE IF NOT EXISTS " + TABELA_CARTAS_JOGADOR2 +
                "(nome TEXT NOT NULL," +
                "tamanho FLOAT NOT NULL," +
                "peso FLOAT NOT NULL," +
                "longevidade FLOAT NOT NULL," +
                "agressividade FLOAT NOT NULL," +
                "velocidade FLOAT NOT NULL, " +
                "id FLOAT NOT NULL);";

        try {

            sqLiteDatabase.execSQL(sql);
            Log.i("INFO DB", "Sucesso ao criar a tabela");

            sqLiteDatabase.execSQL(sqlcartasjogador1);
            Log.i("INFO DB", "Sucesso ao criar a tabela Jogadores");

            sqLiteDatabase.execSQL(sqlcartasjogador2);
            Log.i("INFO DB", "Sucesso ao criar a tabela Jogadores2");


        }catch (Exception e){
            Log.i("INFO DB", "Erro ao criar a tabela" + e.getMessage());
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        String sqlremovertabela = "DROP TABLE IF EXISTS " + TABELA_CARTAS_JOGADOR1 + " ;";
        String sqlremovertabela2 = "DROP TABLE IF EXISTS " + TABELA_CARTAS_JOGADOR2 + " ;";
        String sqlremovertabela3 = "DROP TABLE IF EXISTS " + TABELA_CARTAS + " ;";


        try{

            sqLiteDatabase.execSQL(sqlremovertabela);
            Log.i("INFO DB", "Sucesso ao remover a tabela Jogador 1");

            sqLiteDatabase.execSQL(sqlremovertabela2);
            Log.i("INFO DB", "Sucesso ao remover a tabela Jogador 2");

            sqLiteDatabase.execSQL(sqlremovertabela3);
            Log.i("INFO DB", "Sucesso ao remover a tabela Jogador 3");

            onCreate(sqLiteDatabase);
            Log.i("INFO DB", "Sucesso ao criar as tabelas  novamente");


        }catch (Exception e){

            Log.i("INFO DB", "Erro ao deletar a tabela" + e.getMessage());

        }
    }
}
