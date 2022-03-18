import java.util.HashMap;

/*
Given two singly linked lists that intersect at some point,find the
intersecting node. Assume the lists are non-cyclical.

For example, given A = 3 ➔ 7 ➔ 8 ➔ 10 and B = 99 ➔ 1 ➔ 8 ➔ 10,
return the node with value 8. In this example, assume nodes with the
same value are the exact same node objects.

Do this in 0( m + n) time (where m and n are the lengths of the lists)
and constant space.
*/
public class MyLinkedList<T> {

    static class MyNode<T> {
        T value = null;
        MyNode<T> next;

        MyNode(T value) {
            this.value = value;
            this.next = null;
        }
    }

    private MyNode<T> head = null;
    private int size = 0;

    public int size() {
        return this.size;
    }

    public void add(MyNode<T> node) {
        if (this.head != null) {
            MyNode<T> aux = this.head;
            int auxS = this.size - 1;
            while (aux.next != null && auxS > 0) {
                aux = aux.next;
                auxS--;
            }
            aux.next = node;
        } else {
            this.head = node;
        }
        this.size++;
        // System.out.println("Added value("+node.value+"), size: "+this.size);
    }

    public static MyNode<Integer> findIntersectingNode(MyLinkedList<Integer> listA,
            MyLinkedList<Integer> listB) {
        MyNode<Integer> answer = new MyNode<>(-1);
        HashMap<Integer, MyNode<Integer>> map = new HashMap<>();
        MyNode<Integer> auxA = listA.head;
        for (int i = 0; i < listA.size(); i++) {
            map.put(auxA.value, auxA);
            auxA = auxA.next;
        }
        MyNode<Integer> auxB = listB.head;
        for (int i = 0; i < listB.size(); i++) {
            if(!map.containsKey(auxB.value))
                map.put(auxB.value, auxB);
            else{
                answer = auxB;
                break;
            }
            auxB = auxB.next;
        }
        
        return answer;
    }

    @Override
    public String toString() {
        String answer = "List: ";
        MyNode aux = this.head;
        for (int i = 0; i < this.size; i++) {
            if (i == this.size - 1) {
                answer += aux.value;
                break;
            } else
                answer += aux.value + ", ";
            aux = aux.next;
        }
        return answer;
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> listA = new MyLinkedList<>();
        MyLinkedList<Integer> listB = new MyLinkedList<>();

        MyNode<Integer> n1 = new MyNode<>(1);
        MyNode<Integer> n3 = new MyNode<>(3);
        MyNode<Integer> n7 = new MyNode<>(7);
        MyNode<Integer> n8 = new MyNode<>(8);
        MyNode<Integer> n10 = new MyNode<>(10);
        MyNode<Integer> n99 = new MyNode<>(99);
        MyNode<Integer> n2 = new MyNode<>(2);

        listA.add(n3);
        listA.add(n7);
        listA.add(n8);
        listA.add(n10);

        listB.add(n99);
        listB.add(n1);
        listB.add(n8);
        listB.add(n10);

        // System.out.println(listA.toString());
        // System.out.println(listB.toString());

        MyNode<Integer> answer = findIntersectingNode(listA, listB);
        System.out.println(answer.value);
    }

}
