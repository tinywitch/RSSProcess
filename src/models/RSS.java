package models;


import java.util.ArrayList;

public class RSS
{
	private String title;
	private String link;
	private String description;
	private String lastBuildDate;
	private String docs ;
	private String generator;
	private ArrayList<Feed> entries;
	
	public RSS()
	{
		this.title = "";
		this.link = "";
		this.description = "";
		this.lastBuildDate = "";
		this.docs = "";
		this.generator = "";
		this.entries = new ArrayList<>();
	}
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	public String getLink()
	{
		return link;
	}
	public void setLink(String link)
	{
		this.link = link;
	}
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	public String getLastBuildDate()
	{
		return lastBuildDate;
	}
	public void setLastBuildDate(String lastBuildDate)
	{
		this.lastBuildDate = lastBuildDate;
	}
	public String getDocs()
	{
		return docs;
	}
	public void setDocs(String docs)
	{
		this.docs = docs;
	}
	public String getGenerator()
	{
		return generator;
	}
	public void setGenerator(String generator)
	{
		this.generator = generator;
	}
	public ArrayList<Feed> getEntries()
	{
		return entries;
	}
	public void setEntries(ArrayList<Feed> entries)
	{
		this.entries = entries;
	}
	
}
