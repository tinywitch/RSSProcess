package processors;

import java.util.ArrayList;

import concretes.ConsoleExporter;
import concretes.ErrorExporter;
import concretes.FileExporter;
import interfaces.Exporter;
import models.RSS;

public class RssExport
{
	private ArrayList<RSS> rssList;
	private static ErrorExporter errorExporter = new ErrorExporter();
	public RssExport(ArrayList<RSS> rssList)
	{
		super();
		this.rssList = rssList;
	}
	
	public void run()
	{
		ConsoleExporter consoleExporter = new ConsoleExporter();
		FileExporter fileExporter = new FileExporter();
		for (RSS rss : rssList)
		{
			export(consoleExporter,rss);
			export(fileExporter, rss);
		}
		
	}
	
	private void export(Exporter exporter, RSS rss)
	{
		exporter.export(rss);
	}
	
	public static void errorExporter(String error)
	{
		errorExporter.export(error);
	}
}
