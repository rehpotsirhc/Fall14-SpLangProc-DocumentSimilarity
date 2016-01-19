package VSM;

import java.io.*;
import java.util.*;


public class miscutilities
	{
		public static double log(double x, double base)
			{
				return (Math.log(x) / Math.log(base));
			}

		public static double tfidf(double frequency, double docFrequency, double docCount)
			{
				return frequency * log((docCount / (docFrequency + 1)), 2);
			}

		public static File[] FilesFromDirectory(String directoryPath)
			{
				File directory = new File(directoryPath);
				return directory.listFiles();
			}
		
		
		private static String Normalize(String s)
		{
			return s.trim().replaceAll("[^A-Za-z0-9\\s]", "").replaceAll("\\s+", " ");
		}

		
		public static String[] WordsFromString(String s)
		{
			return  Normalize(s).split(" ");
		}
		public static String[] WordsFromFile(String filePath) throws FileNotFoundException
			{
				Scanner s = new Scanner(new FileReader(filePath));
				String text = "";
				while (s.hasNextLine())
					{
						String line =  Normalize(s.nextLine());
						if (line.equals(""))
							continue;
						else
							text += line + " ";
					}
				s.close();
				return text.split(" ");
			}

		public static Map<String, String[]> WordListsFromDirectory(String directoryPath) throws FileNotFoundException
			{
				Map<String, String[]> wordLists = new HashMap<String, String[]>();
				for (File f : FilesFromDirectory(directoryPath))
					{
						String[] words = WordsFromFile(f.getPath());
						wordLists.put(f.getName(), words);
					}
				return wordLists;
			}
	}
