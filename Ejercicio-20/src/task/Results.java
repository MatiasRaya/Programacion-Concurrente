package task;

//En esta clase se van almacenando los datos que se obtienen
public class Results {
    private int data[];

    public Results (int size) {
        data = new int[size];
    }

    public void setData(int position, int value) {
        data[position] = value;
    }

    public int[] getData() {
        return data;
    }
}
