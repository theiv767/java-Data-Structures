@SuppressWarnings("unchecked")
public class DinamicQueue<E> {
    private int cont = 0;
    private Node firstElement;
    private Node lastElement;

    DinamicQueue() {
        firstElement = null;
        lastElement = firstElement;
    }

    public void queue(E value) {
        Node adds = new Node(value);

        if (firstElement == null) {
            firstElement = adds;
            lastElement = firstElement;
        } else {
            lastElement.nextItem = adds;
            lastElement = adds;
        }
        this.cont++;

    }

    public E dequeue(){
        E aux = (E)firstElement.value;
        firstElement = firstElement.nextItem;
        return aux;
    }

    public E peek(){
        return (E)firstElement.value;
    }

    public boolean isEmpty(){
        if (cont==0)
            return true;

        return false;
    }

    public int indexOf(E value) {
        if(firstElement==null){
            return -1;
        }
        Node currentElement = firstElement;
        int n = 0;
        while (!currentElement.value.equals(value)) {
            n++;
            if (n >= this.cont) {
                return -1;
            }
            currentElement = currentElement.nextItem;
        }
        return n;
    }

    public boolean contains(E value){
        if(this.indexOf(value) == -1)
            return false;

        return true;
    }

    public int size(){
        return this.cont;
    }

    public void clear(){
        this.cont = 0;
        firstElement = null;
        lastElement = firstElement;

    }

    // ------------------------

    private class Node {
        E value;
        Node nextItem;

        Node(E value) {
            this.value = value;
            nextItem = null;
        }

        public String toString() {
            return this.value + "";
        }
    }

    public String toString() {
        String showString = "[";
        Node i = firstElement;
        while (i != null) {
            String adds = "";
            if (i.value.getClass() == String.class) {
                adds += "\"";
                adds += i;
                adds += "\"";
            } else {
                adds += i + "";
            }

            showString += (i.nextItem != null) ? adds + ", " : adds + "";
            i = i.nextItem;
        }
        showString += "]";
        return showString;
    }
}
