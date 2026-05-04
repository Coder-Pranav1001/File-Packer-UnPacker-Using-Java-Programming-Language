/*
	Description :- File Unpacker Application
	Author :- Pranav R Sonawane
*/
import java.io.*;
import java.util.*;
import java.nio.charset.StandardCharsets;

class Unpacker
{
	public static void main(String a[])
	{
		Scanner sobj = new Scanner(System.in);
		System.out.println("---------- Packer Unpacker CUI Panel ----------");
		try 
		{	
			System.out.println("Enter the name of packed file : ");
			System.out.println("Node : Packed file should be in the current directory.");
			
			String Packfile = sobj.nextLine();
			File fpackobj = new File(Packfile);
			
			FileInputStream fin = new FileInputStream(fpackobj);
            int Ret = 0;
			int Count = 0;
            byte Header[] = new byte[100];
			
			if(fpackobj.exists())
			{    	
				while((Ret = fin.read(Header,0,100))>0)
				{
					String StrHeader = new String(Header);
						
					String Arr[] = StrHeader.split(" ");
					   
					File obj = new File(Arr[0]);
					obj.createNewFile();
					System.out.println("New file dropped with name : "+Arr[0]);
					  
					int FileSize = Integer.parseInt(Arr[1]);

					byte DataArray[] = new byte[FileSize];

					fin.read(DataArray,0,FileSize);

	 			    FileOutputStream fout = new FileOutputStream(obj);
					fout.write(DataArray,0,FileSize);
					  
					Count++;
				}
				System.out.println("----- Summary -----");
				System.out.println("Number of files packed succefully : "+Count);
				
				System.out.println("Thank you for using Packer Unpacker Application");
			}
			else
			{
				System.out.println("There is no such folder...");
			}
		}
		catch(Exception obj)
		{
			System.out.println("Exception occured : "+obj);
		}
	}
}

   