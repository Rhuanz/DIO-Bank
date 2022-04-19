package com.pokebank.PokebankPackage;
/** Classe Treinador para projeto PokeBank
 * 
 * À fazeres:
 * Verificar encapsulamento (talvez dê pra esconder um pouco mais)
 * Verificar função Randon em Java para gerar Id automático ou colocar um contador universal para os treinadores
 */
import java.util.ArrayList;
import java.util.List;
//import java.util.random.*;

public class Treinador {
    
    private String nome;
    private String treinadorID;
    private String bankNome;
    private List<Pokemon> equipe;
    private ContaTreinador conta;
    private String senha;

    //Construtor
    public Treinador(String nome, String senha, Pokemon inicial){
        
        this.nome = nome;
        //this.treinadorID = Verificar biblioteca ramdom 
        this.senha = senha;
        this.conta = new ContaTreinador(this);
        this.equipe = new ArrayList<Pokemon>();

        inicial.setTreinador(this);

        this.equipe.add(inicial);
    }

    //Getters
    public String getNome(){

        return this.nome;
    }

    //Getters
    public String getID(){

        return this.treinadorID;
    }

    //Getters
    public ContaTreinador getConta(){
        
        return this.conta;
    }

    //Getters
    public String getBank(){

        return this.bankNome;
    }

    //Getters
    public List<Pokemon> getEquipe(){

        return this.equipe;
    }

    //Setters
    public void setConta(ContaTreinador conta){
        
        this.conta = conta;
    }

    //Setters
    public void setBank(String bank){
        
        this.bankNome = bank;
    }

    //Função para listar equipe atual
    public void listarEquipe(){
        
        for (Pokemon i: equipe){
            System.out.println(i.getApelido() +"\n" + i.getTreinador().getNome());
        }
    }

    //Retorna o tamanho da equipe
    public int tamEquipe(){
        
        return this.equipe.size();
    }

    //Verificar senha
    public boolean verificaSenha(String senha){
        
        if(this.senha.compareTo(senha) == 0)
            return true;
        else
            return false;
    }
    
    //Função para modificar senha
    public void setSenha(String novaSenha){
        
        if(novaSenha.length() >= 8){
            this.senha = novaSenha;
            System.out.println("Senha modificada com sucesso!");
        }
        else
            System.out.println("Digite uma senha com 8 dígitos ou mais"); //Mudar para exception
    }

}
