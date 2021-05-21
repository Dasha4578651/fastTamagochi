import java.awt.*;
import javax.swing.*;
import java.util.Random;

public class Tamagochi extends JPanel {
    private class TamagochiIdle extends JPanel {
        private ImageIcon image;

        public TamagochiIdle() {
            this.image = new ImageIcon(this.getClass().getResource("normal.gif"));
            setPreferredSize(new Dimension(296, 316));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image.getImage(), 82, -20, this);
        }
    }

    private Characteristic purity = new Characteristic("./icons/purity.png");
    private Characteristic hunger = new Characteristic("./icons/hungry.png");
    private Characteristic play = new Characteristic("./icons/play.png");

    private JButton[] buttons = { new ActionFeed(this), new ActionClean(this), new ActionPlay(this) };

    private Box buttonsBox = Box.createHorizontalBox();
    private TamagochiIdle tamagochiIdle = new TamagochiIdle();

    public Tamagochi() {
        setSize(new Dimension(500, 500));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(Box.createVerticalStrut(20));

        Box characteristicsBox = Box.createHorizontalBox();
        characteristicsBox.add(Box.createHorizontalStrut(10));
        characteristicsBox.add(this.hunger);
        characteristicsBox.add(Box.createHorizontalStrut(10));
        characteristicsBox.add(this.purity);
        characteristicsBox.add(Box.createHorizontalStrut(10));
        characteristicsBox.add(this.play);
        characteristicsBox.add(Box.createHorizontalStrut(10));
        
        Box buttonsBox = Box.createHorizontalBox();
        buttonsBox.add(Box.createHorizontalStrut(10));
        buttonsBox.add(this.buttons[0]);
        buttonsBox.add(Box.createHorizontalStrut(10));
        buttonsBox.add(this.buttons[1]);
        buttonsBox.add(Box.createHorizontalStrut(10));
        buttonsBox.add(this.buttons[2]);
        buttonsBox.add(Box.createHorizontalStrut(10));

        this.add(characteristicsBox);
        this.add(Box.createVerticalStrut(20));
        this.add(this.tamagochiIdle);
        this.add(Box.createVerticalStrut(20));
        this.shuffleButtons();
    }

    public void shuffleButtons() {
        Random random = new Random();
        for (int i = 0; i < this.buttons.length; i++) {
            int index1 = random.nextInt(this.buttons.length);
            int index2 = random.nextInt(this.buttons.length);

            JButton temp = this.buttons[index1];
            this.buttons[index1] = this.buttons[index2];
            this.buttons[index2] = temp;
        }

        Box buttonsBox = Box.createHorizontalBox();
        buttonsBox.add(Box.createHorizontalStrut(10));
        buttonsBox.add(this.buttons[0]);
        buttonsBox.add(Box.createHorizontalStrut(10));
        buttonsBox.add(this.buttons[1]);
        buttonsBox.add(Box.createHorizontalStrut(10));
        buttonsBox.add(this.buttons[2]);
        buttonsBox.add(Box.createHorizontalStrut(10));

        this.remove(this.getComponentCount() - 1);
        this.buttonsBox = buttonsBox;
        this.add(this.buttonsBox);
        this.add(Box.createVerticalStrut(20));
        this.revalidate();
    }

    public void feedTamagochi() {
        this.hunger.reset();
    }

    public void playTamagochi() {
        this.play.reset();
    }

    public void cleanTamagochi() {
        this.purity.reset();
    }
}