package Game;

import Cards.Structure.Card;
import org.reflections.Reflections;

import java.util.HashMap;

//TODO
public class CardLibrary extends java.util.Observable{

    //State
    private HashMap<String, Card> library;

    public CardLibrary() {
        library = initializeLibrary();
    }

    private HashMap<String, Card> initializeLibrary() {

        HashMap<String, Card> library = new HashMap<>();
        // From Reflections Library see here: https://github.com/ronmamo/reflections
        Reflections reflection = new Reflections("Cards");
        System.out.println(reflection.getSubTypesOf(Card.class));
        return library;
    }

    public static void main(String[] args) {

        CardLibrary myLibrary = new CardLibrary();
    }
}
