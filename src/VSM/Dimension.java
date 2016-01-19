package VSM;

public class Dimension
	{
		private String	_term;
		private String _unStemmedTerm;
		private int		_frequency;
		private int		_docFrequency;

		public Dimension(String term, String unStemmedTerm)
			{
				_term = term;
				_unStemmedTerm = unStemmedTerm;
				_frequency = 1;
			}

		public String getTerm()
			{
				return _term;
			}

		public int getFrequency()
			{
				return _frequency;
			}

		public void incrementFrequency()
			{
				_frequency++;
			}

		public int getDocFrequency()
			{
				return _docFrequency;
			}

		public void setDocFrequency(int _docFrequency)
			{
				this._docFrequency = _docFrequency;
			}
	}
