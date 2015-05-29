package cli;

import cvsFileIO.CVSFileIO;
import java.io.IOException;

public class Cli {
    
    public static void main(String[] args) throws IOException {
        
        CVSFileIO file = new CVSFileIO(args[0], 41, 1);
        
        file.printFile();     
        
    }
    
}
