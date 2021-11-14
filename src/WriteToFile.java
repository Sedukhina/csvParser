import java.io.FileWriter;

public class WriteToFile {
    String pathToFile;

    WriteToFile(String file){
        this.pathToFile = file;
    }

    void flush(String result)throws Exception{
        FileWriter someFile = new FileWriter(this.pathToFile);
        someFile.write(result);
        someFile.flush();
        someFile.close();
    }
}
