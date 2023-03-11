import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        JFrame f = new JFrame("Swing Paint Demo");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MyPanel myPanel = new MyPanel();
        myPanel.repaint();
        myPanel.setSymbols("1, 2, 3");
        f.add(myPanel);
        f.pack();
        f.setVisible(true);
    }
}