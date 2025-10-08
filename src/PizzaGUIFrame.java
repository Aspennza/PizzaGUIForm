import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
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

    GridBagConstraints gbc = new GridBagConstraints();

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

        createCrustPnl();

        setSize(screenWidth * 3/4, screenHeight * 3/4);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Pizza Order Form");
        setVisible(true);
    }

    private void createCrustPnl()
    {
        crustPnl = new JPanel();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        //may need to add a fill constraint

        crustPnl.setLayout(new GridLayout(3, 1));
        crustPnl.setBorder(new TitledBorder(new EtchedBorder(), "Crust Type"));

        thinRB = new JRadioButton("Thin");
        regularRB = new JRadioButton("Regular");
        deepDishRB = new JRadioButton("Deep Dish");

        crustPnl.add(thinRB);
        crustPnl.add(regularRB);
        crustPnl.add(deepDishRB);

        regularRB.setSelected(true);

        ButtonGroup group = new ButtonGroup();
        group.add(thinRB);
        group.add(regularRB);
        group.add(deepDishRB);

        mainPnl.add(crustPnl, gbc);
    }
}
