/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neuraltest;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcin
 */
public class NeuralTest {

    private Neuron inputNeuron;
    private Neuron outputNeuron;
    private float learningCoefficient = 0.001f;

    public static void main(String[] args) {
        new NeuralTest();
    }

    public NeuralTest() {
        createNetwork();
        //teachNetwork(input[], output[]). 
        //Values for teaching a NOT logic function
        teachNetwork(new float[]{1, 0, 1, 0, 1, 0}, new float[]{0, 1, 0, 1, 0, 1});
        checkNetwork();
    }

    public void createNetwork() {
        inputNeuron = new Neuron(null, null);
        outputNeuron = new Neuron(new LinearFunction(), new float[]{1, 1});
        outputNeuron.addNeuron(inputNeuron);
    }

    public void teachNetwork(float[] input, float[] output) {
        while (learningCoefficient >= 0.0001) {
            //Przejście po wszystkich wartościach
            for (int i = 0; i < input.length; i++) {
                
                inputNeuron.setInput(input[i]);
                outputNeuron.calculateValue();
                outputNeuron.recalculateWeights(learningCoefficient, input[i], output[i]);
                System.out.println("LC:" + learningCoefficient + " Weight" + outputNeuron.previousWeights.get(0));
                learningCoefficient -= 0.001;

            }

        }
    }

    public void checkNetwork() {
        float inputForChecking = 1f;
        System.out.println("Weight: " + outputNeuron.previousWeights.get(0));
            inputNeuron.setInput(inputForChecking);
            outputNeuron.calculateValue();
            System.out.println("Input:" + inputForChecking + " Value:" + outputNeuron.getValue());

    }
}
