import java.util.Scanner;
import java.io.*;

public class Main {

    public static void main(String[] args){
        System.out.println("This is a program to count symbols in your file");
        Scanner in = new Scanner(System.in);
        System.out.print("Input output file directory: ");
        String fileDirectory = in.nextLine();
        System.out.print("Input delimiter ");
        String delimiter = in.nextLine();
        System.out.print("Input symbol to separate the result ");
        String separatingSymbol = in.nextLine();
        try {
            System.out.print("Input input file directory: ");
            FileReader inputFile = new FileReader(in.nextLine());
            SymbolCounter sc = new SymbolCounter(inputFile, delimiter, separatingSymbol);
            String result;
            result = sc.count();
            WriteToFile wtf = new WriteToFile(fileDirectory);
            wtf.flush(result);
            sc.inputFile.close();

        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

}


