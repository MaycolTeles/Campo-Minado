package com.inatel.java.poo;

import java.util.Random;
import java.util.Scanner;

public class CampoMinado {

    // DECLARANDO OS ATRIBUTOS
    private int TAMANHO = 3;

    // Matriz preenchida com '-'.
    // Se a casa tiver sido visitada, será preenchida com 'X'
    // Se tiver bomba, a casa será 'B'.
    private char casas[][] = new char[TAMANHO][TAMANHO];  
    private boolean bomba = false;


    // DEFININDO OS MÉTODOS
    // Construtor
    public CampoMinado() {

        // PREENCHENDO A MATRIZ COM -
        preencherCampo();

        // PLANTANDO BOMBA ALEATÓRIAMENTE
        plantarBomba();
        
    }

    private void preencherCampo() {

        // PREENCHENDO A MATRIZ COM -
        for (int i = 0; i < TAMANHO; i++) {
            for (int j = 0; j < TAMANHO; j++) {
                casas[i][j] = '-';
            }
        }

    }


    private void plantarBomba() {
        Random rand = new Random();
        int x = rand.nextInt(TAMANHO + 1);
        int y = rand.nextInt(TAMANHO + 1);

        casas[x][y] = 'B';
    
    }


    private void mostrarCasasComBomba(){
        System.out.println("Campo:");
        System.out.println("-------------");

        for (int i = 0; i < TAMANHO; i++) {

            for (int j = 0; j < TAMANHO; j++) {
                System.out.print("| ");
                System.out.print(casas[i][j] + " ");
                
            }

            System.out.print("|");
            System.out.println();
        }

        System.out.println("-------------");
    }


    private void mostrarCasasSemBomba(){
        System.out.println("Campo:");
        System.out.println("-------------");

        for (int i = 0; i < TAMANHO; i++) {

            for (int j = 0; j < TAMANHO; j++) {
                System.out.print("| ");

                if (casas[i][j] == 'B')
                    System.out.print("- ");
                else
                    System.out.print(casas[i][j] + " ");
                    
                
            }

            System.out.print("|");
            System.out.println();
        }

        System.out.println("-------------");
    }


    private void definirCasa(int x, int y){
        if(casas[x][y] == '-')
            casas[x][y] = 'X';
    }


    private void acessarCasa(int x, int y) {

        if (casas[x][y] == 'B') {
            System.out.println("BOOOOOOOOOOMMMMMMMBBBBBBBAAAAAAAA!!!!!!!!");
            bomba = true;

        } else {
            System.out.println("Você se safou... Dessa vez...");
            System.out.println("Escolha mais uma casa para acessar...\n");

            definirCasa(x, y);
        }

        escolherCasa();

    }


    private void escolherCasa(){
        if(!bomba)
            mostrarCasasSemBomba();
        else
            mostrarCasasComBomba();

        Scanner teclado = new Scanner(System.in);

        System.out.print("Digite qual linha do Campo Minado você deseja acessar: ");
        int x = teclado.nextInt();

        if(x == -1)
            encerrarJogo();

        System.out.print("Agora, digite qual coluna do Campo Minado você deseja acessar: ");
        int y = teclado.nextInt();

        System.out.println("");

        if(y == -1)
            encerrarJogo();

        if(x >= 0 && x < TAMANHO && y >= 0 && y < TAMANHO)
            acessarCasa(x, y);
        else{
            System.out.println("Essa casa não existe no Campo Minado. Tente novamente...\n");
            escolherCasa();

        }

    }


    private void encerrarJogo(){
        System.out.println("Obrigado por jogar nosso Campo Minado!");
        System.exit(0);

    }


    public void jogar(){
        System.out.println("Seja bem vindo ao jogo Campo Minado!\n");
        System.out.println("Você deve percorrer o campo sem cair no espaço com uma BOOOOMBA\n");
        System.out.println("(Caso precise, digite -1 para sair do programa)\n");
        escolherCasa();
    }




    
}
