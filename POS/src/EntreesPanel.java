import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class EntreesPanel extends JPanel {

    public static JButton reg, spicy, nuggs, strips, grilled, griNugs, spicyGril, chickWrap, joeSpec;
//    public static JButton b1, b2, b3, b4, b5;

    public EntreesPanel(){

        setBackground(new Color(47, 67, 154));
        setLayout(null);

        reg = new JButton("Regular Sandwich");
        spicy = new JButton("Spicy Sandwich");
        nuggs = new JButton("Nuggets");
        strips = new JButton("Strips");
        grilled = new JButton("Grilled Sandwich");
        griNugs = new JButton("Grilled Nuggets");
        spicyGril = new JButton("Spicy Grilled Sandwich");
        chickWrap = new JButton("Wrap");
        joeSpec = new JButton("Joe Special");
//        b1 = new JButton("Button");
//        b2 = new JButton("Button");
//        b3 = new JButton("Button");
//        b4 = new JButton("Button");
//        b5 = new JButton("Button");


        reg.setBounds(10, 10, 130, 130);
        spicy.setBounds(150, 10, 130, 130);
        nuggs.setBounds(290, 10, 130, 130);
        strips.setBounds(430, 10, 130, 130);
        grilled.setBounds(10, 150, 130, 130);
        griNugs.setBounds(150, 150, 130, 130);
        spicyGril.setBounds(290, 150, 130, 130);
        chickWrap.setBounds(430, 150, 130, 130);
        joeSpec.setBounds(10, 290, 130, 130);
//        b1.setBounds(10, 430, 130, 130);
//        b2.setBounds(10, 570, 130, 130);
//        b3.setBounds(10, 710, 130, 130);
//        b4.setBounds(10, 850, 130, 130);
//        b5.setBounds(10, 990, 130, 130);


        for(JButton button : Arrays.asList(reg, spicy, nuggs, strips, grilled, griNugs, spicyGril, chickWrap, joeSpec)){
            this.add(button);
        }

    }
}