import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.tools.Tool;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Write javadoc
//do UML diagrams

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
    ButtonGroup group = new ButtonGroup();

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

    Font buttonFont;

    boolean ordered = false;

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

        mainPnl.setBackground(new Color(123, 0, 51));

        createCrustPnl();

        createSizePnl();

        createToppingPnl();

        createOrderPnl();

        createControlPnl();

        setSize(screenWidth /2, screenHeight /2);
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
        gbc.fill = GridBagConstraints.BOTH;

        crustPnl.setLayout(new GridLayout(3, 1));
        crustPnl.setBorder(new CompoundBorder((new TitledBorder(new EtchedBorder(), "Crust Type")), new EmptyBorder(10, 10, 10, 10)));

        thinRB = new JRadioButton("Thin");
        regularRB = new JRadioButton("Regular");
        deepDishRB = new JRadioButton("Deep Dish");

        crustPnl.add(thinRB);
        crustPnl.add(regularRB);
        crustPnl.add(deepDishRB);

        regularRB.setSelected(true);

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
        gbc.fill = GridBagConstraints.BOTH;

        sizePnl.setBorder(new CompoundBorder((new TitledBorder(new EtchedBorder(), "Pizza Size")), new EmptyBorder(10, 10, 10, 10))) ;

        sizeCB = new JComboBox<>();
        sizeCB.addItem("Small");
        sizeCB.addItem("Medium");
        sizeCB.addItem("Large");
        sizeCB.addItem("Super");

        sizePnl.add(sizeCB);
        mainPnl.add(sizePnl, gbc);
    }

    private void createToppingPnl()
    {
        toppingPnl = new JPanel();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 2;
        gbc.fill = GridBagConstraints.BOTH;

        toppingPnl.setBorder(new CompoundBorder((new TitledBorder(new EtchedBorder(), "Toppings")), new EmptyBorder(10, 10, 10, 10))) ;
        toppingPnl.setLayout(new GridLayout(4, 2));

        pepperoniCB = new JCheckBox("Pepperoni +$1.00");
        sausageCB = new JCheckBox("Sausage +$1.00");
        jalapenoCB = new JCheckBox("Jalapeno +$1.00");
        onionCB = new JCheckBox("Onion +$1.00");
        pineappleCB = new JCheckBox("Pineapple +$1.00");
        pepperCB = new JCheckBox("Green Pepper +$1.00");
        blackOliveCB = new JCheckBox("Black Olive +$1.00");
        greenOliveCB = new JCheckBox("Green Olive +$1.00");

        toppingPnl.add(pepperoniCB);
        toppingPnl.add(sausageCB);
        toppingPnl.add(jalapenoCB);
        toppingPnl.add(onionCB);
        toppingPnl.add(pineappleCB);
        toppingPnl.add(pepperCB);
        toppingPnl.add(blackOliveCB);
        toppingPnl.add(greenOliveCB);

        mainPnl.add(toppingPnl, gbc);
    }

    private void createOrderPnl()
    {
        orderPnl = new JPanel();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.gridheight = 2;
        gbc.fill = GridBagConstraints.BOTH;

        orderPnl.setBorder(new CompoundBorder((new TitledBorder(new EtchedBorder(), "Your Order")), new EmptyBorder(10, 10, 10, 10))) ;

        orderTA = new JTextArea(10, 50);
        orderTA.setEditable(false);
        scroller = new JScrollPane(orderTA);

        orderPnl.add(scroller);
        mainPnl.add(orderPnl, gbc);
    }

    private void createControlPnl()
    {
        controlPnl = new JPanel();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;

        controlPnl.setBorder(new CompoundBorder((new EtchedBorder()), new EmptyBorder(10, 10, 10, 10))) ;
        controlPnl.setLayout(new GridLayout(1, 3));

        orderBtn = new JButton("Order");
        clearBtn = new JButton("Clear");
        quitBtn = new JButton("Quit");

        buttonFont = new Font("SansSerif", Font.BOLD, 16);

        orderBtn.setFont(buttonFont);
        clearBtn.setFont(buttonFont);
        quitBtn.setFont(buttonFont);

        orderBtn.setBackground(new Color(74, 74, 74));
        clearBtn.setBackground(new Color(74, 74, 74));
        quitBtn.setBackground(new Color(74, 74, 74));
        orderBtn.setForeground(new Color(255, 255, 255));
        clearBtn.setForeground(new Color(255, 255, 255));
        quitBtn.setForeground(new Color(255, 255, 255));

        controlPnl.add(orderBtn);
        orderBtn.addActionListener((ActionEvent ae) ->
        {
            double sizePrice;
            double subTotalPrice;
            double taxPrice;
            double totalPrice;

            if(ordered)
            {
                JOptionPane.showMessageDialog(null, "To create a new order, please press the Clear button.");
            } else {
                if (pepperoniCB.isSelected() || sausageCB.isSelected() || jalapenoCB.isSelected() || onionCB.isSelected() || pineappleCB.isSelected() || pepperCB.isSelected() || blackOliveCB.isSelected() || greenOliveCB.isSelected()) {
                    ordered = true;

                    String result = "=========================================\n";

                    if (thinRB.isSelected()) {
                        result += "Thin Crust - ";
                    } else if (regularRB.isSelected()) {
                        result += "Regular Crust - ";
                    } else {
                        result += "Deep Dish Crust - ";
                    }

                    result += (String) sizeCB.getSelectedItem();

                    if (((String) sizeCB.getSelectedItem()).equals("Small")) {
                        sizePrice = 8.00;
                    } else if (((String) sizeCB.getSelectedItem()).equals("Medium")) {
                        sizePrice = 12.00;
                    } else if (((String) sizeCB.getSelectedItem()).equals("Large")) {
                        sizePrice = 16.00;
                    } else {
                        sizePrice = 20.00;
                    }
                    result += "\t$" + String.format("%.2f", sizePrice) + "\n";

                    subTotalPrice = sizePrice;

                    if (pepperoniCB.isSelected()) {
                        result += "Pepperoni\t\t$1.00\n";
                        subTotalPrice++;
                    }

                    if (sausageCB.isSelected()) {
                        result += "Sausage\t\t$1.00\n";
                        subTotalPrice++;
                    }

                    if (jalapenoCB.isSelected()) {
                        result += "Jalapeno\t\t$1.00\n";
                        subTotalPrice++;
                    }

                    if (onionCB.isSelected()) {
                        result += "Onion\t\t$1.00\n";
                        subTotalPrice++;
                    }

                    if (pineappleCB.isSelected()) {
                        result += "Pineapple\t\t$1.00\n";
                        subTotalPrice++;
                    }

                    if (pepperCB.isSelected()) {
                        result += "Green Pepper\t\t$1.00\n";
                        subTotalPrice++;
                    }

                    if (blackOliveCB.isSelected()) {
                        result += "Black Olive\t\t$1.00\n";
                        subTotalPrice++;
                    }

                    if (greenOliveCB.isSelected()) {
                        result += "Green Olive\t\t$1.00\n";
                        subTotalPrice++;
                    }

                    result += "\nSub-total:\t\t$" + String.format("%.2f", subTotalPrice);

                    taxPrice = (subTotalPrice * 0.07);

                    result += "\nTax:\t\t$" + String.format("%.2f", taxPrice);
                    result += "\n-----------------------------------------------------------------------\n";

                    totalPrice = subTotalPrice + taxPrice;

                    result += "Total:\t\t$" + String.format("%.2f", totalPrice);

                    result += "\n=========================================";

                    orderTA.setText(result);
                } else {
                    JOptionPane.showMessageDialog(null, "You must select at least one topping for your pizza before ordering.");
                }
            }
        });

        controlPnl.add(clearBtn);
        clearBtn.addActionListener((ActionEvent ae) ->
        {
            group.clearSelection();
            regularRB.setSelected(true);

            sizeCB.setSelectedIndex(0);

            pepperoniCB.setSelected(false);
            sausageCB.setSelected(false);
            jalapenoCB.setSelected(false);
            onionCB.setSelected(false);
            pineappleCB.setSelected(false);
            pepperCB.setSelected(false);
            blackOliveCB.setSelected(false);
            greenOliveCB.setSelected(false);

            orderTA.setText("");

            ordered = false;
        });

        controlPnl.add(quitBtn);
        quitBtn.addActionListener((ActionEvent ae) ->
        {
            int selection = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit?", "Quit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if(selection == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, "Quitting the program...");
                System.exit(0);
            } else
            {
                JOptionPane.showMessageDialog(null, "The program will remain open.");
            }
        });

        mainPnl.add(controlPnl, gbc);
    }
}
