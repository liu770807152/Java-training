public class 循环 {
    public static void main(String args[]){
        int [] numbers = {10, 20, 30, 40, 50};

        for(int i = 0; i < numbers.length; i++) {
            System.out.print( numbers[i] + "," + '\n' );
            if (numbers[i] == 30) {
                break;
            }
        }
        System.out.print("\n");
        String[] names ={"James", "Larry", "Tom", "Lacy"};
        for(String name : names ) {
            System.out.println(name + " ");
            if (name.equals("Larry") || name.equals("Tom")) {
                continue;
            }
            System.out.println(" not continued!");
        }
    }
}
