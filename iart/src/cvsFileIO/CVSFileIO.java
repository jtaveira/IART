package cvsFileIO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import org.neuroph.core.data.DataSet;

/**
 *
 * @author RicardoJorge
 */
public class CVSFileIO {

    private final String filePath;
    
    private DataSet content;

    public CVSFileIO(String filePath, int numInputCols, int numOutputCols) {
        this.filePath = filePath;
        
        this.content = new double[][][];
        
        
        
        
        
        
        
        
        
    }

    public DataSet parseFileToCSV(int numInputCols, int numOuputCols) {
        DataSet set = new DataSet(numInputCols, numOuputCols);

        return set;
    }

    public void printFile() throws IOException {

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {

                String[] parts = line.split(";");

                for (int i = 0; i < parts.length; i++) {
                    
                    System.out.print(parts[i]);
                    
                    if (i != parts.length - 1)                      
                        System.out.print(" - ");
                    else
                        System.out.println();              
                }
            }
        }
    }
}
