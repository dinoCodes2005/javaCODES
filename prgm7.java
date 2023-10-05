import java.util.*;
public class prgm7{
    public static int noofvowel(String word){
        int count=0;
        word=word.toUpperCase();
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if (ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U'){
                count++;
            }
        }
        return count;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a string");
        String str=sc.nextLine();
        String st[]=str.split(" ");
        int l=st.length;
        for(int i=0;i<l-1;i++){
            for(int j=0;j<l-i-1;j++){
                if(noofvowel(st[j])>noofvowel(st[j+1])){
                    String t=st[j];
                    st[j]=st[j+1];
                    st[j+1]=t;
                }
            }
        }
        System.out.println("The sorted string is:");
        for(int k=0;k<l;k++){
            System.out.print(st[k]+" ");
        }
     }
}