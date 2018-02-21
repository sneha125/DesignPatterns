/*
 For example of Singleton, 
 I'm considering a Authenticator class,
 as, this class functionality or behavior doesnt change at any point of time.
 */

class Authenticator 
{

    private Authenticator a = null;

    private Authenticator()
    {
        //Initialize DB Objects.
    }

    public Authenticator getInstance()
    {
        if(a == null)
            {
                a = new Aunthenticator();
            }
        return a;
    }

    public boolean authenticateTheUser(String userName, String pwd)
    {
        // Has some logic to check for valid creadentials or not.
    }
}