import java.util.*;
import java.lang.*;
import java.io.*;

/*
 For example of Singleton, 
 I'm considering a Authenticator class,
 as, this class functionality or behavior doesnt change at any point of time.
 */

class Authenticator 
{

    private static Authenticator a = null;

    private Authenticator()
    {
        //Initialize DB Objects.
    }

    public static Authenticator getInstance()
    {
        if(a == null)
            {
                System.out.println("Authenticator Object is created for first Name");
                a = new Authenticator();
            }
        return a;
    }

    public void authenticateTheUser(String userName, String pwd)
    {
        // Has some logic to check for valid creadentials or not.
        System.out.println("UserName is:"+userName);
        System.out.println("Pwd is:"+pwd);
    }
}

class SingeltonPatternDemo 
{
    public static void main(String args[]) {

        Authenticator a = Authenticator.getInstance();
        a.authenticateTheUser("CHINNU", "HUNNY");
        Authenticator a1 = Authenticator.getInstance();
        a.authenticateTheUser("HUNNY", "CHINNU");
    }
}