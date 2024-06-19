package Address_book;
import Address_book.get_Chinesefirstchar;
public class get_namefirstchar {
    public static char get_namefirstchar(String name)
    {
     char a=name.toCharArray()[0];
		char x='a';
		if(a>='a'&&a<='z')
		{
			x=(char)((int)a-32);
		}
		else if(a>='A'&&a<='Z')
		{
			x=a;
		}
		else if(a>='0' && a<='9')
		{
			if(a=='0')
			{
				x='L';
			}
			else if(a=='1')
			{
				x='Y';
			}
			else if(a=='2')
			{
				x='E';
			}
			else if(a=='3')
			{
				x='S';
			}
			else if(a=='4')
			{
				x='S';
			}
			else if(a=='5')
			{
				x='W';
			}
			else if(a=='6')
			{
				x='L';
			}
			else if(a=='7')
			{
				x='Q';
			}
			else if(a=='8')
			{
				x='B';
			}
			else if(a=='9')
			{
				x='J';
			}
		}
		else
		{
			x=(char)((int)get_Chinesefirstchar.getFirstLetter(a)-32);
		}
		return x;
    }
}
