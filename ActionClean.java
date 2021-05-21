import java.awt.event.*;

public class ActionClean extends ActionButton {
    public ActionClean(Tamagochi tamagochi) {
        super(tamagochi, "./icons/purity.png");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.tamagochi.cleanTamagochi();
        this.tamagochi.shuffleButtons();
    }
}
