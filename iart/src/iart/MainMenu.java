package iart;

import static iart.MyNeuralNetwork.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import org.neuroph.core.data.DataSet;
import org.neuroph.core.data.DataSetRow;

public class MainMenu {

    //Variables Initialization
    private static String trainFile = "";
    private static String testFile = "";
    private static boolean hasTrainFile = false;
    private static boolean hasTestFile = false;
    private static boolean hasCreatedNetwork = false;

    //Sets
    public static String setTrainFile(String file) {

        File f = new File(file);
        if (f.exists() && !f.isDirectory()) {

            trainFile = file;
            hasTrainFile = true;
            return "Training file is now " + file + ".";
        }

        return "That file does not exist.";
    }

    public static String setTestFile(String file) {

        File f = new File(file);
        if (f.exists() && !f.isDirectory()) {

            testFile = file;
            hasTestFile = true;
            return "Testing file is now " + file + ".";
        }

        return "That file does not exist.";
    }

    //Gets
    public static String getTrainFile() {
        if (hasTrainFile) {
            return trainFile;
        }
        return "Training File must be defined.";
    }

    public static String getTestFile() {
        if (hasTestFile) {
            return testFile;
        }
        return "Testing File must be defined.";
    }

    public static boolean getHasTrainFile() {
        return hasTrainFile;
    }

    public static boolean getHasTestFile() {
        return hasTestFile;
    }

    public static boolean getHasCreatedNetwork() {
        return hasCreatedNetwork;
    }

    //Functions
    public static void drawMainMenu() {
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

    public static void printFileInformation(String file) throws FileNotFoundException, IOException {

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    public static boolean loadTrainingFile() throws FileNotFoundException, IOException {
        if (hasTrainFile) {

            DataSet set = new DataSet(getInputLayerSize(), getOutputLayerSize());

            try (BufferedReader br = new BufferedReader(new FileReader(trainFile))) {
                String line;

                while ((line = br.readLine()) != null) {

                    String[] parts = line.split(";");
                    String output = parts[parts.length-1];

                    double[] inputsDouble = new double[getInputLayerSize()];
                    double[] outputDouble = new double[getOutputLayerSize()];
                    outputDouble[getOutputLayerSize()-1] = Double.parseDouble(output);
                    
                    for (int i = 0; i < parts.length-2; i++) {
                        inputsDouble[i] = Double.parseDouble(parts[i]);                      
                    }

                    set.addRow(new DataSetRow(inputsDouble, outputDouble));
                }
            }

            setTrainingSet(set);
            System.out.println("Neural Network has started learning!");
            trainNeuralNetwork();
            return true;
        }

        return false;
    }

    public static boolean loadTestingFile() throws FileNotFoundException, IOException {
        if (hasTestFile) {
            
            DataSet set = new DataSet(getInputLayerSize(), getOutputLayerSize());

            try (BufferedReader br = new BufferedReader(new FileReader(testFile))) {
                String line;

                while ((line = br.readLine()) != null) {

                    String[] parts = line.split(";");
                    String output = parts[parts.length-1];

                    double[] inputsDouble = new double[getInputLayerSize()];
                    double[] outputDouble = new double[getOutputLayerSize()];
                    outputDouble[getOutputLayerSize()-1] = Double.parseDouble(output);
                    
                    for (int i = 0; i < parts.length-2; i++) {
                        inputsDouble[i] = Double.parseDouble(parts[i]);                      
                    }

                    set.addRow(new DataSetRow(inputsDouble, outputDouble));
                }
            }

            setTestingSet(set);
            System.out.println("Neural Network has started testing!");
            testNeuralNetwork();   
            return true;
        }
        return false;
    }

    //Main Function
    public static void main(String[] args) throws IOException {

        int op = -1;

        while (op != 10) {
            drawMainMenu();

            Scanner in = new Scanner(System.in);
            op = in.nextInt();

            if (op == 0) {

                System.out.print("Insert the desired value:");

                Scanner in2 = new Scanner(System.in);
                int size = in2.nextInt();

                String temp = setInputLayerSize(size);
                System.out.println(temp);
            } else if (op == 1) {

                System.out.print("Insert the desired value:");

                Scanner in2 = new Scanner(System.in);
                int size = in2.nextInt();

                String temp = setHiddenLayerSize(size);
                System.out.println(temp);
            } else if (op == 2) {

                System.out.print("Insert the desired value:");

                Scanner in2 = new Scanner(System.in);
                int size = in2.nextInt();

                String temp = setOutputLayerSize(size);
                System.out.println(temp);
            } else if (op == 3) {

                System.out.print("Insert the desired path file:");

                Scanner in2 = new Scanner(System.in);
                String file = in2.next();

                String temp = setTrainFile(file);
                System.out.println(temp);
            } else if (op == 4) {

                System.out.print("Insert the desired path file:");

                Scanner in2 = new Scanner(System.in);
                String file = in2.next();

                String temp = setTestFile(file);
                System.out.println(temp);
            } else if (op == 5) {

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
