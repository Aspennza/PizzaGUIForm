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

    JComboBox<String> sizeCB;

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

        createSizePnl();

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

    private void createSizePnl()
    {
        sizePnl = new JPanel();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        //may need to add a fill constraint

        sizePnl.setBorder(new TitledBorder(new EtchedBorder(), "Pizza Size"));

        sizeCB = new JComboBox<>();
        sizeCB.addItem("Small - $8.00");
        sizeCB.addItem("Medium - $12.00");
        sizeCB.addItem("Large - $16.00");
        sizeCB.addItem("Super - $20.00");

        sizePnl.add(sizeCB);
        mainPnl.add(sizePnl, gbc);
    }
}
