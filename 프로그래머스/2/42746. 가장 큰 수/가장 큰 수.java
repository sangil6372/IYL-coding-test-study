
import java.util.Arrays;
import java.util.stream.Collectors;


class Solution {
    // 이게 되네 ㅋㅋ
     class Test {
         String str;
         
         Test(String str){
             this.str = str;
         }
     }
        
	 public String solution(int[] numbers) {
         Test[] test = new Test[numbers.length];
         
         for (int i = 0 ; i < numbers.length ; i++){
             test[i] = new Test(Integer.toString(numbers[i]));
         }
          
         Arrays.sort(test, (n1,n2) -> {
             return (n2.str + n1.str).compareTo(n1.str + n2.str);
         });
         StringBuilder sb = new StringBuilder();
         
         for (Test t : test){
             sb.append(t.str);
         }
         
        if (sb.charAt(0) == '0') return "0";

         
         return sb.toString();
         
         
         
// 	     return Arrays.stream(numbers)
// //	    		 String타입으로 변경
// 	    		 .mapToObj(String::valueOf)
// //	    		 뒤집어 붙인게 더 크면 스왑 
// 	    		 .sorted((s1,s2)->{
// 	    			 int seq = Integer.parseInt(s1+s2);
// 	    			 int rev = Integer.parseInt(s2 + s1);
// 	    			 return rev - seq;
// 	    		 })
// //	    		 스트림을 하나의 문자열로 구성
// 	    		 .collect(Collectors.joining(""))
// //	    		 앞에 0을 제거 
// 	    		 .replaceAll("^0+", "0");
		 
		 
	 }
}