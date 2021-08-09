package View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class TheLayout{

    JPanel base = new JPanel();
    private CardLayout cl = new CardLayout();
    private Image img;

    BossThirdPanel btp = new BossThirdPanel();
    MenuPanel mp = new MenuPanel();
    SecondPanel sp = new SecondPanel();
    JFrame frame = new Frame();

    public TheLayout() {
        base.setLayout(cl);
        base.add(btp,"1");
        base.add(mp,"2");
        base.add(sp,"3");
        cl.show(base,"3");

        try {
            img = ImageIO.read(new File("mesImages/portfolio.jpg"));
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        sp.login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("step1");
                if(sp.getState()==1){
                    mp.initComData(sp.com);
                    cl.show(base,"2");
                    System.out.println("step20");
                }else if(sp.getState()==2){
                    cl.show(base,"1");
                    System.out.println("step21");
                }
            }
        });

        frame.setSize(1100, 740);
        frame.setTitle("Portfolio Management");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setIconImage(img);
        frame.setContentPane(base);
        frame.setVisible(true);
    }
}
