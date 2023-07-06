import java.util.*;
public class Projects {
    Scanner sc = new Scanner(System.in);
    String type;
    String description;
    int totalamt;
    int currentamt;
    boolean approved=false;
    String fundraiser;
    String adminapproved;
    int id;
    String latestdonor;
    int latestamt;
    boolean amtreached;


    Projects(int id,String type,String description,int totalamt,String fundraiser){
        this.type = type;
        this.description = description;
        this.totalamt = totalamt;
        
        this.fundraiser = fundraiser;
        this.id = id;
    }
    Projects(String funduser){
        App ap = new App();
        System.out.println("Enter type: ");
        type = sc.next();
        System.out.println("Enter description: ");
        description = sc.next();
        System.out.println("Enter Total amount needed: ");
        totalamt = sc.nextInt();
        System.out.println();
        fundraiser = funduser;
        id = ap.procount;
        


        

    }
    Projects(){

    }

    void getprojectinfo(){
        System.out.println();
        System.out.println("Project id: "+id);
        System.out.println("Project type: "+type);
        System.out.println("Project description: "+description);
        System.out.println("Project amt: "+"$"+totalamt);
        System.out.println("Project created by: "+fundraiser);
        if(approved == true){
            System.out.println("Project approval status: "+approved);
            System.out.println("Project approved by "+adminapproved);
        }
        else System.out.println("Project approval status: "+approved);
        if(currentamt>0){
            System.out.println("Project current amount recieved: "+"$"+currentamt+" / "+"$"+totalamt);
            System.out.println("Latest donation by "+latestdonor+"("+"$"+latestamt+")");
        }
        else System.out.println("Project current amount recieved: "+currentamt+" / "+"$"+totalamt);
        System.out.println();
    }
    void approve(String admin){
        approved = true;
        adminapproved = admin;
    }

    void displayall(ArrayList<Projects> pro){
        for(Projects proj: pro){
                    proj.getprojectinfo();
                    System.out.println();
                    System.out.println();
                }
    }
    void donate(String user){
        System.out.println("Enter amount to donate to project id "+ id+": ");
        int n5 = sc.nextInt();
        latestamt = n5;
        if(type.equals("medical")){ 
            currentamt+=n5;
            System.out.println("You have successfull donated "+"$"+n5+" to project id "+id+" (0% commission for medical projects)");
        }
        if(type.equals("environmental")){ 
        currentamt+=(n5-(0.05*n5));
        System.out.println("You have successfull donated "+"$"+(n5-(0.05*n5))+" to project id "+id+" (5% commission for environmental projects)");
        }
        if(type.equals("Educational")){ 
        currentamt +=(n5-(0.10*n5));
        System.out.println("You have successfull donated "+"$"+(n5-(0.10*n5))+" to project id "+id+" (10% commission for educational projects)");
        }
        latestdonor = user;
        if(currentamt>totalamt) amtreached = true;
    }
        
        
    
    int displayapproved(ArrayList<Projects> pro){
        int flag=0;
        for(Projects pri : pro){
            if(pri.approved==true && pri.amtreached==false){
                flag=1;
                pri.getprojectinfo();
                System.out.println();
                System.out.println();
            }
        }
        if(flag==0){
            System.out.println();
            System.out.println("Sorry no projects available :( ");
            System.out.println();
            return 1;
        }
        else return 0;
    }

    void displaypastprojects(ArrayList<Projects> past){
            for(Projects proje : past){
                if(proje.amtreached==true) proje.getprojectinfo();
                System.out.println();
                System.out.println();
            }
    }

    void fundraisercompleted(ArrayList<Projects> fund,String fundraiser){
        for(Projects proje : fund){
            if(proje.amtreached==true && proje.fundraiser.equals(fundraiser)) proje.getprojectinfo();
            System.out.println();
            System.out.println();
        }
    }
    
    







}
