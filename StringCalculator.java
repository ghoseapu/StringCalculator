/*
import org.junit.Test;
import static org.junit.Assert.*;

public class StringCalculatorTest {
    @Test
    public void testAdd() {
        StringCalculator sc = new StringCalculator();
        int result = sc.add("1,2,3,4");
        assertEquals(10, result);
    }
}
*/

import java.io.IOException;
import java.util.ArrayList;
public class StringCalculator{
	public int add(String numbers){
		if(numbers.length()==0) return 0;
		
		String delims, input;
		if(numbers.startsWith("//")){
			input = numbers.substring(numbers.indexOf("\n")+1); // numbers with delimiters
	        delims = "[" + numbers.substring(2,numbers.indexOf("\n")) + "\n]+"; // only delimiters
	    }
	    else{
	        input = numbers; // numbers with delimiters
	        delims = "[,\n]+"; // only delimiters
	    }
		
		String[] digits = input.split(delims);
		int sum = 0;
		boolean isNegative = false;
		ArrayList<Integer> negatives = new ArrayList<Integer>();
		for(String s : digits){
			int digit = Integer.parseInt(s);
			if(digit<0){
				isNegative = true;
				negatives.add(digit);
			}
			else if(digit>=0 && digit <=1000) sum += digit;
		}
		if(isNegative) throw new ArithmeticException("Negatives Not Allowed: " + negatives.toString());
		return sum;
	}
	
	public static void main(String args[]){
		StringCalculator obj = new StringCalculator();
		
		String input = "2,52,3,6,1000";
		//String input = "";
		//String input = "2,-52,3,-6,1000";
		//String input = "2\n,52,3,6,1000";
		//String input = "2,\n52,3,6,1001";
		//String input = "//;\n2;52;3;6;1000";
		//String input = "//$\n2$52$3$6$1001";
		//String input = "//***\n2***52***3***6***1000";
		//String input = "//$,@\n2$52@3,6@1000";
		//String input = "//$$,@@\n2$$52@@3,6$$100@@1001";
		
		System.out.println("Input: " + input);
		System.out.println("Output: " + obj.add(input));
	}
}