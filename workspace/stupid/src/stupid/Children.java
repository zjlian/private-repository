package stupid;

class Parents
{
String name; //姓名
char cSex;//性别
String nationality;//民族
Parents(String name,char sex,String nl)//构造方法
{
this.name=name;
cSex=sex;
nationality=nl;
}
void showInfo( String n,char s,String nl) //显示个人信息
{
System.out.print("姓名:"+n+" ");
System.out.print("性别:"+s+" ");
System.out.println("民族:"+nl);
}
}
public class Children extends Parents
{
String name; //姓名
char cSex;//性别
Children(String pm,char ps,String nl, String name,char sex) //构造方法 
{
super(pm,ps,nl); //调用父类构造方法，生成父类对象
this.name=name;//this区分同名变数
cSex=sex;
}
void showParent()//显示父类个人信息
{
showInfo(super.name,super.cSex,nationality); //调用父类的方法
}
void showChildren()//显示子类个人信息
{
showInfo(name,cSex,nationality); //调用父类的方法
}
public static void main(String[] args)
{
Children children=new Children("王强",'M',"汉族","王丽",'F');
System.out.println("父类信息如下：");
children.showParent();
System.out.println("子类信息如下：");
children.showChildren();
}
}
