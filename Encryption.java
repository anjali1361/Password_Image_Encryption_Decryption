import java.util.Scanner;

public class Encryption{

   private int key=6;

    void encrypt_password(String string){
        System.out.println(string);

        char[] chars = string.toCharArray();
        for(char c:chars){
            c += key;
            System.out.print(c);        
        }
        
    }


    void decrypt_password(String string){//pass the encrypted password that got using encrypt_password_method
        System.out.println(string);

        char[] chars = string.toCharArray();
        for(char c:chars){
            c -= key;
            System.out.print(c);        
        }
        
    }

    // public static void main(String[] a){
    //    Encryption obj = new Encryption();
    //    Scanner sc = new Scanner(System.in);

    //    System.out.println("Enter your password");
    //    String text = sc.nextLine();
    //    obj.encrypt_password(text);

    //    System.out.println();

    //    System.out.println("Enter the encrypted password");
    //    String encrypted_password = sc.nextLine();
    //    obj.decrypt_password(encrypted_password);

    //    sc.close();

    // }
} 