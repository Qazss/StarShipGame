package ru.geekbrains.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import ru.geekbrains.base.Sprite;
import ru.geekbrains.math.Rect;

public class GameOverMessage extends Sprite {
    private Vector2 position;

    public GameOverMessage(TextureAtlas atlas){
        super(atlas.findRegion("message_game_over"));
        position = new Vector2(0,0.2f);
        pos.set(position);
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.1f);
    }
}
