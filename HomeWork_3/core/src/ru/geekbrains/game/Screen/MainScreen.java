package ru.geekbrains.game.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class MainScreen extends BaseScreen {
    private Texture background;
    private Texture apple;
    private Vector2 touch;
    private Vector2 position;
    private Vector2 velocity;
    private Vector2 tempTouch;
    private final float V_LEN = 0.0001f;

    @Override
    public void show () {
        super.show();
        background = new Texture("cosmos.png");
        apple = new Texture("apple.png");
        position = new Vector2(-0.5f, -0.5f);
        velocity = new Vector2();
        touch = new Vector2(super.getTouch());
        tempTouch = new Vector2();
    }

    @Override
    public void render (float delta) {
        super.render(delta);
        touch.set(super.getTouch());
        tempTouch.set(touch);
        velocity.set(tempTouch.sub(position)).setLength2(V_LEN);
        if(tempTouch.len() > V_LEN) {
            position.add(velocity);
        } else {
            position.set(touch);
        }
        Gdx.gl.glClearColor(0.26f, 0.5f, 0.8f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(background, -1f, -1f, 2f, 2f);
        batch.draw(apple, position.x, position.y, 0.2f, 0.2f);
        batch.end();
    }

    @Override
    public boolean keyDown(int keycode) {
        Vector2 offsetX = new Vector2(0.001f,0);
        Vector2 offsetY = new Vector2(0,0.001f);

        if (keycode == Input.Keys.DPAD_UP){
            position.add(offsetY);
        }
        if (keycode == Input.Keys.DPAD_DOWN){
            position.add(offsetY.scl(-1));
        }
        if (keycode == Input.Keys.DPAD_LEFT){
            position.add(offsetX.scl(-1));
        }
        if (keycode == Input.Keys.DPAD_RIGHT){
            position.add(offsetX);
        }
        return super.keyDown(keycode);
    }

    @Override
    public void dispose () {
        super.dispose();
        background.dispose();
        apple.dispose();
    }
}
