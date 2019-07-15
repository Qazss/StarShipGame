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
    private int screenX = 0;
    private int screenY = 0;
    private float length = 0;
    private final float speed = 0.01f;
    private boolean isMoving;

    @Override
    public void show () {
        super.show();
        background = new Texture("cosmos.png");
        apple = new Texture("apple.png");
        position = new Vector2();
        //touch = new Vector2(screenX, screenY);
    }

    @Override
    public void render (float delta) {
        super.render(delta);
        if(isMoving) {
            updateApplePosition();
        }
        Gdx.gl.glClearColor(0.26f, 0.5f, 0.8f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(background, 0, 0);
        batch.draw(apple, position.x, position.y);
        batch.end();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        this.screenX = screenX - apple.getWidth()/2;
        this.screenY = (Gdx.graphics.getHeight() - screenY) - apple.getHeight()/2;
        Vector2 v = new Vector2(this.screenX, this.screenY);
        touch = v.cpy();
        this.length += v.sub(position).len();
        isMoving = true;
        return super.touchDown(screenX, screenY, pointer, button);
    }

    public void updateApplePosition(){
        if(position.len() < length) {
            touch.set(screenX, screenY).scl(speed);
            position.add(touch);
        } else {
            isMoving = false;
        }
    }

    @Override
    public boolean keyDown(int keycode) {
        Vector2 offsetX = new Vector2(5,0);
        Vector2 offsetY = new Vector2(0,5);

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
