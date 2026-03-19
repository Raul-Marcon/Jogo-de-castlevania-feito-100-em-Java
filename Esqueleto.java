/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mainjogo;

import java.util.Random;

/**
 *
 * @author Barzotto Tecnologia
 */
public class Esqueleto {
    private String nome = "Esqueleto";
    private int vida;
    private int dano;
    Random gerador = new Random();
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setVida(int vida){
        this.vida = vida;
    }
    
    public void setDano(int dano){
        this.dano = dano;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public int getDano(){
        return this.dano;
    }
    
    public int getVida(){
        return this.vida;
    }
    
    public int getDanoAleatorio(){
        int danoAleatorio = gerador.nextInt(10);
        return danoAleatorio;
    }
}
