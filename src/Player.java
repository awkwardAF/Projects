import java.util.Scanner;

import static java.lang.Math.random;

public class Player implements PlayerInt {

    Scanner sc = new Scanner(System.in);
    int hp = 30;
    String name = null;
    boolean sword = false;

    @Override
    public String getName() {
        return name;
    }

    public void searchSword () {
        if (Math.random() > 0.75) {
            System.out.println("Вы нашли счастливый меч!");
            sword = true;
        }
        else System.out.println("Меч найти не удалось");
    }

    @Override
    public boolean hasSword() {
        return sword;
    }

    @Override
    public void attack(Player player, int a) {
        if (a == 99) {
            if (hasSword()) {
                System.out.println("У тебя уже есть меч, зачем тебе второй?");
                System.out.println("Лучше нанеси им удар!");
                a = sc.nextInt();
            }
            else {
                searchSword();
                return;
            }
        }
        if (action(a)) {
            player.hp = player.getHP() - a;
            System.out.println("У игрока " + player.getName() + " теперь " + player.getHP() + " жизней");
        } else {
            System.out.println("У игрока " + player.getName() + " по прежнему " + player.getHP() + " жизней");
        }
    }

    @Override
    public void setName(String newName) {
        name = newName;
    }

    @Override
    public int getHP() {
        return hp;
    }

    @Override
    public void heal() {

    }

    private boolean action(int a) {
        String b = "0." + a;
        if (random() > Double.valueOf(b)) {
            System.out.println("Удар успешно нанесен!");
            return true;
        }
        if (hasSword()) {
            if (random() > Double.valueOf(b)) {
                System.out.println("Вы попали благодаря мечу");
                return true;
            }
        }
        System.out.println("Вы промахнулись");
        return false;
    }
}
