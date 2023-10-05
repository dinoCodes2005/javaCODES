import java.util.*;
public class dateProgram5
{
    String date;
    String day;
    String month;
    String year;
    int dayInt,monthInt,yearInt;
    int n;
    int numberOfDays[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    
    dateProgram5()
    {
        day="";
        month="";
        year="";
        dayInt=0;
        monthInt=0;
        yearInt=0;
        n=0;
    }
    
        int validDate(String date)
        {
        
        day = date.substring(0,2);
        month = date.substring(3,5);
        year = date.substring(6);
        
        dayInt = Integer.parseInt(day);
        monthInt = Integer.parseInt(month);
        yearInt = Integer.parseInt(year);
        
        if(yearInt<0||yearInt>9999)
        {
            return 0;
        }
        
        if((yearInt%4==0 && yearInt%100!=0)||yearInt%400==0)
        {
            numberOfDays[2]= 29;
        }
        
        if(monthInt>12||monthInt<0)
        {
            return 0;
        }

        if(monthInt==4||monthInt==6||monthInt==9||monthInt==11)
        {
            if(dayInt>30)
                return 0;
        }
        
        if(monthInt==2 && ((yearInt%4==0 && yearInt%100!=0)||yearInt%400==0))
        {
            if(dayInt>29)
            return 0;
        }
        
        if(monthInt==2 && ((yearInt%4!=0 && yearInt%100==0)||yearInt%400!=0))
        {
            if(dayInt==29)
            return 0;
        }
        return 1;
    }
    
    int dayCalculation(String date)
    {
        day = date.substring(0,2);
        month = date.substring(3,5);
        year = date.substring(6);
        
        dayInt = Integer.parseInt(day);
        monthInt = Integer.parseInt(month);
        yearInt = Integer.parseInt(year);
        
        n=dayInt;
        for(int i=1;i<monthInt;i++)
        {
            n+= numberOfDays[i];
        }
        return n;
    }
    
    public static void main(String args[])
    {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter the first date in DD/MM/YYYY format: ");
        String date1 = sc.nextLine();
        
        System.out.println("Enter the second date in DD/MM/YYYY format: ");
        String date2 = sc.nextLine();
        
        dateProgram5 obj = new dateProgram5();
        int check1=obj.validDate(date1);
        int check2=obj.validDate(date2);
        int n1 = obj.dayCalculation(date1);
        int n2 = obj.dayCalculation(date2);
        if(check1==1)
        {
        System.out.println("First Date is Valid");    
        System.out.println(date1+" is "+n1+"th of the year");
        }
        else
        System.out.println("Date 1 is invalid");
        
        if(check2==1)
        {
        System.out.println("Second Date is Valid");    
        System.out.println(date2+" is "+n2+"th of the year");
        }
        else
        System.out.println("Date 2 is invalid");
        
        int difference = n1-n2;
        System.out.println("The difference between two dates is:"+difference);
    }
}