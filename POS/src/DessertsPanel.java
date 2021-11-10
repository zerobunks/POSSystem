import javax.swing.*;
import java.awt.*;

public class DessertsPanel extends JPanel {

    public static JButton brownie, cookie, chocM, vanillaM, strawberryM, cncM, idK, idC, idX;

    public DessertsPanel(){
        setLayout(null);
        setBackground(new Color(47, 67, 154));

        brownie = new JButton("Brownie");
        cookie = new JButton("Cookie");
        chocM = new JButton("Chocolate Milkshake");
        vanillaM = new JButton("Vanilla Milkshake");
        strawberryM = new JButton("Strawberry Milkshake");
        cncM = new JButton("Cookies-N-Cream Milkshake");
        idK = new JButton("Ice-Dream Kid's Cup");
        idC = new JButton("Ice-Dream Large Cup");
        idX = new JButton("Ice-Dream Xtra-Large Cup");

        brownie.setBounds(10, 10, 130, 130);
        cookie.setBounds(150, 10, 130, 130);
        chocM.setBounds(10, 150, 130, 130);
        vanillaM.setBounds(150, 150, 130, 130);
        strawberryM.setBounds(290, 150, 130, 130);
        cncM.setBounds(430, 150, 130, 130);
        idK.setBounds(10, 290, 130, 130);
        idC.setBounds(150, 290, 130, 130);
        idX.setBounds(290, 290, 130, 130);

        this.add(brownie);
        this.add(cookie);
        this.add(chocM);
        this.add(vanillaM);
        this.add(strawberryM);
        this.add(cncM);
        this.add(idK);
        this.add(idC);
        this.add(idX);
    }
}