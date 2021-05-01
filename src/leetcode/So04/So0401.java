package leetcode.So04;

/**
 * @author 翼灵
 */
public class So0401 {
	
    static boolean first_add = true;
    
    public static void main(String[] args) {
		System.out.print(clumsy(8));
	}
    
    
    public static int clumsy(int N) {
        if (N < 5) {
            switch (N){
                case 1:{
                    return 1;
                }
                case 2:{
                    return 2;
                }
                case 3:{
                    return 3 * 2;
                }
                case 4:{
                	if (first_add) {
						return 4 * 3 / 2 + 1;
					}
                    return 4 * 3 / 2 - 1;
                }
                default:{

                }
            }
        }
        if(first_add){
        	first_add = false;
            return N * (N-1) / (N-2) + (N-3) - clumsy(N-4);
        }
        else{
            return N * (N-1) / (N-2) - (N-3) + clumsy(N-4);
        }
    }
}
