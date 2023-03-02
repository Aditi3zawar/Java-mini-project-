package java8;

import java.util.Scanner;

class BankDetails {

	private String accno;
	private String name;
	private String acc_type;
	private long balance;
	Scanner sc = new Scanner(System.in);

	public void openAccount()
	{
		System.out.print("Enter Account Number:");
		accno=sc.next();
		System.out.print("Enter Account type:");
		acc_type=sc.next();
		System.out.print("Enter Name:");
		name=sc.next();
		System.out.print("Enter Balance:");
		balance=sc.nextLong();
		System.out.println("---------------------------");
	}

	public void showAccount() 
	{
		System.out.println("Name of account holder:"+name);
		System.out.println("Account number:"+accno);
		System.out.println("Account type:"+acc_type);
		System.out.println("Balance:"+balance);
		System.out.println("---------------------------");
	}

	public void deposit() 
	{
		long amt;
		System.out.println("Enter the amount you want to deposit:");
		amt=sc.nextLong();
		balance=balance+amt;
		System.out.println("Amount Deposited");
		System.out.println("Total balance is:"+balance);
	}

	public void withdrawal() 
	{  
	        long amt;  
	        System.out.println("Enter the amount you want to withdraw:");  
	        amt=sc.nextLong();  
	        if(balance>=amt) 
	        {  
	            balance=balance-amt; 
	            System.out.println("Amount withdraw");
	            System.out.println("Balance after withdrawal is:"+balance);  
	        } 
	        else
	        {  
	            System.out.println("Your balance is less than "+amt);
	            System.out.println("Transaction failed...!!");  
	        }
	}
	public void viewBalance()
	{
		  System.out.println("Total balance is:"+balance);
    }
	
	public boolean search(String ac_no)
	{
		if(accno.equals(ac_no))
		{
			
			return (true);
		}
		return (false);
	}
}

public class BankingApplication 
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		  Scanner sc=new Scanner(System.in);  
	         
	        System.out.print("How many number of customers do you want to enter: ");  
	        int n=sc.nextInt();  
	        BankDetails C[] = new BankDetails[n];  
	        for(int i=0;i<C.length;i++) 
	        {  
	            C[i]=new BankDetails();  
	            C[i].openAccount(); 
	        }  
	        int ch;  
	        do
	        {  
	            System.out.println("\n***Welcome to the National Bank***");  
	            System.out.println("1.Display all account details");
	            System.out.println("2.Check balance");
	            System.out.println("3.Deposit the amount");
	            System.out.println("4.Withdraw the amount");
	            System.out.println("5.Exit");  
	            System.out.println("Enter your choice:");  
	            ch=sc.nextInt();  
	            switch(ch) 
	            {  
                case 1:  
                    for(int i=0;i<C.length;i++)
                    {  
                        C[i].showAccount();  
                    }  
                    break;  
                case 2: 
                	System.out.print("Enter Account number:");  
                    String ac_no = sc.next();  
                    boolean found = false;  
                    for (int i=0;i<C.length;i++)
                    {  
                        found=C[i].search(ac_no);  
                        if(found) 
                        {   
                        	C[i].viewBalance();  
                        	break;  
                        }  
                    }  
                    if(!found)
                    {  
                        System.out.println("Account doesn't exist..!!");  
                    }  
                    break;   
                case 3:  
                    System.out.print("Enter Account number:");  
                    ac_no = sc.next();  
                    found = false;  
                    for (int i=0;i<C.length;i++)
                    {  
                        found=C[i].search(ac_no);  
                        if(found) 
                        {  
                            C[i].deposit();  
                            break;  
                        }  
                    }  
                    if(!found)
                    {  
                        System.out.println("Account doesn't exist..!!");  
                    }  
                    break;  
                case 4:  
                    System.out.print("Enter Account Number:");  
                    ac_no = sc.next();  
                    found = false;  
                    for (int i=0;i<C.length;i++) 
                    {  
                        found=C[i].search(ac_no);  
                        if(found) 
                        {  
                            C[i].withdrawal();  
                            break;  
                        }  
                    }  
                    if(!found)
                    {  
                        System.out.println("Account doesn't exist..!!");  
                    }  
                    break;
                case 5:  
                    System.out.println("See you soon...");  
                    break; 
               
            }  
        }  
        while(ch!=5); 
	        
	  }
}

