=============================== File Packer & Unpacker (Java) ================================


Description:
This project is a File Packer and Unpacker application developed in Java.
It allows users to:
- Pack multiple .txt files into a single file
- Unpack the packed file back into original files

--------------------------------------------------

Author:
Pranav R Sonawane

--------------------------------------------------

Features:
- Packs only .txt files
- Maintains file name and size using header
- Simple Command Line Interface (CUI)
- Efficient file handling using streams

--------------------------------------------------

Project Structure:

Packer.java     -> Packs multiple files into one

Unpacker.java   -> Extracts files from packed file

--------------------------------------------------

How to Run:

1. Compile :

   javac Packer.java
   
   javac Unpacker.java

3. Run Packer :
    java Packer
   - Enter folder path containing .txt files
   - Enter output packed file name

4. Run Unpacker :
    java Unpacker
   - Enter packed file name
   - Files will be extracted in current directory

--------------------------------------------------

How It Works:

Packing:
- Reads all .txt files from given folder
- Creates a 100-byte header:
  - File name
  - File size
- Writes header + file data into packed file

Unpacking:
- Reads 100-byte header
- Extracts:
  - File name
  - File size
- Recreates original file with data

--------------------------------------------------

Example:

Input Folder:
file1.txt
file2.txt

Output:
packed.dat

After Unpacking:
file1.txt
file2.txt

--------------------------------------------------

Limitations:
- Only .txt files are supported
- Header size is fixed (100 bytes)
- No encryption or compression

--------------------------------------------------

Future Improvements:
- Support for all file types
- Add compression (ZIP logic)
- Add encryption for security
- GUI version

--------------------------------------------------

Thank you for using Packer Unpacker Application!
==================================================
