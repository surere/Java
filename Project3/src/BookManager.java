import java.sql.*;
public class BookManager
{
	int MAX_SIZE = 100;
	Book[] books = new Book[MAX_SIZE];
	int size = 0;
	
	public void add(String title, String title2, String title3)
	{
		Book b = new Book();
		b.setTitle(title);
		b.setTitle2(title2);
		b.setTitle3(title3);
		
		books[size++]= b;
	}
	public void remove(String title)
	{
		System.out.println("----------책 삭제----------");
		for(int i = 0; i <size; i++) 
		{
			if(books[i].getTitle().equals(title)) 
			{
				for(;i<size;i++) 
				{
					books[i] = books[i+1];
				}
			}size--;
		}
	}
	public void getList()
	{
		System.out.println("---------책 리스트---------");
		for(int i = 0; i <size; i++) 
		
			System.out.println(books[i]);
		}
	
	public void searchByTitle(String title)
		{
		System.out.println("----------책 검색----------");
	
		for(int i = 0; i <size; i++) 
			{
			if(books[i].getTitle().equals(title)) 
				{
				System.out.println(books[i]);
				}
			}
		
	}
}

