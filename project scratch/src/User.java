import java.util.*;
public class User {
    int id;
    private String name;
    private String username;
    private String password;
    private String role;

    Scanner sc = new Scanner(System.in);
    User(ArrayList<User> user){
        App a = new App();
        System.out.print("Enter your name: ");
            name = sc.next();
            
            while(true){
            int flag1=0;
            System.out.print("Enter your username: ");
            username = sc.next();
            for(User use : user){
                if(use.getuser().equals(username)){
                    System.out.print("Username already taken");
                    System.out.println();
                    flag1=1;
                    break;
                }    
            }
            if(flag1==1) continue;
            else break;
        }
                
            System.out.print("Enter your password: ");
            password = sc.next();
            int flag=0;
            while(true){
            if (flag==0)System.out.print("Enter your role: donor or fundraiser ");
            role = sc.next();
            if (role.equals("donor") || role.equals("fundraiser")) break;
            if(role.equals("admin")) System.out.print("Unauthorised access , please enter appropriate role: ");
            else System.out.print("incorrect role please enter correctly: ");
            flag=1;
            }
            id = a.count;

        }
    User(int id,String name,String username,String password,String role){
        this.name = name;
        this.username = username;
        this.password = password;
        this.role = role;
        this.id = id;
    }
    User(){
        
    }

    String getuser(){
        return username;
    }
    String getpass(){
        return password;
    }
    String getrole(){
        return role;
    }
    int getid(){
        return id;
    }
}
    
