
public class Main {

	public static void main(String[] args) throws CustomException {
		// TODO Auto-generated method stub
		EArray<Integer> arr = null ;
		try{
			arr = new EArray<>(Integer.class,1);
		}
		catch(CustomException e){
			e.printStackTrace();
		}
		arr.push(1);
		arr.push(6);
		arr.push(3);
		arr.push(6);
		arr.prepend(6);
		arr.prepend(4);
		
		Integer[] list = arr.toArray();
		for(Integer item: list){
			System.out.println(item);
		}
		
		arr.remove(9);
		System.out.println("--Find 6--");
		System.out.println(arr.find(6));
		System.out.println("--The Array--");
		list = arr.toArray();
		for(Integer im: list){
			System.out.println(im);
		}
		
	}

}
