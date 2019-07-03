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
public class Neuron {

    List<Neuron> previousNeurons;
    public List<Float> previousWeights;
    private float value;
    public Function function;

    public Neuron(Function funtion, float[] coefficients) {
        this.function = funtion;
        if (coefficients != null) {
            setFunctionCoefficients(coefficients);
        }
        previousNeurons = new ArrayList<>();
        previousWeights = new ArrayList<>();
    }

    public void addNeuron(Neuron n) {
        previousWeights.add(1f);
        previousNeurons.add(n);
    }

    public void calculateValue() {
        value = 0;
        for (int i = 0; i < previousWeights.size(); i++) {
            value += previousWeights.get(i) * previousNeurons.get(i).getValue();
        }
        value *= function.getFunctionValue(value);
    }

    public float getValue() {
        return value;
    }

    public void setInput(float value) {
        this.value = value;
    }

    public void recalculateWeights(float lC, float in, float out) {
        if (out != value) {
            for (int i = 0; i < previousWeights.size(); i++) {
                previousWeights.set(i, lC * (out - value) * previousNeurons.get(i).getValue());
            }
        }
    }

    private void setFunctionCoefficients(float[] coefficients) {
        for (float c : coefficients) {
            function.addCoefficient(c);
        }
    }
}
