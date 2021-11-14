import java.util.Scanner;
import java.io.*;

class SymbolCounter {
    FileReader inputFile;
    String delimiter;
    String separatingSymbol;

    SymbolCounter(FileReader inputFile, String delimiter, String separatingSymbol){
        this.inputFile = inputFile;
        this.delimiter = delimiter;
        this.separatingSymbol = separatingSymbol;
    }

    private String countLine(String line) throws Exception{
        String result = "";
        line = line.replaceAll("/\\*.*\\*/", "");
        String[] words = line.split(this.delimiter);
        boolean parity = true;
        int symbolsAmount = 0;
        for(String word : words){
            if(parity)
                symbolsAmount = 0;
            symbolsAmount += (word.length() - word.replaceAll("\"\"", "").length())/2;
            word = word.replaceAll("\"\"", "");
            if((word.length() - word.replaceAll("\"", "").length())%2 != 0 )
                parity = !parity;
            word = word.replaceAll("\"", "");
            symbolsAmount += word.length();
            if(parity)
                result += symbolsAmount + this.separatingSymbol;
        }
        if(!parity)
            throw new Exception("Exception: odd number of quote marks");
        result = result.substring(0, result.length() - 1);
        return result;
    }

    String count() throws Exception{
        String line;
        String result = "";
        Scanner sc = new Scanner(this.inputFile);
        while (sc.hasNextLine()) {
            line = sc.nextLine();
            result = result+countLine(line)+"\n";
        }
        return result;
    }
}