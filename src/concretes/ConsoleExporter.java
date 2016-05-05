package concretes;

import interfaces.Exporter;
import models.Feed;
import models.RSS;

public class ConsoleExporter implements Exporter
{
	@Override
	public void export(RSS rss)
	{
		export("title : "+rss.getTitle());
		export("link : "+rss.getLink());
		export("description : "+rss.getDescription());
		export("lastBuildDate : "+rss.getLastBuildDate());
		export("docs : "+rss.getDocs());
		export("generator : "+rss.getGenerator());
		for (Feed feed : rss.getEntries())
		{
			export("feed title : "+ feed.getTitle());
			export("feed link : "+ feed.getLink());
			export("feed description : "+ feed.getDescription());
			export("feed guid : "+ feed.getGuid());
			export("feed pubdate : "+ feed.getPubDate());
		}
	}

	@Override
	public void export(String exportedString)
	{
		System.out.println(exportedString);
		
	}
}
