
public class WeightedUF {
	
	private int[] id;
	private int[] sz;
	
	// Constructor
	public WeightedUF(int N)
	{
		id = new int[N];
		sz = new int[N];
		
		for( int i = 0; i < N; i++ )
		{
			id[i] = i;
			sz[i] = 1;
		}
	}
	
	
	// Return the element i's root element (the index of the root).
	private int root(int i)
	{
		// Loop until the test node has found the root node.
		while ( i != id[i] )
		{
			//***************** IMPROVEMENT 2 - COMPRESSION *****************
			// Compression. You can improve on the weighted quick union
			// by adding compression, or moving the branches up to the root
			// as you're traversing the tree to find the root.
			// Two-pass Implementation : Add a second loop to root() to set
			//    the id[] of each examined node to the root.
			// One-pass Implementation : In this example, we make every other
			//    node in the path point to its grandparent. This essentially
			//    halves the path length and yields close enough results of
			//    that of the two-pass implementation.
			//***************************************************************
			//id[i] = id[id[i]];  // point to the grandparent
			
			// Move to the next node up the tree.
			i = id[i];
		}
		
		// The root node is found when i = id[i]
		return i;
	}
	
	// Return whether two nodes are connected, i.e. they have the same root.
	public boolean connected(int p, int q)
	{
		return root(p) == root(q);
	}
	
	// To union, set the id of p's root to the id of q's root
	// The depth of the tree is guaranteed to be lg N, base 2.
	public void union(int p, int q)
	{
		int i = root(p);
		int j = root(q);
		
		// make sure the nodes aren't already connected
		// Update the size of the tree for weighting
		if ( i != j )
		{
			//**************IMPROVEMENT 1 - WEIGHTING ***********************
			// Weighting, put the smaller tree under the bigger tree, update
			// the size of the tree (the weight)
			//***************************************************************
			if( sz[i] < sz[j] )
			{
				id[i] = j;
				sz[j] += sz[i];
			}
			else
			{
				id[j] = i;
				sz[i] += sz[j];
			}
		}
	}

}
