package com.company.Game;

import com.company.Boss;
import com.company.Players.Golem;
import com.company.Players.Hero;
import com.company.Players.Magic;
import com.company.Players.Warrior;

public class RPG_Game {
    private static int roundCounter = 1;
    public static void startGame(){
        Boss boss = new Boss(700,225);
         Golem golem = new Golem (620,68);
        Warrior warrior = new Warrior(660,63);
        Magic magic = new Magic(520,50);

        Hero heroes[] = {magic,warrior,golem,};
        printStatistics(heroes,boss);
        while (!isFinish(heroes, boss)){
            roundCounter++;
            round(heroes, boss);
        }
    }
    private static void printStatistics(Hero heroes[], Boss boss) {
        System.out.println("--------------------------------------");
        System.out.println("Round:" + roundCounter);
        System.out.println("Boss HP:" + boss.getHealth());
        for (Hero hero :
                heroes) {
            System.out.println(hero.getClass().getSimpleName() + " HP:" + hero.getHealth());
        }
        System.out.println("--------------------------------------");
    }
    private static void BossHit(Hero heroes[], Boss boss) {
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0) {
                hero.setHealth(hero.getHealth() - boss.getDamage());
            }
            if (hero.getHealth() <= 0) {
                hero.setHealth(0);
            }
        }
    }
    private static void heroesHits(Hero heroes[], Boss boss){
        for (Hero hero:
                heroes) {
            if (boss.getHealth()>0 && hero.getHealth()>0){
                boss.setHealth(boss.getHealth() - hero.getDamage());
            }
            if (boss.getHealth() <= 0) {
                boss.setHealth(0);
            }
        }
    }
    private static boolean isFinish(Hero heroes[], Boss boss){
        if (boss.getHealth()<=0){
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (Hero hero:
                heroes) {
            if (hero.getHealth()>0){
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead){
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }
    private static void round(Hero heroes[], Boss boss){
        if (boss.getHealth()>0){BossHit(heroes,boss);}

        heroesHits(heroes,boss);
        applyAbility(heroes,boss);
        printStatistics(heroes,boss);

    }
    private static void applyAbility(Hero heroes[], Boss boss){
        for (Hero hero:
                heroes) {
            if (hero.getHealth()>0){
                hero.applySuperAbility(heroes,boss);
            }
        }
    } }