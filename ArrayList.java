import java.util.Arrays;

public class ArrayList implements List {

    Object[] arr;
    int size = 0;

    void growArray(){
        Object[] grown = new Object[arr.length * 2];
        for (int i = 0; i < size; i++){
            grown[i] = arr[i];
        }

        arr = grown;
    }

    public ArrayList(){
        arr = new Object[10];
    }

    public ArrayList(int size){
        arr = new Object[size];
    }

    @Override
    public void add(Object obj) {
        if(size == arr.length){
            growArray();
        }

        arr[size] = obj;
        size++;
    }

    @Override
    public void add(int pos, Object obj) {
        /*
        if(pos > size-1){
            throw new Exception();
        }
        */
        if (size + 1 > arr.length){
            growArray();
        }

        for(int i = size; i > pos; i--){
            arr[i+1] = arr[i];
        }
        arr[pos] = obj;
        size++;
    }

    @Override
    public Object get(int pos) {
        if(pos < size){
            return arr[pos];
        }

        return null;
    }

    @Override
    public Object remove(int pos) {
        /*
        if (pos >= size  || pos < 0){
            throw new Exception();
        }*/
        Object temp = arr[pos];
        for (int i = pos; i < size-1; i ++){
            arr[i] = arr[i+1];
        }
        size--;
        return temp;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString(){
        Object[] out = new Object[size];
        for (int i = 0; i < size; i ++ ){
            out[i] = arr[i];
        }
        return(Arrays.toString(out));
    }

    public static void main(String args[]){

        ArrayList a = new ArrayList(1);
        a.add(2);
        a.add(2);
        a.add(2);
        a.add(2);
        a.add(2);
        System.out.println(a);



    }
}
