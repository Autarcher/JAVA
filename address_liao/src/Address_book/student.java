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
	  this.name="未知";
	  this.Snum="未知";
	  this.address="未知";
	  this.QQ="未知";
	  this.unit="未知";  
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
	  return "姓名:"+name+"  学号:"+Snum+"  住址:"+address+"  QQ号:"+QQ+"  单位:"+unit;
  }
  //排序
  public boolean equals(student temp)
  {
	  boolean a=false;
	  String t=temp.getname();
	  //得到中文校验器。
	  Collator test=Collator.getInstance(Locale.CHINA);
	  int result=test.compare(name,t);
	  if(result<=0)
	  {
		  a=true;
	  }
	  return  a;
  }
}
