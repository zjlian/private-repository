public class Operator {
	public static void main(String[] args) {
		int x=5,y=4,z=3;
		System.out.println("输出前缀++和*运算结果："+((x++)*y));
		System.out.println("输出后缀++和/运算结果："+((++x)/y));
		System.out.println("输出前缀--和%运算结果："+((x--)%y));
		System.out.println("输出后缀--和+运算结果："+((--x)+y));
		System.out.println("输出&&、>和</运算结果："+((x>4)&&(y<3)));
		System.out.println("输出||、>=和<=/运算结果："+((x>=5)||(y<=3)));
		System.out.println("输出^、==和!=运算结果："+((x!=4)^(y==3)));
		System.out.println("输出!运算结果："+(!(x>y)));
		System.out.println("输出+=运算结果："+(x+=7));

		System.out.println("输出条件运算符结果："+((x>y)?((x>z)?x:z):((y>z)?y:z)));
		byte device=0X0E;
		byte save=0X0A;
		byte set=0X0C;
		byte reverse=0X0F;
		
		System.out.println("输出按位与运算结果："+(device&save));
		System.out.println("输出按位或运算结果："+(device|set));
		System.out.println("输出按位异或运算结果："+(device^reverse));
		System.out.println("输出按位取反运算结果："+(~device));
		System.out.println("输出右移1位运算结果："+(device>>1));
		System.out.println("输出带符号右移1位运算结果："+(device>>>1));
		System.out.println("输出左移1位运算结果："+(device<<1));

	}
}
