package VSM;

import java.io.FileNotFoundException;
import java.util.Collections;


public class VectorSpaceRetriever
	{
		private VectorSpaceIndexer _vsi;
		private VectorSpace _vectorSpace;
		private int	_collectionSize;
		private Vector _query;
		
		
		
		public VectorSpaceRetriever(String directory) throws FileNotFoundException
		{
			_vsi = new VectorSpaceIndexer("stoplist.txt");
			
			_vsi.vectorSpaceIndexer(directory);
			
			_vectorSpace = _vsi.getVectorSpace();
			_collectionSize = _vectorSpace.getCollectionSize();
			
		
			
		}
		
		
		public void searchCollection(String user_query)
		{
			if(user_query == null || user_query.trim() == "") return;
			
			_query = _vsi.CreateQueryVector(miscutilities.WordsFromString(user_query));
			
			for(Vector v : _vectorSpace.getVectors())
				{
					v.setSimIndex(CosineSim(_query, v, _collectionSize));
				}
			Collections.sort(_vectorSpace.getVectors());
	
			
		}
		
		
		private static double CosineSim(Vector query, Vector doc, int collectionSize)
		{
		
			double dotProduct = 0;
			double sumOfQueryWeights = 0;
			double sumOfDocWeights = 0;
			double magnitude = 0;
			
			for(Dimension d : doc.getDimensions())
				{
					
					double ofDoc = miscutilities.tfidf(d.getFrequency(), d.getDocFrequency(), collectionSize);
					double ofQuery = 0;
					
					
					Dimension inQuery = query.containsTerm(d.getTerm());
					
					if(inQuery != null) ofQuery = miscutilities.tfidf(inQuery.getFrequency(), d.getDocFrequency(), collectionSize);
						
					
			
					
					
					dotProduct += (ofQuery * ofDoc);
					sumOfQueryWeights += Math.pow(ofQuery, 2);
					sumOfDocWeights += Math.pow(ofDoc, 2);
					
					
				}
			
			
			magnitude = Math.sqrt(sumOfQueryWeights) * Math.sqrt(sumOfDocWeights);
			
			if(dotProduct == 0 || magnitude == 0) return 0;
			
			return (dotProduct / magnitude);
			
			
			
			
			
		}
	
	
		@Override
		public String toString()
		{
			String s = "";
			
			for(Vector v : _vectorSpace.getVectors())
				{
					s+= v.toString() + "\n";
				}
			return s;
		}
	
	}
