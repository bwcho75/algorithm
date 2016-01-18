import java.util.ArrayList;
import java.util.List;


public class MazeSearch {
	
	public static class Stack{
		List l = new ArrayList();
		
		public  void push(Object obj){
			l.add(obj);
		}
		
		public  Object pop(){
			Object obj = l.get(l.size()-1);
			l.remove(l.size()-1);
			
			return obj;
		}
		
		public void dump(){
			for(int i=0;i<l.size();i++){
				System.out.print(l.get(i)+" ");
			}
			System.out.println("");
		}
	}

	public static char maze[][] = {
		{'#','S','#','#','#'},
		{'#','.','.','.','#'},
		{'#','.','#','.','#'},
		{'#','.','.','.','.'},
		{'#','#','#','G','#'},
	};
	
	public static void main(String args[]){
		
		boolean search=false;
		
		Stack s = new Stack();
		
		for(int y=0;y<maze.length;y++){
			for(int x=0;x<maze[0].length;x++){
				char map[][] = new char[maze.length][maze[0].length];
				if(maze[y][x] == 'S'){ 
					dfs(maze,x,y,s);
					search = true;
				}
			}
		}
		
		//printMaze(maze);
		
		if(!search)
			System.out.println("Cannot find start position");
	}
	
	public static void printMaze(char m[][]){
		for(int i=0;i<m.length;i++){
			for(int j=0;j<m[0].length;j++){
				System.out.print(m[i][j]);
			}
			System.out.println("");
		}
	}
	public static void dfs(char maze[][],int x,int y,Stack s){
		System.out.println("("+x+","+y+")");
		
		s.push("("+x+","+y+")");
		
		if(maze[y][x]=='G'){
			printMaze(maze);
			s.dump();
			return;
		}
		maze[y][x]='X';
		
		boolean leaf = true;
		
		if( x>0 && (maze[y][x-1]=='.' || maze[y][x-1]=='G') ){
			leaf=false;
			dfs(maze,x-1,y,s);
		}
		if( x<maze[0].length-1 && (maze[y][x+1]=='.' || maze[y][x+1] =='G') ){
			leaf=false;
			dfs(maze,x+1,y,s);
		}
		
		if( y>0 && (maze[y-1][x]=='.' || maze[y-1][x]=='G') ){
			leaf=false;
			dfs(maze,x,y-1,s);
		}
		if( y<maze[0].length-1 && (maze[y+1][x]=='.' || maze[y+1][x]=='G') ){
			leaf=false;
			dfs(maze,x,y+1,s);
		}

		//if(leaf) s.dump();
		s.pop();
		maze[y][x]='.';
		
		//System.out.println("done");
		
	}

}
