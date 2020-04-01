import java.util.Iterator;

public class ArraySet<T> implements Iterable<T> {

    private T[] items;
    private int size;

    private class ArraySetIterator implements Iterator<T>{
        private int wizPos;

        public ArraySetIterator(){
            wizPos = 0;
        }

        public boolean hasNext(){
            return wizPos < size;
        }

        public T next(){
            T returnItem = items[wizPos];
            wizPos += 1;
            return returnItem;
        }
    }

    public ArraySet(){
        items = (T[]) new Object[100];
        size = 0;
    }

    public boolean contains(T x){
        for(int i = 0; i < size; i += 1){
            if(items[i].equals(x)){
                return true;
            }
        }
        return false;
    }

    public void add(T x){
        if(x == null){
            throw new IllegalArgumentException("can't add null");
        }
        if(contains(x)){
            return;
        }
        items[size] = x;
        size += 1;
    }

    public int size(){
        return size;
    }

    public Iterator<T> iterator(){
        return new ArraySetIterator();
    }

    public String toString() {
        StringBuilder returnSB = new StringBuilder("{");
        for (int i = 0; i < size - 1; i += 1) {
            returnSB.append(items[i].toString());
            returnSB.append(", ");
        }
        returnSB.append(items[size - 1]);
        returnSB.append("}");
        return returnSB.toString();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (other.getClass() != this.getClass()) {
            return false;
        }
        ArraySet<T> o = (ArraySet<T>) other;
        if (o.size() != this.size()) {
            return false;
        }
        for (T item : this) {
            if (!o.contains(item)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ArraySet<Integer> aset = new ArraySet<>();
        aset.add(5);
        aset.add(23);
        aset.add(42);

        //iteration
        for (int i : aset) {
            System.out.println(i);
        }
    }
}
