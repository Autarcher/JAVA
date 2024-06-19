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
	for(i=0;i<students.size()&&sign==0;i++)//���ҵ�һ����������ֵ���
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
		System.out.println("δ�ҵ�����ɾ��ʧ��");
	}
	else
	{
		System.out.println("ɾ���ɹ�");
	}
}
void WriteInFile(String filename,ArrayList<student> students) //������д���ļ�
{
	File f=new File("address.txt");
	int i;
	String name,Snum,address,QQ,unit;
		try {
		FileWriter outone=new FileWriter(f);
		BufferedWriter outtow=new BufferedWriter(outone);
		//������д���ļ�����
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
	    //�ر�������
		}
	    outtow.close();
	    outone.close();
		}catch(IOException e)
		{
			System.out.println(e);
		}	
}
void ReadFromfileIntoArray(String filename,ArrayList<student> students)//�����ļ���students��
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
	    	if(sign==0)//�����ȡ��һ���˵���������
	    	{
	    		student temp=new student(name,Snum,address,QQ,unit);
	    		students.add(temp);
	    	}
	    }
	    //�ر������
	    intow.close();
	    inone.close();
		}catch(IOException e)
		{
			System.out.println(e);
		}	
}
void show_address(ArrayList<student> students) 
{
	String name="����",Snum="ѧ��",address="סַ",QQ="QQ",unit="��λ";
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
void FindByName(String name,ArrayList<student> students)//ͨ����������
{
	ArrayList<student> student_find=new ArrayList<student>();//���崢��ͨѶ��Ϣ����
	int i,sign=0;
	student s1;
	for(i=0;i<students.size();i++)//��������������ֵ�������
	{
		s1=students.get(i);
		if(s1.getname().equals(name))
		{
			student_find.add(s1);
			sign=1;
		}
	}
	System.out.println("���ҽ��:");
	if(sign!=0)
	{
		for(student s2:student_find)
		{
		   System.out.println(s2);
		}
	
	}
	else
	{
		System.out.println("���޴���");
	}
}
void ShowBynamefirst(ArrayList<student> students)
{
	int i,j,sign;
	student s1;
	char[] Char_test= {'A','B','C','D','E','F','G','H','I','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	ArrayList<student> student_in=new ArrayList<student>();//���崢��ͨѶ��Ϣ����
	//�����ı������ͨѶ¼
	String name="����",Snum="�绰",address="סַ",QQ="QQ",unit="ѧУ";
	System.out.printf("%-10s\t %-20s\t %-30s\t %-20s\t %-30s\t \n",name,Snum,address,QQ,unit);
	for(i=0;i<Char_test.length;i++) //����ĸ�������
	{
		char t=Char_test[i];
		sign=0;
		for(j=0;j<students.size();j++)//���ж�����ĸ�Ƿ��뵱ǰ��ĸ���
		{
			s1=students.get(j);
			if(s1.getfirstchar()==t)//����ǵ�ǰ��ĸ����ӵ��������ı�����
			{
				student_in.add(s1);
				sign=1;
			}
		}
		if(sign==1)//��ǰ��ĸ����Ԫ��
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



class SortByKey implements Comparator<student>  //ʵ��Comparator���ʵ�ְ���������ĸ����
{
        public int compare(student s1,student s2){
      	  String name=s1.getname();
    	  String t=s2.getname();
    	  //�õ�����У������
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