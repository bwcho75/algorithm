import java.util.ArrayList;
import java.util.List;


public class Tree {

	public static class Node{
		public int value;
		public List<Node> child = new ArrayList<Node>();
		
		public Node(int value){
			this.value = value;
		}
		
		public void addChild(Node node){
			child.add(node);
		}
	}

	static Node n[] = new Node[11];

	public static void createTree(){
		for(int i=1;i<=10;i++){
			n[i] = new Node(i);
		}
		
		n[1].addChild(n[2]);
		n[1].addChild(n[5]);
		n[1].addChild(n[6]);
		
		n[2].addChild(n[3]);
		n[2].addChild(n[4]);

		n[6].addChild(n[7]);
		n[6].addChild(n[9]);
		n[6].addChild(n[10]);

		n[7].addChild(n[8]);
	}
	
	public static void dfs(Node root){
		System.out.println("Node :"+root.value);
		
		for(int i=0;i<root.child.size();i++){
			Node node = root.child.get(i);
			dfs(node);
		}
	}
	
	public static void bfs(Node root){
		for(int i=0;i<root.child.size();i++){
			Node node = root.child.get(i);
			System.out.println("Node :"+node.value);
		}
		
		for(int i=0;i<root.child.size();i++){
			Node node = root.child.get(i);
			bfs(node);
		}
		
	}
	
	public static void main(String args[]){
		createTree();
		
		dfs(n[1]);
		
		System.out.println("BFS");
		System.out.println("Node :"+n[1].value);
		bfs(n[1]);
		
	}
}
