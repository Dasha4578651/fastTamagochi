import java.awt.event.*;

public class ActionFeed extends ActionButton {
    public ActionFeed(Tamagochi tamagochi) {
        super(tamagochi, "./icons/hungry.png");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.tamagochi.feedTamagochi();
        this.tamagochi.shuffleButtons();
    }
}
