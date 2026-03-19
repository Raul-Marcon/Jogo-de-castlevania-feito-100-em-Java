/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mainjogo;

import java.util.Scanner;

import java.util.Random;

/**
 *
 * @author Barzotto Tecnologia
 */
public class MainJogo {

    public static void esperar(int ms){
        try{
            Thread.sleep(ms);
        }
        catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
    
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Random gerador = new Random();
        
        Dracula dracula = new Dracula();
        Trevor trevor = new Trevor();
        Esqueleto esqueleto = new Esqueleto();
        
        int opcao;
        System.out.println("Escolha a dificuldade desejada: ");
        System.out.println("Digite 1 para a dificuldade facil");
        System.out.println("Digite 2 para a dificuldade media");
        System.out.println("Digite 3 para a dificuldade impossivel");
        opcao = ler.nextInt();
        
        if(opcao == 1){
            dracula.setVida(150);
            dracula.setDano(30);
            
            trevor.setVida(120);
            trevor.setDano(30);
            trevor.setDanoChicote(40);
            
            esqueleto.setVida(70);
            esqueleto.setDano(5);
            System.out.println("Dificuldade facil selecionada!");
        }
        
        else if(opcao == 2){
            dracula.setVida(200);
            dracula.setDano(40);
            
            trevor.setVida(100);
            trevor.setDano(20);
            trevor.setDanoChicote(30);
            
            esqueleto.setVida(80);
            esqueleto.setDano(10);
            System.out.println("Dificuldade media selecionada!");
        }
        
        else if(opcao == 3){
            dracula.setVida(250);
            dracula.setDano(50);
            
            trevor.setVida(90);
            trevor.setDano(20);
            trevor.setDanoChicote(30);
            
            esqueleto.setVida(90);
            esqueleto.setDano(15);
            System.out.println("Deus tenha piedade de voce...");
        }
        
        else {
            System.out.println("Execute o jogo novamente e selecione uma opcao valida!");
            System.exit(0);
        }
            System.out.println("Voce chegou aos portoes de um imenso castelo antigo...");
            esperar(1000);
            System.out.println("Voce ouve um som de estranho vindo de dentro dos portoes...");
            esperar(1000);
            System.out.println("Um esqueleto vem correndo em sua direcao segurando uma foice velha! prepare-se para lutar!");
            esperar(1000);
            System.out.println("\n");
            
            while(esqueleto.getVida() > 0){
                String[] dialogos = {
                    "Espere so ate meus companheiros chegarem!",
                    "Voce e muito atrevido pra um humano!",
                    "Voce vai se arrepender de tentar perturbar o sono do conde Dracula!"
                };
                int indiceFrases = gerador.nextInt(dialogos.length);
                String fraseEsqueleto = dialogos[indiceFrases];
                System.out.println("Esqueleto: " + fraseEsqueleto);
                
                int opcaoAtaque;
                
                System.out.println("Para selecionar o machado digite 1: ");
                System.out.println("Para selecionar o chicote digite 2: ");
                System.out.println("Qual e a sua escolha?");
                opcaoAtaque = ler.nextInt();
                
                if(opcaoAtaque == 1){
                    int VidaAtualEsqueleto = esqueleto.getVida() - trevor.getDano();
                    int AtaqueEsqueleto = gerador.nextInt(3);
                    esqueleto.setVida(VidaAtualEsqueleto);
                    System.out.println("\n");
                    System.out.println("Esqueleto: " + fraseEsqueleto);
                    System.out.println("\n");
                    System.out.println("Voce deu um dano de " + trevor.getDano() + " ao esqueleto, a vida dele agora e: " + esqueleto.getVida());
                    if(AtaqueEsqueleto == 2){
                        int VidaAtualTrevor = trevor.getVida() - esqueleto.getDano();
                        trevor.setVida(VidaAtualTrevor);
                        System.out.println("Esqueleto: toma essa!");
                        System.out.println("Voce foi acertado pelo esqueleto! sua vida agora e de: " + trevor.getVida());
                    }
                }
                
                else if(opcaoAtaque == 2){
                    int VidaAtualEsqueleto = esqueleto.getVida() - trevor.getDanoChicote();
                    int AtaqueEsqueleto = gerador.nextInt(3);
                    esqueleto.setVida(VidaAtualEsqueleto);
                    System.out.println("\n");
                    System.out.println("Esqueleto: " + fraseEsqueleto);
                    System.out.println("\n");
                    System.out.println("Voce deu um dano de " + trevor.getDanoChicote() + " ao esqueleto, a vida dele agora e: " + esqueleto.getVida());
                    if(AtaqueEsqueleto == 2){
                        int VidaAtualTrevor = trevor.getVida() - esqueleto.getDano();
                        trevor.setVida(VidaAtualTrevor);
                        System.out.println("Voce foi acertado pelo esqueleto! sua vida agora e de: " + trevor.getVida());
                    }
                    else {
                        System.out.println("O esqueleto tentou acerta-lo mas errou!");
                    }

                }
                else {
                    System.out.println("Voce nao digitou uma opcao valida!");
                }
            }
            if(esqueleto.getVida() <= 0){
                System.out.println("\n");
                System.out.println("Voce derrotou o esqueleto...");
                esperar(3000);
                System.out.println("Voce encara seus ossos espalhados no chao, e entao entra no castelo...");
                esperar(3000);
                System.out.println("Tudo esta escuro, e de repente as portas se fecham bruscamente atras de voce!");
                esperar(3000);
                System.out.println("Todas as tochas nas paredes se acendem simultaneamente!");
                esperar(3000);
                System.out.println("Dracula: nao sei se isso e coragem, ou estupidez... mortal...");
                esperar(3000);
                System.out.println("O combate se inicia!");
                System.out.println("\n");
                while(dracula.getVida() > 0){
                    if(trevor.getVida() <= 0){
                        System.out.println("Trevor foi derrotado!");
                        System.out.println("Dracula: ate que foi divertido... eu diria...");
                        System.exit(0);
                    }
                    String[] dialogosDracula = {
                            "O que e um homem, trevor? uma pilha miseravel de segredos!",
                            "O homem e um monstro muito maior do que eu!",
                            "Sempre um Belmont... voce sera o ultimo que aparecera no meu caminho!",
                            "Ter vindo aqui vai ser a sua ultima decisao idiota!",
                            "Esse seu chicote e uma piada!",
                            "Voce sera o ultimo belmont a atrapalhar meu planos!"
                        };
                    int indiceDialogosDracula = gerador.nextInt(dialogosDracula.length);
                    String fraseDracula = dialogosDracula[indiceDialogosDracula];
                    System.out.println("Dracula: " + fraseDracula);
                    
                    int AtaqueEscolhido;
                    int CAD = gerador.nextInt(3);
                    System.out.println("Digite 1 para usar o machado");
                    System.out.println("Digite 2 para utilizar o chicote");
                    System.out.println("Digite 3 para usar uma pocao e curar 30 de vida");
                    System.out.println("\n");
                    AtaqueEscolhido = ler.nextInt();
                    
                    if(AtaqueEscolhido == 1){
                        int vidaAtualDracula = dracula.getVida() - trevor.getDano();
                        dracula.setVida(vidaAtualDracula);
                        System.out.println("Trevor usou o machado e " + dracula.getNome() + " sofreu um dano de " + trevor.getDano());
                        System.out.println("A vida atual de dracula e de: " + dracula.getVida());
                    }
                    else if(AtaqueEscolhido == 2){
                        int vidaAtualDracula = dracula.getVida() - trevor.getDanoChicote();
                        dracula.setVida(vidaAtualDracula);
                        System.out.println("Trevor usou o chicote e " + dracula.getNome() + " sofreu um dano de " + trevor.getDanoChicote());
                        System.out.println("A vida atual de dracula e de: " + dracula.getVida());
                    }
                    else if(AtaqueEscolhido == 3){
                        trevor.setVida(trevor.getVida() + 30);
                        System.out.println("Trevor utilizou uma pocao para se curar e sua vida agora e de: " + trevor.getVida());
                    }
                    else {
                        System.out.println("Voce nao digitou uma opcao valida! e dracula ainda tem chance de te atacar!");
                    }
                    if(CAD == 2){
                        if(trevor.getVida() < 0){
                            trevor.setVida(0);
                        }
                        int vidaAtualTrevor = trevor.getVida() - dracula.getDano();
                        trevor.setVida(vidaAtualTrevor);
                        
                        System.out.println(dracula.getNome() + " acertou um golpe em voce e deu " + dracula.getDano() + " de dano!");
                        System.out.println("Sua vida agora e de: " + trevor.getVida());
                    }
                    else {
                        System.out.println(dracula.getNome() + " tentou acerta-lo mas " + trevor.getNome() + " desviou!");
                    }
                }
            }
        else {
            System.out.println("Execute novamente e selecione uma opcao valida!");
        }
    }
}