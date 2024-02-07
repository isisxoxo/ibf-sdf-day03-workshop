package sg.edu.nus.iss;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class ShoppingCart {
    private static HashSet<String> contents = new HashSet<>(); // Needs to be static to keep data (if not it will
                                                               // instantiate every single time)
    private String username;

    // Constructor
    public ShoppingCart(String username) {
        this.username = username;
    }

    // Getters and Setters
    public List<String> getContets() {
        List<String> list = new LinkedList<String>(contents);
        return list;
    }

    // public static void setContents(HashSet<String> contents) {
    // ShoppingCart.contents = contents;
    // }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Other Methods
    public void add(String item) {
        if (this.contents.contains(item))
            return;
        this.contents.add(item);
    }

    public void remove(int index) {
        if (index < contents.size())
            contents.remove(index);
    }

    public void load(InputStream is) throws IOException {
        String item;
        InputStreamReader reader = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(reader);
        while ((item = br.readLine()) != null) {
            contents.add(item);
        }
        br.close();
        reader.close();
    }

    public void save(OutputStream os) {
        OutputStreamWriter writer = new OutputStreamWriter(os);
        BufferedWriter bw = new BufferedWriter(writer);
        try {
            for (String item : contents) {
                try {
                    bw.write(item);
                    bw.newLine();
                } catch (IOException e) { // Can use catch (Exception e) too if want something more generic
                    e.printStackTrace();
                }
            }
        } finally {
            try {
                writer.flush();
                bw.flush();
                writer.close();
                bw.close();
            } catch (IOException e) { // Can use catch (Exception e) too if want something more generic
                e.printStackTrace();
            }
        }
    }
}
