package brandao.android.supertrunfodino.Model;

import java.util.ArrayList;

public class Jogador {

    private String nome;
    private ArrayList<Carta> cartasJogador = new ArrayList();
    private int vitorias;

    public Jogador(String nome, ArrayList<Carta> cartasJogador, int vitorias) {
        this.nome = nome;
        this.cartasJogador = cartasJogador;
        this.vitorias = vitorias;
    }
}
