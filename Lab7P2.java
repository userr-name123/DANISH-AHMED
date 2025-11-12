import java.awt.*;
import java.awt.event.*;

class Lab7P1 {

    public static void main(String... args) {
        final int[] a = {0}; 

        Frame f = new Frame("Lab7 Program");
        f.setLayout(new FlowLayout());
        f.setSize(300, 200);

        TextField tf = new TextField();
        tf.setColumns(20);

        Label l = new Label("Output will appear here");
        l.setPreferredSize(new Dimension(200, 20));

        Button b = new Button("Click");
        b.setSize(100, 20);

        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.out.println("HELLO");
                l.setText(tf.getText() + " - " + a[0]);
                a[0]++;
            }
        });

        f.add(tf);
        f.add(b);
        f.add(l);

        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                f.dispose();
            }
        });

        f.setVisible(true);
    }
}

