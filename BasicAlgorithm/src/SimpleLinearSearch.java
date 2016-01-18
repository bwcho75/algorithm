
import java.io.*;
public class SimpleLinearSearch {
	public static void main(String args[]) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		int num = Integer.parseInt(str);

		str = in.readLine();
		int numbers[] = parse(str,num);

		str = in.readLine();
		int index = Integer.parseInt(str);
		
		boolean found = false;
		for(int i=0;i<num;i++){
			if(numbers[i] == index 
				&& (numbers[i+1] != index) || i==num-1) {
					System.out.println("Index is "+(i+1));
					found = true;
					break;
				}
		}
		if(!found) System.out.println("index is "+num);
		//System.out.println(str);
	}
	
	public static int[] parse(String str,int num){
		int numbers[] = new int[num];
		
		char ch;
		String buf = "";
		int j=0;
		
		for(int i=0;i<str.length();i++){
			ch = str.charAt(i);
			if(ch == ' ' || ch == '\t' || ch == '\n'){
			  numbers[j] = Integer.parseInt(buf);
			  buf="";
			  j++;
			}else{
				buf+=ch;
			}
		}
		if(buf.length() >0 ){
			numbers[j]=Integer.parseInt(buf);
			j++;
		}
		return numbers;
	}

}
