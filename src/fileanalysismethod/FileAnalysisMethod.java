/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileanalysismethod;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Mercedes
 */
public class FileAnalysisMethod {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        try{
        fileAnalysis("demo.txt", "stats.txt");} //file to be read, file to be created to store statistics. 
        catch(IOException e){
            System.out.print("0");//returns 0 if exception caught. 
        }
    }
    /**
     * 
     * @param inputFileName //file to be read from. 
     * @param outputFileName //file to be created to store statistics. 
     * @return
     * @throws IOException if file cannot be found. 
     */
    public static int fileAnalysis (String inputFileName, String outputFileName) throws IOException {
      int sum = 0;
      int L = 0;
      int S = 0;
      boolean go = true;
      int count = 0;
      
      while(go){
      try{
      File file = new File(inputFileName); //Making sure file exsists.
      Scanner inputFile = new Scanner(file);
      go = false;
      }
      catch(IOException e){ //catching exception is file cannot be found. 
        System.out.println("Cannot open the file " +e.getMessage());
        go = false;
        }
         }


      File file = new File(inputFileName); 
      Scanner inputFile = new Scanner(file);//setting up file to be read. 
      
      while(inputFile.hasNext()){
          int number = inputFile.nextInt();//tracking the integers. 
          sum = sum + number; //tracking the sum of numbers. 
            if(number>L){//determining largest and smallest.
                L = number;
            }else if(number<L){
                S = number;
            }
          count++;//keeping count of how many integers in file. 
      }
      inputFile.close();//closeing file. 
      
      PrintWriter outputFile = new PrintWriter(outputFileName);// creating new file to write statistics. 
      
      outputFile.println("Numeric data file name: "+inputFileName);
      outputFile.println("Number of integers: " + count);
      outputFile.println("Total of all integers in file: " + sum);
      outputFile.println("The largest integer in set: "+L);
      outputFile.println("The smallest integer in set: "+S);
      
      outputFile.close();//closing file. 
    
      return sum ;

    }
    
}
