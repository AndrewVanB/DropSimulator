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
                System.out.println("NPC: Zulrah");
                System.out.println("Total items in list: "+result.getItems().size()+"\n");
                int count = 0;
                for(int i = 0; i<4; i++) {
                    count++;
                    rand = (int) (Math.random() * result.getItems().size());
                    System.out.println("Item ID: "+rand);
                    System.out.println(result.getItems().get(rand).getName());
                    System.out.println();
                }
                System.out.println("Randomized "+count+" items.");
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
