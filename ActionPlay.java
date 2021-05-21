import java.awt.event.*;

public class ActionPlay extends ActionButton {
    public ActionPlay(Tamagochi tamagochi) {
        super(tamagochi, "./icons/play.png");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.tamagochi.playTamagochi();
        this.tamagochi.shuffleButtons();
    }
}
