/*
    Kyle Williams - Advanced Java Programming
    Dr Dave Perkins
    Create a calculator
 */
package calculatornew;

public class CalculatorTester {

    public static void main(String[] args) {
        // Calculator Tester
        Calculator calc = new Calculator();
        Calculator calc2 = new Calculator();
        Calculator calc3 = new Calculator();
        Calculator calc4 = new Calculator();
        Calculator calc5 = new Calculator();
        Calculator calc6 = new Calculator();

        System.out.println("Test 1: Calculate 1+2");
        calc.calculate(1);
        calc.setLastOperator("+");
        calc.calculate(2);
        System.out.println("Result = " + calc.getResult());
        System.out.println(" ");

        System.out.println("Test 2: Calculate 1+2+3");
        calc2.calculate(1);
        calc2.setLastOperator("+");
        calc2.calculate(2);
        calc2.setLastOperator("+");
        calc2.calculate(3);
        System.out.println("Result = " + calc2.getResult());
        System.out.println(" ");

        System.out.println("Test 3: Calculate 1+2*3");
        calc3.calculate(1);
        calc3.setLastOperator("+");
        calc3.calculate(2);
        calc3.setLastOperator("*");
        calc3.calculate(3);
        System.out.println("Result = " + calc3.getResult());
        System.out.println(" ");

        System.out.println("Test 4: Calculate 8/2");
        calc4.calculate(8);
        calc4.setLastOperator("/");
        calc4.calculate(2);
        System.out.println("Result = " + calc4.getResult());
        System.out.println(" ");

        System.out.println("Test 5: Calculate 4-2");
        calc5.calculate(4);
        calc5.setLastOperator("-");
        calc5.calculate(2);
        System.out.println("Result = " + calc5.getResult());
        System.out.println(" ");

        System.out.println("Test 6: Calculate -2+2");
        calc6.calculate(-2);
        calc6.setLastOperator("+");
        calc6.calculate(2);
        System.out.println("Result = " + calc6.getResult());
    }
}
