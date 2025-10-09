import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Creates an extension of the JFrame class called PizzaGUIFrame. Allows users to select from a variety
 * of crust styles, pizza sizes, and toppings and outputs their selections to the GUI.
 * @author Zoe Aspenns aspennza@mail.uc.edu
 */
public class PizzaGUIFrame extends javax.swing.JFrame
{
    //A JPanel containing all the other JPanels in the program
    JPanel mainPnl;

    //A JPanel containing radio buttons for selecting different pizza crusts
    JPanel crustPnl;

    //A JPanel containing a JComboBox for selecting pizza size
    JPanel sizePnl;

    //A JPanel containing JCheckBoxes for selecting toppings
    JPanel toppingPnl;

    //A JPanel with a JTextArea that outputs the final order total
    JPanel orderPnl;

    //A JPanel with buttons for controlling the application, like Order, Clear, and Quit
    JPanel controlPnl;

    //A JRadioButton representing thin crust pizza
    JRadioButton thinRB;

    //A JRadioButton representing regular crust pizza
    JRadioButton regularRB;

    //A JRadioButton representing deep dish pizza
    JRadioButton deepDishRB;

    //A ButtonGroup for grouping the JRadioButtons together
    ButtonGroup group = new ButtonGroup();

    //A JComboBox for containing different pizza size options
    JComboBox<String> sizeCB;

    //A JCheckBox representing pepperoni topping
    JCheckBox pepperoniCB;

    //A JCheckBox representing sausage topping
    JCheckBox sausageCB;

    //A JCheckBox representing jalapeno topping
    JCheckBox jalapenoCB;

    //A JCheckBox representing onion topping
    JCheckBox onionCB;

    //A JCheckBox representing pineapple topping
    JCheckBox pineappleCB;

    //A JCheckBox representing peppers as a topping
    JCheckBox pepperCB;

    //A JCheckBox representing black olive topping
    JCheckBox blackOliveCB;

    //A JCheckBox representing green olive topping
    JCheckBox greenOliveCB;

    //A JTextArea for displaying the customer's finished order total like a receipt
    JTextArea orderTA;

    //A JScrollPane for allowing orderTA to scroll
    JScrollPane scroller;

    //A JButton allowing users to view their finished order
    JButton orderBtn;

    //A JButton allowing users to clear the GUI and make a new pizza order
    JButton clearBtn;

    //A JButton allowing users to quit the program
    JButton quitBtn;

    //A custom Font for the control panel buttons
    Font buttonFont;

    //A boolean tracking whether the customer has ordered yet or not
    boolean ordered = false;

    //A GridBagConstraints object allowing each panel to be manually arranged in the main panel
    GridBagConstraints gbc = new GridBagConstraints();

    /**
     * This constructor determines the basic settings for PizzaGUIFrame and calls
     * all the methods that establish the individual panels in the frame.
     */
    public PizzaGUIFrame()
    {
        super("Pizza Order Form");

        //This Toolkit is used to find the screen size of the computer running the GUI
        Toolkit kit = Toolkit.getDefaultToolkit();

        //This Dimension stores the screen size
        Dimension screenSize = kit.getScreenSize();

        //This int stores the height of the screen
        int screenHeight = screenSize.height;

        //This int stores the width of the screen
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

    /**
     * This method establishes the crustPnl, its GridBagConstraints, and the radio buttons inside it.
     */
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

    /**
     * This method establishes the sizePnl, its GridBagConstraints, and the JComboBox options inside it.
     */
    private void createSizePnl()
    {
        sizePnl = new JPanel();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;

        sizePnl.setBorder(new CompoundBorder((new TitledBorder(new EtchedBorder(), "Pizza Size")), new EmptyBorder(10, 10, 10, 10)));

        sizeCB = new JComboBox<>();
        sizeCB.addItem("Small");
        sizeCB.addItem("Medium");
        sizeCB.addItem("Large");
        sizeCB.addItem("Super");

        sizePnl.add(sizeCB);
        mainPnl.add(sizePnl, gbc);
    }

    /**
     * This method establishes the toppingPnl, its GridBagConstraints, and the JCheckBoxes inside it.
     */
    private void createToppingPnl()
    {
        toppingPnl = new JPanel();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 2;
        gbc.fill = GridBagConstraints.BOTH;

        toppingPnl.setBorder(new CompoundBorder((new TitledBorder(new EtchedBorder(), "Toppings")), new EmptyBorder(10, 10, 10, 10)));
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

    /**
     * This method establishes the orderPnl, its GridBagConstraints, and the JTextArea and JScrollPanel inside it.
     */
    private void createOrderPnl()
    {
        orderPnl = new JPanel();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.gridheight = 2;
        gbc.fill = GridBagConstraints.BOTH;

        orderPnl.setBorder(new CompoundBorder((new TitledBorder(new EtchedBorder(), "Your Order")), new EmptyBorder(10, 10, 10, 10)));

        orderTA = new JTextArea(10, 50);
        orderTA.setEditable(false);
        scroller = new JScrollPane(orderTA);

        orderPnl.add(scroller);
        mainPnl.add(orderPnl, gbc);
    }

    /**
     * This method establishes the controlPnl, its GridBagConstraints, and the JButtons inside it.
     * It also sets the ActionListeners for the buttons, which control most of the functional code in the frame.
     */
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
            //This double stores the price associated with the chosen pizza size
            double sizePrice;

            //This double stores the price of the pizza size and its toppings
            double subTotalPrice;

            //This double stores the price of the tax on the pizza
            double taxPrice;

            //This double stores the price of the pizza plus tax
            double totalPrice;

            //This algorithm determines whether the customer has already ordered; if so, they must clear the GUI before ordering again
            if(ordered)
            {
                JOptionPane.showMessageDialog(null, "To create a new order, please press the Clear button.");
            } else {
                //This algorithm determines whether the user has selected any toppings; if so, the program calculates their total; if not, they are prompted to pick a topping
                if (pepperoniCB.isSelected() || sausageCB.isSelected() || jalapenoCB.isSelected() || onionCB.isSelected() || pineappleCB.isSelected() || pepperCB.isSelected() || blackOliveCB.isSelected() || greenOliveCB.isSelected()) {
                    ordered = true;

                    //This String stores the complete order that will be printed to the JTextArea
                    String result = "=========================================\n";

                    //This algorithm tests which crust type was selected and adds it to the result String
                    if (thinRB.isSelected()) {
                        result += "Thin Crust - ";
                    } else if (regularRB.isSelected()) {
                        result += "Regular Crust - ";
                    } else {
                        result += "Deep Dish Crust - ";
                    }

                    result += (String) sizeCB.getSelectedItem();

                    //This algorithm tests which pizza size was selected and tracks the associated price
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

                    //This algorithm tests if the pepperoni checkbox is selected, adds it to the results String, and increments the total price
                    if (pepperoniCB.isSelected()) {
                        result += "Pepperoni\t\t$1.00\n";
                        subTotalPrice++;
                    }

                    //This algorithm tests if the sausage checkbox is selected, adds it to the results String, and increments the total price
                    if (sausageCB.isSelected()) {
                        result += "Sausage\t\t$1.00\n";
                        subTotalPrice++;
                    }

                    //This algorithm tests if the jalapeno checkbox is selected, adds it to the results String, and increments the total price
                    if (jalapenoCB.isSelected()) {
                        result += "Jalapeno\t\t$1.00\n";
                        subTotalPrice++;
                    }

                    //This algorithm tests if the onion checkbox is selected, adds it to the results String, and increments the total price
                    if (onionCB.isSelected()) {
                        result += "Onion\t\t$1.00\n";
                        subTotalPrice++;
                    }

                    //This algorithm tests if the pineapple checkbox is selected, adds it to the results String, and increments the total price
                    if (pineappleCB.isSelected()) {
                        result += "Pineapple\t\t$1.00\n";
                        subTotalPrice++;
                    }

                    //This algorithm tests if the pepper checkbox is selected, adds it to the results String, and increments the total price
                    if (pepperCB.isSelected()) {
                        result += "Green Pepper\t\t$1.00\n";
                        subTotalPrice++;
                    }

                    //This algorithm tests if the black olive checkbox is selected, adds it to the results String, and increments the total price
                    if (blackOliveCB.isSelected()) {
                        result += "Black Olive\t\t$1.00\n";
                        subTotalPrice++;
                    }

                    //This algorithm tests if the green olive checkbox is selected, adds it to the results String, and increments the total price
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
        //This ActionListener clears all the selections from the GUI
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
            //This int tracks whether the user confirmed or denied they wanted to quit the program
            int selection = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit?", "Quit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            //This algorithm determines whether to quit the program based on the user's input
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
