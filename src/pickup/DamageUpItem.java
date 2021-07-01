package pickup;

import fsm.FiniteStateMachine;
import fsm.ImageRenderer;
import fsm.State;
import fsm.WaitingPerFrame;
import jet.attackStates.DamageUpAttack;
import jet.Jet;
import jet.JetImageRenderer;
import model.Direction;
import model.Sprite;
import model.SpriteShape;

import java.awt.*;

import static utils.ImageStateUtils.imageStatesFromFolder;

public class DamageUpItem extends PickupItem {
    public DamageUpItem(Point location) {
        super("ATKbulletitem", location, new SpriteShape(new Dimension(30, 30),
                new Dimension(0, 0), new Dimension(30, 30)));
    }

    public PickupItem getNewInstance() {
        return new DamageUpItem(this.location);
    }

    public void enactOnTarget(Sprite target) {
        Jet player = (Jet)target;
        FiniteStateMachine fsm = player.getFsm();
        String playerFace = (player.getFace() == Direction.UP) ? "up": "down";
        ImageRenderer imageRenderer = new JetImageRenderer(player);
        State ATK = new WaitingPerFrame(8,
                new DamageUpAttack(player, fsm, imageStatesFromFolder("assets/attack" + "/" + playerFace, imageRenderer)));
        fsm.setAttackingState(ATK);
        player.getAmmoBar().reset();
        this.world.removeSprite(this);
    }
}
