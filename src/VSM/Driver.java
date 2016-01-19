package VSM;

import java.io.FileNotFoundException;

public class Driver
	{
		public static void main(String[] args) throws FileNotFoundException
			{

				VectorSpaceRetriever vsr = new VectorSpaceRetriever("collection");
				
				String[] testStrings = new String[30];
				testStrings[0] = "Tom Sawyer";
				testStrings[1] = "Tom";
				testStrings[2] = "Sawyer";
				testStrings[3] = "Huckleberry Finn";
				testStrings[4] = "Huckleberry";
				testStrings[5] = "finn";
				testStrings[6] = "holy land";
				testStrings[7] = "holy";
				testStrings[8] = "land";
				testStrings[9] = "camelot";
				testStrings[10] = "As we approached the town";
				testStrings[11] = "Presbyterian";
				testStrings[12] = "My was a St. Bernard";
				testStrings[13] = "sea going";
				testStrings[14] = "We started westward from New York in midsummer";
				testStrings[15] = "battle";
				testStrings[16] = "soldier";
				testStrings[17] = "He tells it in the character of a dull-witted old farmer";
				testStrings[18] = "mississippi";
				testStrings[19] = "the word'new' in connection with our country";
				testStrings[20] = "my brother";
				testStrings[21] = "The next morning, bright and early, we took a hasty breakfast, and " +
									"hurried to the starting-place.  Then an inconvenience presented itself " +
									"which we had not properly appreciated before, namely, that one cannot " +
									"make a heavy traveling trunk stand for twenty-five pounds of baggage " +
									"--because it weighs a good deal more.";
				testStrings[22] = "adventure";
				testStrings[23] = "THE CRIMEA,";
				testStrings[24] = "London";
				testStrings[25] = "glories of his royal estate";
				
				for(String test : testStrings)
					{
						if(test != null)
							{
						System.out.println("RESULTS FOR: \""+test + "\"");
						vsr.searchCollection(test);
						System.out.println(vsr.toString());
						System.out.println("\n\n");
							}
					}
				
				
				
				
				
			
			}
	}
