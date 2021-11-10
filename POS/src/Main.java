import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                Main app = new Main();
                app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                app.setVisible(true);
            }
        });
    }

    public Main(){
        initGUI();
    }

    private void initGUI(){
        //Setting the main frame's settings
       setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       setTitle("POS System");
       setIconImage(new ImageIcon("res/cfa-logo.png").getImage());
       setSize(1504, 1003);
       setResizable(false);
       setLayout(new GridBagLayout());
       setBackground(new Color(47, 67, 154));

       Panels panels = new Panels();
       BottomPanel bottomPanel = new BottomPanel();

       Utility.addGBComponent(this, panels, 0, 0, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.PAGE_START, 1, 0.9, 0,0,0,0);
//       Utility.addGBComponent(this, bottomPanel, 0, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.PAGE_END, 1, 0.1, 0, 0, 0, 0);
    }

}
