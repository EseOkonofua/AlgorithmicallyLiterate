import java.lang.reflect.Array;
//Implementation of a resizable array
public class EArray<T> {
	private T[] arr;
	private int capacity;
	private int count = 0;
	private Class<T> c;
	
	private void resize(int capacity){
		System.out.println("Resizing EArray");
		@SuppressWarnings("unchecked")
		T[] newArr  = (T[])Array.newInstance(this.c, capacity);
		for(int i = 0;i < this.capacity;i++){
			newArr[i] = arr[i];
		}
		arr = newArr;
		this.capacity = capacity;
	}
	
	public EArray(Class<T> c, int size) throws EArrayException{
		// TODO Auto-generated constructor stub
		//TODO: add size exception
		if(size <= 0 ){
			throw new EArrayException("Array size must be greater than 0");
		}
		@SuppressWarnings("unchecked")
		T[] arr = (T[])Array.newInstance(c, size);
		this.c = c;
		this.arr = arr;
		capacity = size;
		
	}

	public void push(T item){	
		if(count == capacity) resize(capacity*2);
		arr[count] = item;
		count++;
	}
	
	public T[] toArray(){
		return arr;
	}
	
	public int size(){
		return count;
	}
	
	public int capacity(){
		return capacity;
	}
	
	public boolean isEmpty(){
		if(count == 0) return true;
		else return false;
	}
	
	public T at(int index) throws EArrayException{
		if(index < 0 || index > (count-1) ){
			throw new EArrayException("Index is out of bounds!");
		}
		else return arr[index];
	}
	
	public void prepend(T item){
		if(count == capacity) resize(capacity*2);	
		for(int i = count;i>0; i--){
			arr[i] = arr[i-1];
		}
		arr[0] = item;
		count++;
	}
	
	public void insert(T item, int index) throws EArrayException{
		if(index < 0 || index > count ){
			throw new EArrayException("Index is out of bounds!");
		}
		if(index == count) push(item);
		else if(index == 0) prepend(item);
		else{
			if(count == capacity) resize(capacity*2);
			for(int i = count; i > 0;i--){
				arr[i] = arr[i-1];
				if((i-1) == index){
					arr[i-1] = item;
					break;
				}
			}
			count++;
		}
		
	}
}
