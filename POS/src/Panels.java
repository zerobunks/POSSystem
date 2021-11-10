import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

public class Panels extends JPanel {
    //Categories Panel
    private JButton entreesBtn, sidesBtn, bevBtn, dessertsBtn, breakfBtn;

    //Panels Panel
    private JPanel categoriesPanel, itemsPanel, totalPanel, functionalityPanel;

    //Items Panel
    private final CardLayout cardLayout = new CardLayout();

    //Total Panel
    public static JTextArea orderTextArea, subTotal, totalCost, guestInfo;
    static String prevItem;
    static double totalPrice, prevPrice;

    //Functionality Panel
    public static JButton tenderBtn, cancelItemBtn, cancelOrderBtn, guestDescBtn, lookUpBtn;
    public Stack<String> previous = new Stack<>();
    public List<OrderedItem> orderedItems = new ArrayList<>();
    int numOfSave = 1000;

    public Panels() {

        //Settings for the Panels())
        setLayout(new GridBagLayout());
        setBackground(new Color(47, 67, 154));

        //Importing the different panel classes
        categoriesPanel = CategoriesPanel();
        itemsPanel = ItemsPanel();
        totalPanel = TotalPanel();
        functionalityPanel = FunctionalityPanel();

        //Positioning the panels
        Utility.addGBComponent(this, categoriesPanel, 0, 0, 1, 5, GridBagConstraints.BOTH, GridBagConstraints.LINE_START, 0.1, 1, 0, 0, 0, 0);
        Utility.addGBComponent(this, itemsPanel, 1, 0, 1, 5, GridBagConstraints.BOTH, GridBagConstraints.LINE_START, 0.525, 1, 0, 0, 0, 0);
        Utility.addGBComponent(this, totalPanel, 2, 0, 1, 5, GridBagConstraints.BOTH, GridBagConstraints.LINE_START, 0.275, 1, 0, 0, 0, 0);
        Utility.addGBComponent(this, functionalityPanel, 3, 0, 1, 5, GridBagConstraints.BOTH, GridBagConstraints.LINE_START, 0.1, 1, 0, 0, 0, 0);

        //Initializing method
        btnClicked();
    }

    public JPanel CategoriesPanel() {

        JPanel categoriesPanel = new JPanel();
        categoriesPanel.setBackground(new Color(248, 241, 135));

        //This is for GridBagLayout. It gets the shape I want, but it's to big on the x-value.
        categoriesPanel.setLayout(new GridBagLayout());
        Dimension dim = new Dimension(15, 5);

        entreesBtn = new JButton("Entrees");
        entreesBtn.setPreferredSize(dim);

        sidesBtn = new JButton("Sides");
        sidesBtn.setPreferredSize(dim);

        bevBtn = new JButton("Beverages");
        bevBtn.setPreferredSize(dim);

        dessertsBtn = new JButton("Desserts");
        dessertsBtn.setPreferredSize(dim);

        breakfBtn = new JButton("Breakfast");
        breakfBtn.setPreferredSize(dim);


        Utility.addGBComponent(categoriesPanel, entreesBtn, 0, 0, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.PAGE_START, 1, 1, 5, 5, 5, 5);
        Utility.addGBComponent(categoriesPanel, sidesBtn, 0, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.PAGE_START, 1, 1, 5, 5, 5, 5);
        Utility.addGBComponent(categoriesPanel, bevBtn, 0, 2, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.PAGE_START, 1, 1, 5, 5, 5, 5);
        Utility.addGBComponent(categoriesPanel, dessertsBtn, 0, 3, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.PAGE_START, 1, 1, 5, 5, 5, 5);
        Utility.addGBComponent(categoriesPanel, breakfBtn, 0, 4, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.PAGE_START, 1, 1, 5, 5, 5, 5);

        return categoriesPanel;
    }

    public JPanel FunctionalityPanel() {
//        Setting Layout
        JPanel functionalityPanel = new JPanel();
        functionalityPanel.setLayout(new GridBagLayout());
        functionalityPanel.setBackground(new Color(30, 18, 56));

//        Creating variables that will hold the dimension values for the buttons
        Dimension dim = new Dimension(10, 5);

//        Initializing the buttons with their intended text.
        tenderBtn = new JButton("Tender");
        cancelItemBtn = new JButton("Cancel Item");
        cancelOrderBtn = new JButton("Cancel Order");
        guestDescBtn = new JButton("Guest Desc.");
        lookUpBtn = new JButton("Look Up");


//        Adding the dimensions for the buttons.
        tenderBtn.setPreferredSize(dim);
        cancelItemBtn.setPreferredSize(dim);
        cancelOrderBtn.setPreferredSize(dim);
        guestDescBtn.setPreferredSize(dim);
        lookUpBtn.setPreferredSize(dim);


//        Adding the buttons to the FunctionalityPanel.
        Utility.addGBComponent(functionalityPanel, tenderBtn, 0, 0, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.PAGE_START, 1, 1, 10, 5, 5, 5);
        Utility.addGBComponent(functionalityPanel, cancelItemBtn, 0, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.PAGE_START, 1, 1, 5, 5, 5, 5);
        Utility.addGBComponent(functionalityPanel, cancelOrderBtn, 0, 2, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.PAGE_START, 1, 1, 5, 5, 5, 5);
        Utility.addGBComponent(functionalityPanel, guestDescBtn, 0, 3, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.PAGE_START, 1, 1, 5, 5, 5, 5);
        Utility.addGBComponent(functionalityPanel, lookUpBtn, 0, 4, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.PAGE_START, 1, 1, 5, 5, 10, 5);


        return functionalityPanel;
    }

    public JPanel TotalPanel() {
        Font tFont = new Font("Courier", Font.PLAIN, 17);
        Font bFont = new Font("Courier", Font.PLAIN, 35);
        Font gFont = new Font("Courier", Font.PLAIN, 25);

        JPanel totalPanel = new JPanel();
        totalPanel.setLayout(null);
        totalPanel.setBackground((new Color(30, 18, 56)));

        //Guest Description text area
        guestInfo = new JTextArea(1, 1);
        guestInfo.setBackground(Color.LIGHT_GRAY);
        guestInfo.setEditable(false);
        guestInfo.setFont(gFont);

        //Text Area that shows the bill
        orderTextArea = new JTextArea(2, 1);
        orderTextArea.setFont(tFont);
        orderTextArea.setEditable(false);

        //Creating ScrollPane that holds the orderTextArea
        JScrollPane orderScroll = new JScrollPane(orderTextArea);
        orderScroll.setBackground(new Color(255, 255, 255));
        orderScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        //PricePanel contain the subTotal and totalCost
        JPanel pricePanel = new JPanel();
        pricePanel.setLayout(null);
        pricePanel.setBackground(Color.BLACK);

        //Sub total is the totalCost without tax
        subTotal = new JTextArea(1,1);
        subTotal.setBackground(new Color(0,0,0));
        subTotal.setEditable(false);
        subTotal.setFont(bFont);
        subTotal.setForeground(Color.YELLOW);

        //Totalcost includes tax
        totalCost = new JTextArea(1,1);
        totalCost.setBackground(new Color(0,0,0));
        totalCost.setEditable(false);
        totalCost.setFont(bFont);
        totalCost.setForeground(Color.WHITE);

        //Setting JTextArea Bounds
        guestInfo.setBounds(0, 0, 400, 40);
        orderScroll.setBounds(0, 40, 400, 760);
        pricePanel.setBounds(0, 800, 400, 240);
        subTotal.setBounds(0, 10, 400, 65);
        totalCost.setBounds(0, 75, 400, 65);

        //Adding the JTextAreas to their spots.
        pricePanel.add(subTotal);
        pricePanel.add(totalCost);
        totalPanel.add(guestInfo);
        totalPanel.add(orderScroll);
        totalPanel.add(pricePanel);

        return totalPanel;
    }

    public JPanel ItemsPanel() {
        itemsPanel = new JPanel();

        //CardLayout allows the totalCost of the panels with the click of the buttons
        itemsPanel.setLayout(cardLayout);
        itemsPanel.setBackground(new Color(47, 67, 154));

//        Initializing the panels that are used
        EntreesPanel entreesPanel = new EntreesPanel();
        SidesPanel sidesPanel = new SidesPanel();
        BevPanel bevPanel = new BevPanel();
        DessertsPanel dessertsPanel = new DessertsPanel();
        BreakfPanel breakfPanel = new BreakfPanel();

//        Adding the panels into the layered panel
        itemsPanel.add(entreesPanel, "Entrees");
        itemsPanel.add(sidesPanel, "Sides");
        itemsPanel.add(bevPanel, "Bev");
        itemsPanel.add(dessertsPanel, "Desserts");
        itemsPanel.add(breakfPanel, "Breakf");

//        Adding the action that allows the switch the of the panels
        entreesBtn.addActionListener(e -> cardLayout.show(itemsPanel, "Entrees"));
        sidesBtn.addActionListener(e -> cardLayout.show(itemsPanel, "Sides"));
        bevBtn.addActionListener(e -> cardLayout.show(itemsPanel, "Bev"));
        dessertsBtn.addActionListener(e -> cardLayout.show(itemsPanel, "Desserts"));
        breakfBtn.addActionListener(e -> cardLayout.show(itemsPanel, "Breakf"));

        return itemsPanel;
    }

    public void addItem(String foodItem, double price) { //This method adds the items into the orderTextArea when the button are clicked.
        orderTextArea.setText("   " + orderTextArea.getText() + "\n" + foodItem + "\t\t$" + price);
        subTotal.setText("Sub: \t$" + String.format("%,.2f", totalPrice + price));
        totalCost.setText("Tot: \t$" + String.format("%,.2f", ((totalPrice + price) * 1.095)));
        prevItem = foodItem;
        prevPrice = price;
        totalPrice = totalPrice + price;
        previous.addElement(foodItem); previous.addElement(String.valueOf(price));
        OrderedItem order = new OrderedItem(foodItem, price);
        orderedItems.add(order);
    }

    public void cancelItem() { //Does the opposite of addItem(). Adds the prevItem and subtracts the prevPrice.
        try{
            double price  = Double.parseDouble(previous.pop());
            String foodItem = previous.pop();

            if (foodItem.length() < 14) {
                orderTextArea.setText("   " + orderTextArea.getText() + "\n" + foodItem + "\t\t$" + (-1 * price));
                subTotal.setText("Sub: \t$" + String.format("%,.2f", totalPrice - price));
                totalCost.setText("Tot: \t$" + String.format("%,.2f", ((totalPrice - price) * 1.095)));
                prevItem = foodItem;
                prevPrice = price;
                totalPrice = totalPrice - price;
                orderedItems.remove(orderedItems.get(orderedItems.size()-1));


            }
            if (foodItem.length() >= 14) {
                orderTextArea.setText("   " + orderTextArea.getText() + "\n" + foodItem + "\t$" + (-1 * price));
                subTotal.setText("Sub: \t$" + String.format("%,.2f", totalPrice - price));
                totalCost.setText("Tot: \t$" + String.format("%,.2f", ((totalPrice - price) * 1.095)));
                prevItem = foodItem;
                prevPrice = price;
                totalPrice = totalPrice - price;
                orderedItems.remove(orderedItems.get(orderedItems.size()-1));

            }

        } catch (IndexOutOfBoundsException | EmptyStackException err) {
            JOptionPane.showMessageDialog(null, "Order is empty. Please select an item.");
        }

    }

    public void writeReceipt(){

        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa");
        Date date = new Date();
        Collections.sort(orderedItems, new Comparator<OrderedItem>() {
            @Override
            public int compare(OrderedItem o1, OrderedItem o2) {
                return Double.compare(o2.getItemPrice(), o1.getItemPrice());
            }
        });

        orderTextArea.setText("");
        orderTextArea.append(
                "                      Welcome to Chick-Fil-A\n" +
                        "                           Deland, FL 32724 \n" +
                        "                              386-738-0062 \n\n\n" +

                        "                      CUSTOMER COPY\n" +
                        "                   " + dateFormat.format(date) + "\n" +
                        "   Order for: \t" + guestInfo.getText() + "\n" +
                        "   Order Number: \t" + numOfSave + "\n\n"

        );


        for(OrderedItem food : orderedItems){

            orderTextArea.append("    " + food + "\n");
        }

        orderTextArea.append(
                "\n\n    Sub. Total: \t\t$" + String.format("%,.2f", totalPrice) + "\n" +
                        "    Tax: \t\t$" + String.format("%,.2f", totalPrice * .095) + "\n" +
                        "    Total: \t\t$" + String.format("%,.2f", totalPrice * 1.095) + "\n\n\n" +

                        "   Register: 142\n" +
                        "   Cashier: Jorge\n\n" +
                        "                  It was a pleasure serving you!"

        );
        guestInfo.setText(null);
        subTotal.setText(null);
        totalCost.setText(null);
        printReceipt();

    }

    public void printReceipt(){

        BufferedWriter outFile = null;

        try{
            outFile = new BufferedWriter(new FileWriter(new File("receipts/receipt" + numOfSave + ".txt")));
            orderTextArea.write(outFile);
            numOfSave++;

        }catch (IOException exception){
            exception.printStackTrace();
        } finally {
            if(outFile != null){
                try {
                    outFile.close();
                }catch (IOException ex){
                    System.out.println(ex);
                }
            }

        }


    }

    public void importReceipt(){
        String orderNumber = JOptionPane.showInputDialog(this, "Enter Order Number");

        try {
            String line;
            FileReader fr = new FileReader("receipts/receipt" + orderNumber + ".txt");
            BufferedReader reader = new BufferedReader(fr);
            while((line = reader.readLine()) != null){
                if(!line.startsWith(">")){
                    orderTextArea.append(line + "\n");
                }
            }
        }
        catch (IOException ioe) {
            JOptionPane.showMessageDialog(this, "File not found\nPlease input the correct order number.", "File Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void actionPerfomed(ActionEvent e){
        //The prices were taken from https://www.fastfoodprice.com/menu/chick-fil-a-prices/

        //Functionality Panel
        if(e.getSource() == lookUpBtn){
            btnDisabled();
            orderTextArea.setText(null);
            importReceipt();
            repaint();
        }

        if(e.getSource() == cancelOrderBtn){ //CancelOrder clears the screen from anything in the order and empties the ADTs.
            btnEnabled();
            orderTextArea.setText("");
            subTotal.setText("Sub: \t  $");
            totalCost.setText("Tot: \t  $");
            totalPrice = 0;
            previous.clear();
            orderedItems.clear();
            repaint();
        }

        if(e.getSource() == cancelItemBtn){ //CancelItem takes the previous item, and re-writes it in negative.
            cancelItem();
            repaint();
        }

        if(e.getSource() == guestDescBtn){  //Opens a JOptionPane that allows the user to put in some sort of decsription, whether Name or Clothing
            String sGuestDescr = JOptionPane.showInputDialog(null, "Enter Guest Description:", "Guest Info", JOptionPane.QUESTION_MESSAGE);
            sGuestDescr = sGuestDescr.toUpperCase();
            guestInfo.setText(sGuestDescr);
            repaint();
        }

        if(e.getSource() == tenderBtn){   //Finishes the transaction. Prints out a receipt
            int decision = JOptionPane.showConfirmDialog(null, "Complete transaction?");
            System.out.println(decision);
            if(decision == 0){
                writeReceipt();
                JOptionPane.showMessageDialog(null, "Transaction completed!", "Tender", JOptionPane.OK_OPTION);
                totalPrice = 0;
                repaint();
            }
            btnDisabled();
        }

        //EntreesPanel
        if(e.getSource() == EntreesPanel.reg){
            addItem("CFA Sand.", 3.79);
            repaint();
        }
        if(e.getSource() == EntreesPanel.spicy){
            addItem("Spicy Sand.", 4.09);
            repaint();
        }
        if(e.getSource() == EntreesPanel.nuggs){
            addItem("8ct Nuggs", 3.89);
            repaint();
        }
        if(e.getSource() == EntreesPanel.strips){
            addItem("3ct Strips", 4.29);
            repaint();
        }
        if(e.getSource() == EntreesPanel.grilled){
            addItem("GRL Sand.", 5.39);
            repaint();
        }
        if(e.getSource() == EntreesPanel.griNugs){
            addItem("GRL Nuggs", 7.79);
            repaint();
        }
        if(e.getSource() == EntreesPanel.spicyGril){
            addItem("Spicy GRL", 6.09);
            repaint();
        }
        if(e.getSource() == EntreesPanel.chickWrap){
            addItem("GRL Wrap", 6.75);
            repaint();
        }
        if(e.getSource() == EntreesPanel.joeSpec){
            addItem("Mystery", 0.01);
            repaint();
        }

        //Sides Panel
        if(e.getSource() == SidesPanel.fryS){
            addItem("Fries SM", 1.75);
            repaint();
        }
        if(e.getSource() == SidesPanel.fryM){
            addItem("Fries MD", 1.95);
            repaint();
        }
        if(e.getSource() == SidesPanel.fryL){
            addItem("Fries LG", 2.19);
            repaint();
        }
        if(e.getSource() == SidesPanel.macS){
            addItem("Mac SM", 2.49);
            repaint();
        }
        if(e.getSource() == SidesPanel.macM){
            addItem("Mac MD", 3.25);
            repaint();
        }
        if(e.getSource() == SidesPanel.macL){
            addItem("Mac LG", 6.25);
            repaint();
        }
        if(e.getSource() == SidesPanel.fruitS){
            addItem("Fruit SM", 2.65);
            repaint();
        }
        if(e.getSource() == SidesPanel.fruitM){
            addItem("Fruit MD", 3.45);
            repaint();
        }
        if(e.getSource() == SidesPanel.fruitL){
            addItem("Fruit LG", 5.99);
            repaint();
        }
        if(e.getSource() == SidesPanel.kaleS){
            addItem("KaleC SM", 2.09);
            repaint();
        }
        if(e.getSource() == SidesPanel.kaleL){
            addItem("KaleC LG", 3.75);
            repaint();
        }
        if(e.getSource() == SidesPanel.chips){
            addItem("Chips", 1.89);
            repaint();
        }

        //Beverage Panel
        if(e.getSource() == BevPanel.coke){
            addItem("Coke", 1.85);
            repaint();
        }
        if(e.getSource() == BevPanel.dCoke){
            addItem("Dt Coke", 1.85);
            repaint();
        }
        if(e.getSource() == BevPanel.cokeZ){
            addItem("Coke Zero", 1.85);
            repaint();
        }
        if(e.getSource() == BevPanel.cokeC){
            addItem("Cherry Coke", 1.85);
            repaint();
        }
        if(e.getSource() == BevPanel.sprite){
            addItem("Sprite", 1.85);
            repaint();
        }
        if(e.getSource() == BevPanel.drPepper){
            addItem("Dr Pepper", 1.85);
            repaint();
        }
        if(e.getSource() == BevPanel.dietDrPepper){
            addItem("Dt Dr Pep", 1.85);
            repaint();
        }
        if(e.getSource() == BevPanel.rootBeer){
            addItem("Rootbeer", 1.85);
            repaint();
        }
        if(e.getSource() == BevPanel.powerade){
            addItem("Powerade", 1.85);
            repaint();
        }
        if(e.getSource() == BevPanel.hiC){
            addItem("Hi-C", 1.85);
            repaint();
        }
        if(e.getSource() == BevPanel.lemonade){
            addItem("Lemn", 2.19);
            repaint();
        }
        if(e.getSource() == BevPanel.dLemonade){
            addItem("Dt Lemn", 2.19);
            repaint();
        }
        if(e.getSource() == BevPanel.teaS){
            addItem("Swt Tea", 1.85);
            repaint();
        }
        if(e.getSource() == BevPanel.teaU){
            addItem("USwt Tea", 1.85);
            repaint();
        }
        if(e.getSource() == BevPanel.icedCoffee){
            addItem("Iced Coffee", 3.25);
            repaint();
        }

        //Desserts Panel
        if(e.getSource() == DessertsPanel.brownie){
            addItem("Brownie", 1.99);
            repaint();
        }
        if(e.getSource() == DessertsPanel.cookie){
            addItem("CC Cookie", 1.45);
            repaint();
        }
        if(e.getSource() == DessertsPanel.chocM){
            addItem("Choc MlkSh", 3.99);
            repaint();
        }
        if(e.getSource() == DessertsPanel.vanillaM){
            addItem("Van MlkSh", 3.99);
            repaint();
        }
        if(e.getSource() == DessertsPanel.strawberryM){
            addItem("Straw MlkSh", 3.99);
            repaint();
        }
        if(e.getSource() == DessertsPanel.cncM){
            addItem("CkC MlkSh", 3.99);
            repaint();
        }
        if(e.getSource() == DessertsPanel.idK){
            addItem("ID Kids", 1.25);
            repaint();
        }
        if(e.getSource() == DessertsPanel.idC){
            addItem("ID Cup", 2.19);
            repaint();
        }
        if(e.getSource() == DessertsPanel.idX){
            addItem("ID Quart", 4.45);
            repaint();
        }


        //Breakfast Panel
        if(e.getSource() == BreakfPanel.biscuit){
            addItem("Chick Bisc", 2.65);
            repaint();
        }
        if(e.getSource() == BreakfPanel.minis){
            addItem("Minis", 3.09);
            repaint();
        }
        if(e.getSource() == BreakfPanel.ewgmuffin){
            addItem("EWG Muff", 3.95);
            repaint();
        }
        if(e.getSource() == BreakfPanel.burrito){
            addItem("CFA Burr.", 2.69);
            repaint();
        }
        if(e.getSource() == BreakfPanel.bowl){
            addItem("CFA Bowl", 2.69);
            repaint();
        }
        if(e.getSource() == BreakfPanel.muffins){
            addItem("CFA Muff", 3.29);
            repaint();
        }
        if(e.getSource() == BreakfPanel.bagels){
            addItem("CFA Bagel", 3.95);
            repaint();
        }

    }

    public void btnDisabled(){
        for (JButton button : Arrays.asList(tenderBtn, guestDescBtn, cancelItemBtn, EntreesPanel.reg, EntreesPanel.spicy, EntreesPanel.nuggs, EntreesPanel.strips, EntreesPanel.grilled, EntreesPanel.griNugs, EntreesPanel.spicyGril, EntreesPanel.chickWrap, EntreesPanel.joeSpec, SidesPanel.fryS, SidesPanel.fryM, SidesPanel.fryL, SidesPanel.macS, SidesPanel.macM, SidesPanel.macL, SidesPanel.fruitS, SidesPanel.fruitM, SidesPanel.fruitL, SidesPanel.kaleS, SidesPanel.kaleL, SidesPanel.chips, BevPanel.coke, BevPanel.dCoke, BevPanel.cokeZ, BevPanel.cokeC, BevPanel.sprite, BevPanel.drPepper, BevPanel.dietDrPepper, BevPanel.rootBeer, BevPanel.powerade, BevPanel.hiC, BevPanel.lemonade, BevPanel.dLemonade, BevPanel.teaS, BevPanel.teaU, BevPanel.icedCoffee, DessertsPanel.brownie, DessertsPanel.cookie, DessertsPanel.chocM, DessertsPanel.vanillaM, DessertsPanel.strawberryM, DessertsPanel.cncM, DessertsPanel.idK, DessertsPanel.idC, DessertsPanel.idX, BreakfPanel.biscuit, BreakfPanel.minis, BreakfPanel.ewgmuffin, BreakfPanel.burrito, BreakfPanel.bowl, BreakfPanel.muffins, BreakfPanel.bagels)) {
            button.setEnabled(false);
        }
    }

    public void btnEnabled(){
        for (JButton button : Arrays.asList(lookUpBtn, tenderBtn, guestDescBtn, cancelItemBtn, cancelOrderBtn, EntreesPanel.reg, EntreesPanel.spicy, EntreesPanel.nuggs, EntreesPanel.strips, EntreesPanel.grilled, EntreesPanel.griNugs, EntreesPanel.spicyGril, EntreesPanel.chickWrap, EntreesPanel.joeSpec, SidesPanel.fryS, SidesPanel.fryM, SidesPanel.fryL, SidesPanel.macS, SidesPanel.macM, SidesPanel.macL, SidesPanel.fruitS, SidesPanel.fruitM, SidesPanel.fruitL, SidesPanel.kaleS, SidesPanel.kaleL, SidesPanel.chips, BevPanel.coke, BevPanel.dCoke, BevPanel.cokeZ, BevPanel.cokeC, BevPanel.sprite, BevPanel.drPepper, BevPanel.dietDrPepper, BevPanel.rootBeer, BevPanel.powerade, BevPanel.hiC, BevPanel.lemonade, BevPanel.dLemonade, BevPanel.teaS, BevPanel.teaU, BevPanel.icedCoffee, DessertsPanel.brownie, DessertsPanel.cookie, DessertsPanel.chocM, DessertsPanel.vanillaM, DessertsPanel.strawberryM, DessertsPanel.cncM, DessertsPanel.idK, DessertsPanel.idC, DessertsPanel.idX, BreakfPanel.biscuit, BreakfPanel.minis, BreakfPanel.ewgmuffin, BreakfPanel.burrito, BreakfPanel.bowl, BreakfPanel.muffins, BreakfPanel.bagels)) {
            button.setEnabled(true);
        }
    }

    public void btnClicked(){
        //Created a separate class that hold each action listener for each button
        for (JButton button : Arrays.asList(lookUpBtn, tenderBtn, guestDescBtn, cancelItemBtn, cancelOrderBtn, EntreesPanel.reg, EntreesPanel.spicy, EntreesPanel.nuggs, EntreesPanel.strips, EntreesPanel.grilled, EntreesPanel.griNugs, EntreesPanel.spicyGril, EntreesPanel.chickWrap, EntreesPanel.joeSpec, SidesPanel.fryS, SidesPanel.fryM, SidesPanel.fryL, SidesPanel.macS, SidesPanel.macM, SidesPanel.macL, SidesPanel.fruitS, SidesPanel.fruitM, SidesPanel.fruitL, SidesPanel.kaleS, SidesPanel.kaleL, SidesPanel.chips, BevPanel.coke, BevPanel.dCoke, BevPanel.cokeZ, BevPanel.cokeC, BevPanel.sprite, BevPanel.drPepper, BevPanel.dietDrPepper, BevPanel.rootBeer, BevPanel.powerade, BevPanel.hiC, BevPanel.lemonade, BevPanel.dLemonade, BevPanel.teaS, BevPanel.teaU, BevPanel.icedCoffee, DessertsPanel.brownie, DessertsPanel.cookie, DessertsPanel.chocM, DessertsPanel.vanillaM, DessertsPanel.strawberryM, DessertsPanel.cncM, DessertsPanel.idK, DessertsPanel.idC, DessertsPanel.idX, BreakfPanel.biscuit, BreakfPanel.minis, BreakfPanel.ewgmuffin, BreakfPanel.burrito, BreakfPanel.bowl, BreakfPanel.muffins, BreakfPanel.bagels)) {
            button.addActionListener(this::actionPerfomed);
        }

    }


}
