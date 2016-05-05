package processors;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import models.Feed;
import models.RSS;

public class RssImport
{
	private final String CHANNEL = "channel";
	private final String TITLE = "title";
	private final String DESCRIPTION = "description";
	private final String LINK = "link";
	private final String LAST_BUILD_DATE = "lastBuildDate";
	private final String DOCS = "docs";
	private final String GENERATOR = "generator";
	private final String GUID = "guid";
	private final String ITEM = "item";
	private final String PUB_DATE = "pubDate";
	
	public  ArrayList<RSS> getRSSList(String[] urls)
	{
		ArrayList<RSS> rssList = new ArrayList<>();
		for (String url : urls)
		{
			rssList.add(getRss(url));
		}
		return rssList;
	}
	
	
	private RSS getRss(String url)
	{
		RSS rss = new RSS();
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		try
		{
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(url);
			doc.getDocumentElement().normalize();
			NodeList rssNodeList = doc.getElementsByTagName(CHANNEL);
			Node rssNode = rssNodeList.item(0);
			if (rssNode.getNodeType() == Node.ELEMENT_NODE)
			{
				Element rssElement = (Element) rssNode;
				rss.setTitle(rssElement.getElementsByTagName(TITLE).item(0).getTextContent());
				rss.setDescription(rssElement.getElementsByTagName(DESCRIPTION).item(0).getTextContent());
				rss.setLink(rssElement.getElementsByTagName(LINK).item(0).getTextContent());
				rss.setLastBuildDate(
						rssElement.getElementsByTagName(LAST_BUILD_DATE).item(0).getTextContent());
				rss.setDocs(rssElement.getElementsByTagName(DOCS).item(0).getTextContent());
				rss.setGenerator(rssElement.getElementsByTagName(GENERATOR).item(0).getTextContent());
				NodeList nodeList = doc.getElementsByTagName(ITEM);
				for (int i = 0; i < nodeList.getLength(); i++)
				{
					Node node = nodeList.item(i);
					Element element = (Element) node;
					Feed feed = new Feed();
					feed.setTitle(element.getElementsByTagName(TITLE).item(0).getTextContent());
					feed.setLink(element.getElementsByTagName(LINK).item(0).getTextContent());
					feed.setDescription(element.getElementsByTagName(DESCRIPTION).item(0).getTextContent());
					feed.setGuid(element.getElementsByTagName(GUID).item(0).getTextContent());
					feed.setPubDate(element.getElementsByTagName(PUB_DATE).item(0).getTextContent());
					rss.getEntries().add(feed);
				}

			}

		}
		catch (SAXException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			RssExport.errorExporter(e.toString());
		}
		catch (ParserConfigurationException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
			RssExport.errorExporter(e1.toString());
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			RssExport.errorExporter(e.toString());
		}
		catch (Exception e)
		{
			// TODO: handle exception
			RssExport.errorExporter(e.toString());
		}

		return rss;
	}
	
}
