
public class While_nested {

	public static void main(String[] args) {
	
		/*
★[i=0,j=0]★[i=0,j=1]★[i=0,j=2]★[i=0,j=3]★[i=0,j=4]
★[i=1,j=0]★[i=1,j=1]★[i=1,j=2]★[i=1,j=3]★[i=1,j=4]
★[i=2,j=0]★[i=2,j=1]★[i=2,j=2]★[i=2,j=3]★[i=2,j=4]
★[i=3,j=0]★[i=3,j=1]★[i=3,j=2]★[i=3,j=3]★[i=3,j=4]
★[i=4,j=0]★[i=4,j=1]★[i=4,j=2]★[i=4,j=3]★[i=4,j=4]
		 */
		int i = 0;
		while (i < 5) {
			int j = 0;
			while (j < 5) {
				System.out.printf("%s[i=%d,j=%d]","★",i,j);
				j++;
			}
			System.out.println();
			i++;
		}
		System.out.println("1.---------------------------");
		/*-------------------------------------------------
		  ★★★★★ 
		  ★★★★★ 
		  ★★★★★ 
		  ★★★★★ 
		  ★★★★★
		 *///-----------------------------------------------
		i = 0;
		while (i < 5) {
			int j = 0;
			while (j < 5) {
				System.out.print("★");
				j++;
			}
			System.out.println();
			i++;
		}
		System.out.println("2.---------------------------");
		/*-------------------------------------------------
		  ☆★★★★ 
		  ★☆★★★ 
		  ★★☆★★ 
		  ★★★☆★ 
		  ★★★★☆
		 *///-----------------------------------------------
		i=0;
		while(i<5) {
			int j=0;
			while(j<5) {
				
				if(i!=j) {
					System.out.print("★");
				}else {
					System.out.print("☆");
				}
				j++;
			}
			System.out.println();
			i++;
		}
		
		System.out.println("3.---------------------------");
		/*-------------------------------------------------
		 ☆☆☆☆☆
		 ★☆☆☆☆
		 ★★☆☆☆
		 ★★★☆☆
		 ★★★★☆
		 *///-----------------------------------------------
		i=0;
		while(i<5) {
			int j=0;
			while(j<5) {
				
				if(i > j) {
					System.out.print("★");
				}else {
					System.out.print("☆");
				}
				j++;
			}
			System.out.println();
			i++;
		}
		
		/*-------------------------------------------------
		 ★
		 ★★
		 ★★★
		 ★★★★
		 ★★★★★
		 *///-----------------------------------------------
		System.out.println("4.---------------------------");
		i=0;
		while(i<5) {
			int j=0;
			while(j<5) {
				
				if(i >= j) {
					System.out.print("★");
				}else {
					System.out.print(" ");
				}
				j++;
			}
			System.out.println();
			i++;
		}
		/*-------------------------------------------------
	    ★★★★★
	      ★★★★ 
	        ★★★ 
	          ★★ 
	            ★
	     *///-----------------------------------------------
		System.out.println("5.---------------------------");
		i=0;
		while(i<5) {
			int j=0;
			while(j<5) {
				
				if(i >= j) {
					System.out.print("  ");
				}else {
					System.out.print("★");
				}
				j++;
			}
			System.out.println();
			i++;
		}
		

		/*//-------------------------------------------------
		 ★★★★★
		 ★★★★
		 ★★★
		 ★★
		 ★
		 *///-------------------------------------------------
		System.out.println("6.---------------------------");
		
		i=0;
		while(i<5) {
			int j=0;
			while(j<5) {
				
				if((i + j) < 5) {
					System.out.print("★");
				}else {
					System.out.print("  ");
				}
				j++;
			}
			System.out.println();
			i++;
		}
		
	
	
	
	}

}
