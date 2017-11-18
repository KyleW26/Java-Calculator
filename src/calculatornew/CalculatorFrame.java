package calculatornew;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.*;
import javax.swing.text.DefaultEditorKit;

public class CalculatorFrame {

    public JFrame frame;
    public JPanel overallPanel, leftButtons, rightButtons, topButtons, centreButtons, allButtons;
    public JButton one, two, three, four, five, six, seven, eight, nine, zero, add, minus, plusMinus,
            divide, multiply, equals, dot, mc, mr, ms, mPlus, bs, ce, c, sqrRoot, percent, oneX;
    public JTextField resultsField;
    public static JMenuBar menuBar;
    public static JMenu edit, view, help;
    public static JMenuItem copy, paste, exit, standard, scientific, digitGrouping, helpItem, aboutCalc;
    public double memory, secondVal, firstVal, percentage, convertedStr;
    Calculator calc = new Calculator();

    public double conversion() {
        convertedStr = Double.parseDouble(resultsField.getText());
        return convertedStr;
    }

    public void createFrame() {

        ActionListener insert = new InsertActionListener();
        ActionListener operate = new OperatorActionListener();

        //Create the overall frame and name it
        frame = new JFrame();
        frame.setTitle("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Define my vars
        memory = 0.0;

        // Create my JMenu Edit Section      
        JMenuBar menuBar = new JMenuBar();
        edit = new JMenu("Edit");
        edit.setMnemonic(KeyEvent.VK_E);

        copy = new JMenuItem(new DefaultEditorKit.CopyAction());
        copy.setText("Copy");
        copy.setMnemonic(KeyEvent.VK_C);
        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));

        paste = new JMenuItem(new DefaultEditorKit.PasteAction());
        paste.setText("Paste");
        paste.setMnemonic(KeyEvent.VK_C);
        paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
        edit.add(copy);
        edit.add(paste);

        // Create my View JMenu Item
        view = new JMenu("View");

        standard = new JMenuItem("Standard");
        standard.setMnemonic(KeyEvent.VK_N);
        standard.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, ActionEvent.CTRL_MASK));

        scientific = new JMenuItem("Scientific");
        scientific.setMnemonic(KeyEvent.VK_E);
        scientific.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));

        digitGrouping = new JMenuItem("Digit Grouping");
        digitGrouping.setMnemonic(KeyEvent.VK_G);
        digitGrouping.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        digitGrouping.addActionListener((ActionEvent e) -> {
            NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
            String numberAsString = numberFormat.format(Double.parseDouble(resultsField.getText()));
            resultsField.setText(numberAsString);
        });

        // Create my Help menu
        help = new JMenu("Help");
        helpItem = new JMenuItem("Help Topics");
        helpItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_5, ActionEvent.ALT_MASK));
        helpItem.addActionListener((ActionEvent ev) -> {
            if (Desktop.isDesktopSupported()) {
                try {
                    File myFile;
                    myFile = new File("C:\\Users\\Kyle\\Documents\\Year 2\\ICP 2150 - Advanced Java Programming\\READMECALC.txt");
                    Desktop.getDesktop().open(myFile);
                } catch (IOException ex) {

                }
            }
        });

        aboutCalc = new JMenuItem("About Calculator");
        aboutCalc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_9, ActionEvent.ALT_MASK));
        aboutCalc.addActionListener((ActionEvent ev) -> {
            JOptionPane.showMessageDialog(null, "Kyles Calculator v1.6 " + "\n"
                    + "Stable Build", "About Kyles Calculator", JOptionPane.INFORMATION_MESSAGE);
        });

        help.add(helpItem);
        help.add(new JSeparator());
        help.add(aboutCalc);
        view.add(standard);
        view.add(scientific);
        view.add(new JSeparator());
        view.add(digitGrouping);
        menuBar.add(edit);
        menuBar.add(view);
        menuBar.add(help);
        frame.setJMenuBar(menuBar);

        //Create a panel which will house EVERYTHING in the project
        overallPanel = new JPanel();
        overallPanel.setLayout(new BorderLayout());
        overallPanel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
        frame.setContentPane(overallPanel);

        //Create a panel to house all of the buttons in the project
        allButtons = new JPanel();
        allButtons.setLayout(new BorderLayout());

        // Create and define the buttons, as well as setting the text colour
        one = new JButton("1");
        one.setForeground(Color.BLUE);
        two = new JButton("2");
        two.setForeground(Color.BLUE);
        three = new JButton("3");
        three.setForeground(Color.BLUE);
        four = new JButton("4");
        four.setForeground(Color.BLUE);
        five = new JButton("5");
        five.setForeground(Color.BLUE);
        six = new JButton("6");
        six.setForeground(Color.BLUE);
        seven = new JButton("7");
        seven.setForeground(Color.BLUE);
        eight = new JButton("8");
        eight.setForeground(Color.BLUE);
        nine = new JButton("9");
        nine.setForeground(Color.BLUE);
        zero = new JButton("0");
        zero.setForeground(Color.BLUE);
        add = new JButton("+");
        add.setForeground(Color.RED);
        minus = new JButton("-");
        minus.setForeground(Color.RED);
        plusMinus = new JButton("+/-");
        plusMinus.setForeground(Color.BLUE);
        divide = new JButton("/");
        divide.setForeground(Color.RED);
        multiply = new JButton("*");
        multiply.setForeground(Color.RED);
        dot = new JButton(".");
        dot.setForeground(Color.BLUE);

        // Create and insert my result text field
        resultsField = new JTextField("0", 23);
        resultsField.setHorizontalAlignment(SwingConstants.RIGHT);
        overallPanel.add(resultsField, BorderLayout.NORTH);

        // Create a panel to house the three buttons at the top of the calculator, underneath the results bar
        topButtons = new JPanel();
        topButtons.setLayout(new GridLayout(1, 3, 4, 4));
        topButtons.setBorder(BorderFactory.createEmptyBorder(0, 0, 4, 4));

        bs = new JButton("BS");
        bs.setForeground(Color.RED);
        bs.addActionListener((ActionEvent e) -> {
            resultsField.setText(resultsField.getText().substring(0, resultsField.getText().length() - 1));
        });

        ce = new JButton("CE");
        ce.setForeground(Color.red);
        ce.addActionListener((ActionEvent e) -> {
            calc.clearResult();
            resultsField.setText("");
        });

        c = new JButton("C");
        c.setForeground(Color.red);
        c.addActionListener((ActionEvent e) -> {
            resultsField.setText("");
        });

        topButtons.add(bs);
        topButtons.add(ce);
        topButtons.add(c);
        topButtons.setBorder(BorderFactory.createEmptyBorder(5, 60, 4, 0));
        allButtons.add(topButtons, BorderLayout.NORTH);

        // Add the left hand side buttons to the leftPanel
        leftButtons = new JPanel();
        leftButtons.setLayout(new GridLayout(4, 1, 4, 4));

        mc = new JButton("MC");
        mc.setForeground(Color.red);
        mc.addActionListener((ActionEvent e) -> {
            memory = 0.0;
            //resultsField.setText(String.format("%.2f", tempResult));
        });

        mr = new JButton("MR");
        mr.setForeground(Color.red);
        mr.addActionListener((ActionEvent e) -> {
            resultsField.setText(String.format("%.1f", memory));
        });

        ms = new JButton("MS");
        ms.setForeground(Color.red);
        ms.addActionListener((ActionEvent e) -> {
            memory = Double.parseDouble(resultsField.getText());
        });

        mPlus = new JButton("M+");
        mPlus.setForeground(Color.RED);
        mPlus.addActionListener((ActionEvent e) -> {
            memory = memory + Double.parseDouble(resultsField.getText());
        });

        leftButtons.add(mc);
        leftButtons.add(mr);
        leftButtons.add(ms);
        leftButtons.add(mPlus);

        allButtons.add(leftButtons, BorderLayout.WEST);

        // Create the centreButtons panel and add all of the standard buttons into it
        centreButtons = new JPanel();
        centreButtons.setLayout(new GridLayout(4, 4, 4, 4));
        centreButtons.setBorder(BorderFactory.createEmptyBorder(0, 4, 0, 4));
        centreButtons.add(seven);
        seven.addActionListener(insert);
        centreButtons.add(eight);
        eight.addActionListener(insert);
        centreButtons.add(nine);
        nine.addActionListener(insert);
        centreButtons.add(divide);
        divide.addActionListener(operate);

        centreButtons.add(four);
        four.addActionListener(insert);
        centreButtons.add(five);
        five.addActionListener(insert);
        centreButtons.add(six);
        six.addActionListener(insert);
        centreButtons.add(multiply);
        multiply.addActionListener(operate);

        centreButtons.add(one);
        one.addActionListener(insert);
        centreButtons.add(two);
        two.addActionListener(insert);
        centreButtons.add(three);
        three.addActionListener(insert);
        centreButtons.add(minus);
        minus.addActionListener(operate);

        centreButtons.add(zero);
        zero.addActionListener(insert);
        centreButtons.add(plusMinus);

        plusMinus.addActionListener((ActionEvent ev2) -> {
            Double plusMinusDouble = Double.parseDouble(resultsField.getText());
            plusMinusDouble = plusMinusDouble * -1;
            resultsField.setText(Double.toString(plusMinusDouble));
        });

        centreButtons.add(dot);
        dot.addActionListener(insert);
        centreButtons.add(add);
        add.addActionListener(operate);

        allButtons.add(centreButtons, BorderLayout.CENTER);

        // Create the right buttons panel and add in the extra functionality buttons
        rightButtons = new JPanel();
        rightButtons.setLayout(new GridLayout(4, 1, 4, 4));
        sqrRoot = new JButton("√");
        sqrRoot.setForeground(Color.BLUE);
        sqrRoot.addActionListener((ActionEvent e) -> {
            double tempResult = Math.sqrt(Double.parseDouble(resultsField.getText()));
            resultsField.setText(String.format("%.2f", tempResult));
        });
        percent = new JButton("%");
        percent.setForeground(Color.BLUE);
        percent.addActionListener((ActionEvent e) -> {
            firstVal = calc.getResult();
            secondVal = Double.parseDouble(resultsField.getText());
            secondVal = secondVal / 100;
            percentage = firstVal + (firstVal * secondVal);
            resultsField.setText(Double.toString(percentage));
        });

        oneX = new JButton("1/x");
        oneX.addActionListener(operate);
        oneX.setForeground(Color.BLUE);

        equals = new JButton("=");
        equals.addActionListener(operate);
        equals.setForeground(Color.RED);

        rightButtons.add(sqrRoot);
        rightButtons.add(percent);
        rightButtons.add(oneX);
        rightButtons.add(equals);
        allButtons.add(rightButtons, BorderLayout.EAST);

        // Add the panel which houses the button to the panel which houses everything and set the frame to visible
        overallPanel.add(allButtons, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);

    }

    /**
     * Action Listener to insert digits
     */
    public class InsertActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String input = e.getActionCommand();

            if (calc.getStart() == true) {
                resultsField.setText("");
                calc.setStart(false);
            }
            resultsField.setText(resultsField.getText() + input);
        }
    }

    public class OperatorActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            switch (command) {
                case "+":
                    calc.calculate(conversion());
                    calc.setLastOperator("+");
                    resultsField.setText("");
                    break;
                case "-":
                    calc.calculate(conversion());
                    calc.setLastOperator("-");
                    resultsField.setText("");
                    break;
                case "*":
                    calc.calculate(conversion());
                    calc.setLastOperator("*");
                    resultsField.setText("");
                    break;
                case "/":
                    calc.calculate(conversion());
                    calc.setLastOperator("/");
                    resultsField.setText("");
                    break;
                case "1/x":
                    calc.setLastOperator("1/x");
                    calc.calculate(conversion());
                    resultsField.setText("" + Double.toString(calc.getResult()));
                    break;
                case "=":
                    calc.calculate(conversion());
                    if (calc.getResult() % 1 == 0) {
                        resultsField.setText("" + (int) calc.getResult());
                    } else {
                        resultsField.setText(String.format("%.2f", calc.getResult()));
                    }
                    calc.clearResult();
                    break;
            }
        }

    }
}
