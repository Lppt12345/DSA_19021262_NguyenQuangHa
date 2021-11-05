package Week8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class BangTraCuu {
    public Map<String,Integer> data = new TreeMap<>();
    private static final String EV_PATH = "src/Week8/E_V.txt";
    private static final String SPLITTING_CHARACTERS = "<html";
    BangTraCuu(){}
    int count = 0;
    private void readFile(String filePath) {
        // put these line in try-catch block as BufferredReader dont throw error if the file is not exist.
        try {
            FileReader fis = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fis);
            String line;
            // read till end.
            while ((line = br.readLine()) != null) {
                // spliting each line into 2 part separated by html block.
                String[] parts = line.split(SPLITTING_CHARACTERS);
                String word = parts[0];
                if (data.containsKey(word)){
                    Integer value = data.get(word) + 1;
                    data.replace(word, value);
                    count++;
                }else{
                    data.put(word, 1);
                    count++;
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main (String [] args){
        BangTraCuu test = new BangTraCuu();
        test.readFile(EV_PATH);
        System.out.println(test.count);
        Set<String> allWord = test.data.keySet();
        int i = 1;
        for (String show : allWord){
            Integer count = test.data.get(show);
            System.out.println("No " + i + " | " + show + " |  xuat hien: " + count);
            i++;
        }
    }
}
