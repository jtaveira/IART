package logic;

import java.util.Arrays;
import org.neuroph.core.data.DataSet;
import org.neuroph.core.data.DataSetRow;
import org.neuroph.nnet.MultiLayerPerceptron;
import org.neuroph.nnet.learning.BackPropagation;
import org.neuroph.util.TransferFunctionType;

public class MyNeuralNetwork {

    private int inputLayerSize;
    private int hiddenLayerSize;
    private int outputLayerSize;

    private final BackPropagation learning_rule;

    private DataSet dataSet;
    private MultiLayerPerceptron neuralNetwork;

    public MyNeuralNetwork(int inputLayerSize, int hiddenLayerSize, int outputLayerSize) {

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
        this.dataSet.shuffle();
    }

    public void trainNetwork() {
        
        DataSet[] trainingSet = dataSet.sample(70);
        neuralNetwork.learn(trainingSet[0]);
    }

    public void testNetwork() {

        DataSet[] testingSet = dataSet.sample(30);

        for (DataSetRow dataRow : testingSet[0].getRows()) {
            neuralNetwork.setInput(dataRow.getInput());
            neuralNetwork.calculate();
            System.out.println("Expected: " + Arrays.toString(dataRow.getDesiredOutput()) + " Output: " + Arrays.toString(neuralNetwork.getOutput()));
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

    public DataSet getDataSet() {
        return dataSet;
    }

    public void setDataSet(DataSet dataSet) {
        this.dataSet = dataSet;
    }

    public MultiLayerPerceptron getNeuralNetwork() {
        return neuralNetwork;
    }

    public void setNeuralNetwork(MultiLayerPerceptron neuralNetwork) {
        this.neuralNetwork = neuralNetwork;
    }
}
