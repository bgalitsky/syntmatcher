package opennlp.tools.similarity.apps.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PageFetcher
{
	private static final Logger LOG = LoggerFactory.getLogger(PageFetcher.class);

	private static int DEFAULT_TIMEOUT = 15000;

	public String fetchPage(final String url)
	{
		return fetchPage(url, DEFAULT_TIMEOUT);
	}

	public String fetchPage(final String url, final int timeout)
	{
		String fetchURL = addHttp(url);

		LOG.info("fetch url " + fetchURL);

		String pageContent = null;
		URLConnection connection;
		try
		{
			connection = new URL(url).openConnection();
			connection.setReadTimeout(DEFAULT_TIMEOUT);
			Tika tika = new Tika();
			pageContent = tika.parseToString(connection.getInputStream()).replace('\n', ' ').replace('\t', ' ');
		}
		catch (MalformedURLException e)
		{
			LOG.error(e.getMessage(), e);
		}
		catch (IOException e)
		{
			LOG.error(e.getMessage(), e);
		}
		catch (TikaException e)
		{
			LOG.error(e.getMessage(), e);
		}
		return pageContent;
	}

	private String addHttp(final String url)
	{
		if (!url.startsWith("http://"))
		{
			return "http://" + url;
		}
		return url;
	}

	public String fetchOrigHTML(String url)
	{
		System.out.println("fetch url " + url);
		String pageContent = null;
		StringBuffer buf = new StringBuffer();
		try
		{
			URLConnection connection = new URL(url).openConnection();
			connection.setReadTimeout(10000);
			connection.setRequestProperty("User-Agent",
				"Mozilla/5.0 (Windows; U; Windows NT 6.0; en-US; rv:1.9.0.3) Gecko/2008092417 Firefox/3.0.3");
			String line;
			BufferedReader reader = null;
			try
			{
				reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			}
			catch (Exception e)
			{
				// we dont need to log trial web pages if access fails
				// LOG.error(e.getMessage(), e);
			}

			while ((line = reader.readLine()) != null)
			{
				buf.append(line);
			}

		}
		// normal case when a hypothetical page does not exist
		catch (Exception e)
		{

			// LOG.error(e.getMessage(), e);
			// System.err.println("error fetching url " + url);
		}
		try
		{
			Thread.sleep(50); // do nothing 4 sec
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		return buf.toString();
	}

}
