import javax.swing.*;
import java.awt.*;

public class BreakfPanel extends JPanel {

    public static JButton biscuit, minis, ewgmuffin, burrito, bowl, muffins, bagels;

    public BreakfPanel(){
        setLayout(null);
        setBackground(new Color(47, 67, 154));

        biscuit = new JButton("Biscuit");
        minis = new JButton("Minis");
        ewgmuffin = new JButton("Egg White Grilled Muffin");
        burrito = new JButton("Burrito");
        bowl = new JButton("Bowl");
        muffins = new JButton("English Muffins");
        bagels = new JButton("Bagels");

        biscuit.setBounds(10, 10, 130, 130);
        minis.setBounds(150, 10, 130, 130);
        ewgmuffin.setBounds(290, 10, 130, 130);
        burrito.setBounds(10, 150, 130, 130);
        bowl.setBounds(150, 150, 130, 130);
        muffins.setBounds(10, 290, 130, 130);
        bagels.setBounds(150, 290, 130, 130);

        this.add(biscuit);
        this.add(minis);
        this.add(ewgmuffin);
        this.add(burrito);
        this.add(bowl);
        this.add(muffins);
        this.add(bagels);

    }
}