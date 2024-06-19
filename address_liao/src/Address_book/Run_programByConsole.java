package Address_book;
import Address_book.file_op;//���������
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.*;
import Address_book.student; //����Ԫ����
public class Run_programByConsole {
public static void main(String[] args)
{
	String name,Snum,address,QQ,unit;
	Scanner input=new Scanner(System.in);
	String filename="address.txt";
	ArrayList<student> students=new ArrayList<student>();//���崢��ͨѶ��Ϣ����
	file_op op=new file_op();
	int chiose=1;
	boolean sign=true;
	while(sign)
	{
	switch (chiose)
	{
	case 0: //����0:�˳�����
		    op.WriteInFile(filename, students);//��������
			sign=false;
			break;
	case 1:op.ReadFromfileIntoArray(filename, students);//����1:ִ���ļ��������鲢��������
	       op.show_address(students);
			break;
	case 2: //����2:���Ԫ�ؽ������鲢�������
		System.out.println("�����ʽ������ �绰 סַ QQ ѧУ ");
		name=input.next();
		Snum=input.next();
		address=input.next();
		QQ=input.next();
		unit=input.next();
		student s1=new student(name,Snum,address,QQ,unit);
		if(op.FindSameName(name, students))
		{
			System.out.println("�����Ѵ��ڴ���ʧ��");
		}
		else
		{
			students.add(s1);
			System.out.println("��ӳɹ�");	
		}
		break;
	case 3://����3ɾ����Ӧ����
		System.out.println("����Ҫɾ����ͨѶ����");
		name=input.next();
		op.DelectAddressByname(name, students);
		break;
	case 4://����4����ɾ���������
		op.WriteInFile(filename, students);
		break;
	case 5://����5������ʾ
		System.out.println("����ͨѶ¼��ʾ");
		op.show_address(students);
		break;
	case 6://����6����������ĸ���������б�
		System.out.println("����������ĸ���������б�");
		op.ShowBynamefirst(students);
		break;
	case 7://����7��ѯ��Ӧ��������Ϣ
		System.out.println("����Ҫ���ҵ�ͨѶ����");
		name=input.next();
		op.FindByName(name, students);
		break;
	default:
		sign=false;
	}
	if(sign)//�жϳ����Ƿ����
	{
		System.out.println("����0:�˳��������벻����Ҫ��Ҳ���˳�����");
		System.out.println("����1:ִ���ļ��������鲢��������");
		System.out.println("����2:���Ԫ�ؽ�������");
		System.out.println("����3ɾ����Ӧ����");
		System.out.println("����4����ɾ�������");
		System.out.println("����5������ʾ");
		System.out.println("����6����������ĸ������б�");
		System.out.println("����7��ѯ��Ӧ��������Ϣ");
		try {
			chiose=input.nextInt();
		}catch(InputMismatchException e)
		{
			sign=false;
		}
		
	}
	
	}
	System.out.println("ͨѶ¼�ر�");
}
}

