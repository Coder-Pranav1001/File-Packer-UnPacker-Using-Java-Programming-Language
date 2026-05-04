/*
	Description :- File Packer Application
	Author :- Pranav R Sonawane
*/
import java.io.*;
import java.util.*;
import java.nio.charset.StandardCharsets;

class Packer
{
	public static void main(String a[])
	{
		Scanner sobj = new Scanner(System.in);
		System.out.println("---------- Packer Unpacker CUI Panel ----------");
		try
		{
			System.out.println("Enter folder name which contains the files that you want to pack : ");
			String FolderName = sobj.nextLine();
			
			File fobj = new File(FolderName);
			
			System.out.println("Enter the name of packed file that you want to create: ");
			System.out.println("Node : Packed file gets automatically created in the current directory.");
			
			String Packfile = sobj.nextLine();
			
			File fpackobj = new File(Packfile);
			fpackobj.createNewFile();
			
			FileOutputStream fout = new FileOutputStream(fpackobj);

			if(fobj.exists())
			{
				File allfiles[] = fobj.listFiles();
				
				System.out.println("File names are : ");
				
				byte Buffer[] = new byte[1024];
				int ret = 0;
				int Counter = 0;
				
				String name; 
				
				for(int i = 0; i < allfiles.length; i++)
				{
					name = allfiles[i].getName();
					
					if(name.endsWith(".txt")) // Filter 
					{
						name = name + " " + (allfiles[i].length());
						System.out.println("File Name :" +allfiles[i].getName()+ " with length : "+allfiles[i].length() +"bytes");
						
						for(int j = name.length(); j < 100; j++) // Header Formation
						{
							name = name + " ";
						}
					
						byte HeaderByte [] = name.getBytes(); // String to byte array conversion
						
						fout.write(HeaderByte,0,HeaderByte.length); // write header in packed file
						
						FileInputStream fiobj = new FileInputStream(allfiles[i]);
						
						while((ret = fiobj.read(Buffer)) != -1)
						{
							fout.write(Buffer,0,ret);
						}
						Counter++;
					}
				}
				
				System.out.println("----- Summary -----");
				System.out.println("Number of files scanned : "+allfiles.length);
				System.out.println("Number of files packed succefully : "+ Counter);
				
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

 