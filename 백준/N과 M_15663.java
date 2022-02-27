import java.util.*;

public class Main {
	static int N,M;
	static int[] arr;
	static LinkedHashSet<String> hs = new LinkedHashSet<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		// 증가하는 순서로 출력하기 위해 수 정렬
		Arrays.sort(arr);
		
		// 백트래킹을 사용한 순열 생성
		permu(0,new int[M], new boolean[N]);
		
		// Iterator를 사용해 LinkedHashSet 출력
		Iterator iter = hs.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}

	private static void permu(int idx, int[] value, boolean[] visit) {
		// idx == M 이면 순열 완성(기저조건)
		if(idx==M) {
			String str = "";
			for(int i=0; i<idx; i++) {
				str += Integer.toString(value[i]) + " ";
			}
			// 중복 방지, 입력 순서 유지를 위해 LinkedHashSet에 저장
			hs.add(str);
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!visit[i]) {
				visit[i] = true;
				value[idx] = arr[i];
				permu(idx+1, value, visit);
				visit[i] = false;
			}
		}
	}

}
