import java.util.Scanner;

public class ArithmeticOperator
{
    public static void main(String[] args)
    {
        int time, S, M, H;
        Scanner sc = new Scanner(System.in);

        System.out.print("정수를 입력하세요:");
        time = sc.nextInt();
        S = time % 60;
        M = time / 60 % 60;
        H = time / 60 / 60;

        System.out.println(time + "초는 " + H + "시간, " + M + "분, " + S + "초입니다.");
    }
}