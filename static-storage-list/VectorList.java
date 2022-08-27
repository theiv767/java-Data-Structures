public class VectorList {
    private Object[] elements;
    private int cont = 0;

    VectorList() {
        elements = new Object[10]; //standard initial lenght
    }

    VectorList(int n) {
        elements = new Object[n]; // initial lenght
    }


    /**
     * Adds a new item to the list
     *
     * @param value new item
     */
    public void add(int value) {
        if (cont == this.elements.length - 1) incrementSize();

        elements[cont] = value;
        cont++;
    }


    /**
     * removes an item from de list
     *
     * @param index position of the item that will be removed
     * @throws IndexOutOfBoundsException
     * @throws IllegalArgumentException
     */
    public void remove(int index) throws IndexOutOfBoundsException, IllegalArgumentException {
        if (cont <= 0)
            throw new IllegalArgumentException("Illegal Argument Exception");

        if (index <= cont)
            throw new IndexOutOfBoundsException("index out of bounds");

        cont--;
        for (int i = index; i < cont; i++) {
            this.elements[i] = this.elements[i + 1];
        }
    }


    /**
     * clear all positions from the VectorList
     */
    public void clearAll() {
        cont = 0;
        this.elements = new Object[10];

    }


    //---------------------------
    private void incrementSize() {
        Object[] aux = new Object[cont + (cont / 2)];
        for (int i = 0; i < cont; i++) {
            aux[i] = this.elements[i];
        }
        this.elements = aux;
    }

    @Override
    public String toString() {
        String elementsString = "[";
        for (int i = 0; i < cont; i++)
            elementsString += (i == cont - 1) ? this.elements[i] : this.elements[i] + ", ";

        elementsString += "]";
        return elementsString;
    }
}

