package Game;

import Cards.Structure.Card;
import Cards.Structure.Minion;
import Cards.Structure.Spell;
import Cards.Structure.Weapon;
import Game.Player.Player;
import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;

//TODO
// Reflections Library see here: https://github.com/ronmamo/reflections
public class CardLibrary extends java.util.Observable{


    //State
    private HashMap<String, Card> library;

    public CardLibrary() {
        library = initializeLibrary();
    }

    private HashMap<String, Card> initializeLibrary() {

        HashMap<String, Card> library = new HashMap<>();
        Player mockPlayer = new Player("Cards.Expansions.Classic.Neutral.Minions.AcidicSwampOoze", "Hunter", "Mock Player");
        ArrayList<Class> classesList = new ArrayList<>();
        Reflections reflections = new Reflections("Cards");

        classesList.addAll(reflections.getSubTypesOf(Minion.class));
        classesList.addAll(reflections.getSubTypesOf(Spell.class));
        classesList.addAll(reflections.getSubTypesOf(Weapon.class));
        System.out.println(classesList);
        for (Class cards: classesList) {
            Constructor constructor = null;//
            try {
                constructor = cards.getConstructor(Player.class);
                Object card1 = constructor.newInstance(mockPlayer);
                if (card1 instanceof Card) {
                    Card card2 = (Card) (card1);
                    library.put(card2.getName(), card2);
                }
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | InstantiationException e) {
                e.printStackTrace();
            }
        }
        return library;
    }

    public HashMap<String, Card> getLibrary() {
        return library;
    }


    public static void main(String[] args) {

        CardLibrary myLibrary = new CardLibrary();
        System.out.println(myLibrary.library.values());
    }
}
