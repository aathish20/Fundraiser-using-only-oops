import java.util.*;
public class App {
static int count=5;
static int procount=1;

        static boolean admin = false;
        static boolean fundraiser = false;
        static boolean donor = false;
        static String curruser;
   
    
    public static  void main(String[] args) throws Exception {
        App a = new App();
        Scanner sc = new Scanner(System.in);
         ArrayList<User> u = new ArrayList<User>();
         ArrayList<Projects> pro = new ArrayList<Projects>();
        
        
        u.add(new User(1,"Aathish","aat20","meow123","admin"));
        u.add(new User(2,"Kevin","kev20","meow321","admin"));
        u.add(new User(3,"DhineshRam","dr20","bozo123","admin"));
        u.add(new User(4,"donordefault","donor1","donor123","donor"));
        u.add(new User(5,"fundraiserdefault","fund","fund123","fundraiser"));
        pro.add(new Projects(1,"medical","des",1200,"he"));
        
        

        while(true){
        while(true){
        System.out.println("Enter 1 to register or 2 to login or 3 to exit: ");
        int n = sc.nextInt();
        if(n==3){
            System.exit(0);
        }
        if(n==1){
        a.count+=1;
        u.add(new User(u));
        System.out.println();
        System.out.println("Registration successfull");
        System.out.println();
        continue;
        }
        else{
            int flag=0;
            System.out.println("Enter username: ");
            String s = sc.next();
            System.out.println("Enter password: ");
            String p =sc.next();
            for(User us : u){
                if(us.getuser().equals(s) && us.getpass().equals(p)){
                    System.out.println();
                    System.out.print("you have successfully logged in as "+us.getrole());
                    System.out.println();
                    curruser = us.getuser();
                    if(us.getrole().equals("admin")) admin = true;
                    if(us.getrole().equals("fundraiser")) fundraiser = true;
                    if(us.getrole().equals("donor")) donor = true;
                    flag = 1;
                    break;
                    



                }
                
                
                    

                
            }
            if(flag==1) break;
            System.out.println("Username not found or password incorrect , if u havent registered please register first!");
            System.out.println();
            }
        }

        if(fundraiser==true){
            while(true){
            Fundraiser f = new Fundraiser();
            f.display();
            int n1 = sc.nextInt();
            if(n1==1){
                procount++;
                pro.add(new Projects(curruser));
                System.out.println("Project has been successfully created with Project id: "+procount);
                
            }
            if(n1==2){      
                 Projects pr = new Projects();
                 pr.fundraisercompleted(pro,curruser);   
            }
            if(n1==3){
            fundraiser = false;
            break;
            }
           
        }
         continue;
    }

        else if(admin==true){
            while(true){
            Admin ad = new Admin();
            Projects pr = new Projects();
            ad.display();
            int n2 = sc.nextInt();
            if(n2==1){
                pr.displayall(pro);
                System.out.println("Enter project id to approve: ");
                int id = sc.nextInt();
                for(Projects proj : pro){
                    if(proj.id==id){
                        proj.approve(curruser);
                        System.out.println();
                        System.out.println("Project "+proj.id+" has been succesfully approved");
                    }
                }
            }
            if(n2==2) pr.displayall(pro);
            if(n2==3){ 
                pr.displayall(pro);
                System.out.println("Enter project id to remove: ");
                int id = sc.nextInt();
                for(int i =0;i<pro.size();i++){
                    if(pro.get(i).id==id){
                        System.out.println("Project "+pro.get(i).id+" has been successfully removed");
                        pro.remove(i);
                        break;
                    }
                }
            }
            if(n2==4){
                pr.displaypastprojects(pro);
            }
            if(n2==5){
                admin = false;
                break;
            }
        }
            continue;
        }

        else{
            Donor d = new Donor();
            Projects pu = new Projects();
            while(true){
            d.display();
            int n3 = sc.nextInt();
            if(n3==1){      
                if(pu.displayapproved(pro)==1){
                    continue;
                }
                else{
                System.out.println("From the list , select the project id u want to donate to ");
                int id = sc.nextInt();
                for(Projects pur : pro){
                    if(pur.id==id){
                        pur.donate(curruser);
                    };
                }
            }

            }
            if(n3==2)  pu.displayapproved(pro);
            if(n3==3){
                donor = false;
                break;
            } 
        }
        continue;
    }
        
    }

            
    }
}
