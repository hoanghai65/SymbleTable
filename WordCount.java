import java.util.ArrayList;
import java.util.List;

public class WordCount<Key extends Comparable<Key>, Value> extends AbstractSymbleTable<Key,Value> {
    class Node {
        Node next;
        Key key;
        Value value;

        public Node(Key key, Value value) {
            next = null;
            this.key = key;
            this.value = value;
        }
    }

    Node list;
    Node rear;

    public WordCount(){
        list = null;
        rear = null;
    }

    @Override
    public void put(Key key, Value value) {
        // TODO Auto-generated method stub
        Node p = list;
        while (p != null) {
            if (key.equals(p.key)) {
                p.value = value;
                return;
            }
            p = p.next;
        }

        Node q = new Node(key, value);
        if (list == null) {
            list = q;
        } else {
            rear.next = q;
        }
        rear = q;

    }

    @Override
    public Value get(Key key) {
        // TODO Auto-generated method stub
        if (isEmpty()) {
            return null;
        }
        Node p = list;
        while (p != null) {
            if (p.key.equals(key)) {
                return p.value;
            }
            p = p.next;
        }
        return null;
    }

    @Override
    public void delete(Key key) {
        // TODO Auto-generated method stub
        if (isEmpty() || key == null) {
            return;
        }
        if (key.equals(list.key)) {
            list = list.next;
        } else {
            Node p = list;
            while (p != null) {
                if (key.equals(p.next.key)) {
                    super.delete(key);
                    p.next = p.next.next;
                    return;
                }
                p = p.next;
            }
        }
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        int count = 0;
        Node p = list;
        while (p != null) {
            if (p.value != null) {
                count++;
            }
            p = p.next;
        }
        return count;
    }

    @Override
    public boolean constain(Key key) {
        // TODO Auto-generated method stub
        if (isEmpty()) {
            return false;
        }
        Node p = list;
        while (p != null) {
            if (key.equals(p.key)) {
                return true;
            }
            p = p.next;
        }
        return false;
    }

    @Override
    public Iterable<Key> Keys() {
        // TODO Auto-generated method stub
        List<Key> temp = new ArrayList<>();
        Node p = list;
        while (p != null) {
            temp.add(p.key);
            p = p.next;
        }
        return temp;
    }
}
