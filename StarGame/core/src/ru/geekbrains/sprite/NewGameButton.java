package ru.geekbrains.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import ru.geekbrains.base.ScaledTouchUpButton;
import ru.geekbrains.math.Rect;
import ru.geekbrains.screen.GameScreen;

public class NewGameButton extends ScaledTouchUpButton {
    private Vector2 position;
    private GameScreen gameScreen;

    public NewGameButton(TextureAtlas atlas, GameScreen gameScreen){
        super(atlas.findRegion("button_new_game"));
        this.gameScreen = gameScreen;
        position = new Vector2(0,0f);
        pos.set(position);
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.1f);
    }

    @Override
    public void action() {
        gameScreen.startNewGame();
    }
}
