package concretes;

import interfaces.Exporter;
import models.RSS;

public class ErrorExporter implements Exporter
{

	@Override
	public void export(RSS rss)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void export(String exportedString)
	{
		System.err.println(exportedString);
		
	}

}
