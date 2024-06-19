package Address_book;
import java.util.*;
import Address_book.file_op;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.Collator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Address_book.file_op;//引入操作类
public class op_UIR {
void ShowAreas(JTextArea area1,ArrayList<student> students)//按格式提交students内元组到文本域内
{
	String name="姓名",Snum="电话",address="住址",QQ="QQ",unit="学校";
	String w="          ";
	String title=name+w+w+"\t"+Snum+w+w+"\t"+address+w+w+w+"\t"+QQ+w+w+w+"\t"+unit+"\n";
	String info;
	area1.setText("");
	area1.append(title);
	for(student s1: students)
	{
		info=s1.getname()+w+w+"\t"+s1.getSnum()+w+w+"\t"+s1.getaddress()+w+w+w+"\t"+s1.getQQ()+w+w+w+"\t"+s1.getunit()+"\n";
		area1.append(info);
	}
}
void UIDelectAddressByname(JTextArea area1,String name,ArrayList<student> students) //按名字删除元组
{
	int i,sign=0;
	student s1;
	for(i=0;i<students.size()&&sign==0;i++)//查找第一个交这个名字的人
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
		area1.setText("未找到此人");
	}
	else
	{
		area1.setText("删除操作完成");
	}
}
void UIFind_address(JTextArea area1,String name,ArrayList<student> students) //按姓名查询通讯信息
{
	ArrayList<student> student_find=new ArrayList<student>();//定义储存通讯信息数组
	int i,index=-1;
	student s1;
	for(i=0;i<students.size();i++)//查找第一个交这个名字的人
	{
		s1=students.get(i);
		if(s1.getname().equals(name))
		{
			student_find.add(s1);
			index=1;
		}
	}
	if(index==-1)
	{
		area1.setText("查无此人");
	}
	else
	{
		ShowAreas(area1, student_find);//设置文本域
	}
}
void UIAddAddress(JTextArea area2,JTextArea area1,ArrayList<student> students) //添加通讯录信息
{
	String name=null,Snum=null,address=null,QQ=null,unit=null;
	String temp=area1.getText().trim();
	file_op op=new file_op();
	String[] info=temp.split(" ");//按空格分割输入
	try
	{
	name=info[0];
	Snum=info[1];
	address=info[2];
	QQ=info[3];
	unit=info[4];
	if(!op.FindSameName(name, students))
	{
	student s1=new student(name,Snum,address,QQ,unit);
	students.add(s1);
	area2.setText("存入成功");
	}
	else
	{
		area2.setText("姓名已存在存入失败");
	}
	}catch(ArrayIndexOutOfBoundsException e)
	{
		area2.setText("数据输入不完整存入失败");
	}
}
}
