class Solution {
    static boolean[][] visited;
    static int[][] map;
    static int mapSize;
    static Pos pos;
    static Pos direction;
    
    static class Pos {
        int x;
        int y;
        
        Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    static boolean isPossible(){
        int nx = pos.x + direction.x;
        int ny = pos.y + direction.y;
        
        return 0<=nx && nx< mapSize && 0<= ny && ny< mapSize && !visited[nx][ny];
    }
    
    static void changeDirection(){
        int x = direction.x;
        int y = direction.y;
        
        if(x==0 && y==1){ // 우측 방향이라면
            x=1;
            y=0;
        } else if(x==1&&y==0) {   // 아래 방향이라면
            x=0;
            y=-1;
        } else if(x==0&&y==-1) {   // 좌측 방향이라면
            x=-1;
            y=0;
        } else {    // 위쪽 방향이라면
            x=0;
            y=1;
        }
        
        direction = new Pos(x,y);
    }
    
    static void movePos(){
        pos.x += direction.x;
        pos.y += direction.y;
    }
    
    public int[][] solution(int n) {
        mapSize = n;
        
        map = new int[mapSize][mapSize];
        visited = new boolean[mapSize][mapSize];
        
        int cnt = 1;
        
        pos = new Pos(0, 0);
        direction = new Pos(0, 1);  // 우측 방향으로 초기 세팅
        
        for(int i = 0; i < n * n; i++){
            map[pos.x][pos.y] = cnt++;
            visited[pos.x][pos.y] = true;
            
            if(!isPossible()){   // 이동 가능 하지 않다면
                changeDirection();  // 방향 변경
            } 
            
            movePos();  // pos 이동
        }
        
        
        
        return map;
    }
}