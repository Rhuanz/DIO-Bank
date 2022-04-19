package com.pokebank.PokebankPackage;
/** Classe PokeBank para projeto PokeBank
 * 
 * À fazeres:
 * Verificar encapsulamento (talvez dê pra esconder um pouco mais)
 */
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

public class PokeBank {
    
    private String bankNome;
    private List<Treinador> treinadores;

    //Construtor
    public PokeBank(String nome){
        
        this.bankNome = nome;
        this.treinadores = new ArrayList<Treinador>();
    }

    //Getters
    protected String getNomeProfessor(){                                       
        
        return this.bankNome;
    }

    //Getters
    protected Treinador getTreinador(String nome){
        for (Treinador i: treinadores){
            if (i.getNome().compareTo(nome) == 0 || i.getID().compareTo(nome) == 0)
                return i;
        }
        throw new RuntimeErrorException(null, "Treinador não encontrado");
    }

    //Função para listar os treinadors do banco
    public void listarTreinadores(){

        for (Treinador i: treinadores){ //percorrendo a lista de treinadores
            System.out.println(i.getNome() + " ID: " + i.getID()); //adicionando o nome dos treinadores à lista
        }
    }

    //Função para adicionar um novo treinador ao banco
    public void addTreinador(Treinador treinador){

        treinador.setBank(this.bankNome);
        treinadores.add(treinador);
    }



}
