package stupid;
public class app2_3{ 
public static void main(String args[]) {
byte b=0x55;
short s=0x55ff;
int i=1000000;
long l=0xffffL;
char c='c';
float f=0.23f;
double d=0.7e-3;
boolean B=true;
String S="This is a string";
System.out.println(" 字节型变量b="+b);
System.out.println (" 短整型变量s="+s);
System.out.println (" 整型变量i="+i);
System.out.println (" 长整型变量l="+l);
System.out.println (" 字符型变量c="+c);
System.out.println (" 浮点型变量f="+f);
System.out.println (" 双精度变量d="+d);
System.out.println (" 布尔型变量B="+B);
System.out.println (" 字符串类对象S="+S); 
S=" 改变的数据";
System.out.println (" 改变数据的S="+S);
}
}
