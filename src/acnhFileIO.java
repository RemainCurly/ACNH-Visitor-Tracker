import java.io.*;
import java.nio.file.Files;
import javax.swing.JTextField;

public class acnhFileIO
{
	public static File lwv = new File("lastWeeksVisitors.dat");
	public static File twp = new File("thisWeeksProgress.dat");
	public static boolean isImport = false;
	public static boolean inProgress = twp.exists();

	public static void saveProgress(JTextField[] tfs) throws IOException
	{
		FileWriter fw = new FileWriter(twp, false);
		BufferedWriter bw = new BufferedWriter(fw);
		
		sentenceCase(tfs);
		
		for(int i = 0; i < tfs.length; i++)
		{
			/*if(tfs[i].getText().equals(""))
				continue;
			else if(!acnhValid.visitorExists(tfs[i].getText()))
				tfs[i].setText("*non-visitor*");*/
			if(tfs[i].getText().equals("") && !acnhValid.visitorExists(tfs[i].getText()))
				tfs[i].setText("#");
		}
		
		for(int i = 0; i < tfs.length; i++)
		{
			if(!tfs[i].getText().equals(""))
			{
				bw.write(tfs[i].getText());
				bw.newLine();
			}
		}
		
		bw.close();
	}

	public static void save(JTextField[] tfs) throws IOException
	{
		FileWriter fw = new FileWriter(lwv, false);
		BufferedWriter bw = new BufferedWriter(fw);

		for (int i = 0; i < tfs.length; i++)
		{
			bw.write(tfs[i].getText());
			bw.newLine();
		}

		bw.close();
	}

	public static void readProgress(JTextField[] tfs) throws IOException
	{
		FileReader fr = new FileReader(twp);
		BufferedReader br = new BufferedReader(fr);
		String read;

		for (int i = 0; (read = br.readLine()) != null; i++)
		{
			if(read.equals("#"))
				tfs[i].setText("");
			else
				tfs[i].setText(read);
			
			if(acnhValid.isChancer(read))
			{
				acnhStats.markChancer(read);
			}
			else if(acnhValid.isGuaranteer(read))
			{
				acnhStats.markGuaranteer(read);
			}
		}

		br.close();
		Files.deleteIfExists(twp.toPath());
	}

	// Input from file
	public static void checkRead() throws IOException
	{
		if (lwv.exists())
		{
			if (fileIsValid(lwv))
				isImport = true;
		}
	}

	public static void read() throws IOException
	{
		FileReader fr = new FileReader(lwv);
		BufferedReader br = new BufferedReader(fr);

		for (int i = 0; i < acnhData.CHANCE_LENGTH; i++)
		{
			String visitor = br.readLine();
			if (acnhValid.isChancer(visitor))
			{
				acnhPrioritize.reversePrioritize(visitor);
			}
		}

		br.close();
	}

	public static boolean fileIsValid(File f) throws IOException
	{
		FileReader frTest = new FileReader(f);
		BufferedReader brTest = new BufferedReader(frTest);
		String test;

		return (test = brTest.readLine()) != null;
	}

	public static void sentenceCase(JTextField[] tfs)
	{
		for(int i = 0; i < tfs.length; i++)
		{
			if(!tfs[i].getText().equals(""))
				tfs[i].setText(tfs[i].getText().substring(0,1).toUpperCase() + tfs[i].getText().substring(1).toLowerCase());
		}
	}
}