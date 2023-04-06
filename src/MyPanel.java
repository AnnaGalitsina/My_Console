import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
public class MyPanel extends JPanel{
    public MyPanel() {
        setBorder(BorderFactory.createLineBorder(Color.black));
    }

    public  Dimension getPreferredSize() {
        return new Dimension( 1560,  700);
    }
    private int x = 100;
    private int y = 100;
    private int width = 50;
    private  int height = 100;
    private int step = 30;
    private  int delta = 5;
    //private String[] numbers = null;
    // private int otstup = 1;

    private ArrayList<Rectangle> outlist = new ArrayList<Rectangle>();

    public void setSymbols(String parm){
        String[] arr = parm.replace(",", "").split(" ");
        for (String cifra: arr){
            switch (cifra){
                case "А":
                   break;
                case "2":
                    segment(1);
                    segment(2);
                    segment(3);
                    segment(6);
                    segment(5);
                    break;
                case "3":
                    segment(1);
                    segment(2);
                    segment(3);
                    segment(4);
                    segment(5);
                    break;
            }
            x = x + step + width;
        }
    }

    public class APanel extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            int width = getWidth();
            int height = getHeight();
            g.drawLine(0, height, width / 2, 0);
            g.drawLine(width / 2, 0, width, height);
            g.drawLine(width / 4, height / 2, 3 * width / 4, height / 2);
        }
    }
    public void segment(int number){
        switch (number) {
            // 1-7 сегменты с лабораторной работы
            // горизонтальные сегменты, 1 - верхний, 3 - средний, 5 - нижний
            case 1: outlist.add(new Rectangle(x + delta, y, x+ width - delta, y));
                break;
            case 3: outlist.add(new Rectangle(x + delta, y + height / 2, x + width - delta, y + height / 2));
                break;
            case 5: outlist.add(new Rectangle(x + delta, y + height, x + width - delta, y + height));
                break;

            // правые вертикальные сегменты, 2 - верхний, 4 - нижний
            case 2: outlist.add(new Rectangle(x + width, y + delta, x + width, y + (height / 2) - delta));
                break;
            case 4: outlist.add(new Rectangle(x + width, y + (height / 2) + delta, x + width, y + height - delta));
                break;

            // левые сегменты, 7 - верхний, 6 - нижний
            case 6: outlist.add(new Rectangle(x, y + (height / 2) + delta, x, y + height - delta));
                break;
            case 7: outlist.add(new Rectangle(x, y + delta, x, y + (height / 2) - delta));
                break;

            // 8-12 сегменты собственные
            // для корейской буквы ю
            case 8:
                outlist.add(new Rectangle(x + (width/3), y+height/2+delta, x + (width/3), y+height-delta));
                break;
            case 9:
                outlist.add(new Rectangle(x + (width*2/3), y+height/2+delta, x + (width*2/3), y+height-delta));
                break;

            // для корейских букв я, йэ
            case 10:
                outlist.add(new Rectangle(x+delta, y+height/3, x + width-delta, y+height/3));
                break;
            case 11:
                outlist.add(new Rectangle(x+delta, y+height*2/3, x + width-delta, y+height*2/3));
                break;

            // для корейской буквы нь
            case 12:
                outlist.add(new Rectangle(x + (width/2) - 5, y+delta, x + (width/2), y+(height/2)-delta));
                break;
        }
    }
        public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Rectangle rect: outlist){
            g.drawLine(rect.x, rect.y, rect.width, rect.height);
        }
    }

    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }    public void setWidth(int width){
        this.width = width;
    }    public void setHeight(int height){
        this.height = height;
    }    public void setStep(int step){
        this.step = step;
    }
}
