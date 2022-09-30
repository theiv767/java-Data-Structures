@SuppressWarnings("unchecked")
public class VectorList<E> implements List<E>{
    private Object[] elements;
    private int cont = 0;

    VectorList() {
        elements = new Object[10]; //standard initial lenght
    }

    VectorList(int n) {
        elements = new Object[n]; // initial lenght
    }

    /**
     * get item
     * @param index position
     * @return item
     */
    @Override
    public E get(int index) {
        return (E) this.elements[index];
    }

    /**
     * set item
     * @param index position
     * @param value new item value
     */
    @Override
    public void set(int index, E value) {
        this.elements[index] = value;
    }

    /**
     * Adds a new item to the list
     *
     * @param value new item
     */
    @Override
    public void add(E value) {
        if (cont == this.elements.length - 1) incrementSize();

        elements[cont] = value;
        cont++;
    }

    /**
     * adds an item to a position in the list
     *
     * @param index position
     * @param value new item
     */
    public void add(int index, E value) {
        if (cont == this.elements.length - 1) incrementSize();

        for (int i = cont; i > index; i--) {
            this.elements[i] = this.elements[i - 1];
        }

        this.elements[index] = value;
        cont++;
    }

    /**
     * removes a list item by position
     *
     * @param index position of the item that will be removed
     * @throws IndexOutOfBoundsException
     * @throws IllegalArgumentException
     */
    @Override
    public void remove(int index) throws IndexOutOfBoundsException, IllegalArgumentException {
        if (cont <= 0)
            throw new IllegalArgumentException("Illegal Argument Exception");

        if (index >= cont)
            throw new IndexOutOfBoundsException("index out of bounds");

        for (int i = index; i < cont; i++) {
            this.elements[i] = this.elements[i + 1];
        }
        cont--;
    }

    /**
     * removes a list item by value
     * @param value item value
     * @throws IllegalArgumentException
     */
    @Override
    public void remove(E value) throws IllegalArgumentException {
        if (cont <= 0)
            throw new IllegalArgumentException("Illegal Argument Exception");

        for (int i = 0; i < cont; i++) {
            if (this.elements[i].equals(value)) {
                for (int j = i; j < cont; j++) {
                    this.elements[j] = this.elements[j + 1];
                }
                cont--;
            }
        }
    }

    /**
     *  find the position of the item
     * @param value item to find position
     * @return item position or -1 if item does not exist
     */
    @Override
    public int indexOf(E value) {
        for (int i = 0; i < cont; i++) {
            if (this.elements[i].equals(value))
                return i;
        }
        return -1;
    }

    /**
     * checks to see if the item exists
     * @param value item
     * @return
     */
    @Override
    public boolean contains(E value) {
        if(indexOf(value) == -1)
            return false;

        return true;
    }

    /**
     * return length
     *
     * @return length
     */
    @Override
    public int size() {
        return cont;

    }

    /**
     * clear all positions from the VectorList
     */
    @Override
    public void clear() {
        cont = 0;
        this.elements = new Object[10];

    }




    //---------------------------
    private void incrementSize() {
        Object[] aux = new Object[(int) cont + (cont / 2)];
        for (int i = 0; i < cont; i++) {
            aux[i] = this.elements[i];
        }
        this.elements = aux;
    }

    @Override
    public String toString() {
        String elementsString = "[";
        for (int i = 0; i < cont; i++) {
            String adds = "";
            if (elements[i].getClass() == String.class) {
                adds += "\"";
                adds += this.elements[i];
                adds += "\"";
            } else {
                adds += this.elements[i] + "";
            }
            elementsString += (i == cont - 1) ? adds : adds + ", ";
        }
        elementsString += "]";
        return elementsString;
    }
}
