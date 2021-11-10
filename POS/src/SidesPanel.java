import javax.swing.*;
import java.awt.*;

public class SidesPanel extends JPanel {

    public static JButton fryS, fryM, fryL, macS, macM, macL, fruitS, fruitM, fruitL, kaleS, kaleL, chips;

    public SidesPanel(){
        setLayout(null);
        setBackground(new Color(47, 67, 154));

        fryS = new JButton("Small Fry");
        fryM = new JButton("Medium Fry");
        fryL = new JButton("Large Fry");
        macS = new JButton("Small Mac&Cheese");
        macM = new JButton("Medium Mac&Cheese");
        macL = new JButton("Large Mac&Cheese");
        fruitS = new JButton("Small Fruit");
        fruitM = new JButton("Medium Fruit");
        fruitL = new JButton("Large Fruit");
        kaleS = new JButton("Small Kale");
        kaleL = new JButton("Large Kale");
        chips = new JButton("Potato Chips");

        fryS.setBounds(10, 10, 130, 130);
        fryM.setBounds(150, 10, 130, 130);
        fryL.setBounds(290, 10, 130, 130);
        macS.setBounds(10, 150, 130, 130);
        macM.setBounds(150, 150, 130, 130);
        macL.setBounds(290, 150, 130, 130);
        fruitS.setBounds(10, 290, 130, 130);
        fruitM.setBounds(150, 290, 130, 130);
        fruitL.setBounds(290, 290, 130, 130);
        kaleS.setBounds(10, 430, 130, 130);
        kaleL.setBounds(150, 430, 130, 130);
        chips.setBounds(290, 430, 130, 130);

        this.add(fryS);
        this.add(fryM);
        this.add(fryL);
        this.add(macS);
        this.add(macM);
        this.add(macL);
        this.add(fruitS);
        this.add(fruitM);
        this.add(fruitL);
        this.add(kaleS);
        this.add(kaleL);
        this.add(chips);

    }
}