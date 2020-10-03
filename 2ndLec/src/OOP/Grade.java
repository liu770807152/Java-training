package OOP;

public enum Grade {
    /* 关于final关键字：
    用final修饰普通变量通常分为两种情况，修饰普通基本类变量和修饰引用类型变量，也就是对象类型变量。
    修饰普通基本类型变量最能清楚直白的表现出final的作用，它能使变量的值无法改变，因为变量不能再次被赋值。

    运行此代码，编译器会报错：
    final int myInt = 1;
    myInt = 2;

    但我们使用final修饰引用类型变量时，我们可以保证变量不能被再次赋值，但我们无法保证对象值的改变。

    final StringBuilder sb = new StringBuilder("Java");
    sb.append("Script");
    System.out.println(sb);  //resultJavaScript

    如上代码所示， 虽然我们用final修饰变量，但仍旧无法阻止变量内在值的改变。
    使用final能保证变量不能改变引用的目标，却不能保证变量所引用的目标本身的变化。
    因为对于基本类型，我们可以把变量看作是变量值的本身；而对于引用类型变量，变量和变量的值需要区分看待，它们只是以某种方式被关联起来了而已，
    事实上它们是不同的东西，所以final无法同时作用于两者身上。
    ===================================================================================================================
    Java不支持原生常量，在Java种也没有定义常量的const关键字。然而， 我们可以使用final关键字间接的实现常量。

    public static final int CONST_ONE = 1;
    public static final int CONST_TWO = 2;

    常量是全局的、不可变的，因此我们同时使用static和final来修饰变量，就能达到定义常量的效果。 常量名通常全由大写字母组成。
    ===================================================================================================================
    final可以保证实例变量必须被初始化，这点特性能减少代码出错几率，如令所有Java程序员头疼的NullPointerException

    public class Main {
        private String name ;
        @Override
        public String toString() {
            return name;
        }
        public static void main(String[] arg) throws Exception {
            Main main = new Main();
            System.out.println(main.toString().toLowerCase());
        }
    }
    以上代码因为没给name赋值，代码在运行起将报NPE异常。假如我们使用final修饰name变量，代码将无法通过编译，
    因为Java语法规定，final变量在使用前必须被初始化，因此我们必须在构造函数中初始化name变量，这样能百分百保证我们使用的name变量不会是null。
    ===================================================================================================================
    如果我们用final修饰方法，假如方法所属的类被继承，方法将不能在子类中被重写。

    class SuperClass{
       protected final String getName() {
           return “supper class”;
       }

       @Override
        public String toString() {
            return getName();
        }
    }

    class SubClass extends SuperClass{
        @override
      protected String getName() {
          return “sub class”;
      }
    }
    以上代码无法通过编译，编译器报错。因为SuperClass的getName方法被修饰为final，因此在子类中无法被重写。
    通常，我们不希望方法在被继承时重写，可以用private修饰，因为这样方法的可见性被限制于方法所在的类中。
    但是，有时候我们需要公开方法，却又不想方法被重写，此时用final修饰方法就有用武之地了。
     */
    HD(80), D(70), CR(60), P(50), N(0);
    private final int lowerBound;

    Grade(int lowerBound) {
        this.lowerBound = lowerBound;
    }

    public static Grade fromMark(int mark) {
        for (Grade g : Grade.values()) {
            if (mark >= g.lowerBound) {
                return g;
            }
        }
        return N;
    }
}

