
public class Book
{
	private String title;
	private String title2;
	private String title3;
	
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	public String getTitle2()
	{
		return title2;
	}
	public void setTitle2(String title2)
	{
		this.title2 = title2;
	}
	public String getTitle3()
	{
		return title3;
	}
	public void setTitle3(String title3)
	{
		this.title3 = title3;
	}
	public Book ()
	{
		
	}
	public Book (String title, String title2, String title3)
	{
		super();
		this.title = title;
		this.title2 = title2;
		this.title3 = title3;
	}
	
	public String toSrting() {
		return title + "" + title2 + "" +title3;
	}
}

