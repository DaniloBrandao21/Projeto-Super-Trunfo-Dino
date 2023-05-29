package brandao.android.supertrunfodino.Model;

import java.io.Serializable;

public class Carta implements Serializable {

    public String nome;
    public float tamanho;
    public float peso;
    public float longevidade;
    public float agressividade;
    public float velocidade;
    public float id;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getTamanho() {
        return tamanho;
    }

    public void setTamanho(float tamanho) {
        this.tamanho = tamanho;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getLongevidade() {
        return longevidade;
    }

    public void setLongevidade(float longevidade) {
        this.longevidade = longevidade;
    }

    public float getAgressividade() {
        return agressividade;
    }

    public void setAgressividade(float agressividade) {
        this.agressividade = agressividade;
    }

    public float getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(float velocidade) {
        this.velocidade = velocidade;
    }

    public float getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Carta(String nome, float tamanho, float peso, float longevidade, float agressividade, float velocidade, float id) {
        this.nome = nome;
        this.tamanho = tamanho;
        this.peso = peso;
        this.longevidade = longevidade;
        this.agressividade = agressividade;
        this.velocidade = velocidade;
        this.id = id;
    }
}
