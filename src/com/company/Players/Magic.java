package com.company.Players;

import com.company.Boss;
import com.company.SuperAbility;

import java.util.Random;

public class Magic extends Hero {
    public Magic(int health, int damage) {
        super(health, damage, SuperAbility.BOOST);
    }

    @Override
    public void applySuperAbility(Hero[] heroes, Boss boss) {
        int available = new Random().nextInt(2);
        if(available == 1){
            for (int i = 0; i < heroes.length; i++) {
                if (!heroes[i].getClass().getSimpleName().equals("Medic")){
                    int randomHero = new Random().nextInt(heroes.length - 1);
                    int randomDamage = new Random().nextInt(13);
                    heroes[randomHero].setDamage(heroes[randomHero].getDamage()
                            + randomDamage);
                    System.out.println("Magical boosted " + heroes[randomHero].getClass().getSimpleName() + " on " + randomDamage);
                }
            }
        }
        else {
            System.out.println("Magical loosed his super ability.");
        }

    }
        }

