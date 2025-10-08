import javax.swing.*;
import javax.tools.Tool;
import java.awt.*;

public class PizzaGUIFrame extends javax.swing.JFrame
{
    JPanel mainPnl;
    JPanel crustPnl;
    JPanel sizePnl;
    JPanel toppingPnl;
    JPanel orderPnl;
    JPanel controlPnl;

    JRadioButton thinRB;
    JRadioButton regularRB;
    JRadioButton deepDishRB;

    JComboBox sizeCB;

    JCheckBox pepperoniCB;
    JCheckBox sausageCB;
    JCheckBox jalapenoCB;
    JCheckBox onionCB;
    JCheckBox pineappleCB;
    JCheckBox pepperCB;
    JCheckBox blackOliveCB;
    JCheckBox greenOliveCB;

    JTextArea orderTA;
    JScrollPane scroller;

    JButton orderBtn;
    JButton clearBtn;
    JButton quitBtn;

    public PizzaGUIFrame()
    {
        super("Pizza Order Form");

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;

        mainPnl = new JPanel();
        mainPnl.setLayout(new GridBagLayout());
        add(mainPnl);

        setSize(screenWidth * 3/4, screenHeight * 3/4);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Pizza Order Form");
        setVisible(true);
    }
}
