@SuppressWarnings("unchecked")
public class ChainList<E> {
    int cont = 0;
    Node firstElement;
    Node lastElement;


    ChainList() {
        firstElement = new Node(null);
        lastElement = firstElement.getNextItem();
    }


    public E get(int index) throws IndexOutOfBoundsException {
        if (index >= this.cont || index < 0)
            throw new IndexOutOfBoundsException("index out of bounds exception");

        Node currentElement = firstElement;
        int n = 0;
        while (currentElement != lastElement) {
            if (n == index) {
                break;
            }
            currentElement = currentElement.getNextItem();
            n++;
        }
        return (E) currentElement.getValue();

    }

    public void set(int index, E value) throws IndexOutOfBoundsException{
        if (index >= this.cont || index < 0)
            throw new IndexOutOfBoundsException("index out of bounds exception");

        Node currentElement = firstElement;
        int n = 0;
        while (currentElement != lastElement) {
            if (n == index) {
                break;
            }
            currentElement = currentElement.getNextItem();
            n++;
        }
        currentElement.value = value;

    }

    public void add(E value) {
        Node adds = new Node(value);

        if (firstElement.value == null) {
            firstElement = adds;
            lastElement = firstElement;
        } else {
            lastElement.nextItem = adds;
            lastElement = adds;
        }
        this.cont++;

    }

    public void remove(int index) throws IndexOutOfBoundsException{
        if (index >= this.cont || index < 0)
            throw new IndexOutOfBoundsException("index out of bounds exception");

        if(index == 0){
            firstElement = firstElement.getNextItem();
            return;
        }

        Node currentElement = firstElement;
        int n = 0;
        while (currentElement != lastElement) {
            if (n == index-1) {
                break;
            }
            currentElement = currentElement.getNextItem();
            n++;
        }
        currentElement.nextItem = currentElement.getNextItem().getNextItem();
        this.cont--;
    }


    public int indexOf(E value) {
        Node currentElement = firstElement;
        int n = 0;
        while (currentElement.getValue() != value) {
            currentElement = currentElement.getNextItem();
            n++;
            if (n >= cont) {
                return -1;
            }
        }
        return n;
    }

    public void clear(){
        this.cont = 0;
        firstElement = null;
        lastElement = firstElement;

    }

    public int size(){
        return this.cont;
    }

    public boolean contains(E value){
        Node currentElement = firstElement;
        for(int i=0; i<this.cont-1; i++){

            if(currentElement.getValue().equals(value)) {
                return true;
            }
            currentElement = currentElement.getNextItem();

        }

        return false;
    }


    // aux ------------------------
    class Node {
        private Object value;
        private Node nextItem;

        Node(Object value) {
            this.value = value;
            nextItem = null;
        }

        public E getValue() {
            return (E)value;
        }

        public Node getNextItem() {
            return nextItem;
        }

        @Override
        public String toString() {
            return this.value + "";
        }
    }

    @Override
    public String toString() {
        String showString = "[";
        Node i = firstElement;
        while (i != null) {
            String adds = "";
            if (i.getValue().getClass() == String.class) {
                adds += "\"";
                adds += i;
                adds += "\"";
            } else {
                adds += i + "";
            }

            showString += (i.getNextItem() != null) ? adds + ", " : adds + "";
            i = i.getNextItem();
        }
        showString += "]";
        return showString;
    }
}
