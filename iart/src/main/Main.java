/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import cli.Cli;
import static cli.Cli.drawMainMenu;
import static iart.MainMenu.loadTestingFile;
import static iart.MainMenu.loadTrainingFile;
import static iart.MyNeuralNetwork.createNeuralNetwork;
import static iart.MyNeuralNetwork.loadNeuralNetwork;
import static iart.MyNeuralNetwork.saveNeuralNetwork;
import static iart.MyNeuralNetwork.setHiddenLayerSize;
import static iart.MyNeuralNetwork.setInputLayerSize;
import static iart.MyNeuralNetwork.setOutputLayerSize;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author RicardoJorge
 */
public class Main {

    public static void main(String[] args) throws IOException {

        Cli cli = new Cli();

        

        Cli.FileType f;
        
        

        /*
         CVSFileIO file = new CVSFileIO(args[0], 41, 1);
        
         NeuralNetwork n = new NeuralNetwork(41, 20, 1);
        
         n.setTrainingSet(file.getContent());
       
         n.setTrainingParameters(0.05, 0.02);
        
         System.out.println("::::::::::::::Learning Parameters::::::::::::::");
         System.out.println("Learning Rule: " + n.getNeuralNetwork().getLearningRule());
         System.out.println("Max Error: " + n.getNeuralNetwork().getLearningRule().getMaxError());
         System.out.println("Learning Rate: " + n.getNeuralNetwork().getLearningRule().getLearningRate());
         */
    }

}
