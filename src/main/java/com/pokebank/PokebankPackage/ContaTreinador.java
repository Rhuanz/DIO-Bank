package com.pokebank.PokebankPackage;
/** Classe Conta de Treinador para projeto PokeBank
 * 
 * À fazeres:
 * Verificar encapsulamento (talvez dê pra esconder um pouco mais)
 * Refazer o método transferir (lembrar de setar o novo treinador no pokemon)
 */
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException; //Criar classe de Exception personalizada para o projeto

public class ContaTreinador {
    
    private Treinador treinador;
    private List<Pokemon> pokemons;

    
    //Construtor
    public ContaTreinador(Treinador treinador) {
        
        this.treinador = treinador;
        this.pokemons = new ArrayList<Pokemon>();
    }

    //Getters
    public String getTitular() {
        
        return this.treinador.getNome();
    }

    //Getters
    public String getID() {
        
        return this.treinador.getID();
    }

    //Função para retirada de pokemons por nome ou apelido
    public Pokemon retirar(String nome) {
        
        if(this.treinador.tamEquipe() > 6)
            throw new RuntimeErrorException(null, "Equipe já cheia");

        else{
            for (Pokemon i: pokemons) {
                if (i.getNome().compareTo(nome) == 0 || i.getApelido().compareTo(nome) == 0){
                    
                    pokemons.remove(i);
                    System.out.println("Operação bem sucedida");
                    return i;
                }
            }
            throw new RuntimeErrorException(null, "Pokemon não encontrado");
        }
    }

     //Função para retirada de pokemons por nome e level ou apelido e level
     public Pokemon retirar(String nome, int level) {
        
        if(this.treinador.tamEquipe() > 6)
            throw new RuntimeErrorException(null, "Equipe já cheia");

        else{
            for (Pokemon i: pokemons){
                if (i.getNome().compareTo(nome) == 0 && i.getLevel() == level ||
                    i.getApelido().compareTo(nome) == 0 && i.getLevel() == level) {
                    
                    pokemons.remove(i);
                    System.out.println("Operação bem sucedida");
                    return i;
                }
            }
            throw new RuntimeErrorException(null, "Pokemon não encontrado");
        }
    }

    //Função para deposito de pokemon
    public void depositar(Pokemon pokemon) {

        for (Pokemon i: this.treinador.getEquipe()){ //For para verificar a equipe atual do treinador

            if (i == pokemon) {
                
                for (Pokemon j: pokemons) {
                    
                    if (j.getApelido().compareTo(pokemon.getApelido()) == 0)
                        throw new RuntimeErrorException(null, "Pokemons devem ter apelidos diferentes");
                }
                
                pokemons.add(pokemon);
                this.treinador.getEquipe().remove(pokemon);
                System.out.println("Operação bem sucedida");
                break;
            }
        }
    }

    //Função para transferir pokemons
    public void transferir(String pokemon, PokeBank pokebank, String id) {

       pokebank.getTreinador(id).getConta().depositar(this.retirar(pokemon));

    }

    //Função para liberar pokemons capturados
    public void liberar(String nomePokemon) {
        
        for (Pokemon i: pokemons) {
            if(i.getApelido().compareTo(nomePokemon) == 0 || i.getNome().compareTo(nomePokemon) == 0) {
                pokemons.remove(i);
                System.out.println("O " + i.getApelido() + "foi libertado com sucesso!");
                break;
            }
        }
    } 
}
