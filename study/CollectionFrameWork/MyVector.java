package study.CollectionFrameWork;
import java.util.*;

public class MyVector implements List<Object>{
    Object [] data = null;
    int capacity = 0;
    int size = 0;

    // 생성자
    public MyVector(int capacity){  // capacity가 0이 아닐때 값만큼 용량을 할당함
        if(capacity < 0){
            throw new IllegalArgumentException("유효하지 않은 값입니다. :"+ capacity);
        }

        this.capacity = capacity;
        data = new Object[capacity];
    }

    public MyVector(){  // 크기를 입력받지 않았을 때
        this(10);
    }
    
    // Vector을 내가 직접 구현하기
    public boolean contains(Object o) {
        // 지정된 객체가 있는지 확인 => null인 경우를 고려해 수정됨
        for (int i = 0; i < size; i++) {
            if (o != null ? o.equals(data[i]) : data[i] == null) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object o){
        // 두 객체의 참조가 같은지 확인
        if(o == this) return true;
        if(!(o instanceof List)) return false;
        List<?> other = (List<?>)o;
        if(size != other.size()) return false;

        for(int i=0;i<size;i++){
            if(o.equals(data[i])){
                i++;
            }else{
                return false;
            }
        }
        return true;
    }

    public Object set(int index, Object element){
        if(index >= size || index < 0){
            throw new IndexOutOfBoundsException("범위를 벗어났습니다.");
        }
        Object oldValue = data[index];
        data[index] = element;
        return oldValue;
    }

    private void ensureCapacaity(int minCapacity) {
        if(minCapacity - data.length > 0){
            setCapacity(minCapacity);
        }

    }

    
    public boolean add(Object obj) {
        ensureCapacaity(size+1);
        data[size++] = obj;
        return true;
    }
    
    
    public void add(int index, Object element){
        if(index >= size || index < 0){
            throw new IndexOutOfBoundsException("범위를 벗어났습니다.");
        }
        for(int i= size-1;i>=index;i--){
            data[i+1] = data[i];
        }
        data[index] = element;
        size++;
    }
    
    public Object get(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("범위를 벗어났습니다.");
        }
        return data[index];
    }

    private void setCapacity(int capacity) {
        if(this.capacity == capacity) return;

        Object [] tmp = new Object[capacity];
        System.arraycopy(data, 0, tmp, 0, size);
        data = tmp;
        this.capacity = capacity;
    }

    // 1 2 3 4 5
    public Object remove(int index) {
        if(index >= size || index < 0){
            throw new IndexOutOfBoundsException("범위를 벗어났습니다.");
        }
        Object o = data[index];
        for(int i=index;i!=size-1;i++){
            data[i] = data[i+1];
        }
        data[size-1] = null;
        size--;
        return o;
    }
    
    /* ---------------------------------------------------------------- */
    
    // 필드 반환 메서드
    public boolean isEmpty() { return size == 0; }
    public int capacity() { return capacity; }
    public int size() { return size; }
    
    // List 인터페이스로부터 상속받은 메서드들 => 잘 작동되기 위해 기능 생략
    public void clear() {}
    public int indexOf(Object o) { throw new UnsupportedOperationException("아직 구현하지 않았습니다."); }
    public int lastIndexOf(Object o) { throw new UnsupportedOperationException("아직 구현하지 않았습니다."); }
    public Iterator<Object> iterator() { throw new UnsupportedOperationException("아직 구현하지 않았습니다."); }
    public List<Object> subList(int fromIndex, int toIndex) { throw new UnsupportedOperationException("아직 구현하지 않았습니다."); }
    public ListIterator<Object> listIterator() { throw new UnsupportedOperationException("아직 구현하지 않았습니다."); }
    public ListIterator<Object> listIterator(int index) { throw new UnsupportedOperationException("아직 구현하지 않았습니다."); }
    public Object[] toArray() { throw new UnsupportedOperationException("아직 구현하지 않았습니다."); }
    public <T> T[] toArray(T[] a) { throw new UnsupportedOperationException("아직 구현하지 않았습니다."); }
    public boolean addAll(Collection<?> c) { throw new UnsupportedOperationException("아직 구현하지 않았습니다."); }
    public boolean addAll(int index, Collection<?> c){ throw new UnsupportedOperationException("아직 구현하지 않았습니다."); }
    public boolean remove(Object o) { throw new UnsupportedOperationException("아직 구현하지 않았습니다."); }
    public boolean removeAll(Collection<?> c) { throw new UnsupportedOperationException("아직 구현하지 않았습니다."); }
    public boolean retainAll(Collection<?> c) { throw new UnsupportedOperationException("아직 구현하지 않았습니다."); }
    public boolean containsAll(Collection<?> c) { throw new UnsupportedOperationException("아직 구현하지 않았습니다."); }
    
    //default void sort(Comparator c) {}
    //default Spliterator spliterator() {}
    //default void replaceAll(UnaryOperator operator) {}
}