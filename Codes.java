import java.util.Scanner;
public class Code{
    public static void main(String[] args){
        Scanner NK=new Scanner(System.in);
        
        
         // Calculate Compound Interest in Java:
         System.out.print("What is the principle amount :  ");
         double principle=NK.nextDouble();
         
         System.out.print("What is the rate per compound period : ");
         double rate =NK.nextDouble();
         
         System.out.print("What is the time period acording  to year :  ");
         double Time=NK.nextDouble();
         
         double Amount=principle * Math.pow((1 + rate / 100), Time);;
         System.out.println("The Amount will be  : " + Amount);
         
         double CompoundIntrest= (principle-Amount);
         
         
         System.out.print("The compound intrest will be  : " + CompoundIntrest);
        
         
    }
}
