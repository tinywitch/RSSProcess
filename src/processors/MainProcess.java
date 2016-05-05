package processors;
import java.util.ArrayList;
import models.RSS;
import processors.RssExport;
import processors.RssImport;

public class MainProcess
{
	public static void main(String[] args)
	{
		ArrayList<RSS> rssList;
		RssImport rssProcessor = new RssImport();
		rssList = rssProcessor.getRSSList(args);
		
		RssProcess rssProcess = new RssProcess();
		rssProcess.filter(rssList);
		
		RssExport rssExport = new RssExport(rssList);
		rssExport.run();
	}
}
