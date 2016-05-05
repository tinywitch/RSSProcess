
package concretes;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import interfaces.Exporter;
import models.Feed;
import models.RSS;
import processors.RssExport;

public class FileExporter implements Exporter
{
	@Override
	public void export(RSS rss)
	{
		try
		{
			BufferedWriter writer = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream("rss_log.txt",true), "UTF-8"));
			writer.write("title : " + rss.getTitle());
			writer.newLine();
			writer.write("link : " + rss.getLink());
			writer.newLine();
			writer.write("description : " + rss.getDescription());
			writer.newLine();
			writer.write("lastBuildDate : " + rss.getLastBuildDate());
			writer.newLine();
			writer.write("docs : " + rss.getDocs());
			writer.newLine();
			writer.write("generator : " + rss.getGenerator());

			for (Feed feed : rss.getEntries())
			{
				writer.write("feed title : " + feed.getTitle());
				writer.newLine();
				writer.write("feed link : " + feed.getLink());
				writer.newLine();
				writer.write("feed description : " + feed.getDescription());
				writer.newLine();
				writer.write("feed guid : " + feed.getGuid());
				writer.newLine();
				writer.write("feed pubdate : " + feed.getPubDate());
				writer.newLine();
			}
			writer.close();
		}
		catch (IOException e)
		{
			RssExport.errorExporter(e.toString());
		}

	}

	@Override
	public void export(String exportedString)
	{
		// TODO Auto-generated method stub

	}

}
