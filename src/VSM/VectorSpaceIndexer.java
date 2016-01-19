package VSM;

import java.io.FileNotFoundException;
import java.util.Map;
import normalization.Stemmer;


public class VectorSpaceIndexer
	{
		private String[]	_stopList;
		private VectorSpace	_vectors;

		private boolean InStopList(String word)
			{
				if (_stopList.length < 1) return false;
				for (String stop : _stopList)
					{
						if(word.equalsIgnoreCase(stop)) return true;
					}
				return false;
			}

		private String Stem(Stemmer s, String word)
			{
				char[] wordChars = word.toCharArray();
				for (char c : wordChars)
					{
						s.add(c);
						
					}
				s.stem();
				return s.toString();
			}

		private Vector CreateVector(String docName, String[] words)
			{
				Stemmer s = new Stemmer();
				Vector v = new Vector(docName);
				for (String word : words)
					{
						if (!InStopList(word))
							{
								v.AddTerm(Stem(s, word), word);
							}
					}
				return v;
			}

		private void SetDocFreq(Vector v)
			{
				for (Dimension d : v.getDimensions())
					{
						int count = 0;
						for (Vector otherV : _vectors.getVectors())
							{
								if (otherV.ContainsTerm(d.getTerm())) count++;
							}
						d.setDocFrequency(count);
					}
			}

		public VectorSpaceIndexer()
			{
				_stopList = new String[0];
				
			}

		
		public VectorSpaceIndexer(String stopListFilePath) throws FileNotFoundException
			{
				if(stopListFilePath== null || stopListFilePath.trim() == "") return;
				
				_stopList = miscutilities.WordsFromFile(stopListFilePath);
			}

		public VectorSpace getVectorSpace()
		{
			return _vectors;
		}
		

		
		
		public void vectorSpaceIndexer(String directory) throws FileNotFoundException
			{
				
				if(directory == null || directory.trim() == "") return;
				
				_vectors = new VectorSpace();
				
				for (Map.Entry<String, String[]> pair : miscutilities.WordListsFromDirectory(directory).entrySet())
					{
						Vector v = CreateVector(pair.getKey(), pair.getValue());
						_vectors.AddVector(v);
					}
				for (Vector v : _vectors.getVectors())
					{
						SetDocFreq(v);
					}
			}

		public Vector CreateQueryVector(String[] queryWords)
			{
				Vector query = CreateVector("QUERY", queryWords);
				SetDocFreq(query);
				return query;
			}
	}
