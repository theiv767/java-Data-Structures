@SuppressWarnings("unchecked")
public class ChainList<E> {
    int cont = 0;
    private Node firstElement;
    private Node lastElement;


    ChainList() {
        firstElement = new Node(null);
        lastElement = firstElement.nextItem;
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
            currentElement = currentElement.nextItem;
            n++;
        }
        return (E) currentElement.value;

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
            currentElement = currentElement.nextItem;
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

    public void add(int index, E value) throws IndexOutOfBoundsException{
        if (index > this.cont)
            throw new IndexOutOfBoundsException("index out of bounds exception");

        this.cont++;
        Node adds = new Node(value);

        if (index == this.cont) {
            this.add(value);
            return;
        }
        if (index == 0){
            adds.nextItem = firstElement;
            firstElement = adds;
            return;
        }

        Node currentElement = firstElement;
        for(int i=0; i<index-1; i++){
            currentElement = currentElement.nextItem;

        }

        adds.nextItem = currentElement.nextItem;
        currentElement.nextItem = adds;

    }

    public void remove(int index) throws IndexOutOfBoundsException{
        if (index >= this.cont || index < 0)
            throw new IndexOutOfBoundsException("index out of bounds exception");

        this.cont--;
        if(index == 0){
            firstElement = firstElement.nextItem;
            return;
        }

        Node currentElement = firstElement;
        int n = 0;
        while (currentElement != lastElement) {
            if (n == index-1) {
                break;
            }
            currentElement = currentElement.nextItem;
            n++;
        }
        currentElement.nextItem = currentElement.nextItem.nextItem;

    }

    public void remove(E value){

        if(firstElement.value == value){
            firstElement = firstElement.nextItem;
            this.cont--;
            return;
        }

        Node currentElement = firstElement;

        while(!currentElement.nextItem.value.equals(value)){
            currentElement = currentElement.nextItem;
            if (currentElement.nextItem == null)
                return;

        }

        this.cont--;
        currentElement.nextItem = currentElement.nextItem.nextItem;
    }


    public int indexOf(E value) {
        Node currentElement = firstElement;
        int n = 0;
        while (currentElement.value != value) {
            n++;
            if (n >= this.cont) {
                return -1;
            }
            currentElement = currentElement.nextItem;
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
        if(this.indexOf(value) == -1)
            return false;

        return true;
    }


    // ------------------------
    
    private class Node {
        Object value;
        Node nextItem;

        Node(Object value) {
            this.value = value;
            nextItem = null;
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
