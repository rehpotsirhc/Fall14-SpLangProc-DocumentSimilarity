package VSM;

import java.util.ArrayList;
import java.util.List;


public class Vector implements Comparable<Vector> 
	{
		private List<Dimension>	_dimensions;
		private String					_documentName;
		private double _simIndex;

		public Dimension containsTerm(String term)
			{
				for (Dimension d : _dimensions)
					{
						if (d.getTerm().equalsIgnoreCase(term)) return d;
					}
				return null;
			}

		public Vector(String documentName)
			{
				_documentName = documentName;
			}

		public void AddTerm(String term, String unStemmedTerm)
			{
				if (_dimensions == null) _dimensions = new ArrayList<Dimension>();
				Dimension d = containsTerm(term);
				if (d != null)
					d.incrementFrequency();
				else
					_dimensions.add(new Dimension(term, unStemmedTerm));
			}

		public List<Dimension> getDimensions()
			{
				return _dimensions;
			}
		
		

		double getSimIndex()
			{
				return _simIndex;
			}

		void setSimIndex(double simIndex)
			{
				_simIndex = simIndex;
			}

		public String getDocumentName()
			{
				return _documentName;
			}

		public boolean ContainsTerm(String term)
			{
				return (containsTerm(term) != null);
			}

		@Override
		public int compareTo(Vector v)
			{
				if(_simIndex > v.getSimIndex()) return -1;
				else if(_simIndex < v.getSimIndex()) return 1;
				else return 0;
			}
		
		
		@Override
		public String toString()
			{
			return _documentName + "--" + _simIndex; 
		}

	
			
	}
