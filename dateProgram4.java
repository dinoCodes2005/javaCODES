import java.util.*;
public class dateProgram4
{
    String date;
    String day;
    String month;
    String year;
    int dayInt,monthInt,yearInt;
    int n;
    int numberOfDays[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    
    dateProgram4()
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
        {                                       //validity of date
        
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
        n=dayInt;
        for(int i=1;i<monthInt;i++)                 //nth day Calculation function
        {
            n+= numberOfDays[i];
        }
        return n;
    }
    
    String dateCalculation(int day,int year)        //date calculation function
    {
        if(day<366)
        {
        int maxDays;
        int monthNumber=1;
        if((year%4==0 && year%100!=0)||year%400==0)
        {
            numberOfDays[2]=29;
            while(day>29)
            {
                day=day-numberOfDays[monthNumber];
                monthNumber++;
            }
        }
        else
        {
            while(day>28)
            {
                day=day-numberOfDays[monthNumber];
                monthNumber++;
            }
        }
        String dayForDate = (day>10)?Integer.toString(day):"0"+day;
        String date = dayForDate+"/"+monthNumber+"/"+year;
        return date;
        }
        return "";
    }
    
    static boolean isLeapYear(int year)                     //function to check leapyear
    {
        return ((year%4==0 && year%100!=0)||year%400==0);
    }
    
    static int daysInMonth(int month,int year)              //function to check number of days of a given month in a given year
    {
        int numberOfDays[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if(month==2 && isLeapYear(year))
        {
            return 29;
        }
        return numberOfDays[month];
    }
    
    String dateAfterN(String date, int n)                   //date after adding n number of days to a given date
    {
        day = date.substring(0,2);
        month = date.substring(3,5);
        year = date.substring(6);
        
        dayInt = Integer.parseInt(day);
        monthInt = Integer.parseInt(month);
        yearInt = Integer.parseInt(year);
        
       for(int i=0;i<n;i++)
       {
       dayInt++;
       if(dayInt>daysInMonth(monthInt,yearInt))
       {
       dayInt=1;
       monthInt++;
       if(monthInt>12)
       {
           monthInt=1;
           yearInt++;
       }
       }
       }
       
       String dateAfterAddition = dayInt +"/"+monthInt+"/"+yearInt;
       return dateAfterAddition;
    }
    
    
    public static void main(String args[])
    {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter the date in DD/MM/YYYY format: ");
        String date = sc.nextLine();
        
        System.out.println("Enter year whose date you want to find: ");
        int yearNumber=sc.nextInt();
        System.out.println("Enter day whose date you want to find: ");
        int dayNumber =sc.nextInt();
        
        dateProgram4 obj = new dateProgram4();
        
        int check =obj.validDate(date);
        int nth = obj.dayCalculation(date);
        String dateObtained = obj.dateCalculation(dayNumber,yearNumber);
        String dateAfterAdd = obj.dateAfterN(date,nth);
        
        System.out.println("Date after addition: "+dateAfterAdd);
        
        if(dateObtained=="")
            System.out.println("Invalid day Number");
        else
            System.out.println("Date is: "+dateObtained);
        
        if(check==1)
        {
        System.out.println("Valid Date");    
        System.out.println(date+" is "+nth+"th of the year");
        }
        else
        System.out.println("Invalid Date");
    }
}