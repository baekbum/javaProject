package kr.koreait.fileio;

import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class StringTokenizerTest {
	public static void main(String[] args) {
		String str1 = "사과 배 복숭아		대추 밤";
		//StringTokenizer 클래스는 문자열을 특정 구분자를 이용해 분리한다.
		//구분자를 생략하면 공백과 탭이 기본 구분자가 된다.
		StringTokenizer st1 = new StringTokenizer(str1);
		
		//hasMoreTokens() : StringTokenizer 객체에 다음에 읽어들일 토큰이 있으면 true, 없으면 false를 리턴한다.		
		while(st1.hasMoreTokens()){
			//nextToken() : StringTokenizer 객체에 다음 토큰을 얻어온다.
			System.out.println(st1.nextToken());
			
		}
		System.out.println("===============");
		
		String str2 = "사과,배,복숭아,대추,밤";
		StringTokenizer st2 = new StringTokenizer(str2, ",");
		while(st2.hasMoreTokens()){
			System.out.println(st2.nextToken());			
		}
		System.out.println("===============");
		
		String str3 = "사과,배.복숭아,대추,밤";
		//StringTokenizer 클래스 생성자의 2번째 인수에 여러개의 구분자를 지정할 수 있다.
		StringTokenizer st3 = new StringTokenizer(str2, ",.");
		while(st3.hasMoreTokens()){
			System.out.println(st3.nextToken());			
		}
		System.out.println("===============");
		
		String str4 = "사과=100,배=200,복숭아=300,대추=400,밤=500";
		//StringTokenizer 클래스 생성자의 3번째 인수에 구분자가 토큰에 포함될지 여부를 지정할 수있다.
		//3번째 인수를 생략하면 false이고 구분자를 토큰에 포함시키지 않고 true를 적어주면 토큰에 포함시킨다.
		StringTokenizer st4 = new StringTokenizer(str4, "=,", true);	
		while(st4.hasMoreTokens()){
			String str = st4.nextToken();
			if(str.equals("=")){
				System.out.print("(");
			}
			else if(str.equals(",")){
				System.out.println("원)");
			}
			else{
				System.out.print(str);
			}
		}
		System.out.println(")\n");
		
		System.out.println("===============");
		
		String str5 = "사과=100,배=200,복숭아=300,대추=400,밤=500";
		StringTokenizer st5 = new StringTokenizer(str5, "=,");
		DecimalFormat df = new DecimalFormat("(#.##0원)");
		while(st5.hasMoreTokens()){
			String str = st5.nextToken();
			try{
				System.out.println(df.format(Integer.parseInt(str)));
			}
			catch(Exception e){
				System.out.println(str);
			}
		}		
	}
}
