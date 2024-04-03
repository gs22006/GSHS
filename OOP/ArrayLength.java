import java.util.Scanner;

public class ArrayLength
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int arr[] = new int[5];
        double ans = 0;

        for(int i = 0 ; i < arr.length ; i++)
            arr[i] = in.nextInt();
        
        for(int i = 0 ; i < arr.length ; i++)
            ans += arr[i];
        
        ans /= arr.length;
        System.out.println("배열 원소의 평균은 " + ans + "입니다.");
    }
}