import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class BottomPanel extends JPanel {

    public static JButton menu, status, POS, strMgt;

    public BottomPanel(){

        setLayout(new FlowLayout());
        setBackground(new Color(189, 191, 190));

        menu = new JButton("Menu");
        menu.setForeground(Color.ORANGE);

        status = new JButton("Status");
        status.setForeground(Color.WHITE);

        POS = new JButton("POS");
        POS.setForeground(Color.WHITE);

        strMgt = new JButton("Store Mgt.");
        strMgt.setForeground(Color.WHITE);

        for(JButton button : Arrays.asList(menu, status, POS, strMgt)){
            button.setBackground(new Color(122, 70, 153));
            this.add(button);
        }
    }
}
