

    import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JList;

    public class Calc implements ActionListener {



        JFrame frame;
        JTextField textField;

        JTextField memoryField;

        JButton[] numberButtons = new JButton[10];
        JButton[] functionButtons = new JButton[9];

        JButton[] memoryButtons = new JButton[4];



        JButton addB, subB, mulB, divB;
        JButton decB, eqB, delB, clrB, negB;
        JButton memoryPlus, memoryMinus, memoryClear, memorySave;

        JPanel buttonPanel;

        JPanel memoryPanel;

        double memory;

        DefaultListModel<Double> memoryListModel = new DefaultListModel<>();
        JList<Double> memoryList = new JList<>(memoryListModel);

        Font font = new Font("Calibri", Font.BOLD, 18);

        double num1;
        double num2;
        double result;
        char operator;


        public Calc() {
            frame = new JFrame("Calculator");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setSize(420, 600);
            frame.setLayout(null); // k nastaveni pozice komponenty rucne


            textField = new JTextField();
            textField.setBounds(50, 25, 300, 60);
            textField.setFont(font);
            textField.setEditable(false);

            addB = new JButton("+");
            subB = new JButton("-");
            mulB = new JButton("*");
            divB = new JButton("/");
            decB = new JButton(".");
            eqB = new JButton("=");
            delB = new JButton("Del");
            clrB = new JButton("Clear");
            negB = new JButton("-");

            functionButtons[0] = addB;
            functionButtons[1] = subB;
            functionButtons[2] = mulB;
            functionButtons[3] = divB;
            functionButtons[4] = decB;
            functionButtons[5] = eqB;
            functionButtons[6] = delB;
            functionButtons[7] = clrB;
            functionButtons[8] = negB;


            memoryPlus = new JButton("M+");
            memoryMinus = new JButton("M-");
            memoryClear = new JButton("MC");
            memorySave = new JButton("MS");


            memoryButtons[0] = memoryPlus;
            memoryButtons[1] = memoryMinus;
            memoryButtons[2] = memoryClear;
            memoryButtons[3] = memorySave;

            for(int i = 0; i < 4; i++) {
                memoryButtons[i].addActionListener(this);
                memoryButtons[i].setFont(font);
                memoryButtons[i].setFocusable(false);
            }




            memoryPanel = new JPanel();
            memoryPanel.setBounds(50, 120, 300, 30);
            memoryPanel.setLayout(new GridLayout(1, 4, 0, 0));

            memoryField = new JTextField();
            memoryField.setEditable(false);

            memoryPanel.add(memoryButtons[0]);
            memoryPanel.add(memoryButtons[1]);
            memoryPanel.add(memoryButtons[2]);
            memoryPanel.add(memoryButtons[3]);
            memoryPanel.add(memoryField);
            //memoryPanel.add(memoryList);




            for (int i = 0; i < 9; i++) {
                functionButtons[i].addActionListener(this); //zprovozneni kazdeho tlacitka
                functionButtons[i].setFont(font);
                functionButtons[i].setFocusable(false);
            }

            for (int i = 0; i < 10; i++) { //vytvareni numberButtons
                numberButtons[i] = new JButton(String.valueOf(i)); //tlacitko musi byt text a i je ted cislo
                numberButtons[i].addActionListener(this); //zprovozneni kazdeho tlacitka
                numberButtons[i].setFont(font);
                numberButtons[i].setFocusable(false);
            }


            buttonPanel = new JPanel();
            buttonPanel.setBounds(50, 180, 300, 300);
            buttonPanel.setLayout(new GridLayout(4, 4, 10, 10)); //rows colums, spaces
            buttonPanel.setBackground(Color.PINK);

            buttonPanel.add(numberButtons[1]);
            buttonPanel.add(numberButtons[2]);
            buttonPanel.add(numberButtons[3]);
            buttonPanel.add(addB);

            buttonPanel.add(numberButtons[4]);
            buttonPanel.add(numberButtons[5]);
            buttonPanel.add(numberButtons[6]);
            buttonPanel.add(subB);

            buttonPanel.add(numberButtons[7]);
            buttonPanel.add(numberButtons[8]);
            buttonPanel.add(numberButtons[9]);
            buttonPanel.add(mulB);
            buttonPanel.add(decB);
            buttonPanel.add(numberButtons[0]);
            buttonPanel.add(eqB);
            buttonPanel.add(divB);

            negB.setBounds(50, 500, 100, 50);
            delB.setBounds(150, 500, 100, 50);
            clrB.setBounds(250, 500, 100, 50);

            frame.add(textField);
            frame.add(buttonPanel);
            frame.add(memoryPanel);

            frame.add(negB);
            frame.add(clrB);
            frame.add(delB);


            frame.setVisible(true);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < 10; i++) { //pro cisla
                if (e.getSource() == numberButtons[i]) { //pokud se e rovna nejakemu cislu
                    textField.setText(textField.getText().concat(String.valueOf(i))); //prevede cislo na text
                }
            }
            if (e.getSource() == decB) {
                textField.setText(textField.getText().concat("."));
            }

            if (e.getSource() == addB) {
                num1 = Double.parseDouble(textField.getText());
                operator = '+';
                textField.setText("");
            }

            if (e.getSource() == subB) {
                num1 = Double.parseDouble(textField.getText());
                operator = '-';
                textField.setText("");
            }

            if (e.getSource() == mulB) {
                num1 = Double.parseDouble(textField.getText());
                operator = '*';
                textField.setText("");
            }

            if (e.getSource() == divB) {
                num1 = Double.parseDouble(textField.getText());
                operator = '/';
                textField.setText("");
            }

            if (e.getSource() == eqB) {
                num2 = Double.parseDouble(textField.getText());

                switch (operator) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '/':
                        result = num1 / num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                }
                textField.setText(String.valueOf(result));
                num1 = result;
            }
            if (e.getSource() == clrB) {
                textField.setText("");
            }

            if (e.getSource() == delB) {
                String string = textField.getText(); //645
                textField.setText("");
                for (int i = 0; i < string.length() - 1; i++) { //64
                    textField.setText(textField.getText() + string.charAt(i));

                }
            }
            if (e.getSource() == negB) {
                {
                    double temp = Double.parseDouble(textField.getText());
                    temp*=-1;
                    textField.setText(String.valueOf(temp));

                }
            }
            if (e.getSource() == memoryClear) {
                textField.setText("");
                memoryField.setText("");
                memoryListModel.clear();

            }

            if (e.getSource() == memoryPlus) {
                double currentValue = Double.parseDouble(textField.getText());
                memory += currentValue;
                textField.setText("");
                memoryField.setText(String.valueOf(memory)); //set text
                memoryListModel.addElement(memory);

            }
            if (e.getSource() == memoryMinus) {
                double currentValue = Double.parseDouble(textField.getText());
                memory -= currentValue;
                textField.setText("");
                memoryField.setText(String.valueOf(memory)); //set text
                memoryListModel.addElement(memory);

            }

            if (e.getSource() == memorySave) {
                double currentValue = Double.parseDouble(textField.getText());
                memory = currentValue;
                textField.setText("");
                memoryField.setText(String.valueOf(memory)); //set text
                memoryListModel.addElement(memory);

            }


        }

        public static void main(String[] args) {
            Calc c = new Calc();
        }
    }


