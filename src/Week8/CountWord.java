package Week8;

import java.util.*;

public class CountWord {
    CountWord(){}
    public void read(){
        List <String> arr = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while (true){
            String st = sc.nextLine();
            if (st.equals("STOP")){
                break;
            }
            arr.add(st);
        }
        Collections.sort(arr);
        int N = arr.size();
        int i = 0;
        int No = 0;
        while (i < N){
            int count = 1;
            int j = i +1;
            for (;j< N;j++){
                if (arr.get(j).equals(arr.get(i))){
                    count ++;
                }else{
                    break;
                }
            }
            System.out.println("No " + No + " | " + arr.get(i) + " | xuat hien: " + count);
            No ++;
            i = j;
        }
    }

    public static void main (String [] args){
        CountWord test = new CountWord();
        test.read();
    }
}
