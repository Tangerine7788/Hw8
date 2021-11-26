package com.company.Players;

import com.company.Boss;
import com.company.SuperAbility;

import java.util.Random;

public class Warrior extends Hero{
    public Warrior(int health, int damage) {
        super(health, damage, SuperAbility.CRITICAL_DAMAGE);
    }

    @Override
    public void applySuperAbility(Hero[] heroes, Boss boss) {
        int available = new Random().nextInt(2);
        if(available == 1){
            int randomDamage = new Random().nextInt(2+2);
            setDamage(getDamage()+randomDamage);
            System.out.println("Warrior's damage upped for"+randomDamage);
        }else {
            System.out.println("Warrior loosed his super ability!");
        }
    }
}
