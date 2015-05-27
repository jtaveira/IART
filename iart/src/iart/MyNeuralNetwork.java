package iart;

import java.util.Arrays;
import org.neuroph.core.NeuralNetwork;
import org.neuroph.nnet.MultiLayerPerceptron;
import org.neuroph.core.data.DataSet;
import org.neuroph.core.data.DataSetRow;
import org.neuroph.util.TransferFunctionType;

public class MyNeuralNetwork {

    //Variables Initialization
    private static int inputLayerSize = 41;
    private static int hiddenLayerSize = 30;
    private static int outputLayerSize = 1;

    private static DataSet trainingSet;
    private static DataSet testingSet;
    private static MultiLayerPerceptron neuralNetwork;

    //Sets
    public static String setInputLayerSize(int size) {

        if (size <= 0) {
            return "Input Layer Size is invalid, must be a value bigger than 0";
        }

        inputLayerSize = size;
        return "Input Layer Size is now " + size + ".";
    }

    public static String setHiddenLayerSize(int size) {

        if (size <= 0) {
            return "Hidden Layer Size is invalid, must be a value bigger than 0";
        }

        hiddenLayerSize = size;
        return "Hidden Layer Size is now " + size + ".";
    }

    public static String setOutputLayerSize(int size) {

        if (size <= 0) {
            return "Output Layer Size is invalid, must be a value bigger than 0";
        }

        outputLayerSize = size;
        return "Output Layer Size is now " + size + ".";
    }

    public static void setTrainingSet(DataSet set) {
        trainingSet = set;
    }

    public static void setTestingSet(DataSet set) {
        testingSet = set;
    }

    //Gets
    public static int getInputLayerSize() {
        return inputLayerSize;
    }

    public static int getHiddenLayerSize() {
        return hiddenLayerSize;
    }

    public static int getOutputLayerSize() {
        return outputLayerSize;
    }

    public static DataSet getTrainingSet() {
        return trainingSet;
    }

    public static DataSet getTestingSet() {
        return testingSet;
    }

    //Functions
    public static void createNeuralNetwork() {
        neuralNetwork = new MultiLayerPerceptron(TransferFunctionType.SIGMOID, inputLayerSize, hiddenLayerSize, outputLayerSize);
    }

    public static void trainNeuralNetwork() {
        neuralNetwork.learn(trainingSet);
    }
    
    public static void testNeuralNetwork() {

        for (DataSetRow dataRow : testingSet.getRows()) {
            neuralNetwork.setInput(dataRow.getInput());
            neuralNetwork.calculate();
            double[] networkOutput = neuralNetwork.getOutput();
            System.out.print("Input: " + Arrays.toString(dataRow.getInput()));
            System.out.println(" Output: " + Arrays.toString(networkOutput));
        }
    }
    
    public static void saveNeuralNetwork() {
        neuralNetwork.save("neuralNetwork.nnet");
    }
    
    public static void loadNeuralNetwork() {
        neuralNetwork =  (MultiLayerPerceptron) NeuralNetwork.createFromFile("neuralNetwork.nnet");
    }
}
