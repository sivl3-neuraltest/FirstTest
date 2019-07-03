/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neuraltest;

/**
 *
 * @author Marcin
 */
public class SigmoidFunction extends Function{
    
    @Override
    public float getFunctionValue(float x) {
        return (float) (1/(1+Math.pow((double)Math.E, (double)coefficients.get(0) * -1 * x)));
    }
    
}
