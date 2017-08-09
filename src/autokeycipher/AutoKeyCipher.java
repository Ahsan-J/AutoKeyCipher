/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autokeycipher;

/**
 *
 * @author Xcalaiberz
 */
public class AutoKeyCipher {

    static char CipherLetters[][];
    public static char [][] initialize(){
        char C [][] = new char[26][26];
        for(int i=0;i<26;i++){
            for(int j=0;j<26;j++){
                C[i][j]=(char) (('A')+(i+j)%26);
            }
        }
        return C;
    }
    public static void main(String[] args) {
        CipherLetters=initialize();
        String message = encrypt("We Love Cryptology","CIDMATH");
        System.out.println(message);
        
        System.out.println("");
        System.out.println(decrypt(message,"CIDMATH"));
    }
    
    
    public static char getEncryptedChar(char A,char B){
        A = Character.toUpperCase(A);
        B = Character.toUpperCase(B);
        return CipherLetters[(int) (A-'A')][(int) (B-'A')];
    }
    public static char getDecryptedChar(char A,char B){
        A = Character.toUpperCase(A);
        B = Character.toUpperCase(B);
        for(int i=0;i<26;i++){
            if(CipherLetters[i][(int) (B-'A')]==A){
                return (char) ('A'+i);
            }
        }
        return ' ';//Equivalent to Null
    }
    public static String encrypt(String Message,final String Key){
        Message = Message.toUpperCase();
        Message = Message.replaceAll(" ","");
        String Encrypted = new String();
        String autoKey = Key;
        for(int i=0;i+Key.length()<Message.length();i++){
            autoKey = autoKey + Message.charAt(i);
        }
        
        for(int i=0;i<Message.length();i++){
            Encrypted = Encrypted + getEncryptedChar(Message.charAt(i),autoKey.charAt(i));
        }
        return Encrypted;
    }
    public static String decrypt(String Message,final String Key){
        Message = Message.toUpperCase();
        Message = Message.replaceAll(" ","");
        String autoKey = Key;
        String Decrypted = new String();
        for(int i=0;i<Message.length();i++){
            Decrypted = Decrypted + getDecryptedChar(Message.charAt(i),autoKey.charAt(i));
            if(i+Key.length()<Message.length()){
                autoKey = autoKey + Decrypted.charAt(i);
                
            }
        }
        return Decrypted;
    }
}
