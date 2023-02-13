public class leet {
    int ans,n;
    private int dfs(int[][] grid,int i,int j,Integer[][] dist){
        if(grid[i][j]==1){
            return 1;
        }
        if(dist[i][j]!=null){
            return dist[i][j];
        }
        int min=Integer.MAX_VALUE;
        if(i+1<n){
            int x=dfs(grid, i+1, j, dist);
        }
        if(j+1<n){
            int x=dfs(grid, i, j+1, dist);
        }
        if(i-1>=0){
            int x=dfs(grid, i-1, j, dist);
        }
        if(j-1>=0){
            int x=dfs(grid, i, j-1, dist);
        }
    }

    public int maxDistance(int[][] grid) {
        n = grid.length;
        boolean[][] visit=new boolean[n][n];
        Integer[][] dist=new Integer[n][n];
        ans=Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]==0 && dist[i][j]==null){
                    int x=dfs(grid, i, j, dist);
                    ans=Math.max(ans, x);
                }     
            }
        }
    }
    
    public static void main(String[] args) {
        
    }
}
