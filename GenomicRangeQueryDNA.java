package br.com.exemplo.codilify;

import java.util.Arrays;

public class GenomicRangeQueryDNA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int P[] = {2,5,0};
		int Q[] = {4,5,6};
		
		int R[] = solution("CAGCCTA", P, Q);
		Arrays.stream(R).forEach(r -> System.out.println(r));
	}

	//O(N + M)
	public static int[] solution(String S, int[] P, int[] Q) {

		int tamanho = S.length();
		int[] Aquantidade = new int[tamanho];
		int[] Cquantidade = new int[tamanho];
		int[] Gquantidade = new int[tamanho];
		int[] Tquantidade = new int[tamanho];
		
		if (S.charAt(0) == 'A')
			Aquantidade[0]++;
		else if (S.charAt(0) == 'C')
			Cquantidade[0]++;
		else if (S.charAt(0) == 'G')
			Gquantidade[0]++;
		else if (S.charAt(0) == 'T')
			Tquantidade[0]++;

		for (int i = 1; i < tamanho; i++) {
			Aquantidade[i] = Aquantidade[i - 1];
			Cquantidade[i] = Cquantidade[i - 1];
			Gquantidade[i] = Gquantidade[i - 1];
			Tquantidade[i] = Tquantidade[i - 1];
			if (S.charAt(i) == 'A')
				Aquantidade[i]++;
			else if (S.charAt(i) == 'C')
				Cquantidade[i]++;
			else if (S.charAt(i) == 'G')
				Gquantidade[i]++;
			else if (S.charAt(i) == 'T')
				Tquantidade[i]++;
		}
		int[] solucao = new int[P.length];
		for (int i = 0; i < P.length; i++) {
			int comeco = P[i];
			int fim = Q[i];
			char c = S.charAt(comeco);

			if (((Aquantidade[fim] - Aquantidade[comeco]) > 0) || c == 'A')
				solucao[i] = 1;
			else if ((Cquantidade[fim] - Cquantidade[comeco]) > 0 || c == 'C')
				solucao[i] = 2;
			else if ((Gquantidade[fim] - Gquantidade[comeco]) > 0 || c == 'G')
				solucao[i] = 3;
			else
				solucao[i] = 4;
		}

		return solucao;
	}

}
