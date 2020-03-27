import java.util.LinkedList;
import java.util.List;

//
public class LinkedListDeque2<T> {
    public class ListNode {
        public T elem;
        public ListNode next;
        public ListNode prev;

        public ListNode(T elem, ListNode next, ListNode prev) {
            this.elem = elem;
            this.next = next;
            this.prev = prev;
        }
    }

    private ListNode sentinel;
    private int size;

    public LinkedListDeque2() {
        sentinel = new ListNode(null, null, null);
        size = 0;
    }

    public void addFirst(T item) {
        size += 1;
        ListNode newNode = new ListNode(item, null, null);
        if (isEmpty()) {
            newNode.next = newNode;
            newNode.prev = newNode;
            sentinel.next = newNode;
            return;
        }
//        ListNode firstNode = sentinel.next;
        // 两个节点连接起来
        newNode.next = sentinel.next;
        newNode.prev = sentinel.next.prev;
        sentinel.next.prev.next = newNode;
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
    }

    public void addLast(T item) {
        size += 1;
        if (sentinel.next == null) {
            addFirst(item);
            return;
        }
        ListNode newNode = new ListNode(item, null, null);
        newNode.prev = sentinel.next.prev;
        newNode.next = sentinel.next;
        sentinel.next.prev.next = newNode;
        sentinel.next.prev = newNode;
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        ListNode removedNode = sentinel.next;
        size -= 1;
        if (removedNode == removedNode.next) {
            sentinel.next = null;
            return removedNode.elem;
        }
        ListNode newFirstNode = removedNode.next;
        // 尾部节点连接新节点
        removedNode.prev.next = newFirstNode;
        // 新节点前置节点更新为待删除节点的前置节点
        newFirstNode.prev = removedNode.prev;
        // 哨兵节点指向新节点
        sentinel.next = newFirstNode;
        return removedNode.elem;
    }

    public T removeLast(){
        if (isEmpty()){
            return null;
        }
        size -= 1;
        if(sentinel.next == sentinel.next.next){
            T elem = sentinel.next.elem;
            sentinel.next = null;
            return elem;
        }
        ListNode removedNode = sentinel.next.prev;
        T elem = removedNode.elem;
        removedNode.prev.next = removedNode.next;
        removedNode.next.prev = removedNode.prev;
        return elem;
    }

    public T get(int index){
        if(index >= size){
            return null;
        }
        ListNode ptr = sentinel;
        while (index >= 0){
            ptr = ptr.next;
            index -= 1;
        }
        return ptr.elem;
    }

    public void printDeque() {
        ListNode start = sentinel.next;
        ListNode ptr = start;
        if (start == null) {
            System.out.println();
            return;
        }
        if (ptr.next == start) {
            System.out.println(ptr.elem);
            return;
        }
        StringBuilder sb = new StringBuilder(ptr.elem.toString() + ",");
        while (ptr.next != start) {
            sb.append(ptr.next.elem.toString()).append(",");
            ptr = ptr.next;
        }
        System.out.println(sb.substring(0, sb.length() - 1));
    }

    public boolean isEmpty() {
        return sentinel.next == null;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        LinkedListDeque2<Integer> intList = new LinkedListDeque2<>();
//        LinkedList<String> strList = new LinkedList<>();
//
//        strList.addFirst("123");
//        strList.addFirst("456");
//        strList.addFirst("789");
//        System.out.println(strList.size());
        intList.addFirst(1);
        intList.addFirst(3);
        intList.addFirst(2);
        intList.printDeque();
        intList.addLast(4);
        intList.addLast(5);
        intList.printDeque();
        intList.removeLast();
        intList.removeFirst();
        intList.printDeque();
        System.out.println(intList.get(0));
        System.out.println(intList.get(1));
        System.out.println(intList.get(2));


//        intList.addFirst(10);
//        intList.addFirst(11);
//        intList.addLast(20);
//        intList.addLast(21);
//        intList.addLast(22);
//        intList.addLast(23);
//
//        System.out.println(intList.get(0));
//        System.out.println(intList.get(1));
//        System.out.println(intList.get(2));
//        System.out.println(intList.get(3));
//
//        intList.printDeque();
//        System.out.println("Start to remove");
//        intList.removeFirst();
//        intList.printDeque();
//        intList.removeLast();
//        intList.printDeque();
//        intList.removeFirst();
//        intList.printDeque();
//        intList.removeFirst();
//        intList.printDeque();
//        intList.removeLast();
//        intList.printDeque();
//        intList.removeLast();
//        intList.printDeque();
//        System.out.println("====================");

    }


}