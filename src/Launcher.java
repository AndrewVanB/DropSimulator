/**
 * Created by Andrew on 1/13/2017.
 */

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class Launcher {
    public static void main(String args[]) {
        Gson gson = new Gson();
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader("./data/json/zulrah.json"));
            Result result = gson.fromJson(br, Result.class);

            if(result != null) {
                int rand;
//                for (Item item : result.getItems()) {
//                    System.out.println("===================");
//                    System.out.println(item.getName());
//                    System.out.println("Quantity: " + item.getQuantity());
//                    System.out.println("1/" + item.getChance() + " chance.");
//                }
                /*
                 * Get chance, do formula to get drop chance percent
                  *
                 */
                rand = (int) Math.random() * 100;
                System.out.println(result.getItems().get(1).getName());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
