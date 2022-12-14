@SuppressWarnings("unchecked")
public class OrdenedChainList<E extends Comparable<E>> implements List<E>{
    private int cont = 0;
    private Node firstElement;
    private Node lastElement;


    OrdenedChainList() {
        firstElement = null;
        lastElement = firstElement;
    }

    /**
     * get item
     * @param index position
     * @return item
     */
    @Override
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

    /**
     * set item
     * @param index position
     * @param value new item value
     */
    @Override
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

    /**
     * Adds a new item to the list
     *
     * @param value new item
     */
    @Override
    public void add(E value) {
        Node adds = new Node(value);

        if (firstElement == null) {
            firstElement = adds;
            lastElement = firstElement;
        } else if(firstElement.value.compareTo(value) >= 0) { //adds antes do primeiro elemento
            adds.nextItem = firstElement;
            firstElement = adds;
        }else if(lastElement.value.compareTo(value) <= 0){
            lastElement.nextItem = adds;
            lastElement = adds;
        }else{
            Node currentElement = firstElement;
            for(int i=0; i<cont-1; i++){
                if(currentElement.nextItem.value.compareTo(value) >= 0){
                    adds.nextItem = currentElement.nextItem;
                    currentElement.nextItem = adds;
                    break;
                }
                currentElement = currentElement.nextItem;
            }
        }

        this.cont++;

    }

    /**
     * removes a list item by position
     *
     * @param index position of the item that will be removed
     * @throws IndexOutOfBoundsException
     */
    @Override
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

    /**
     * removes a list item by value
     * @param value item value
     */
    @Override
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

    /**
     *  find the position of the item
     * @param value item to find position
     * @return item position or -1 if item does not exist
     */
    @Override
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

    /**
     * checks to see if the item exists
     * @param value item
     * @return
     */
    @Override
    public boolean contains(E value){
        if(this.indexOf(value) == -1)
            return false;

        return true;
    }

    /**
     * return length
     *
     * @return length
     */
    @Override
    public int size(){
        return this.cont;
    }

    /**
     * clear all positions from the ChainList
     */
    @Override
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
