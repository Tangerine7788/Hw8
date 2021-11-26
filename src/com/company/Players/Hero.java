package com.company.Players;

import com.company.SuperAbility;

import java.lang.reflect.InvocationHandler;

public abstract class Hero extends GameEntity implements IHavingSuperAbility {

    private SuperAbility ability;

    public Hero(int health, int damage, SuperAbility ability) {
        super(health, damage);
        this.ability=ability;
    }
}
