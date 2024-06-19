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
import Address_book.op_UIR;//引入界面处理相关函数
public class run_programByUI {
public static void main(String[] args)
{
String filename="address.txt";
op_UIR op_ui= new op_UIR();//定义界面处理操作类
ArrayList<student> students=new ArrayList<student>();//定义储存通讯信息数组
file_op op=new file_op();//定义文件操作类
op.ReadFromfileIntoArray(filename, students);
JFrame jf=new JFrame("学生通讯录系统");
jf.setBounds(300,50,1000,800);
jf.setLayout(new BorderLayout());
JPanel jp=new JPanel();
jp.setBounds(100,100,1000,200);
JTextArea area=new JTextArea(35,80); //建立文本框
JScrollPane js = new JScrollPane(area);//建立滚动框
jp.add(js);//添加滚动框
JButton jb1= new JButton("退出程序并保存更改");
jb1.addActionListener(new ActionListener()//按钮触发模块
{
@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource()==jb1) {
		op.WriteInFile(filename, students);
		System.exit(0);
	}
}
}
);
JButton jb8= new JButton("退出程序不保存更改");
jb8.addActionListener(new ActionListener()//按钮触发模块
{
@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource()==jb8) {
		System.exit(0);
	}
}
}
);
JButton jb2= new JButton("刷新显示");//刷新并显示页面
jb2.addActionListener(new ActionListener()//显示更新按钮
		{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==jb2)
			{
				//设置文本框输出通讯录
			op_ui.ShowAreas(area, students);
			jf.setVisible(true);	
			}
		}
		}
		);
JButton jb3= new JButton("添加联系人");//添加按钮
jb3.addActionListener(new ActionListener()//按钮触发模块
{
@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource()==jb3) {
		JDialog jd = new JDialog(jf,"添加联系人窗口"); //设置子窗口
		jd.setBounds(350, 340, 1000, 200);
		jd.setLayout(new BorderLayout());
		JPanel jp=new JPanel();
		JPanel jp2=new JPanel();
		JLabel jl= new JLabel("输入格式：姓名 电话 住址 QQ 学校(空值请填“无”)");
		JLabel jl2= new JLabel("添加结果");
		jp.add(jl);//添加说明label
		JTextArea area1=new JTextArea(2,30);
		jp.add(area1);//添加文本框area1
		JTextArea area2=new JTextArea(2,30);
		jp2.add(jl2);//添加结果框label
		jp2.add(area2);//添加输出结果
		JButton jb= new JButton("输入完毕");
		jb.addActionListener(new ActionListener()
		{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==jb)
			{
				op_ui.UIAddAddress(area2,area1, students);//area1信息载入输入信息到students中存入结果载入area2
				jd.add(jp);
			}
		}
		}
		);
		jp.add(jb);//加入输入确认按钮
		jd.add(jp,BorderLayout.NORTH);//加入内置窗口输入
		jd.add(jp2,BorderLayout.CENTER);//加入内置窗口结果
		jd.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		jd.setVisible(true);//显示子窗口
	}
}
}
);
JButton jb4= new JButton("删除联系人（姓名）");//删除按钮
jb4.addActionListener(new ActionListener()//按钮触发模块
{
@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource()==jb4) {
		JDialog jd = new JDialog(jf,"通过姓名删除联系人"); //设置子窗口
		jd.setBounds(450, 350, 600, 200);
		JPanel jp=new JPanel();
		JPanel jp2=new JPanel();
		JLabel jl2= new JLabel("删除结果");
		JLabel jl= new JLabel("请输入删除联系人的姓名:");
		jp.add(jl);//添加说明label
		JTextArea area1=new JTextArea(2,30);
		jp.add(area1);//添加文本框area1
		JTextArea area2=new JTextArea(2,30);
		jp2.add(jl2);//添加结果框label
		jp2.add(area2);//添加输出结果
		JButton jb= new JButton("输入完毕");
		jb.addActionListener(new ActionListener()
		{
		@Override
		public void actionPerformed(ActionEvent e) {
			String name;
			name=area1.getText();
			if(e.getSource()==jb)
			{
				op_ui.UIDelectAddressByname(area2, name, students);//删除对应姓名联系人并将结果载入area2
			}
		}
		}
		);
		jp.add(jb);//加入输入确认按钮
		jd.add(jp,BorderLayout.NORTH);//加入内置窗口输入
		jd.add(jp2,BorderLayout.CENTER);//加入内置窗口结果
		jd.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		jd.setVisible(true);//显示子窗口
	}
}
}
);

JButton jb5= new JButton("保存"); //保存按钮
jb5.addActionListener(new ActionListener()//按钮触发模块
{
@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource()==jb5) {
		op.WriteInFile(filename, students);
		JDialog jd = new JDialog(jf,"保存"); //设置子窗口
		jd.setBounds(700, 300, 100,100);
		JPanel jp=new JPanel();
		JLabel jl= new JLabel("保存成功");
		jp.add(jl);//添加说明label
		jd.add(jp);//加入内置窗口
		jd.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		jd.setVisible(true);//显示子窗口
	}
}
}
);
JButton jb6= new JButton("分组");
jb6.addActionListener(new ActionListener()//按钮触发模块
{
@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource()==jb6) {
		JDialog jd = new JDialog(jf,"按姓氏首字母分组"); //设置子窗口
		jd.setBounds(310,60,1000,900);
		JPanel jp=new JPanel();
		JTextArea area1=new JTextArea(35,80);
		JScrollPane js = new JScrollPane(area1);
		jp.add(js);//添加文本框area1
		int i,j,sign;
		student s1;
		String info;
		char[] Char_test= {'A','B','C','D','E','F','G','H','I','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		ArrayList<student> student_in=new ArrayList<student>();//定义储存通讯信息数组
		//设置文本框输出通讯录
		op.SortByFirstName(students);//排序式分组
		String name="姓名",Snum="学号",address="住址",QQ="QQ",unit="单位";
		String w="          ";
		String title=name+w+w+"\t"+Snum+w+w+"\t"+address+w+w+w+"\t"+QQ+w+w+w+"\t"+unit+"\n";
		area1.append(title);
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
				area1.append(t+"\n");
				for(student s2 :student_in)
				{
					info=s2.getname()+w+w+"\t"+s2.getSnum()+w+w+"\t"+s2.getaddress()+w+w+w+"\t"+s2.getQQ()+w+w+w+"\t"+s2.getunit()+"\n";
					area1.append(info);
				}
			}
			student_in.clear();
		}
		
		jd.add(jp);//加入内置窗口
		jd.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		jd.setVisible(true);//显示子窗口
	}
}
}
);
JButton jb7= new JButton("查询");//查询按钮
jb7.addActionListener(new ActionListener()//按钮触发模块
{
@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource()==jb7) {
		JDialog jd = new JDialog(jf,"查询联系人窗口"); //设置子窗口
		jd.setBounds(450, 350, 1000, 300);
		jd.setLayout(new BorderLayout());
		JPanel jp=new JPanel();
		JPanel jp2=new JPanel();
		JLabel jl= new JLabel("输入要查询人的姓名");
		JLabel jl2= new JLabel("查询结果");
		jp2.add(jl2);
		jp.add(jl);//添加说明label
		JTextArea area1=new JTextArea(1,10);
		jp.add(area1);//添加文本框area1
		JTextArea area2=new JTextArea(7,80);
		jp2.add(area2);
		JScrollPane js = new JScrollPane(area2);//建立滚动框
		jp2.add(js);//添加滚动框
		JButton jb= new JButton("输入完毕");
		jb.addActionListener(new ActionListener()
		{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==jb)
			{
				String name=area1.getText().trim();
				op_ui.UIFind_address(area2, name, students);//找到要查询的人并将数据载入文本域
			}
		}
		}
		);
		jp.add(jb);//加入输入确认按钮
		jd.add(jp,BorderLayout.NORTH);//加入内置窗口北
		jd.add(jp2,BorderLayout.CENTER);//加入内置窗口南
		jd.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		jd.setVisible(true);//显示子窗口
	}
}
}
);
//jp添加各个按钮
jp.add(jb1,BorderLayout.NORTH);
jp.add(jb8,BorderLayout.NORTH);
jp.add(jb2,BorderLayout.NORTH);
jp.add(jb3,BorderLayout.NORTH);
jp.add(jb4,BorderLayout.NORTH);
jp.add(jb5,BorderLayout.NORTH);
jp.add(jb6,BorderLayout.NORTH);
jp.add(jb7,BorderLayout.NORTH);
jp.add(js,BorderLayout.SOUTH);
jf.add(jp);//jf添加jp
jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
jf.setVisible(true);
}
}


