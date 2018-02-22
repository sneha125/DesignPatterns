import java.lang.*;
import java.io.*;

class DBConnection implements Cloneable
{
	String className = null;

	public DBConnection()
	{
	    this.className = "DBConnection";
	}

	public void setClassName(String className) {

	    this.className=className;

	}

	public String getClassName() {
	    return this.className;
	}

	@Override
	public Object clone() throws CloneNotSupportedException
	{
	  return super.clone();
	}

}

class PrototypeDemo {
	
	public static void main(String args[])throws CloneNotSupportedException
	{
		DBConnection db1 = new DBConnection();
		DBConnection db2 = (DBConnection)db1.clone();
		db1.setClassName("SNEHA");
		System.out.println("ClassName from created DBConnection Object is:"+db1.getClassName());
		System.out.println("ClassName from cloned DBConnection Object is:"+db2.getClassName());
		
	}
}