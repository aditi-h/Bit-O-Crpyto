import java.util.Scanner;

public class Shift {
    public static void main (String args[]) {

        //Create scanner
        Scanner scan = new Scanner(System.in);
        
        //Brief explanation to user
        System.out.println("Note: to decrypt encrypted text, negate the key");

        //Ask user to enter plaintext
        System.out.print("Enter plaintext: ");
        String plaintext = scan.nextLine();

        //Ask user to enter integer key
        System.out.print("Enter an integer key: ");
        int key = scan.nextInt();

        //Create an array with the same length as the plaintext
        char[] cipherArray = new char[plaintext.length()];

        //For every element in the array...
        for(int i = 0; i < cipherArray.length; i++) {
            
            //If the ASCII value of the character is greater than 97 and less than 122 (is lowercase)
            if(((int)(plaintext.charAt(i)) >= 97) && ((int)(plaintext.charAt(i)) <= 122)) {
                
                //Subtract 97 from the ASCII value, add the key, mod it by 26, and add 97 back
                cipherArray[i] = (char) (((((int) (plaintext.charAt(i) - 97)) + key) % 26) + 97);

                //Add 26 if the element value is less than 97 
                if (cipherArray[i] < 97) {
                    cipherArray[i] += 26;
                }
            } 
            
            //If the ASCII value of the character is greater than 65 and less than 90 (is uppercase)
            else if(((int)(plaintext.charAt(i)) >= 65) && ((int)(plaintext.charAt(i)) <= 90)) {

                //Subtract 65 from the ASCII value, add the key, mod it by 26, and add 65 back
                cipherArray[i] = (char) (((((int) (plaintext.charAt(i) - 65)) + key) % 26) + 65);
                
                //Add 26 if the element value is less than 65 
                if (cipherArray[i] < 65) {
                    cipherArray[i] += 26;
                }
            }

            //If the element is not a letter, don't change it
            else {
                cipherArray[i] = plaintext.charAt(i);
            }
        } 

        //Convert the array of characters into a string
        String ciphertext = new String(cipherArray);

        //Print out the string
        System.out.println("Ciphertext: " + ciphertext);

        //Close the scanner
        scan.close();
    }
}
