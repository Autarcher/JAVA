package Address_book;

import java.text.Collator;
import java.util.Locale;
import Address_book.get_namefirstchar;
public class student {
private String name;
private String Snum;
private String address;
private String QQ;
private String unit;
private char firstchar;
  student(String name,String Snum,String address,String QQ,String unit)
  {
	  this.name=name;
	  this.Snum=Snum;
	  this.address=address;
	  this.QQ=QQ;
	  this.unit=unit;
	  firstchar=get_namefirstchar.get_namefirstchar(name);
  }
  student()
  {
	  this.name="δ֪";
	  this.Snum="δ֪";
	  this.address="δ֪";
	  this.QQ="δ֪";
	  this.unit="δ֪";  
  }
  String getname()
  {
	  return name;
  }
  String getSnum()
  {
	  return Snum;
  }
  String getaddress()
  {
	  return address;
  }
  char getfirstchar()
  {
	  return firstchar;
  }
  String getQQ()
  {
	  return QQ;
  }  String getunit()
  {
	  return unit;
  }
  void setname(String name)
  {
	  this.name=name;
	  firstchar=get_namefirstchar.get_namefirstchar(name);
  }
  void setSnum(String Snum)
  {
	  this.Snum=Snum;
  }
  void setaddress(String address)
  {
	  this.address=address;
  }
  void setQQ(String QQ)
  {
	  this.QQ=QQ;
  }
  void setunit(String unit)
  {
	  this.unit=unit;
  }
  public String toString()
  {
	  return "����:"+name+"  ѧ��:"+Snum+"  סַ:"+address+"  QQ��:"+QQ+"  ��λ:"+unit;
  }
  //����
  public boolean equals(student temp)
  {
	  boolean a=false;
	  String t=temp.getname();
	  //�õ�����У������
	  Collator test=Collator.getInstance(Locale.CHINA);
	  int result=test.compare(name,t);
	  if(result<=0)
	  {
		  a=true;
	  }
	  return  a;
  }
}
