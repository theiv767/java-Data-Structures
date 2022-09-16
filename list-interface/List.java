public interface List<E> {

    E get(int index);
    
    void set(int index, E value);
    
    void add(E value);
    
    void add(int index, E value);
    
    public void remove(int index);
    
    public void remove(E value);
    
    public int indexOf(E value);
    
    public boolean contains(E value);
    
    public int size();
    
    void clear();

}
