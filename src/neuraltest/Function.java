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
public abstract class Function {

    public List<Float> coefficients = new ArrayList<>();

    public void addCoefficient(float coefficient) {
        coefficients.add(coefficient);
    }

    public void clearCoefficients() {
        coefficients = new ArrayList<>();
    }

    public abstract float getFunctionValue(float x);

}
