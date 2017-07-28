package Utility.UtilityMethods;

import Game.BoardState;
import Game.Player.Player;

import java.io.*;

/**
 * Created by Cheech on 3/25/2017.
 */
public class UtilityMethods {

    public UtilityMethods() {}

    public static String fileParser(String fileName) {
        File file = new File(fileName);
        StringBuffer stringBuffer = new StringBuffer();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line);
                stringBuffer.append(" ");
            }
            fileReader.close();
            //System.out.println("Contents of file:");
            //System.out.println(stringBuffer.toString());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuffer.toString();
    }

    public static Player findEnemy(BoardState board, Player player) {
        if (board.getP1().equals(player)) {
            return board.getP1();
        }
        else return board.getP2();
    }
}
