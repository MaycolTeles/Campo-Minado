package com.inatel.java.poo;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException, IOException{

        // LIMPANDO O TERMINAL
        limparTerminal();
        

        CampoMinado campoMinado = new CampoMinado();

        campoMinado.jogar();

    }


    public final static void limparTerminal(){

        for(int i = 0; i < 10; i++){
            System.out.println("");
        }

        // CÓDIGO ABAIXO NÃO FUNCIONOU
        /*
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows"))
                Runtime.getRuntime().exec("cls");
            else
                Runtime.getRuntime().exec("clear");
        }
        catch (final Exception e){
            //  Handle any exceptions.

        }
        */
        
    }

}
