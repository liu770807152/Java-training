public class AboutSwitch {
    public static void main(String args[]){
        //char grade = args[0].charAt(0);
        char grade = 'a';
        switch(grade)
        {
            case 'A':
                System.out.println("优秀");
                break;
            case 'B':
            case 'C':
                System.out.println("良好");
                break;
            case 'D':
                System.out.println("及格");
            case 'F':
                System.out.println("你需要继续努力");
                break;
            default:
                System.out.println("无效等级");
        }
        System.out.println("你的等级是 " + grade);
    }
}
