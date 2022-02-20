import java.util.*;

public class Main {
	static int N,r,c,res;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		
		solve(N);
		
		System.out.println(res);
	}

	private static void solve(int n) {
		if(n==0) {
			return;
		}
		int len = (int)Math.pow(2, n); // 행렬 길이
		int cnt = (int)Math.pow(4, n-1); // 사분면에따라 더해줘야할 값
		int qua = 0; // 사분면 위치
		
		if(r>=(len/2)) { // 행 값이 행렬 절반 길이 보다 길면 3,4 분면이므로 +2
			qua += 2;
			r -= len/2;
		}
		
		if(c>=(len/2)) {
			qua += 1;
			c -= len/2;
		}
		
		for(int i=0; i<qua; i++) { // 사분면 만큼 cnt값 더하기
			res += cnt;
		}
		
		solve(--n); // --n 후 반복
		
	}
	
	
}
