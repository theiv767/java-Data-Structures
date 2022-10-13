@SuppressWarnings("unchecked")
public class StaticQueue <E>{
    private final int STANDART_LENGHT = 10;
    private int size = 0;
    private int firstIndex = 0;
    private int lastIndex = 0;
    Object[] elements;
    StaticQueue(){
        this.elements = new Object[STANDART_LENGHT];
    }
    StaticQueue(int initLenght){
        this.elements = new Object[initLenght];
    }

    public void queue(E value){
        if(isEmpty()) {
            size++;
            this.elements[0] = value;
            return;
        }
        if(lastIndex+1 == firstIndex)
            incrementSize();

        try{
            lastIndex++;
            elements[lastIndex] = value;
        }catch (ArrayIndexOutOfBoundsException e){
            if(firstIndex > 0){
                lastIndex = 0;
                elements[lastIndex] = value;
            }else{
                lastIndex--; //retornando a posição correta para aumentar o tamanho corretamente
                incrementSize();
                lastIndex++;
                elements[lastIndex] = value;
            }
        }
        size++;

    }

    public E dequeue(){
        if(!isEmpty()){
            if(firstIndex == lastIndex){
                E aux = (E)this.elements[firstIndex];
                clear();
                return aux;
            }
            size--;
            firstIndex++;
            return (E)this.elements[firstIndex-1];
        }
        return null;
    }

    public E peek(){
        if(isEmpty())
            return null;

        return (E)this.elements[firstIndex];
    }

    public boolean isEmpty(){
        if(size==0)
            return true;

        return false;
    }

    public int size(){
        return this.size;
    }

    public void clear() {
        firstIndex = 0;
        lastIndex = 0;
        size = 0;
        this.elements = new Object[STANDART_LENGHT];

    }

    //------------------------------------
    public void incrementSize() {
        Object[] aux = new Object[(int) size + (size / 2)];

        int auxIndex = 0;
        for (int i = firstIndex; i != lastIndex; i++) {
            aux[auxIndex] = elements[i];
            auxIndex++;

            if(i+1 >= elements.length)
                i=-1;
        }
        aux[auxIndex] = elements[lastIndex];
        firstIndex = 0;
        lastIndex = size-1;
        this.elements = aux;
    }


    @Override
    public String toString() {
        String elementsString = "[";
        for (int i = firstIndex; i != lastIndex; i++) { //até o penultimo elemento
            String adds = "";
            if (elements[i].getClass() == String.class) {
                adds += "\"";
                adds += this.elements[i];
                adds += "\"";
            } else {
                adds += this.elements[i] + "";
            }
            elementsString += adds + ", ";

            if(i+1 >= elements.length)
                i=-1;
        }
        // add ultimo elemento
        if(!isEmpty()){
            String adds = "";
            if (elements[lastIndex].getClass() == String.class) {
                adds += "\"";
                adds += this.elements[lastIndex];
                adds += "\"";
            } else {
                adds += this.elements[lastIndex] + "";
            }
            elementsString+=adds;
        }
        elementsString += "]";
        return elementsString;
    }
}
