import java.util.*;
public class prgm6{
    public static void main(String args[]){
        Scanner sc=new Scanner (System.in);
        System.out.println("Enter a string");
        
        String str=sc.nextLine();
        int l=str.length();
        String st[]=str.split(" ");
        for(int i=0;i<st.length-1;i++){
            for(int j=0;j<st.length-1-i;j++){
                if(st[j].length()>st[j+1].length()){
                    String a=st[j];
                    st[j]=st[j+1];
                    st[j+1]=a;
                }
            }
            
        }
        System.out.println("The sorted words are:");
        for(int k=0;k<st.length;k++)
        System.out.print(st[k]+" ");
    }
}
