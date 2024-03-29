/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jogodavelha;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas
 */
public class Jogo {
    public int tabuleiro[][] = new int[3][3];
    public boolean ganhar = false;
    public boolean ganharO = false;
    public boolean vezx = true;
    public void jogar(){
        //preencher tabuleiro
        preenchertabuleiro(tabuleiro);
        Scanner input = new Scanner(System.in);
        while(this.ganhar==false && this.ganharO == false){
            //imprimir tabuleiro
            imprimirtabuleiro(tabuleiro);
            //pegar linha
            System.out.println("Digite a linha: ");
            int linha = input.nextInt();
            linha -=1;
            //pegar coluna
            System.out.println("Digite a coluna: ");
            int coluna = input.nextInt();
            coluna-=1;
            
            if(vezx ==  true ){
                if (tabuleiro[linha][coluna] == 0) {
                    tabuleiro[linha][coluna] = 1;
                    vezx = false;
                    
                }
                else{
                    System.out.println("Tentou colocar na casa ja selecionada tente denovo:");
                }
                
            }
            else{
                if (tabuleiro[linha][coluna] == 0) {
                    tabuleiro[linha][coluna] = 2;
                    vezx = true;
                    
                }
                else{
                    System.out.println("Tentou colocar na casa ja selecionada tente denovo:");
                }
            }
            checavictory(tabuleiro);
        }
        imprimirtabuleiro(tabuleiro);
        if(ganhar == true){
            System.out.println("\"Jogador X ganhou!\"");
        }
        if(ganharO == true){
            System.out.println("\"Jogador Y ganhou!\"");
        }
    }
    public void preenchertabuleiro(int[][] x){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                x[i][j] = 0;
            }
            
        }
    }
    public void imprimirtabuleiro(int[][] x){
        System.out.println("   1 2 3 ");
        System.out.println("  -------");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(j == 0){
                    System.out.print((i+1)+" |");
                }
                
                switch (x[i][j]) {
                    case 1:
                        System.out.print("x ");
                        break;
                    case 2:
                        System.out.print("o ");
                        break;
                    case 0:
                        System.out.print("-"+ " ");
                        break;
                }
                
                
                if(j == 2){
                    System.out.print("\n");
                }
            }
            
        }
        
    }
    public void checavictory(int[][] x){
       
       
       for (int i = 0; i < 3; i++) {
           int certosx = 0,certosO=0;
           for (int j = 0; j < 3; j++) {
               if(x[i][j] == 1){
                   certosx+=1;
               }
               if(x[i][j] == 2){
                   certosO+=1;
               }
           }
           if(certosx == 3){
               this.ganhar = true;
           }
           if(certosO == 3){
               this.ganharO = true;
           }
       }
       for (int i = 0; i < 3; i++) {
           int certosx = 0,certosO=0;
           for (int j = 0; j < 3; j++) {
               if(x[j][i] == 1){
                   certosx+=1;
               }
               if(x[j][i] == 2){
                   certosO+=1;
               }
           }
           if(certosx == 3){
               this.ganhar = true;
           }
           if(certosO == 3){
               this.ganharO = true;
           }
        }
        int certosx = 0,certosO=0;
        for (int i = 0; i < 3; i++) {
            if(x[i][i]== 1){
                certosx+=1;
            }
            if(x[i][i]== 2){
                certosO+=1;
            }
            if(certosx == 3){
               this.ganhar = true;
           }
           if(certosO == 3){
               this.ganharO = true;
           }
        }
        certosx = 0;
        certosO=0;
        for (int i = 0; i < 3; i++) {
            int j = 2;
            if(x[i][j]==1){
                certosx+=1;
            }
            if(x[i][j]==2){
                certosO+=1;
            }
            
        }
        if(certosx == 3){
               this.ganhar = true;
           }
           if(certosO == 3){
               this.ganharO = true;
           }
    }
}
