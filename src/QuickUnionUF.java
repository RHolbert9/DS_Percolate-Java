//***************************************************************************
// Quick Union
// Faster than quickFind, but still too slow because of the root/find method
//***************************************************************************
public class QuickUnionUF {
	private int[] id;
	
	// Constructor
	public QuickUnionUF(int N)
	{
		id = new int[N];
		for ( int i = 0; i < N; i++ )
		{
			id[i] = i;
		}
	}
	
	// Return the element i's root element (the index of the root).
	private int root(int i)
	{
		// Loop until the root is reached, i.e. i equals the value in id[i].
		while ( i != id[i] )
		{
			// Move the while loop up the tree to the next node, re-check.
			i = id[i];
		}
		
		// The index after the loop is completed is the index of the root.
		return i;
	}
	
	// Return whether two nodes are connected, i.e. they have the same root.
	public boolean connected(int p, int q)
	{
		return root(p) == root(q);
	}
	
	// To union, set the id of p's root to the id of q's root
	public void union(int p, int q)
	{
		// Don't have to test if connected, should be done when this method
		// is called
		//if ( !connected(p,q) )
		//{
		//	id[root(p)] = root(q);
		//}
		
		int i = root(p);
		int j = root(q);
		
		id[i] = j;
	}
}
