package ru.geekbrains.pool;

import ru.geekbrains.base.SpritesPool;
import ru.geekbrains.sprite.Bullet;

public class BulletPool extends SpritesPool<Bullet> {
    private ExplosionPool explosionPool;

    public BulletPool(ExplosionPool explosionPool){
        this.explosionPool = explosionPool;
    }

    @Override
    protected Bullet newObject() {
        return new Bullet(explosionPool);
    }
}
