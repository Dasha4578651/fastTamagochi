import javax.swing.*;

public class Main extends JFrame implements Runnable {
    public Main() {
        super("Tamagochi");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        Box contentPane = Box.createVerticalBox();
        contentPane.add(new Tamagochi());

        setContentPane(contentPane);
        pack();
        setVisible(true);
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(70);
                repaint();
            } catch (Exception e) {
            }
        }
    }

    public static void main(String[] args) {
        Main t = new Main();
        new Thread(t).start();
    }
}