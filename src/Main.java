import java.util.Scanner;

public class Main {

    private static int count = 0;
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {
        String a;
        PlayerInt player1 = new Player();
        PlayerInt player2 = new Player();
        System.out.println("Добро пожаловать в игру, в которой правит Госпожа удача! (пока что только она, но игра будет разрабатываться и далее) ");
        System.out.println(ANSI_RED + "Правила:" + ANSI_RESET);
        System.out.println("Цель этой игры проста: вам нужно победить");
        System.out.println("У каждого из вас по " + player1.getHP() + " жизней ");
        System.out.println("Вам нужно поочередно, нанося друг другу удары (в игре), опустить жизни своего соперника до нуля");
        System.out.println("Вы сами выбираете, насколько сильно вы хотите его ударить.");
        System.out.println("Итак, сила удара может быть от 1 до 9 включительно");
        System.out.println("Но учтите, чем сильнее вы бьете, тем больше шанс промахнуться!");
        System.out.println("Раздайте вашим персонажам имена! Как хочет звать своего персонажа первый игрок?");
        Scanner sc = new Scanner(System.in);
        a = sc.nextLine();
        player1.setName(a);
        System.out.println("Как насчет второго игрока?");
        a = sc.nextLine();
        player2.setName(a);
        System.out.println("В борьбу вступают " + player1.getName() + " и " + player2.getName() + ". Запасайтесь попкорнами, будет жарко!");
        System.out.println("Бросаем монетку, чтобы определить, за кем первый ход. Орёл - " + player1.getName()+ ", решка - " +player2.getName());
        if (Math.random() > 0.5) {
            count++;
            System.out.println("Решка!");
        }
        else System.out.println("Орёл!");
        while (player1.getHP() > 0 && player2.getHP() > 0) {
            if (turn()){
                System.out.println("Ходит " + ANSI_RED + player1.getName() + ANSI_RESET + ". Введи силу удара!");
                player1.attack((Player) player2, sc.nextInt());
            }
            else {
                System.out.println("Ходит " + ANSI_RED + player2.getName() + ANSI_RESET + ". Введи силу удара!");
                player2.attack((Player) player1, sc.nextInt());
            }
        }
        System.out.println("-----------------------------------");
        if (player1.getHP() < 1) {
            System.out.println("Победа за " + player2.getName() + ". Апплодисменты!");
            System.out.println(player1.getName() + " терпит поражение :(");
        }
        else {
            System.out.println(ANSI_RED + player1.getName() + " одерживает победу в этой схватке. Апплодисменты!" + ANSI_RESET);
            System.out.println(player2.getName() + " терпит поражение :(");
        }
        System.out.println(ANSI_GREEN + "Game was created and designed by Azat Valiev. ver. 1.0" );

    }

    public static boolean turn() {
        if (count % 2 == 0) {
            count++;
            return true;
        }
        else count++; return false;
    }
}
