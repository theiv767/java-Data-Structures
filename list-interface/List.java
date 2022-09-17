public interface List<E> {

    E get(int index); 
    
    void set(int index, E value); 
    
    void add(E value); 
    
    void add(int index, E value); 
    
    void remove(int index); 
    
    void remove(E value); 
    
    int indexOf(E value); 
    
    boolean contains(E value);
    
    int size(); 
    
    void clear();

}
