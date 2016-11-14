import java.lang.reflect.Array;
//Ese's array
//Implementation of a resizable array with various helper functions
//Komplete!
public class EArray<T> {
	private T[] arr;
	private int capacity;
	private int count = 0;
	private Class<T> c;
	
	public EArray(Class<T> c, int size) throws CustomException{
		// TODO Auto-generated constructor stub
		//TODO: add size exception
		if(size <= 0 ){
			throw new CustomException("Array size must be greater than 0");
		}
		@SuppressWarnings("unchecked")
		T[] arr = (T[])Array.newInstance(c, size);
		this.c = c;
		this.arr = arr;
		capacity = size;
		
	}
	
	private void resize(int capacity){
		@SuppressWarnings("unchecked")
		T[] newArr  = (T[])Array.newInstance(this.c, capacity);
		for(int i = 0;i < this.count;i++){
			newArr[i] = arr[i];
		}
		arr = newArr;
		this.capacity = capacity;
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
	
	public T at(int index) throws CustomException{
		if(index < 0 || index > (count-1) ){
			throw new CustomException("Index is out of bounds!");
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
	
	public void insert(T item, int index) throws CustomException{
		if(index < 0 || index > count ){
			throw new CustomException("Index is out of bounds!");
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
	
	public T pop(){
		if(count <= 0){
			return null;
		}
		if((count-1) < (capacity/4)){
			resize(capacity/2);
		}
		T temp = arr[count-1];
		arr[count-1] = null;
		count--;
		return temp;
	}
	
	public void delete(int index){
		if((count-1) < (capacity/4)){
			resize(capacity/2);
		}
		arr[index] = null;
		for(int i = index; i < (count-1);i++){
			arr[i] = arr[i+1];
		}
		arr[count-1] = null;
		count--;
	}
	
	@SuppressWarnings("unchecked")
	public void remove(T item){
		int removed = 0;
		T[] tempArr;
		for(int i = 0; i < count; i++){
			if(arr[i] == item){
				arr[i] = null;
				removed++;
			}
		}
		if(removed > 0){
			if((count-removed) < (capacity/4))tempArr = (T[])Array.newInstance(c,capacity/4);
			else tempArr = (T[])Array.newInstance(c,capacity);
			int pos = 0;
			for(int i = 0; i < count; i++){
				if(arr[i] != null){
					tempArr[pos] = arr[i];
					pos++;
				}
			}
			arr = tempArr;
			count -= removed;
		}
	}
	
	public int find(T item){
		int index = -1;
		for(int i = 0; i < count; i++){
			if(arr[i] == item) return i;
		}	
		return index;
	}
	
}
