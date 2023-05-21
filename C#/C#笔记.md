## 格式化输入输出

```c#
name = System.Console.ReadLine();
System.Console.WriteLine("我的名字是{0}",name);
```

## 字符串忽略转义字符

```c#
string str1 = @"C:\Users\AXC\Desktop\C# study\code";  //加@忽略转义字符
```

## 字符串 转换大写

```c#
string str1 = "abc";
str1 = str1.ToUpper();
```

## 计时器

```c#
Stopwatch 计时器 = new Stopwatch();
计时器.Start();
//string str = string.Empty;
//for(int i = 0;i < 10000;i++)
//{
 //    str += i.ToString();
//}

StringBuilder sb = new StringBuilder();
for(int i=0;i<10000;i++)
{
	sb.Append(i.ToString());
}
计时器.Stop();
Console.WriteLine(计时器.ElapsedMilliseconds);
```

## 隐式类型 

```c#
var number = 1;
```

## 检查强制转换时的溢出

```c#
int a;
checked
{
	a = int.MaxValue;
	a = a+1;
}
```

## 类型转换

```c#
int a1 = int.Parse(str1);	//转换成int
```

```c#
var str1 = Console.ReadLine(); 
int a1;


if(int.TryParse(str1,out a1)) //更健壮
{
	Console.WriteLine(a1);
}
else
{
	Console.WriteLine("解析失败！");
}
```

```c#
a1.ToString(); //转换成字符串
```

## 不可变的常量

```c#
const int a = 10;
```

## 空结合运算符

表达式1??表达式2

```c#
string fileName = null;
fileName = fileName??"defalut.txt";
```

## 数组声明

```c#
int[] a= new int[10];
```

## foreach循环（遍历）

```c#
foreach(long x in a)
{
    Console.WriteLine(x);
}
```

## 生成随机数

```c#
Random r = new Random();
for(int i = 0;i < 10;i++)
{
	a[i] = r.Next(1, 10);
}
```

## 预处理指令

```c#
#region
#endregion
```

## list列表

```c#
using System.Collections.Generic;
using System.Linq;

var nums = new List<int>();
nums.Add(3);
nums.Add(2);
nums.Add(1);

nums.Sort();	//从小到大排序
nums.Max();
nums.Min();
nums.Average();


```

## 传引用类型

```c#
static void Swap(ref int a,ref int b){}
static void Main(string[] args)
{
    Swap(ref a, ref b);
}
```

## 泛型

```c#
static void Swap<T>(ref T a,ref T b){}
static void Main(string[] args)
{
    Swap<int>(ref a, ref b);
}
```

## 可变参数

```c#
static int Sum(params int[] nums)
{
    return nums.Sum();
}
```

## 文件统计

```c#
file.ToLower().EndsWith(extension);	//后缀名为extension的文件
```

## get and set

```c#
private string _Name;

public string Name
{
    get{return _Name;}
    set{_Name = value;}
}

//或者这样
public string Name{get;get;}
```

## readonly

仅能在声明、构造函数中赋值

## protected：继承类可以使用

## sealed class:无法被继承的类，密封类

## base.:访问基类的成员，访问基类的构造函数

## virtual and override

```c#
class Animal
{
    public virtual void Shout(){Console.WriteLine("未知的叫声");}
}

class Dog:Animal
{
    public override void Shout(){Console.WriteLine("狗的叫声");}
}
```

## 抽象类：实例化后无意义

```c#
abstract class Animal
{
    public abstract void Shout();
}
```

# 各种细节

## 枚举

```c#
enum ConnectionnState
{
	Connecting,
	Connected,
	Disconnecting,
	Disconnected,
}

static void Test(ConnectionnState state)
{
	switch (state)
	{
		case ConnectionnState.Connecting:
			break;
		case ConnectionnState.Connected:
			break;
	}
}
```

## 写入文件与资源自动清理

```c#
static void Main(string[] args)
{
	StreamWriter sw = new StreamWriter(new FileStream("777.txt",FileMode.Create,FileAccess.Write));
	sw.WriteLine("123");
	sw.Close();
}
```

```c#
static void Main(string[] args)
{
	using (StreamWriter sw = new StreamWriter(new FileStream("777.txt", FileMode.Create, FileAccess.Write)))
	{
		sw.WriteLine("123");
	}
                       
}
```

## 读取文件

```c#
using(var sr = new StreamReader("777.txt"))
{
	Console.WriteLine(sr.ReadToEnd());
}
```

# 委托

```c#
namespace ConsoleApp3
{
    class Program
    {
        delegate bool Function(int num);    //定义了一个Function类型的委托
        static Function GreaterThan10 = delegate (int n) { return n >= 10; };
        static Function IsEven = delegate (int num) { return num % 2 == 0; };

        static List<int> Traverse(List<int> nums, Function function)
        {
            List<int> list = new List<int>();
            foreach(int num in nums)
            {
                if (function(num))
                {
                    list.Add(num);
                }
            }
            return list;
        }
        static void Main(string[] args)
        {
            List<int> lists = new List<int>();
            lists = Traverse(new List<int>() { 1, 2, 3, 4, 5, 6, 7 },IsEven);
            foreach(int list in lists)
            {
                Console.WriteLine(list);
            }
        }
    }
}
```

# 多线程

```c#
namespace 多线程
{
    class Program
    {
        static void Main(string[] args)
        {
            var task = new Task(()=> 
            {
                for (int i = 0; i < 5000000; i++)
                {
                    Console.WriteLine(i);
                }
            });
            task.Start();
            task.Wait();
            
        }
    }
}
```

```c#
var task = Task.Factory.StartNew(()=>"1");
```

# DateTime

```c#
var dt = DateTime.Now;
Console.WriteLine(dt.ToString("yyyy-MM-dd HH:mm:ss"));
```

