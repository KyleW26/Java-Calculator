/*
    Kyle Williams - Advanced Java Programming
    Dr Dave Perkins
    Create a calculator
 */
package calculator3;

import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.*;
import javax.swing.text.DefaultEditorKit;

public class CalculatorFrame {

    public double result;
    public JFrame frame;
    public JPanel overallPanel, leftButtons, rightButtons, topButtons, centreButtons, allButtons;
    public JButton one, two, three, four, five, six, seven, eight, nine, zero, add, minus, plusMinus, divide, multiply, equals, dot,
            mc, mr, ms, mPlus, bs, ce, c, sqrRoot, percent, oneX;
    public JTextField resultsField;
    public boolean start, startPercent;
    public String lastCommand;
    public static JMenuBar menuBar;
    public static JMenu edit, view, help;
    public static JMenuItem copy, paste, exit, standard, scientific, digitGrouping, helpItem, aboutCalc;
    public double memory, secondVal, firstVal, percentage;
    private static DecimalFormat df2 = new DecimalFormat(".###");

    public void createFrame() {

        Calculator calcWorking = new Calculator();

        //Create the overall frame and name it
        frame = new JFrame();
        frame.setSize(350, 240);
        frame.setTitle("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set variables
        memory = 0.0;
        result = calcWorking.getResult();
        start = true;
        lastCommand = "=";

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
            String numberAsString = numberFormat.format(result);
            resultsField.setText(numberAsString);
        });

        // Create my Help menu
        help = new JMenu("Help");

        JFrame f2 = new JFrame();
        f2.setSize(230, 250);
        f2.setTitle("Basic Help");
        JPanel helpPanel = new JPanel();
        JLabel helpTitle = new JLabel("                         Basic Help                         ");
        JLabel backSpace = new JLabel("BS = BackSpace, Remove last digit");
        JLabel clearEntry = new JLabel("CE = Clear Entry, Clear to 0");
        JLabel clear = new JLabel("C = Clear, Clear display");
        JLabel memClear = new JLabel("MC = Memory Clear");
        JLabel memRecall = new JLabel("MR = Memory Recall");
        JLabel MemStore = new JLabel("MS = Memory Store");
        JLabel memPlus = new JLabel("M+ = Memory Plus");
        helpPanel.add(helpTitle);
        helpPanel.add(backSpace);
        helpPanel.add(clearEntry);
        helpPanel.add(clear);
        helpPanel.add(memClear);
        helpPanel.add(memRecall);
        helpPanel.add(MemStore);
        helpPanel.add(memPlus);
        f2.add(helpPanel);

        helpItem = new JMenuItem("Help Topics");
        helpItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_5, ActionEvent.ALT_MASK));
        helpItem.addActionListener((ActionEvent ev) -> {
            f2.setVisible(true);
        });

        aboutCalc = new JMenuItem("About Calculator");
        aboutCalc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_9, ActionEvent.ALT_MASK));
        aboutCalc.addActionListener((ActionEvent ev) -> {
            JOptionPane.showMessageDialog(null, "This calculator was created as part of my "
                    + "Advanced Java Programming Module in Bangor University.", "About my Calculator", JOptionPane.INFORMATION_MESSAGE);
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

        // Create both of my action listeners
        ActionListener insert = new InsertAction();
        ActionListener command = new CommandAction();

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
            result = 0;
            resultsField.setText(" ");
        });

        c = new JButton("C");
        c.setForeground(Color.red);
        c.addActionListener((ActionEvent e) -> {
            resultsField.setText(" ");
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
        mr.addActionListener((ActionEvent e)
                -> {
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
        addButton("7", insert);
        addButton("8", insert);
        addButton("9", insert);
        addButton3("/", command);

        addButton("4", insert);
        addButton("5", insert);
        addButton("6", insert);
        addButton3("*", command);

        addButton("1", insert);
        addButton("2", insert);
        addButton("3", insert);
        addButton3("-", command);

        addButton("0", insert);
        centreButtons.add(plusMinus);
        plusMinus.addActionListener((ActionEvent ev2) -> {
            double tempResult1 = result *= -1;
            resultsField.setText(String.format("%.2s", tempResult1));
        });
        addButton(".", insert);
        addButton3("+", command);
        allButtons.add(centreButtons, BorderLayout.CENTER);

        // Create the right buttons panel and add in the extra functionality buttons
        rightButtons = new JPanel();
        rightButtons.setLayout(new GridLayout(4, 1, 4, 4));
        sqrRoot = new JButton("√");
        sqrRoot.setForeground(Color.BLUE);
        sqrRoot.addActionListener((ActionEvent e) -> {
            double tempResult = Math.sqrt(result);
            resultsField.setText(String.format("%.2f", tempResult));
        });
        percent = new JButton("%");
        percent.setForeground(Color.BLUE);
        percent.addActionListener((ActionEvent e) -> {
            firstVal = result;
            secondVal = Double.parseDouble(resultsField.getText());

            // Add a percentage on
            percentage = firstVal + (firstVal * secondVal / 100);
            result = percentage;
            resultsField.setText(Double.toString(percentage));

            // Take away a percentage
            percentage = firstVal - (firstVal * secondVal / 100);
            result = percentage;
            resultsField.setText(Double.toString(percentage));

            // Multiply a percentage
            percentage = firstVal * (firstVal * secondVal / 100);
            result = percentage;
            resultsField.setText(Double.toString(percentage));

            // Divide a percentage
            percentage = firstVal / (firstVal * secondVal / 100);
            result = percentage;
            resultsField.setText(Double.toString(percentage));

            System.out.println(firstVal);
            System.out.println(secondVal);
            System.out.println(percentage);
        });

        oneX = new JButton("1/x");
        oneX.setForeground(Color.BLUE);
        oneX.addActionListener((ActionEvent e) -> {
            double number = result;
            double inverse = 1 / number;

            result = inverse;
            resultsField.setText(Double.toString(result));
        });

        equals = new JButton("=");
        equals.setForeground(Color.RED);
        rightButtons.add(sqrRoot);
        rightButtons.add(percent);
        rightButtons.add(oneX);
        addButton2("=", command);
        allButtons.add(rightButtons, BorderLayout.EAST);

        // Add the panel which houses the button to the panel which houses everything and set the frame to visible
        overallPanel.add(allButtons, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Adds a button to the centre panel.
     *
     * @param label the button label
     * @param listener the button listener
     */
    private void addButton(String label, ActionListener listener) {
        JButton button = new JButton(label);
        button.addActionListener(listener);
        button.setForeground(Color.BLUE);
        centreButtons.add(button);
    }

    private void addButton2(String label, ActionListener listener) {
        JButton button = new JButton(label);
        button.addActionListener(listener);
        button.setForeground(Color.RED);
        rightButtons.add(button);
    }

    private void addButton3(String label, ActionListener listener) {
        JButton button = new JButton(label);
        button.addActionListener(listener);
        button.setForeground(Color.RED);
        centreButtons.add(button);
    }

    /**
     * This action inserts the button action string to the end of the
     * resultField text.
     */
    private class InsertAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            String input = event.getActionCommand();
            if (start) {
                resultsField.setText("");
                start = false;
            }
            resultsField.setText(resultsField.getText() + input);
        }
    }

    /**
     * This action executes the command that the button action string denotes.
     */
    private class CommandAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            String command = event.getActionCommand();

            if (start) {
                if (command.equals("-")) {
                    resultsField.setText(command);
                    start = false;
                } else {
                    lastCommand = command;
                }
            } else {
                calculate(Double.parseDouble(resultsField.getText()));
                lastCommand = command;
                start = true;
            }
        }
    }

    /**
     * Carries out the pending calculation.
     *
     * @param x the value to be accumulated with the prior result.
     */
    public void calculate(double x) {
        switch (lastCommand) {
            case "+":
                result += x;
                break;
            case "-":
                result -= x;
                break;
            case "*":
                result *= x;
                break;
            case "/":
                result /= x;
                break;
            case "=":
                result = x;
                break;
            default:
                break;
        }
        resultsField.setText("" + result);
    }
}
