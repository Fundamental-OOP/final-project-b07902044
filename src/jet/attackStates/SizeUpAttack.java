package jet.attackStates;

import bullet.BigBullet;
import fsm.State;
import fsm.StateMachine;
import jet.Attacking;
import jet.Jet;
import media.AudioPlayer;
import model.Direction;

import java.awt.*;
import java.util.List;

public class SizeUpAttack extends Attacking {
    public static final String LARGER = "larger";
    public SizeUpAttack(Jet jet, StateMachine stateMachine, List<? extends State> states) {
        super(jet, stateMachine, states);
    }

    public void enactAttack() {
        Point bulletSpawnPoint = new Point(this.jet.getLocation());
        bulletSpawnPoint.x += this.jet.getRange().width / 2;
        bulletSpawnPoint.y += (this.jet.getFace() == Direction.UP) ? 0: this.jet.getRange().height;
        double angle = (this.jet.getFace() == Direction.UP) ? 270: 90;
        this.jet.getWorld().addSprite(new BigBullet(this.jet, bulletSpawnPoint, 100, 10, angle));
        AudioPlayer.playSounds(LARGER);
    }
}

