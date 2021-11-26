package com.company.Players;

import com.company.Boss;
import com.company.SuperAbility;

import java.util.Random;

public class Golem extends Hero{
    public Golem(int health, int damage) {
        super(health, damage, SuperAbility.SAVE_DAMAGE_AND_REVERT);
    }

    @Override
    public void applySuperAbility(Hero[] heroes, Boss boss) {
        int available = new Random().nextInt(2);
        if(available == 1){
            int bossDamage = boss.getDamage();
            boss.setHealth(boss.getDamage()- bossDamage);
            System.out.println("Golem reverted boss damage");
        }else {
            System.out.println("Golem loosed his super ability!");
        }
    }
}
