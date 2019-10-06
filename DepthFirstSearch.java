import java.util.ArrayList;
import java.util.Stack;

public class DepthFirstSearch{

	static ArrayList<Node> nodes=new ArrayList<>();
	static class Node{
		int data;
		boolean visited;

		Node(int data){
			this.data=data;
		}
	}

	public ArrayList<Node> findNeighbours(int adjacency_matrix[][],Node x){
		int nodeIndex=-1;

		ArrayList<Node> neighbours=new ArrayList<>();
		for (int i = 0; i < nodes.size(); i++) {
			if(nodes.get(i).equals(x)){
				nodeIndex=i;
				break;
			}
		}

		if(nodeIndex!=-1){
			for (int j = 0; j < adjacency_matrix[nodeIndex].length; j++) {
				if(adjacency_matrix[nodeIndex][j]==1){
					neighbours.add(nodes.get(j));
				}
			}
		}
		return neighbours;
	}

	public  void dfs(int adjacency_matrix[][], Node node){

		System.out.print(node.data + " ");
		ArrayList<Node> neighbours=findNeighbours(adjacency_matrix,node);
        node.visited=true;
		for (int i = 0; i < neighbours.size(); i++) {
			Node n=neighbours.get(i);
			if(n!=null && !n.visited){
				dfs(adjacency_matrix,n);
			}
		}
	}

	public static void main(String arg[]){
		Node node40 =new Node(40);
		Node node10 =new Node(10);
		Node node20 =new Node(20);
		Node node30 =new Node(30);
		Node node60 =new Node(60);
		Node node50 =new Node(50);
		Node node70 =new Node(70);

		nodes.add(node40); nodes.add(node10); nodes.add(node20);
		nodes.add(node30); nodes.add(node60); nodes.add(node50);
        	nodes.add(node70);
		int adjacency_matrix[][] = {
				{0,1,1,0,0,0,0},  // Node 1: 40
				{0,0,0,1,0,0,0},  // Node 2 :10
				{0,1,0,1,1,1,0},  // Node 3: 20
				{0,0,0,0,1,0,0},  // Node 4: 30
				{0,0,0,0,0,0,1},  // Node 5: 60
				{0,0,0,0,0,0,1},  // Node 6: 50
				{0,0,0,0,0,0,0},  // Node 7: 70
		};

		DepthFirstSearch dfsob = new DepthFirstSearch();
		System.out.println("The DFS traversal of the graph using recursion ");
		dfsob.dfs(adjacency_matrix, node40);
	}
}
