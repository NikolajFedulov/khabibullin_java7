package listing_01_06;

public class PascalTriangle {
    public static final int LINES = 10;

    public static void main(String[] args){
        int[][] triangleElement = new int[LINES][];
        for (int i = 0; i < triangleElement.length; i++){
            for (int k = 0; k < triangleElement.length-1-i; k++) {
                System.out.print("\t");
            }
            triangleElement[i] = new int[i+1];
            for (int j = 0; j < i; j++) {
                System.out.print((triangleElement[i][j] = j-1 < 0 ? 1 : triangleElement[i-1][j-1] + triangleElement[i-1][j]) + "\t\t");
            }
            System.out.println(triangleElement[i][i] = 1);
        }
    }
}
