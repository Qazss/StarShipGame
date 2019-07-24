package ru.geekbrains.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.Sprite;

public class StarShip extends Sprite {
    private Vector2 endPos = new Vector2();
    private Vector2 velocity = new Vector2();
    private Vector2 temp = new Vector2();
    private final float V_LEN = 0.01f;

    public StarShip(TextureAtlas atlas) {
        super(atlas.findRegion("main_ship"));
        pos.set(0, -0.38f);
        setHeightProportion(0.15f);
    }

    @Override
    public void update(float delta) {
        temp.set(endPos);
        if(temp.sub(pos).len() > V_LEN){
            pos.add(velocity);
        } else {
            pos.set(endPos);
        }
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        endPos.set(touch);
        velocity.set(touch.sub(pos).setLength(V_LEN));
        System.out.println("starship " + touch);
        return false;
    }
}
