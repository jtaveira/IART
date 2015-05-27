package iart;

import java.io.File;
import java.util.Scanner;

public class MainMenu {

    //Variables Initialization
    private static int inputLayerSize = 41;
    private static int hiddenLayerSize = 30;
    private static int outputLayerSize = 1;
    private static String trainFile = "";
    private static String testFile = "";
    private static boolean hasTrainFile = false;
    private static boolean hasTestFile = false;

    //Sets
    static String setInputLayerSize(int size) {

        if (size <= 0) {
            return "Input Layer Size is invalid, must be a value bigger than 0";
        }

        inputLayerSize = size;
        return "Input Layer Size is now " + size + ".";
    }

    static String setHiddenLayerSize(int size) {

        if (size <= 0) {
            return "Hidden Layer Size is invalid, must be a value bigger than 0";
        }

        hiddenLayerSize = size;
        return "Hidden Layer Size is now " + size + ".";
    }

    static String setOutputLayerSize(int size) {

        if (size <= 0) {
            return "Output Layer Size is invalid, must be a value bigger than 0";
        }

        outputLayerSize = size;
        return "Output Layer Size is now " + size + ".";
    }

    static String setTrainFile(String file) {

        File f = new File(file);
        if (f.exists() && !f.isDirectory()) {

            trainFile = file;
            hasTrainFile = true;
            return "Training file is now " + file + ".";
        }

        return "That file does not exist.";
    }

    static String setTestFile(String file) {

        File f = new File(file);
        if (f.exists() && !f.isDirectory()) {

            testFile = file;
            hasTestFile = true;
            return "Testing file is now " + file + ".";
        }

        return "That file does not exist.";
    }

    //Gets
    int getInputLayerSize() {
        return inputLayerSize;
    }

    int getHiddenLayerSize() {
        return hiddenLayerSize;
    }

    int getOutputLayerSize() {
        return outputLayerSize;
    }

    String getTrainFile() {
        if (hasTrainFile) {
            return trainFile;
        }
        return "Training File must be defined.";
    }

    String getTestFile() {
        if (hasTestFile) {
            return testFile;
        }
        return "Testing File must be defined.";
    }

    //Functions
    static void drawMainMenu() {
        System.out.println("Neural Network Main Menu");
        System.out.println("1-Modify Input Layer Size");
        System.out.println("2-Modify Hidden Layer Size");
        System.out.println("3-Modify Output Layer Size");
        System.out.println("4-Define NN Training File");
        System.out.println("5-Define NN Testing File");
        System.out.println("6-Create Neural Network");
        System.out.println("7-Train Neural Network");
        System.out.println("8-Test Neural Network");
        System.out.println("9-Exit");
    }

    boolean loadTrainingFile(String file) {
        if (hasTrainFile) {
            return true;
        }
        
        return false;
    }

    boolean loadTestFile(String file) {
        if (hasTestFile) {
            return true;
        }
        return false;
    }

    String createNeuralNetwork(){
        return "";
    }
    
    String trainNeuralNetwork() {
        return "";
    }

    String testNeuralNetwork() {
        return "";
    }

    //Main Function
    public static void main(String[] args) {

        int op = 0;

        while (op != 9) {
            drawMainMenu();

            Scanner in = new Scanner(System.in);
            op = in.nextInt();

            if (op == 1) {

                System.out.print("Insert the desired value:");

                Scanner in2 = new Scanner(System.in);
                int size = in2.nextInt();

                String temp = setInputLayerSize(size);
                System.out.println(temp);
            } 
            
            else if (op == 2) {

                System.out.print("Insert the desired value:");

                Scanner in2 = new Scanner(System.in);
                int size = in2.nextInt();

                String temp = setHiddenLayerSize(size);
                System.out.println(temp);
            } 
            
            else if (op == 3) {

                System.out.print("Insert the desired value:");

                Scanner in2 = new Scanner(System.in);
                int size = in2.nextInt();

                String temp = setOutputLayerSize(size);
                System.out.println(temp);
            } 
            
            else if (op == 4) {
                
                System.out.print("Insert the desired path file:");

                Scanner in2 = new Scanner(System.in);
                String file = in2.next();

                String temp = setTrainFile(file);
                System.out.println(temp);
            } 
            
            else if (op == 5) {
                
                System.out.print("Insert the desired path file:");

                Scanner in2 = new Scanner(System.in);
                String file = in2.next();

                String temp = setTestFile(file);
                System.out.println(temp);
            } 
            
            else if (op == 6) {

            } 
            
            else if (op == 7) {

            }
            
            else if (op == 8) {

            }
        }

        System.out.println("The program has ended.");
    }
}
