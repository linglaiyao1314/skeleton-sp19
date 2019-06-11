public class LinkedListDeque<T>{
    public class Node{
        public T elem;
        public Node next;
        public Node prev;

        public Node(){
            this.next = null;
            this.prev = null;
        }

        public Node(T e){
            this.elem = e;
            this.next = null;
            this.prev = null;
        }

        public Node(T e, Node n){
            this.elem = e;
            this.next = n;
            this.prev = null;
        }

        public Node(T e, Node n, Node p){
            this.elem = e;
            this.next = n;
            this.prev = p;
        }
    }


    private Node last;
    private Node sentinel;
    private int size;

    public LinkedListDeque(){
        sentinel = new Node();
        last = new Node();
        size = 0;
    }

    public T get(int index){
        if(index < 0 || index > size - 1){
            return null;
        }
        Node n = sentinel.next;
        while(index > 0){
            n = n.next;
            index -= 1;
        }
        return n.elem;
    }

    public void addFirst(T item){
        Node n = new Node(item, sentinel.next, null);
        if(sentinel.next != null){
            sentinel.next.prev = n;
        }
        sentinel.next = n;
        if(last.next == null){
            last.next = n;
        }
        size += 1;
    }

    public T removeFirst(){
        if(size == 0){
            return null;
        }
        Node n = sentinel.next;
        sentinel.next = n.next;
        if(size == 1){
            last.next = n.next;
        }else{
            sentinel.next.prev = null;
        }

        size -= 1;
        return n.elem;
    }

    public void addLast(T item){
        Node n = new Node(item, null, last.next);
        if(last.next != null){
            last.next.next = n;
        }
        last.next = n;
        if(sentinel.next == null){
            sentinel.next = n;
        }
        size += 1;
    }

    public T removeLast(){
        if(size == 0){
            return null;
        }
        Node n = last.next;
        last.next = n.prev;
        if(size == 1){
            sentinel.next = n.prev;
        }else{
            last.next.next = null;
        }
        size -= 1;
        return null;
    }


    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        Node p = sentinel;
        while (p.next != null){
            System.out.print(p.next.elem + " ");
            p = p.next;
        }
        System.out.println();
    }

    public static void main(String[] args){
        LinkedListDeque<Integer> intList = new LinkedListDeque<>();
        intList.addFirst(10);
        intList.addFirst(11);
        intList.addLast(20);
        intList.addLast(21);
        intList.addLast(22);
        intList.addLast(23);

        System.out.println(intList.get(0));
        System.out.println(intList.get(1));
        System.out.println(intList.get(2));
        System.out.println(intList.get(3));

        intList.printDeque();
        System.out.println("Start to remove");
        intList.removeFirst();
        intList.printDeque();
        intList.removeLast();
        intList.printDeque();
        intList.removeFirst();
        intList.printDeque();
        intList.removeFirst();
        intList.printDeque();
        intList.removeLast();
        intList.printDeque();
        intList.removeLast();
        intList.printDeque();
        System.out.println("====================");

    }


}