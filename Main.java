import java.util.*;
public class Main {
    public static class rowcol{
        int i,j;
        public rowcol(int i,int j){
            this.i=i;
            this.j=j;
        }
    }
    static List<rowcol> list=new ArrayList<>();
    static List<rowcol> ShortestPath=new ArrayList<>();
    static int min=Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("ENTER ROWS :");
        int row=s.nextInt();
        System.out.println("ENTER COLUMS :");
        int col=s.nextInt();
        int[][] mat=matrix(row,col);
        System.out.println("YOUR MATRIX IS :");
        printmat(mat);
        boolean[][] vis=new boolean[row][col];
        System.out.println("ENTER STARTING INDEX BETWEEN 1 TO ROW AND 1 TO COLUMN BY SPACES");
        int statt1=s.nextInt(),start2=s.nextInt();
        System.out.println("ENTER ENDING INDEX BETWEEN 1 TO ROW AND 1 TO COLUMN BY SPACES");
        int end1=s.nextInt(),end2=s.nextInt();
        shortestpath(mat,statt1-1,start2-1,end1-1,end2-1,vis);
        printshortestpath(ShortestPath,mat);
    }

    private static void printshortestpath(List<rowcol> ShortestPath,int[][] mat) {
        if(ShortestPath.size()==0){
            System.out.println("No Path Found !");
        }
        for(rowcol i:ShortestPath){
            System.out.println((i.i+1)+","+(i.j+1)+" :"+mat[i.i][i.j]);
        }
    }

    private static void shortestpath(int[][] mat, int row, int col, int rowend, int colend,boolean[][] vis) {
        if(row<0 || col<0 || row>rowend || col>colend || vis[row][col] || mat[row][col]==1){
            return;
        }
        list.add(new rowcol(row,col));
        if(row==rowend && col==colend){
            if(list.size()<min){
                ShortestPath=new ArrayList<>(list);
                min= list.size();
            }
            list.remove(list.size()-1);
            return;
        }
        vis[row][col]=true;
        shortestpath(mat,row+1,col,rowend,colend,vis);
        shortestpath(mat,row-1,col,rowend,colend,vis);
        shortestpath(mat,row,col-1,rowend,colend,vis);
        shortestpath(mat,row,col+1,rowend,colend,vis);
        vis[row][col]=false;
        list.remove(list.size()-1);
    }

    private static void printmat(int[][] mat) {
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static int[][] matrix(int row, int col) {
        int[][] mat=new int[row][col];
        int c=1;
        Random random=new Random();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                mat[i][j]=random.nextInt(1-0+1)+0;
            }
        }
    return mat;
    }
}
