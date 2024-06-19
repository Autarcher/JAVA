package Address_book;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.Collator;
import java.util.*;
import Address_book.student;
public class file_op {
void DelectAddressByname(String name,ArrayList<student> students)
{
	int i,sign=0;
	student s1;
	for(i=0;i<students.size()&&sign==0;i++)//查找第一个叫这个名字的人
	{
		s1=students.get(i);
		if(s1.getname().equals(name))
		{
			students.remove(i);
			sign=1;
		}
	}
	if(sign==0)
	{
		System.out.println("未找到此人删除失败");
	}
	else
	{
		System.out.println("删除成功");
	}
}
void WriteInFile(String filename,ArrayList<student> students) //将数组写如文件
{
	File f=new File("address.txt");
	int i;
	String name,Snum,address,QQ,unit;
		try {
		FileWriter outone=new FileWriter(f);
		BufferedWriter outtow=new BufferedWriter(outone);
		//将数组写如文件输入
		student s1 ;
		for(i=0; i<students.size();i++)
		{
			s1=students.get(i);
			name=s1.getname();
			Snum=s1.getSnum();
			address=s1.getaddress();
			QQ=s1.getQQ();
			unit=s1.getunit();
			outtow.write(name);
			outtow.newLine();
			outtow.write(Snum);
			outtow.newLine();
			outtow.write(address);
			outtow.newLine();
			outtow.write(QQ);
			outtow.newLine();
			outtow.write(unit);
			outtow.newLine();
	    //关闭输入流
		}
	    outtow.close();
	    outone.close();
		}catch(IOException e)
		{
			System.out.println(e);
		}	
}
void ReadFromfileIntoArray(String filename,ArrayList<student> students)//读出文件到students中
{
	try {
		students.clear();
		FileReader inone=new FileReader(filename);
	    BufferedReader intow=new BufferedReader(inone);
	    String s=null;
	    int sign=0;
	    String name=null,Snum=null,address=null,QQ=null,unit=null;
	    while((s=intow.readLine())!=null)
	    {
	    	if(sign==0)
	    	{
	    		name=s;
	    	}
	    	else if(sign==1)
	    	{
	    		Snum=s;
	    	}
	    	else if(sign==2)
	    	{
	    		address=s;
	    	}
	    	else if(sign==3)
	    	{
	    		QQ=s;
	    	}
	    	else
	    	{
	    		unit=s;
	    	}
	    	sign=(sign+1)%5;
	    	if(sign==0)//如果读取了一个人的所有数据
	    	{
	    		student temp=new student(name,Snum,address,QQ,unit);
	    		students.add(temp);
	    	}
	    }
	    //关闭输出流
	    intow.close();
	    inone.close();
		}catch(IOException e)
		{
			System.out.println(e);
		}	
}
void show_address(ArrayList<student> students) 
{
	String name="姓名",Snum="学号",address="住址",QQ="QQ",unit="单位";
	System.out.printf("%-10s\t %-20s\t %-30s\t %-20s\t %-30s\t \n",name,Snum,address,QQ,unit);
	for(student s1 : students)
	{
		System.out.printf("%-10s\t %-20s\t %-30s\t %-20s\t %-30s\t \n",s1.getname(),s1.getSnum(),s1.getaddress(),s1.getQQ(),s1.getunit());
	}
}

void SortByFirstName(ArrayList<student> students)
{
 students.sort(new SortByKey());
}
boolean FindSameName(String name,ArrayList<student> students)
{
	for(int i=0;i<students.size();i++)
	{
		if(name.equals(students.get(i).getname()))
		{
			return true;
		}
	}
	return false;
}
void FindByName(String name,ArrayList<student> students)//通过姓名查找
{
	ArrayList<student> student_find=new ArrayList<student>();//定义储存通讯信息数组
	int i,sign=0;
	student s1;
	for(i=0;i<students.size();i++)//查找所有这个名字的所有人
	{
		s1=students.get(i);
		if(s1.getname().equals(name))
		{
			student_find.add(s1);
			sign=1;
		}
	}
	System.out.println("查找结果:");
	if(sign!=0)
	{
		for(student s2:student_find)
		{
		   System.out.println(s2);
		}
	
	}
	else
	{
		System.out.println("查无此人");
	}
}
void ShowBynamefirst(ArrayList<student> students)
{
	int i,j,sign;
	student s1;
	char[] Char_test= {'A','B','C','D','E','F','G','H','I','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	ArrayList<student> student_in=new ArrayList<student>();//定义储存通讯信息数组
	//设置文本框输出通讯录
	String name="姓名",Snum="电话",address="住址",QQ="QQ",unit="学校";
	System.out.printf("%-10s\t %-20s\t %-30s\t %-20s\t %-30s\t \n",name,Snum,address,QQ,unit);
	for(i=0;i<Char_test.length;i++) //按字母输出排序
	{
		char t=Char_test[i];
		sign=0;
		for(j=0;j<students.size();j++)//开判断首字母是否与当前字母相等
		{
			s1=students.get(j);
			if(s1.getfirstchar()==t)//如果是当前字母则添加到带输入文本域中
			{
				student_in.add(s1);
				sign=1;
			}
		}
		if(sign==1)//当前字母内有元组
		{
			System.out.println(t);
			for(student s2 :student_in)
			{
				System.out.printf("%-10s\t %-20s\t %-30s\t %-20s\t %-30s\t \n",s2.getname(),s2.getSnum(),s2.getaddress(),s2.getQQ(),s2.getunit());
				
			}
		}
		student_in.clear();
	}}
}



class SortByKey implements Comparator<student>  //实现Comparator借口实现按姓氏首字母排序
{
        public int compare(student s1,student s2){
      	  String name=s1.getname();
    	  String t=s2.getname();
    	  //得到中文校验器。
    	  Collator test=Collator.getInstance(Locale.CHINA);
    	  int result=test.compare(name,t);
    	  if(result<0)
    	  {
    		  return -1;
    	  }
    	  else if(result==0)
    	  {
    		  return 0;
    	  }
    	  else
    	  {
    		  return 1;
    	  }
        }
}