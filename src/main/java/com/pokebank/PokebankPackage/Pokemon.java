package com.pokebank.PokebankPackage;
/** Classe Pokemon para projeto PokeBank
 * 
 * À fazeres:
 * Verificar encapsulamento (talvez dê pra esconder um pouco mais)
 */
public class Pokemon {

    private String nome;
    private String apelido;
    private String tipo;
    private Treinador treinador;
    private int level;

    //Construtor
    public Pokemon(String nome, String apelido){
        this.nome = nome;
        this.apelido = apelido;
    }

    //Construtor sobrecarregado
    public Pokemon(String nome){
        this.nome = nome;
        this.apelido = nome;
    }

    //Getters
    public String getNome(){
        return this.nome;
    }
    
    //Getters
    public String getApelido(){
        return this.apelido;
    }

    //Getters
    public String getTipo(){
        return this.tipo;
    }

    //Getters
    public int getLevel(){
        return this.level;
    }

    //Getters
    public Treinador getTreinador(){
        return this.treinador;
    }

    //Setters
    protected void setTreinador(Treinador treinador){

        this.treinador = treinador;
    }

}
