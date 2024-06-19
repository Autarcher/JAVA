package Address_book;
import Address_book.file_op;//引入操作类
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.*;
import Address_book.student; //引入元组类
public class Run_programByConsole {
public static void main(String[] args)
{
	String name,Snum,address,QQ,unit;
	Scanner input=new Scanner(System.in);
	String filename="address.txt";
	ArrayList<student> students=new ArrayList<student>();//定义储存通讯信息数组
	file_op op=new file_op();
	int chiose=1;
	boolean sign=true;
	while(sign)
	{
	switch (chiose)
	{
	case 0: //输入0:退出程序
		    op.WriteInFile(filename, students);//更新数据
			sign=false;
			break;
	case 1:op.ReadFromfileIntoArray(filename, students);//输入1:执行文件读入数组并读出数组
	       op.show_address(students);
			break;
	case 2: //输入2:添加元素进入数组并更新输出
		System.out.println("输入格式：姓名 电话 住址 QQ 学校 ");
		name=input.next();
		Snum=input.next();
		address=input.next();
		QQ=input.next();
		unit=input.next();
		student s1=new student(name,Snum,address,QQ,unit);
		if(op.FindSameName(name, students))
		{
			System.out.println("姓名已存在存入失败");
		}
		else
		{
			students.add(s1);
			System.out.println("添加成功");	
		}
		break;
	case 3://输入3删除对应数据
		System.out.println("输入要删除的通讯人名");
		name=input.next();
		op.DelectAddressByname(name, students);
		break;
	case 4://输入4保存删、填操作；
		op.WriteInFile(filename, students);
		break;
	case 5://输入5更新显示
		System.out.println("更新通讯录显示");
		op.show_address(students);
		break;
	case 6://输入6按姓氏首字母排序分组后列表
		System.out.println("按姓氏首字母排序分组后列表");
		op.ShowBynamefirst(students);
		break;
	case 7://输入7查询对应姓名人信息
		System.out.println("输入要查找的通讯人名");
		name=input.next();
		op.FindByName(name, students);
		break;
	default:
		sign=false;
	}
	if(sign)//判断程序是否结束
	{
		System.out.println("输入0:退出程序（输入不符合要求也会退出程序）");
		System.out.println("输入1:执行文件读入数组并读出数组");
		System.out.println("输入2:添加元素进入数组");
		System.out.println("输入3删除对应数据");
		System.out.println("输入4保存删、填操作");
		System.out.println("输入5更新显示");
		System.out.println("输入6按姓氏首字母排序后列表");
		System.out.println("输入7查询对应姓名人信息");
		try {
			chiose=input.nextInt();
		}catch(InputMismatchException e)
		{
			sign=false;
		}
		
	}
	
	}
	System.out.println("通讯录关闭");
}
}

