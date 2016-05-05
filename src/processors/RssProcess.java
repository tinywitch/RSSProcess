package processors;

import java.util.ArrayList;

import interfaces.Filter;
import models.Feed;
import models.RSS;

public class RssProcess implements Filter
{
	@Override
	public void  filter (ArrayList<RSS> rssList)
	{
		for (RSS rss : rssList)
		{
			filterRss(rss, "NewsPicks");
		}
	}
	
	private void filterRss (RSS rss, String oldString)
	{
		rss.setDocs(rss.getDocs().replaceAll(oldString, ""));
		rss.setDescription(rss.getDescription().replaceAll(oldString, ""));
		rss.setGenerator(rss.getGenerator().replaceAll(oldString, ""));
		rss.setLastBuildDate(rss.getLastBuildDate().replaceAll(oldString, ""));
		rss.setLink(rss.getLink().replaceAll(oldString, ""));
		rss.setTitle(rss.getTitle().replaceAll(oldString, ""));
		for (Feed feed : rss.getEntries())
		{
			feed.setDescription(feed.getDescription().replaceAll(oldString, ""));
			feed.setGuid(feed.getGuid().replaceAll(oldString, ""));
			feed.setLink(feed.getLink().replaceAll(oldString, ""));
			feed.setPubDate(feed.getPubDate().replaceAll(oldString, ""));
			feed.setTitle(feed.getTitle().replaceAll(oldString, ""));
		}
		
	}
	
}
