package cli;

import cvsFileIO.CVSFileIO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import logic.NeuralNetwork;
import org.neuroph.core.data.DataSet;

public class Cli {

    public enum FileType {

        TRAIN, TEST
    }

    private NeuralNetwork neuralNetwork;
    private CVSFileIO testFileIO;
    private CVSFileIO trainFileIO;

    public Cli() {
        this.neuralNetwork = null;
        this.testFileIO = null;
        this.trainFileIO = null;
    }

    //Functions
    private static void drawMainMenu() {
        System.out.println("Neural Network Main Menu");
        System.out.println("0 - Create Neural Network");
        System.out.println("1 - Define NN Training File");
        System.out.println("2 - Define NN Testing File");
        System.out.println("3 - Train Neural Network");
        System.out.println("4 - Test Neural Network");
        System.out.println("5 - Save Neural Network");
        System.out.println("6 - Load Neural Network");
        System.out.println("7 - Exit");
        System.out.print("Choose an option:");
    }

    private int menuInput() {
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    private double menuInputDouble() {
        Scanner in = new Scanner(System.in);
        return in.nextDouble();
    }

    private String menuInputString() {
        Scanner in = new Scanner(System.in);
        return in.next();
    }

    private void fileInput(FileType fType) throws IOException {

        System.out.print("Insert the desired path file:");

        String file = menuInputString();

        if (fType == FileType.TEST) {
            this.testFileIO = new CVSFileIO(file, neuralNetwork.getInputLayerSize(), neuralNetwork.getOutputLayerSize());
            neuralNetwork.setTestingSet(this.testFileIO.getContent());
        } else if (fType == FileType.TRAIN) {
            this.trainFileIO = new CVSFileIO(file, neuralNetwork.getInputLayerSize(), neuralNetwork.getOutputLayerSize());
            neuralNetwork.setTrainingSet(this.trainFileIO.getContent());
        }

        System.out.println("File inserted with success");
    }

    private void createNeuralNetwork() {

        System.out.print("Input Layer Size:");
        int inputLayerSize = menuInput();

        System.out.print("Hidden Layer Size:");
        int hiddenLayerSize = menuInput();

        System.out.print("Output Layer Size:");
        int outputLayerSize = menuInput();

        neuralNetwork = new NeuralNetwork(inputLayerSize, hiddenLayerSize, outputLayerSize);
        System.out.println("Neural Network created successfully.");
    }

    private void trainNetwork() {
        if (neuralNetwork != null) {
            System.out.println("Please enter training parameters");
            System.out.println("Max Error:");
            double maxError = menuInputDouble();
            System.out.println("Learning Rate:");
            double learningRate = menuInputDouble();
            neuralNetwork.setTrainingParameters(maxError, learningRate);
            neuralNetwork.trainNetwork();
        }
    }

    private void testNetwork() {
        if (neuralNetwork != null) {
            System.out.println("Network is being tested!");
            neuralNetwork.testNetwork();
            System.out.println("Finish Testing!");        
        }
    }

    public void Menu() throws IOException {

        int op = -1;

        while (op != 7) {

            drawMainMenu();

            op = menuInput();

            if (op == 0) {
                createNeuralNetwork();
            } else if (op == 1) {
                fileInput(FileType.TRAIN);
            } else if (op == 2) {
                fileInput(FileType.TEST);
            } else if (op == 3) {
                trainNetwork();
            } else if (op == 4) {
                testNetwork();
            } else if (op == 5) {
                /*
                 if (!hasCreatedNetwork) {
                 System.out.println("You must create a neural network before saving it.");
                 } else {
                 saveNeuralNetwork();
                 System.out.println("Neural Network saved successfully.");
                 }
                 */
            } else if (op == 6) {

            }
        }

        System.out.println("The program has ended.");
    }
}
