import java.util.Scanner;

public class EncryptionByLetterSubstitution {

    public static void main(String[] a){
        java.util.Scanner sc = new Scanner(System.in);
        System.out.println("Enter Your Password");
        String s=sc.nextLine();

        int l= s.length();

        if(l<=3 && l>=100){
            System.out.println("Invalid String"); 
        }
        else{
            System.out.println("Plain Text: "+s);
            System.out.println("Cipher Text: "+ cipher(s));
        }
    }

    static String cipher(String s){
        String res ="";
        char ch ;
        int a;
        for(int i=0;i<s.length()-1;i++){
            ch = s.charAt(i);
            if(Character.isLetter(ch)){

                a = ch+13;//if this line is commented using a will cause error

                if((Character.isUpperCase(ch) && a>90 )|| (Character.isLowerCase(ch) && a<122)){
                    a = a-26;
                }
    
                ch = (char) a;
            }
            res = res+ch;
        }

        return res;
    }

}
