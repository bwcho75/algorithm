
public class DFSArray {
	static int maze[][] = {  {0,1,1,0,1,0,0},
			                 {0,1,1,0,1,0,1},
			                 {1,1,1,0,1,0,1},
			                 {0,0,0,0,1,1,1},
			                 {0,1,0,0,0,0,0},
			                 {0,1,1,1,1,1,0},
			                 {0,1,1,1,0,0,0},
			                 {0,1,1,1,0,0,0}
			                 };
	
	public static void main(String args[]) throws Exception{
	
		//System.out.println("maze"+maze.length+" "+maze[0].length);
		for(int y=0;y<maze.length;y++){
			for(int x=0;x<maze[y].length;x++){
				if(maze[y][x] == 1) {
					System.out.println("Start traversing "+x+","+y);
					int length = 0;
					length = dfs(maze,x,y,length);
					
					System.out.println("Length:"+length);
				}
			}
			
		}
	}
	
	public static int dfs(int a[][],int x,int y,int length) throws Exception{
		a[y][x] = 2;
		length++;
		
		try{
			if(x>0 && a[y][x-1] == 1 ) length=dfs(a,x-1,y,length);
			if(x<a[y].length-1 && a[y][x+1] == 1 ) length=dfs(a,x+1,y,length);
			if(y>0 && a[y-1][x] == 1 ) length=dfs(a,x,y-1,length);
			if(y<a.length-1 && a[y+1][x] == 1 ) length=dfs(a,x,y+1,length);
		}catch(Exception e){
			System.out.println("x,y:"+x+","+y+" length "+a[y].length+","+a.length);
			throw e;
		}
		return length;
		
	}

}
