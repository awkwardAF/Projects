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
        System.out.println("Добро пожаловать в игру, в которой правит Госпожа удача! (пока что только она, ");
        System.out.println("но игра будет разрабатываться и далее).");
        System.out.println(ANSI_RED + "Правила:" + ANSI_RESET);
        System.out.println("Ты пошел в пещеру в поисках сокровища, но вот незадача: оказывается, что в этой пещере ты не один ");
        System.out.println("Есть только один выход из этой ситуации - " + ANSI_RED + "драться до конца" + ANSI_RESET + ", чтобы забрать все золото.");
        System.out.println("У каждого из вас по " + player1.getHP() + " жизней и обычный меч.");
        System.out.println("Вам нужно, поочередно нанося друг другу удары (в игре), убить своего соперника до нуля");
        System.out.println("Вы сами выбираете, насколько сильно вы хотите его ударить.");
        System.out.println("Итак, сила удара может быть от 1 до 9 включительно");
        System.out.println("Но учтите, чем сильнее вы бьете, тем больше шанс промахнуться!");
        System.out.println("Вместо удара по сопернику вы можете отправиться в поиски " + ANSI_RED + "Счастливого Меча." + ANSI_RESET);
        System.out.println("Для этого во время вашего хода нужно прописать " + ANSI_RED + "\"99\"" + ANSI_RESET);
        System.out.println("Меч позволяет вам в случае промаха после первого удара нанести второй с той же силой, что и первый");
        System.out.println("Раздайте вашим персонажам имена! Как хочет звать своего персонажа " + ANSI_RED + "первый игрок?" + ANSI_RESET);
        Scanner sc = new Scanner(System.in);
        a = sc.nextLine();
        player1.setName(a);
        System.out.println("Как насчет второго игрока?");
        a = sc.nextLine();
        player2.setName(a);
        System.out.println("В борьбу вступают " + player1.getName() + " и " + player2.getName() + ". Запасайтесь попкорнами, будет жарко!");
        System.out.println("Бросаем монетку, чтобы определить, за кем первый ход. Орёл - " + player1.getName()+ ", решка - " +player2.getName());
        flip();
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
        System.out.println(ANSI_GREEN + "Game was created and designed by Azat Valiev. ver. 0.2.3 BETA" );

    }


    // определяет чей ход
    public static boolean turn() {
        if (count % 2 == 0) {
            count++;
            return true;
        }
        else count++; return false;
    }

    public static void flip() {
        if (Math.random() > 0.5) {
            count++;
            System.out.println(ANSI_RED + "Решка!" + ANSI_RESET);
        } else System.out.println(ANSI_RED + "Орёл!" + ANSI_RESET);
    }

}
