
public class Main {

	public static void main(String[] args) throws EArrayException {
		// TODO Auto-generated method stub
		EArray<Integer> arr = null ;
		try{
			arr = new EArray<>(Integer.class,1);
		}
		catch(EArrayException e){
			e.printStackTrace();
		}
		arr.push(1);
		arr.push(2);
		arr.push(3);
		arr.push(4);
		arr.prepend(5);
		arr.prepend(6);
		arr.insert(7,6);
		arr.insert(8,7);
		
		Integer[] list = arr.toArray();
		for(Integer item: list){
			System.out.println(item);
		}
		
	}

}
