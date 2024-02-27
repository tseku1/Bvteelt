package lab1;

import java.util.Scanner;

public class main extends MyArrayList
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        MyArrayList ml=new MyArrayList();
        
        System.out.print("Please enter the first size of your list:");
        int flag =0, n =sc.nextInt() , response;

        for(int i=0;i<n;i++)
        {
            System.out.print(i+1+"th element:");
            ml.add(i,sc.nextInt());
        }


        while( flag == 0 )
        {
            System.out.print("1.Add new element\n2.Max\n3.Min\n4.Avarage\n5.Sum\n6.Remove odd\n7.Sort\n8.unique\n10.QUIT\n");
            response = sc.nextInt();
            switch (response)
            {
                case 1:
                    System.out.print("please enter the new element:");
                    ml.add(ml.size(),sc.nextInt());
                    break;
                    
                case 2:
                    System.out.println("Max:"+ml.max());
                    break;

                case 3:
                    System.out.println("Min:"+ml.min());
                    break;

                case 4:
                    System.out.println("Avarage:"+ml.avarage());
                    break;
                    
                case 5:
                    System.out.println("Sum:"+ml.sum());
                    break;

                case 6:
                	System.out.println("removeOdd:"+ml.removeOdd());
                    break;

                case 7:
                    System.out.println("sort:" +ml.sort());
                    break;

                case 8:
                	System.out.println("unique:"+ml.unique());
                    break;

                case 9:
                    flag = 1;
                    break;

                default:
                    System.out.println("wrong input");
                    break;
            }
        }
    }
}