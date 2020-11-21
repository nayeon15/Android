
import java.util.Scanner;

public class calu {

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        String[] input=s.nextLine().split(" ");
        double result=0;
        int a=Integer.parseInt(input[0]);
        int b=Integer.parseInt(input[2]);
        char c=input[1].charAt(0);
        switch(c) {
            case '+':
                System.out.printf("%d + %d = %d",a,b,a+b);
                break;
            case '-':
                System.out.printf("%d - %d = %d",a,b,a-b);
                break;
            case '*':
                System.out.printf("%d * %d = %d",a,b,a*b);
                break;
            case '/':
                result=(double)a/b;
                System.out.printf("%d / %d = %.5f",a,b,result);
                break;
        }
    }

}
