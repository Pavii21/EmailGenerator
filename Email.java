import java.util.*;
public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailBoxCapacity=500;
    private int defaultPasswordLength=10;
    private String alternateEmail;
    private String collegeSuffix="drngpit.ac.in";

    //constructor to receive FN and LN
    public Email(String firstName,String lastName){
        this.firstName=firstName;
        this.lastName=lastName;
        System.out.println("Email created: "+this.firstName+" "+this.lastName);
        //call method for dept
        this.department= setDepartment();
        System.out.println("Department:"+this.department);

        //call a method for random password
        this.password=randomPassword(defaultPasswordLength);
        System.out.println("Password:"+password);

        //combine elements to generate email

        email=firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"+department+"."+collegeSuffix;
    }

    //Ask for dept
    private String setDepartment(){
        System.out.print("Department codes:\n1 for CSE dept\n2 for IT Dept\n3 for EEE dept\nEnter dept:");
        Scanner sc = new Scanner(System.in);
        int deptChoice=sc.nextInt();
        if(deptChoice==1){return "CSEDept"; }
        else if(deptChoice==2){ return "ITDept";}
        else if(deptChoice==3){ return "EEEDept";}
        else{return "Other dept";}
    }

    private String randomPassword(int length){
        String passwordSet="ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890@$%";
        char[] password = new char[length];
        for(int i=0;i<length;i++){
            int random=(int) (Math.random()*passwordSet.length());
            password[i]=passwordSet.charAt(random);
        }
        return new String(password);
    }

    //set mailbox capacity
    public void setMailboxCapacity(int capacity){
        this.mailBoxCapacity=capacity;
    }

    //set alternate email
    public void setAlternateEmail(String alt){
        this.alternateEmail=alt;
    }

    //change password
    public void changePassword(String password){
        this.password=password;
    }
    public int getMailBoxCapacity(){return mailBoxCapacity;}
    public String getAlternateEmail(){return alternateEmail;}
    public String getPassword(){return password;}

    public String showInfo(){
        return "Name:"+firstName+" "+lastName+
                "\nCollege mail: "+email+
                "\nMailbox Capacity: "+mailBoxCapacity+"mb";
    }
}
