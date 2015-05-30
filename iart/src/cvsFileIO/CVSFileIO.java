package cvsFileIO;

import static iart.MyNeuralNetwork.getInputLayerSize;
import static iart.MyNeuralNetwork.getOutputLayerSize;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.neuroph.core.data.DataSet;
import org.neuroph.core.data.DataSetRow;

public class CVSFileIO {

    private final String filePath;
    private final DataSet content;
    private final int numInputCols;
    private final int numOutputCols;
    private int numOfRows;

    public CVSFileIO(String filePath, int numInputCols, int numOutputCols) throws FileNotFoundException, IOException {

        this.filePath = filePath;
        this.numInputCols = numInputCols;
        this.numOutputCols = numOutputCols;

        content = new DataSet(numInputCols, numOutputCols);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;

            numOfRows = 0;

            while ((line = br.readLine()) != null) {

                String[] parts = line.split(";");
                String output = parts[parts.length - 1];

                double[] inputsDouble = new double[getInputLayerSize()];

                for (int i = 0; i < parts.length - 2; i++) {
                    inputsDouble[i] = Double.parseDouble(parts[i]);
                }

                double[] outputDouble = new double[getOutputLayerSize()];

                outputDouble[getOutputLayerSize() - 1] = Double.parseDouble(output);

                content.addRow(new DataSetRow(inputsDouble, outputDouble));

                numOfRows++;
            }
        }
    }

    public CVSFileIO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void printFile() {

        System.out.println(numOfRows);
        for (int i = 0; i < numOfRows; i++) {
            System.out.println(content.getRowAt(i));
        }
    }

    public String getFilePath() {
        return filePath;
    }

    public DataSet getContent() {
        return content;
    }

    public int getNumInputCols() {
        return numInputCols;
    }

    public int getNumOutputCols() {
        return numOutputCols;
    }

    public int getNumOfRows() {
        return numOfRows;
    }
}
