package Week7;

import java.util.NoSuchElementException;

public class PriorityQueue {

    private int[] innerArray;
    private int size;

    public PriorityQueue() {
        this.innerArray = new int[10];
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
    // Gia su uu tien la so be hon len dau
    public void insert(int x) {
        if (size == 0) {
            size++;
            innerArray[0] = x;
            return;
        }
        if (size() == innerArray.length){
            doubleArray();
        }
        int temp = x;
        for (int i = 0; i < size; i++) {
            // Tim vi tri chen
            if (x <= innerArray[i]) {
                int next;
                temp = innerArray[i];
                innerArray[i] = x;
                // Dich chuyen cac phan tu
                while (i < size - 1) {
                    next = innerArray[i + 1];
                    innerArray[i + 1] = temp;
                    temp = next;
                    i++;
                }
                break;
            }
        }
        innerArray[size] = temp;
        size++;
    }

    public int deleteMin() {
        if (isEmpty())
            throw new NoSuchElementException("The queue is empty");

        // Luu du lieu
        int retValue = innerArray[0];
        // Day cac phan tu khac len dau
        for (int i = 1; i < size; i++) {
            innerArray[i - 1] = innerArray[i];
        }

        innerArray[size - 1] = 0;
        size--;
        return retValue;
    }

    public int peek() {
        if (isEmpty())
            throw new NoSuchElementException("The queue is empty");
        return innerArray[0];
    }
    // kiem tra xem so do co trong hang doi ko
    public boolean contains(int x) {
        if (isEmpty())
            return false;
        for (int i = 0; i < size; i++) {
            if (innerArray[i] == x)
                return true;
        }
        return false;
    }



    private void doubleArray() {
        int[] newArr = new int[innerArray.length * 2];

        for(int i = 0; i < innerArray.length; i++) {
            newArr[i] = innerArray[i];
        }

        innerArray = newArr;
    }
}
