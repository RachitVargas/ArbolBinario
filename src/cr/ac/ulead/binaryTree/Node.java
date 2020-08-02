package cr.ac.ulead.binaryTree;

public class Node {

	public Persona data;
	public Node leftChild; 
	public Node rightChild;

	public Node(Persona persona) {
		this.data = persona;
	}

	public void displayNode() 
	{
		System.out.print('{');
		System.out.print(data);
		System.out.print("} ");
	}

}
