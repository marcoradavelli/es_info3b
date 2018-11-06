package hello;

import java.util.Date;

public class Image {
	private final String date;
	private final String url;
	public Image(Date date, String url) {
		this.date = date.toString();
		this.url = url;
	}
	public String getDate() {
		return date;
	}
	public String getUrl() {
		return url;
	}
	
	
	
}
