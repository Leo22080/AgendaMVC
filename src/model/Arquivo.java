package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Arquivo {
 //   private static final String Caminho = "base.txt";
    
    public static String Read(String caminho){
        String conteudo = "";
        try {
            FileReader arq = new FileReader(caminho);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha="";
            try {
                linha = lerArq.readLine();
                while(linha!=null){
                    conteudo += linha+"\n";
                    linha = lerArq.readLine();
                }
                arq.close();
                return conteudo;
            } catch (IOException ex) {
                System.out.println("Erro: Não foi possível ler o arquivo!");
                return "";
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Erro: Arquivo não encontrado!");
            return "";
        }
    }
    
    public static boolean Write(String Texto, String caminho){
        try {
            FileWriter arq = new FileWriter(caminho);
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.println(Texto);
            gravarArq.close();
            return true;
        }catch(IOException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public static boolean limpar(String caminho){
        try {
            Writer arq = new FileWriter(caminho);
            arq.write("");
            arq.flush();
            return true;
        }catch(IOException e){
            System.out.println(e.getMessage());
            return false;
        }
        
    }
}
