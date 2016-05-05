package interfaces;

import models.RSS;

public interface Exporter
{
	void export(RSS rss);
	void export(String exportedString);
}
