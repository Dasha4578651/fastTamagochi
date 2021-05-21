import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.File;
import javax.imageio.ImageIO;

import java.util.Random;

public class Characteristic extends JComponent {
    private static int HEIGHT = 10;
    private static int THICKNESS = 2;
    private static Random random = new Random();

    private int current;
    private int maxDecrease;
    private int minDecrease;
    private int maxValue;

    private double increaser;

    private BufferedImage rawImage;

    public Characteristic(String imagePath) {
        this.maxValue = 100;
        this.current = this.maxValue;
        this.maxDecrease = 3;
        this.minDecrease = 0;

        this.increaser = 0.0;

        try {
            this.rawImage = ImageIO.read(new File(imagePath));
        } catch (Exception e) {
        }

        setPreferredSize(new Dimension(this.maxValue + THICKNESS * 2 + 35, HEIGHT + THICKNESS * 2 + 28));
    }

    public void reset() {
        this.current = this.maxValue;
        this.increaser += 0.03;

        if (this.increaser >= 1) {
            this.maxDecrease++;
            this.minDecrease++;
            this.increaser = 0;
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.current -= random.nextInt(this.maxDecrease) + this.minDecrease;
        if (this.current <= 0)
            System.exit(1);

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, this.maxValue + THICKNESS, HEIGHT + THICKNESS * 2);

        if (this.current > 75)
            g.setColor(Color.GREEN);
        else if (this.current > 25 && this.current <= 75)
            g.setColor(Color.YELLOW);
        else
            g.setColor(Color.RED);

        g.fillRect(THICKNESS, THICKNESS, this.current, HEIGHT);
        g.drawImage(this.rawImage, this.maxValue + THICKNESS + 5, 0, 28, 28, null);
    }
}
