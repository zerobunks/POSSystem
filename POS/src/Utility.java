import java.awt.*;
import javax.swing.*;

public class Utility extends JPanel{

    public static void addGBComponent(Container parent, Component comp, int x, int y, int w, int h)
    {
        addGBComponent(parent, comp, x, y, w, h, GridBagConstraints.BOTH, GridBagConstraints.CENTER, 1, 1, 0, 0, 0, 0);
    }

    public static void addGBComponent(Container parent, Component comp, int x, int y, int w, int h, int f, int a, double wx, double wy, int it, int il, int ib, int ir)
    {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = w;
        gbc.gridheight = h;
        gbc.weightx = wx;
        gbc.weighty = wy;
        gbc.fill = f;
        gbc.anchor = a;
        gbc.insets = new Insets(it, il, ib, ir);
        parent.add(comp, gbc);
    }
}
