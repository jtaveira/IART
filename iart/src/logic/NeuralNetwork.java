package logic;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import org.neuroph.core.data.DataSet;
import org.neuroph.core.data.DataSetRow;
import org.neuroph.nnet.MultiLayerPerceptron;
import org.neuroph.nnet.learning.BackPropagation;
import org.neuroph.util.TransferFunctionType;

public class NeuralNetwork {

    private int inputLayerSize;
    private int hiddenLayerSize;
    private int outputLayerSize;

    private final BackPropagation learning_rule;

    private DataSet trainingSet;
    private DataSet testingSet;
    private MultiLayerPerceptron neuralNetwork;

    public NeuralNetwork(int inputLayerSize, int hiddenLayerSize, int outputLayerSize) {

        this.inputLayerSize = inputLayerSize;
        this.hiddenLayerSize = hiddenLayerSize;
        this.outputLayerSize = outputLayerSize;

        this.neuralNetwork = new MultiLayerPerceptron(TransferFunctionType.SIGMOID, inputLayerSize, hiddenLayerSize, outputLayerSize);
        this.learning_rule = new BackPropagation();
    }

    public void setTrainingParameters(double maxError, double learningRate) {
        this.learning_rule.setMaxError(maxError);
        this.learning_rule.setLearningRate(learningRate);
        neuralNetwork.setLearningRule(this.learning_rule);
    }

    public void trainNetwork() {
        neuralNetwork.learn(trainingSet);
    }

    public void testNetwork() {
        
        //ArrayList<double[]> results = new ArrayList<>();
        
       

        for (DataSetRow dataRow : testingSet.getRows()) {
            neuralNetwork.setInput(dataRow.getInput());
            neuralNetwork.calculate();
            neuralNetwork.getLearningRule().getMaxError();
            
            //results.add(neuralNetwork.getOutput());
            
            double[ ] networkOutput = neuralNetwork.getOutput();
            System.out.print("Expected: " + Arrays.toString(dataRow.getDesiredOutput()));
            System.out.println(" Output: " + Arrays.toString(networkOutput));            
        }
    }
    
    

    public int getInputLayerSize() {
        return inputLayerSize;
    }

    public void setInputLayerSize(int inputLayerSize) {
        this.inputLayerSize = inputLayerSize;
    }

    public int getHiddenLayerSize() {
        return hiddenLayerSize;
    }

    public void setHiddenLayerSize(int hiddenLayerSize) {
        this.hiddenLayerSize = hiddenLayerSize;
    }

    public int getOutputLayerSize() {
        return outputLayerSize;
    }

    public void setOutputLayerSize(int outputLayerSize) {
        this.outputLayerSize = outputLayerSize;
    }

    public DataSet getTrainingSet() {
        return trainingSet;
    }

    public void setTrainingSet(DataSet trainingSet) {
        this.trainingSet = trainingSet;
    }

    public DataSet getTestingSet() {
        return testingSet;
    }

    public void setTestingSet(DataSet testingSet) {
        this.testingSet = testingSet;
    }

    public MultiLayerPerceptron getNeuralNetwork() {
        return neuralNetwork;
    }

    public void setNeuralNetwork(MultiLayerPerceptron neuralNetwork) {
        this.neuralNetwork = neuralNetwork;
    }
}
