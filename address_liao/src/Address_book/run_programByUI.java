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
import Address_book.op_UIR;//������洦����غ���
public class run_programByUI {
public static void main(String[] args)
{
String filename="address.txt";
op_UIR op_ui= new op_UIR();//������洦�������
ArrayList<student> students=new ArrayList<student>();//���崢��ͨѶ��Ϣ����
file_op op=new file_op();//�����ļ�������
op.ReadFromfileIntoArray(filename, students);
JFrame jf=new JFrame("ѧ��ͨѶ¼ϵͳ");
jf.setBounds(300,50,1000,800);
jf.setLayout(new BorderLayout());
JPanel jp=new JPanel();
jp.setBounds(100,100,1000,200);
JTextArea area=new JTextArea(35,80); //�����ı���
JScrollPane js = new JScrollPane(area);//����������
jp.add(js);//��ӹ�����
JButton jb1= new JButton("�˳����򲢱������");
jb1.addActionListener(new ActionListener()//��ť����ģ��
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
JButton jb8= new JButton("�˳����򲻱������");
jb8.addActionListener(new ActionListener()//��ť����ģ��
{
@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource()==jb8) {
		System.exit(0);
	}
}
}
);
JButton jb2= new JButton("ˢ����ʾ");//ˢ�²���ʾҳ��
jb2.addActionListener(new ActionListener()//��ʾ���°�ť
		{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==jb2)
			{
				//�����ı������ͨѶ¼
			op_ui.ShowAreas(area, students);
			jf.setVisible(true);	
			}
		}
		}
		);
JButton jb3= new JButton("�����ϵ��");//��Ӱ�ť
jb3.addActionListener(new ActionListener()//��ť����ģ��
{
@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource()==jb3) {
		JDialog jd = new JDialog(jf,"�����ϵ�˴���"); //�����Ӵ���
		jd.setBounds(350, 340, 1000, 200);
		jd.setLayout(new BorderLayout());
		JPanel jp=new JPanel();
		JPanel jp2=new JPanel();
		JLabel jl= new JLabel("�����ʽ������ �绰 סַ QQ ѧУ(��ֵ����ޡ�)");
		JLabel jl2= new JLabel("��ӽ��");
		jp.add(jl);//���˵��label
		JTextArea area1=new JTextArea(2,30);
		jp.add(area1);//����ı���area1
		JTextArea area2=new JTextArea(2,30);
		jp2.add(jl2);//��ӽ����label
		jp2.add(area2);//���������
		JButton jb= new JButton("�������");
		jb.addActionListener(new ActionListener()
		{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==jb)
			{
				op_ui.UIAddAddress(area2,area1, students);//area1��Ϣ����������Ϣ��students�д���������area2
				jd.add(jp);
			}
		}
		}
		);
		jp.add(jb);//��������ȷ�ϰ�ť
		jd.add(jp,BorderLayout.NORTH);//�������ô�������
		jd.add(jp2,BorderLayout.CENTER);//�������ô��ڽ��
		jd.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		jd.setVisible(true);//��ʾ�Ӵ���
	}
}
}
);
JButton jb4= new JButton("ɾ����ϵ�ˣ�������");//ɾ����ť
jb4.addActionListener(new ActionListener()//��ť����ģ��
{
@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource()==jb4) {
		JDialog jd = new JDialog(jf,"ͨ������ɾ����ϵ��"); //�����Ӵ���
		jd.setBounds(450, 350, 600, 200);
		JPanel jp=new JPanel();
		JPanel jp2=new JPanel();
		JLabel jl2= new JLabel("ɾ�����");
		JLabel jl= new JLabel("������ɾ����ϵ�˵�����:");
		jp.add(jl);//���˵��label
		JTextArea area1=new JTextArea(2,30);
		jp.add(area1);//����ı���area1
		JTextArea area2=new JTextArea(2,30);
		jp2.add(jl2);//��ӽ����label
		jp2.add(area2);//���������
		JButton jb= new JButton("�������");
		jb.addActionListener(new ActionListener()
		{
		@Override
		public void actionPerformed(ActionEvent e) {
			String name;
			name=area1.getText();
			if(e.getSource()==jb)
			{
				op_ui.UIDelectAddressByname(area2, name, students);//ɾ����Ӧ������ϵ�˲����������area2
			}
		}
		}
		);
		jp.add(jb);//��������ȷ�ϰ�ť
		jd.add(jp,BorderLayout.NORTH);//�������ô�������
		jd.add(jp2,BorderLayout.CENTER);//�������ô��ڽ��
		jd.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		jd.setVisible(true);//��ʾ�Ӵ���
	}
}
}
);

JButton jb5= new JButton("����"); //���水ť
jb5.addActionListener(new ActionListener()//��ť����ģ��
{
@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource()==jb5) {
		op.WriteInFile(filename, students);
		JDialog jd = new JDialog(jf,"����"); //�����Ӵ���
		jd.setBounds(700, 300, 100,100);
		JPanel jp=new JPanel();
		JLabel jl= new JLabel("����ɹ�");
		jp.add(jl);//���˵��label
		jd.add(jp);//�������ô���
		jd.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		jd.setVisible(true);//��ʾ�Ӵ���
	}
}
}
);
JButton jb6= new JButton("����");
jb6.addActionListener(new ActionListener()//��ť����ģ��
{
@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource()==jb6) {
		JDialog jd = new JDialog(jf,"����������ĸ����"); //�����Ӵ���
		jd.setBounds(310,60,1000,900);
		JPanel jp=new JPanel();
		JTextArea area1=new JTextArea(35,80);
		JScrollPane js = new JScrollPane(area1);
		jp.add(js);//����ı���area1
		int i,j,sign;
		student s1;
		String info;
		char[] Char_test= {'A','B','C','D','E','F','G','H','I','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		ArrayList<student> student_in=new ArrayList<student>();//���崢��ͨѶ��Ϣ����
		//�����ı������ͨѶ¼
		op.SortByFirstName(students);//����ʽ����
		String name="����",Snum="ѧ��",address="סַ",QQ="QQ",unit="��λ";
		String w="          ";
		String title=name+w+w+"\t"+Snum+w+w+"\t"+address+w+w+w+"\t"+QQ+w+w+w+"\t"+unit+"\n";
		area1.append(title);
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
				area1.append(t+"\n");
				for(student s2 :student_in)
				{
					info=s2.getname()+w+w+"\t"+s2.getSnum()+w+w+"\t"+s2.getaddress()+w+w+w+"\t"+s2.getQQ()+w+w+w+"\t"+s2.getunit()+"\n";
					area1.append(info);
				}
			}
			student_in.clear();
		}
		
		jd.add(jp);//�������ô���
		jd.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		jd.setVisible(true);//��ʾ�Ӵ���
	}
}
}
);
JButton jb7= new JButton("��ѯ");//��ѯ��ť
jb7.addActionListener(new ActionListener()//��ť����ģ��
{
@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource()==jb7) {
		JDialog jd = new JDialog(jf,"��ѯ��ϵ�˴���"); //�����Ӵ���
		jd.setBounds(450, 350, 1000, 300);
		jd.setLayout(new BorderLayout());
		JPanel jp=new JPanel();
		JPanel jp2=new JPanel();
		JLabel jl= new JLabel("����Ҫ��ѯ�˵�����");
		JLabel jl2= new JLabel("��ѯ���");
		jp2.add(jl2);
		jp.add(jl);//���˵��label
		JTextArea area1=new JTextArea(1,10);
		jp.add(area1);//����ı���area1
		JTextArea area2=new JTextArea(7,80);
		jp2.add(area2);
		JScrollPane js = new JScrollPane(area2);//����������
		jp2.add(js);//��ӹ�����
		JButton jb= new JButton("�������");
		jb.addActionListener(new ActionListener()
		{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==jb)
			{
				String name=area1.getText().trim();
				op_ui.UIFind_address(area2, name, students);//�ҵ�Ҫ��ѯ���˲������������ı���
			}
		}
		}
		);
		jp.add(jb);//��������ȷ�ϰ�ť
		jd.add(jp,BorderLayout.NORTH);//�������ô��ڱ�
		jd.add(jp2,BorderLayout.CENTER);//�������ô�����
		jd.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		jd.setVisible(true);//��ʾ�Ӵ���
	}
}
}
);
//jp��Ӹ�����ť
jp.add(jb1,BorderLayout.NORTH);
jp.add(jb8,BorderLayout.NORTH);
jp.add(jb2,BorderLayout.NORTH);
jp.add(jb3,BorderLayout.NORTH);
jp.add(jb4,BorderLayout.NORTH);
jp.add(jb5,BorderLayout.NORTH);
jp.add(jb6,BorderLayout.NORTH);
jp.add(jb7,BorderLayout.NORTH);
jp.add(js,BorderLayout.SOUTH);
jf.add(jp);//jf���jp
jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
jf.setVisible(true);
}
}


