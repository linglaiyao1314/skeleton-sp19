public class ArrayDeque<Item> {
    private Item []items;
    private int size;
    private int nextLast;
    private int nextFirst;

    public ArrayDeque(){
        items = (Item []) new Object[1000];
        size = 0;
        nextLast = items.length / 2;
        nextFirst = nextLast - 1;
    }

    public void addFirst(Item item){
        resize();
        size += 1;
        items[nextFirst] = item;
        nextFirst = (nextFirst - 1 + items.length) % items.length;
    }

    public Item removeFirst(){
        if(size == 0){
            return null;
        }else {
            nextFirst = (nextFirst + 1) % items.length;
            Item item = items[nextFirst];
            items[nextFirst] = null;
            size -= 1;
            resize();
            return item;
        }
    }

    public Item removeLast(){
        if(size == 0){
            return null;
        }else {
            nextLast = (nextLast - 1) % items.length;
            Item item = items[nextLast];
            items[nextLast] = null;
            size -= 1;
            resize();
            return item;
        }
    }

    public boolean isEmpty(){
        return size == 0;
    }
    public int size(){
        return size;
    }

    public void addLast(Item item){
        resize();
        size += 1;
        items[nextLast] = item;
        nextLast = (nextLast + 1 + items.length) % items.length;
    }

    /** 扩容与缩容 */
    public void resize(){
        if(size > items.length - 1){
            Item []newitems =  (Item []) new Object[size * 2];
            for(int i=0; i < size; i++){
                newitems[i] = this.get(i);
            }
            items = newitems;
            nextFirst = items.length - 1;
            nextLast = size;
        }else{
            double factor = (double)size / (double) items.length;
            if(factor <= 0.25){
                Item[] newitems = (Item[]) new Object[size * 2 + 2];
                for(int i=0; i < size; i++){
                    newitems[i] = this.get(i);
                }
                items = newitems;
                nextFirst = items.length - 1;
                nextLast = size;
            }
        }
    }

    public Item get(int index){
        if(index >= size){
            return null;
        }
        return items[(nextFirst + 1 + index) % items.length];
    }

    public void printDeque(){
        for(int i=0; i< size; i++){
            System.out.print(get(i));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        ad.addFirst(4);
        ad.addFirst(3);
        ad.addFirst(2);
        ad.addFirst(1);
        ad.printDeque();
        ad.addLast(5);
        ad.addLast(6);
        ad.addLast(7);
        ad.addLast(8);
        ad.addLast(9);
        ad.printDeque();
        ad.addFirst(0);
        ad.addFirst(-1);
        ad.printDeque();
        ad.removeFirst();
        ad.removeFirst();
        ad.removeLast();
        ad.removeLast();
        ad.printDeque();

    }

}
