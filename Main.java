
import java.util.*;
public class Main
{
    public static void duplicates(int [] arr){
        List<Integer> list = new ArrayList<>();
        Arrays.sort(arr);
        for(int i=0; i<arr.length-1; i++){
            if(arr[i] == arr[i+1]){
                list.add(arr[i]);
                while (i < arr.length-1 && arr[i] == arr[i+1]){
                    i++;
                }
            }
        }
        
        if(list.size() == 0){
            list.add(-1);
        }
        System.out.println(list);
        
        
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
		int [] arr = {0,3,1,2};// 1 2 2 3 3 
	    duplicates(arr);
        
	}
}