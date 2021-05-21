import javax.swing.*;
import java.awt.event.*;

import javax.imageio.*;
import java.awt.image.BufferedImage;
import java.io.File;

public abstract class ActionButton extends JButton implements ActionListener {
    protected Tamagochi tamagochi;
    protected BufferedImage rawImage;
    protected ImageIcon imageIcon;

    public ActionButton(Tamagochi tamagochi, String pathToImage) {
        this.tamagochi = tamagochi;

        this.addActionListener(this);

        try {
            this.rawImage = ImageIO.read(new File(pathToImage));
            this.imageIcon = new ImageIcon(this.rawImage);

            this.setIcon(this.imageIcon);
        } catch (Exception e) {
        }
    }

    @Override
    abstract public void actionPerformed(ActionEvent e);
}
