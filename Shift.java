import java.util.Scanner;

public class ShiftEncoder {
    public static void main (String args[]) {

        Scanner scan = new Scanner(System.in);
        
        System.out.print("Enter plaintext: ");
        String plaintext = scan.nextLine();

        System.out.print("Enter key: ");
        int key = scan.nextInt();

        char[] cipherArray = new char[plaintext.length()];

        for(int i = 0; i < cipherArray.length; i++) {
                
            if(((int)(plaintext.charAt(i)) >= 97) && ((int)(plaintext.charAt(i)) <= 122)) {
                cipherArray[i] = (char) (((((int) (plaintext.charAt(i) - 97)) + key) % 26) + 97);
            } 
                
            else if(((int)(plaintext.charAt(i)) >= 65) && ((int)(plaintext.charAt(i)) <= 90)) {
                cipherArray[i] = (char) (((((int) (plaintext.charAt(i) - 65)) + key) % 26) + 65);
            }

            else {
                cipherArray[i] = plaintext.charAt(i);
            }

        } 

        String ciphertext = new String(cipherArray);
        System.out.println("Ciphertext: " + ciphertext);

        scan.close();
    }
}
