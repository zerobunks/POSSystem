import javax.swing.*;
import java.awt.*;

public class BevPanel extends JPanel {

    public static JButton coke, dCoke, cokeZ, cokeC, sprite, drPepper, dietDrPepper, rootBeer, powerade, hiC, lemonade, dLemonade, teaS, teaU, icedCoffee;

    public BevPanel(){
        setLayout(null);
        setBackground(new Color(47, 67, 154));

        coke = new JButton("Coke");
        dCoke = new JButton("Diet Coke");
        cokeZ = new JButton("Coke Zero");
        cokeC = new JButton("Cherry Coke");
        sprite = new JButton("Sprite");
        drPepper = new JButton("Dr. Pepper");
        dietDrPepper = new JButton("Diet Dr. Pepper");
        rootBeer = new JButton("Root Beer");
        powerade = new JButton("Powerade");
        hiC = new JButton("Hi-C");
        lemonade = new JButton("Lemonade");
        dLemonade = new JButton("Diet Lemonade");
        teaS = new JButton("Sweet Tea");
        teaU = new JButton("Unsweet Tea");
        icedCoffee = new JButton("Iced Coffee");

        coke.setBounds(10, 10, 130, 130);
        dCoke.setBounds(150, 10, 130, 130);
        cokeZ.setBounds(290, 10, 130, 130);
        cokeC.setBounds(430, 10, 130, 130);
        sprite.setBounds(10, 150, 130, 130);
        drPepper.setBounds(150, 150, 130, 130);
        dietDrPepper.setBounds(290, 150, 130, 130);
        rootBeer.setBounds(430, 150, 130, 130);
        powerade.setBounds(10, 290, 130, 130);
        hiC.setBounds(150, 290, 130, 130);
        lemonade.setBounds(290, 290, 130, 130);
        dLemonade.setBounds(430, 290, 130, 130);
        teaS.setBounds(10, 430, 130, 130);
        teaU.setBounds(150, 430, 130, 130);
        icedCoffee.setBounds(290, 430, 130, 130);
        
        this.add(coke);
        this.add(dCoke);
        this.add(cokeZ);
        this.add(cokeC);
        this.add(sprite);
        this.add(drPepper);
        this.add(dietDrPepper);
        this.add(rootBeer);
        this.add(powerade);
        this.add(hiC);
        this.add(lemonade);
        this.add(dLemonade);
        this.add(teaS);
        this.add(teaU);
        this.add(icedCoffee);

    }
}