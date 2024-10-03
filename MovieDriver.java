package lab1;
import java.util.Scanner;

public class MovieDriver {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in); 
        String continueInput;

        do {
            Movie movie = new Movie();

            System.out.print("Enter the title of the movie: "); 
            String title = keyboard.nextLine();
            movie.setTitle(title); 

            
            System.out.print("Enter the rating of the movie: "); 
            String rating = keyboard.nextLine();
            movie.setRating(rating); 

            
            System.out.print("Enter the number of tickets sold for this movie: "); 
            int soldTickets = keyboard.nextInt();
            movie.setSoldTickets(soldTickets); 

            
            System.out.println(movie.toString());

            
            System.out.print("Do you want to enter another movie? (yes/no): "); 
            keyboard.nextLine(); 
            continueInput = keyboard.nextLine();

        } while (continueInput.equalsIgnoreCase("yes")); 

        
        keyboard.close();
    }
}

