/*
    Kyle Williams - Advanced Java Programming
    Dr Dave Perkins
    Create a calculator
 */
package calculator3;

public class CalculatorTester {
    
    public static void main(String[] args)
    {
        // Calculator Tester
        Calculator calc = new Calculator();
        System.out.println("Test 1: Calculate 1+2");
        System.out.println("Result = "+calc.calculate(1+2));
        System.out.println(" ");
        
        System.out.println("Test 2: Calculate 1+2+3");
        System.out.println("Result = "+calc.calculate(1+2+3));
        System.out.println(" ");
        
        System.out.println("Test 3: Calculate 1+2*3");
        System.out.println("Result = "+calc.calculate((1+2)*3));
        System.out.println(" ");
        
        System.out.println("Test 4: Calculate 8/2");
        System.out.println("Result = "+calc.calculate(8/2));
        System.out.println(" ");
        
        System.out.println("Test 5: Calculate 4-2");
        System.out.println("Result = "+calc.calculate(4-2));
        System.out.println(" ");
        
        System.out.println("Test 6: Calculate -2+2");
        System.out.println("Result = "+calc.calculate(-2+2));
    }
}
