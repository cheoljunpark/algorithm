import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * 
 * @author 박철준
 * 
 * 1. 전체 문자열을 입력받는다
 * 2. 검색할 문자열을 입력받는다
 * 3. KMP알고리즘을 적용해 검색할 문자열이 포함된 횟수와 
 *    포함되었을 때 첫 인덱스를 출력한다
 *
 */

public class Main {
	
	static void KMP(String parent, String pattern){
		int[] table = makeTable(pattern);
		
		int n1 = parent.length(), n2 = pattern.length();
		int idx=0;
		int cnt=0;
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<n1; i++) {
			while(idx>0 && parent.charAt(i) != pattern.charAt(idx)) {
				idx = table[idx-1];
			}
			
			if(parent.charAt(i) == pattern.charAt(idx)) {
				if(idx == n2-1) {
					sb.append((i-idx+1)+" ");
					cnt++;
					idx = table[idx];
				}else {
					idx +=1;
				}
			}
		}
		System.out.println(cnt);
		System.out.println(sb.toString());
	}
	
	static int[] makeTable(String pattern) {
		int[] table = new int[pattern.length()];	// 테이블 생성
		
		int idx = 0;
		for(int i=1; i<pattern.length(); i++) {
			while(idx>0 && pattern.charAt(i) != pattern.charAt(idx)) {
				idx = table[idx-1];
			}
			if(pattern.charAt(i) == pattern.charAt(idx)) {
				table[i] = ++idx;
			}
		}
		return table;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String parent = br.readLine();	// 전체 문자열
		String pattern = br.readLine();	// 검색할 문자열
		KMP(parent,pattern);
	}
}
