package lang;



public class LottoMain {

	public static void main(String[] args) {
		System.out.println("------------------------------");
		int[] lottoNo=new int[6];
		
		for (int i = 0; i < lottoNo.length; i++) {
			//중복체크
			lottoNo[i] = (int)(Math.random()*45)+1;
		}
		for (int i = 0; i < lottoNo.length; i++) {
			System.out.print(lottoNo[i]+" ");
		}
		
		
	
		

	}

}
