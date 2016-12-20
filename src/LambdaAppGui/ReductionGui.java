package LambdaAppGui;

import ApplicationModel.AbstractionToken;
import ApplicationModel.LambdaAppEngine;
import ApplicationModel.VariableToken;
import Util.StringResource;

import javax.swing.*;

public class ReductionGui implements LambdaView {

    private static final int HEIGHT = 300;
    private static final int WIDTH = 350;
    private final LambdaAppEngine lambdaAppEngine;

    public void display() {
        JFrame frame = new JFrame(StringResource.APP_TITLE);

        frame.setSize(WIDTH, HEIGHT);

        JPanel panel = new JPanel();
        addButtons(panel, frame);

        JPanel textPanel = new JPanel();
        JTextField inputExpr = new JTextField("Input Expression goes here",
                20);
        textPanel.add(inputExpr);

        panel.add(textPanel);
        frame.getContentPane().add(panel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void addButtons(JPanel panel, JFrame frame) {
        JButton variableButton = new JButton(StringResource.VARIABLE);
        variableButton.addActionListener(e -> {
            String variable = getInputVariable("Please enter variable " +
                    "name", frame);
            if(variable.length() > 0){
                lambdaAppEngine.addInput(new VariableToken(variable));
            }
        });
        panel.add(variableButton);

        JButton lambdaAbstrButton = new JButton(StringResource.LAMBDA);
        lambdaAbstrButton.addActionListener(e -> {
            String variable = getInputVariable("Please enter variable name " +
                    "for the lambda abstraction.", frame);
            if(variable.length() > 0) {
                lambdaAppEngine.addInput(new AbstractionToken(variable));
            }
        });
        panel.add(lambdaAbstrButton);

        JButton backSpace = new JButton(StringResource.BACKSPACE);
        backSpace.addActionListener(e -> lambdaAppEngine.undoInput());
        panel.add(backSpace);
    }

    private String getInputVariable(String message, JFrame frame) {
        String title = "LambdaVariable Input";
        String result;
        do{
            result = JOptionPane.showInputDialog(frame, message, title,
                    JOptionPane.PLAIN_MESSAGE);
            //In case no input or an error occurs
        } while(result == null);

        return result;
    }

    public ReductionGui(LambdaAppEngine lambdaAppEngine) {
        this.lambdaAppEngine = lambdaAppEngine;
    }
}
