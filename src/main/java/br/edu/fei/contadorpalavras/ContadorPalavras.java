/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.edu.fei.contadorpalavras;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author feispvisouza
 */
public class ContadorPalavras {
    
    public static void incrementaNoPar(String palavra, 
        ArrayList<ParDeValores> contador){ 
        
        for(ParDeValores <String, Integer> p : contador){
            if(palavra.equals(p.getChave())){
                Integer valorAntes = p.getValue();
                valorAntes++;
                p.setValue(valorAntes);
                return;
            }
        }
        contador.add(new ParDeValores(palavra, 1));
    }
    
    public static ParDeValores<String, Integer> parMax(ArrayList<ParDeValores> contador){
        ParDeValores<String, Integer> maisVezes = new ParDeValores("", -1);
        
        for(ParDeValores<String, Integer> pal: contador){
            Integer palWord = pal.getValue();
            if(palWord > maisVezes.getValue()){
                maisVezes = pal;
            }
        }
        return maisVezes;
    }

    public static void main(String[] args) {
        ArrayList<ParDeValores> contador = new ArrayList();
        
        String caminhoArquivo = "loren.txt";
        int quantidadePalavras = 0;
        
        

        try { 
            System.out.println(System.getProperty("user.dir"));
            FileReader fileReader = new FileReader(caminhoArquivo);
            BufferedReader br = new BufferedReader(fileReader);

            String linha;

            while ((linha = br.readLine()) != null) {

                // Remove espaços extras
                linha = linha.trim();

                if (!linha.isEmpty()) {
                    String[] palavras = linha.split(" ");
                    for(String p : palavras){
                        p = p.toLowerCase()
                                .replace(".", "")
                                .replace(",", "");
                        incrementaNoPar(p, contador);
                    }
                    quantidadePalavras += palavras.length;
                }
            }
            
            System.out.println(
                    "Quantidade de palavras: "
                    + quantidadePalavras
            );

            ParDeValores<String, Integer> palavraMax = parMax(contador);
            System.out.print("Palavra mais citada: ");
            System.out.println(palavraMax.toString());
            
            br.close();

        }catch(IOException e) {

            System.out.println(
                    "Erro ao ler o arquivo: "
                    + e.getMessage()
            );
        }
    }
}
