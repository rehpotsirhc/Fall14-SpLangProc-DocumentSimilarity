package VSM;

import java.util.ArrayList;
import java.util.List;


public class VectorSpace
	{
	
		private List<Vector>	_vectors;

		public VectorSpace()
			{
				
				_vectors = new ArrayList<Vector>();
			}

		public List<Vector> getVectors()
			{
				return _vectors;
			}
		
		public int getCollectionSize()
			{
				return _vectors.size();
			}

		public void AddVector(Vector v)
			{
				_vectors.add(v);
			}
	}
