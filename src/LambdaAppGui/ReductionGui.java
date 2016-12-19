package LambdaAppGui;

import ApplicationModel.LambdaParser;
import LambdaTerm.LambdaAbstraction;
import LambdaTerm.Variable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by User on 19/12/2016.
 */
public class ReductionGui implements LambdaView {

    public static final String TITLE = "Lambda Application";
    public static final int HEIGHT = 300;
    public static final int WIDTH = 350;
    private final LambdaParser lambdaParser;

    public void display() {
        JFrame frame = new JFrame(TITLE);

        frame.setSize(WIDTH, HEIGHT);

        JPanel panel = new JPanel();

        JButton variableButton = new JButton("x");
        variableButton.addActionListener(e -> lambdaParser.parse(new Variable()));
        panel.add(variableButton);

        JButton lambdaAbstrButton = new JButton("\\");
        lambdaAbstrButton.addActionListener(e -> lambdaParser.parse(new LambdaAbstraction()));
        panel.add(lambdaAbstrButton);
        
        frame.getContentPane().add(panel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public ReductionGui(LambdaParser lambdaParser) {
        this.lambdaParser = lambdaParser;
    }
}
