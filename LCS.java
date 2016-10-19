import java.util.Scanner;


class LCS {
	static int[][] memo;
	public static void main(String args[]){
		int L1,L2;
		String s1,s2;
		Scanner scanner = new Scanner(System.in);
		int count = scanner.nextInt();
		for (int k = 1; k<=count; k++){
			L1 = scanner.nextInt();
			L2 = scanner.nextInt();
			s1 = scanner.next();
			s2 = scanner.next();
			memo = new int[L1][L2];
			char[] S1  = s1.toCharArray();
			char[] S2  = s2.toCharArray();
			if (S1[0]==S2[0])
				memo[0][0] = 1;
			for (int i = 1; i<L1; i++)
				if(S1[i]==S2[0])
    				memo[i][0] = 1;
    			else
    			    memo[i][0] = memo[i-1][0];
			for (int i = 1; i<L2; i++){
				if(S2[i]==S1[0])
    				memo[0][i] = 1;
    			else
    			    memo[0][i] = memo[0][i-1];
			}
			for (int i = 1; i<L1; i++){
				for(int j = 1; j<L2; j++){
					memo[i][j] = Score(i,j,S1,S2);
				}
			}
			System.out.println(memo[L1-1][L2-1]);
		}
		scanner.close();
	}

	private static int Score(int i, int j, char[] S1, char[] S2){
		if(S1[i] == S2[j]){
			int Temp = memo[i-1][j-1] + 1;
			return Max(memo[i-1][j],memo[i][j-1],Temp);
		}
		else{
			return Max(memo[i-1][j],memo[i][j-1],memo[i-1][j-1]);
		}
	}

	private static int Max(int a, int b, int c){
		if (a>=b){
			if(a>=c)
				return a;
			else
				return c;
		}
		else
			if (c>=b)
				return c;
			else
				return b;
	}
}