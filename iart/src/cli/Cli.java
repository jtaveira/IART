package cli;

import static iart.MainMenu.loadTestingFile;
import static iart.MainMenu.loadTrainingFile;
import static iart.MainMenu.setTestFile;
import static iart.MainMenu.setTrainFile;
import cvsFileIO.CVSFileIO;
import static iart.MyNeuralNetwork.createNeuralNetwork;
import static iart.MyNeuralNetwork.loadNeuralNetwork;
import static iart.MyNeuralNetwork.saveNeuralNetwork;
import static iart.MyNeuralNetwork.setHiddenLayerSize;
import static iart.MyNeuralNetwork.setInputLayerSize;
import static iart.MyNeuralNetwork.setOutputLayerSize;
import java.io.IOException;
import java.util.Scanner;
import logic.NeuralNetwork;

public class Cli {

    public enum FileType {

        TRAIN, TEST
    }

    private NeuralNetwork neuralNetwork;
    private CVSFileIO testFileIO;
    private CVSFileIO trainFileIO;

    public Cli() {
        this.neuralNetwork = null;
        this.testFileIO = new CVSFileIO();
        this.trainFileIO = new CVSFileIO();
    }

    //Functions
    private static void drawMainMenu() {
        System.out.println("Neural Network Main Menu");
        System.out.println("0 - Modify Input Layer Size");
        System.out.println("1 - Modify Hidden Layer Size");
        System.out.println("2 - Modify Output Layer Size");
        System.out.println("3 - Define NN Training File");
        System.out.println("4 - Define NN Testing File");
        System.out.println("5 - Create Neural Network");
        System.out.println("6 - Train Neural Network");
        System.out.println("7 - Test Neural Network");
        System.out.println("8 - Save Neural Network");
        System.out.println("9 - Load Neural Network");
        System.out.println("10 - Exit");
        System.out.print("Choose an option:");
    }

    private void fileInput(FileType fType) {

        System.out.print("Insert the desired path file:");

        Scanner in = new Scanner(System.in);
        String file = in.next();

        if (fType == FileType.TEST) {
            setTrainFile(file);
        } else if (fType == FileType.TRAIN) {
            setTestFile(file);
        }

        System.out.print("File inserted with success");
    }

    private Boolean createNeuralNetwork(int inputLayerSize, int hiddenLayerSize, int outputLayerSize) {

        if (neuralNetwork == null) {
            neuralNetwork = new NeuralNetwork(inputLayerSize, hiddenLayerSize, outputLayerSize);
            System.out.println("Neural Network created successfully.");
            return true;
        } else {
            System.out.print("Neural Network already created!!");
            return false;
        }
    }

    private void changeInputLayerSize() {

        if (neuralNetwork != null) {

            System.out.print("Insert the desired value:");
            Scanner in = new Scanner(System.in);
            int size = in.nextInt();
            neuralNetwork.setInputLayerSize(size);

            System.out.print("Value changed with success!");
        } else {
            System.out.print("Neural Network Must be created First!!");
        }
    }

    private void changeHiddenLayerSize() {

        if (neuralNetwork != null) {

            System.out.print("Insert the desired value:");
            Scanner in = new Scanner(System.in);
            int size = in.nextInt();
            neuralNetwork.setHiddenLayerSize(size);

            System.out.print("Value changed with success!");
        } else {
            System.out.print("Neural Network Must be created First!!");
        }
    }

    private void changeOutputLayerSize() {

        if (neuralNetwork != null) {

            System.out.print("Insert the desired value:");
            Scanner in = new Scanner(System.in);
            int size = in.nextInt();
            neuralNetwork.setInputLayerSize(size);

            System.out.print("Value changed with success!");
        } else {
            System.out.print("Neural Network Must be created First!!");
        }
    }

    public void Menu() {

        int op = -1;

        while (op != 10) {
            drawMainMenu();

            Scanner in = new Scanner(System.in);
            op = in.nextInt();

            if (op == 0)
                changeInputLayerSize();
            else if (op == 1)
                changeHiddenLayerSize();
            else if (op == 2)
                changeOutputLayerSize();
            else if (op == 3)
                fileInput(Cli.FileType.TRAIN);
            else if (op == 4)
                fileInput(Cli.FileType.TEST);
            else if (op == 5) {

                createNeuralNetwork();
                hasCreatedNetwork = true;
                System.out.println("Neural Network created successfully.");
            } else if (op == 6) {

                if (!hasCreatedNetwork || !hasTrainFile) {
                    System.out.println("You must choose a training file and create a neural network before training it.");
                } else {
                    loadTrainingFile();
                }

            } else if (op == 7) {

                if (!hasCreatedNetwork || !hasTestFile) {
                    System.out.println("You must choose a testing file and create a neural network before training it.");
                } else {
                    loadTestingFile();
                }

            } else if (op == 8) {

                if (!hasCreatedNetwork) {
                    System.out.println("You must create a neural network before saving it.");
                } else {
                    saveNeuralNetwork();
                    System.out.println("Neural Network saved successfully.");
                }
            } else if (op == 9) {

                loadNeuralNetwork();
                System.out.println("Neural Network loaded successfully.");
            }
        }

        System.out.println("The program has ended.");
    }
}
