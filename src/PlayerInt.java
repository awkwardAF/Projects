public interface PlayerInt {

    String getName ();

    boolean hasSword ();

    void attack(Player player, int a);

    void setName (String name);

    int getHP ();

    void heal ();

}