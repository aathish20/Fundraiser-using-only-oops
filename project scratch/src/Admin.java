import java.util.*;
public class Admin extends User {
    int a;
    Scanner sc = new Scanner(System.in);

    void display(){
        System.out.println();
        System.out.println("Enter your choice:");
        System.out.println("1 for approving a project");
        System.out.println("2 for viewing all projects");
        System.out.println("3 to remove an existing project");
        System.out.println("4 to display past projects");
        System.out.println("5 to logout");
        System.out.println();
    }


    
    void action(){
        int n = sc.nextInt();
        if(n==1){
            Projects p = new Projects();
            

        }
    }
}
