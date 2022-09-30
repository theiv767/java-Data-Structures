@SuppressWarnings("unchecked")
public class StackChain<E> {
    private int size = 0;
    private Node lastElement = null;

    public void push(E value){
        size++;
        Node adds = new Node(value);
        if(lastElement == null){
            lastElement = adds;
        }else{
            adds.previus = lastElement;
            lastElement = adds;
        }
    }

    public E peek(){
        return (E)lastElement.value;
    }

    public E pop(){
        if(lastElement == null){
            return null;
        }
        size--;
        E aux = (E)lastElement.value;
        lastElement = lastElement.previus;
        return aux;
    }

    public boolean isEmpty(){
        if(lastElement == null)
            return true;

        return false;
    }

    public int size(){
        return size;
    }

    //---------------------------
    class Node<E>{
        Node previus = null;
        E value;
        public Node(E value){
            this.value = value;
        }
        @Override
        public String toString() {
            return this.value + "";
        }
    }

    @Override
    public String toString() {
        String showString = "";
        Node i = lastElement;

        while(i != null){
            String adds = "";
            if (i.value.getClass() == String.class) {
                adds += "\"";
                adds += i;
                adds += "\"";
            } else {
                adds += i + "";
            }
            String aux = showString;
            showString = (i!=lastElement)?adds +", ":adds;
            showString += aux;
            i = i.previus;
        }
        String aux = showString;
        showString = "[";
        showString += aux;
        showString += "]";

        return showString;
    }
}
