import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world");
        int[] koords = new int[5];
        JTextField smallField = new JTextField("300, 250, 25, 45, 20");
        JTextField letters = new JTextField("А, Б, В, Г, а, мю, ю, я, йэ, нь");
        JFrame f = new JFrame("Swing Paint Demo");
        MyPanel myPanel = new MyPanel();
        letters.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] parm = smallField.getText().replaceAll(" ", "").split(",");
                int[] koords = new int[parm.length];
                if (parm.length != parm.length) {
                    JOptionPane.showMessageDialog(null,
                            "Ошибка в количестве параметров");
                }
                for (int i = 0; i < parm.length; i++) {
                    koords[i] = getInteger(parm[i]);
                }
                myPanel.setX(koords[0]);
                myPanel.setY(koords[1]);
                myPanel.setWidth(koords[2]);
                myPanel.setHeight(koords[3]);
                myPanel.setStep(koords[4]);
                myPanel.setSymbols(letters.getText());
                myPanel.repaint();
                f.add(myPanel);
                f.pack();
                f.setVisible(true);
            }
        });

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel contents = new JPanel(new FlowLayout(FlowLayout.LEFT));

        contents.add(letters);
        contents.add(smallField);
        contents.setPreferredSize(new Dimension(1560,700));
        f.setContentPane(contents);

        myPanel.repaint();
        f.add(myPanel);
        f.pack();
        f.setVisible(true);
    }

    private static int getInteger(String parm) {
        try {
            return Integer.parseInt(parm);
        }
        catch (Exception e) {
            new Exception("Это не буква");
        }
        return 0;
    }
}