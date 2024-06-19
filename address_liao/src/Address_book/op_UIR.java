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
import Address_book.file_op;//���������
public class op_UIR {
void ShowAreas(JTextArea area1,ArrayList<student> students)//����ʽ�ύstudents��Ԫ�鵽�ı�����
{
	String name="����",Snum="�绰",address="סַ",QQ="QQ",unit="ѧУ";
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
void UIDelectAddressByname(JTextArea area1,String name,ArrayList<student> students) //������ɾ��Ԫ��
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
		area1.setText("δ�ҵ�����");
	}
	else
	{
		area1.setText("ɾ���������");
	}
}
void UIFind_address(JTextArea area1,String name,ArrayList<student> students) //��������ѯͨѶ��Ϣ
{
	ArrayList<student> student_find=new ArrayList<student>();//���崢��ͨѶ��Ϣ����
	int i,index=-1;
	student s1;
	for(i=0;i<students.size();i++)//���ҵ�һ����������ֵ���
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
		area1.setText("���޴���");
	}
	else
	{
		ShowAreas(area1, student_find);//�����ı���
	}
}
void UIAddAddress(JTextArea area2,JTextArea area1,ArrayList<student> students) //���ͨѶ¼��Ϣ
{
	String name=null,Snum=null,address=null,QQ=null,unit=null;
	String temp=area1.getText().trim();
	file_op op=new file_op();
	String[] info=temp.split(" ");//���ո�ָ�����
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
	area2.setText("����ɹ�");
	}
	else
	{
		area2.setText("�����Ѵ��ڴ���ʧ��");
	}
	}catch(ArrayIndexOutOfBoundsException e)
	{
		area2.setText("�������벻��������ʧ��");
	}
}
}
