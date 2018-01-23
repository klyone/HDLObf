//*************************************************************************
// DESCRIPTION: HDLObf: Identifier Obfuscate Module
//
// Code available from: http://sourceforge.net/projects/hdlobf/
//
// AUTHORS: Vispi Cassod
//
//*************************************************************************
//
// This program is free software; you can redistribute it and/or modify
// it under the terms of either the GNU General Public License or the
// Perl Artistic License.
//
// Verilator is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with Verilator; see the file COPYING.  If not, write to
// the Free Software Foundation, Inc., 59 Temple Place - Suite 330,
// Boston, MA 02111-1307, USA.
//
//*************************************************************************

import java.io.*;
import java.util.*;

class Obfuscate
{
   public   boolean      DebugTrue; 
   public   HashMap<String,String>  obfHMap;   

   public Obfuscate( )
   {
      DebugTrue   = false;         
   }


   public static void main(String[] args) 
   {
     // debug option
     String       lanOpt   = "";
     String       mapFileIn  = "";
     String       mapFileOut  = "";
     String       inFile   = "";
     String       outFile  = "";
     Obfuscate    obf      = new Obfuscate();
     obf.DebugTrue         = true;
     try{

       // actual  option
       if(args.length > 3)
       {
         lanOpt  = args[0];
         mapFileIn = args[1];
         mapFileOut = args[2];
         inFile  = args[3];
         outFile = args[4];
       }
       obf.processFile(lanOpt, mapFileIn, mapFileOut, inFile, outFile);

     }catch (Exception e)
     {
         System.out.println("Usage: NameChange <Language Option> <map input file> <map output file> <input file> <output file>" + e.getMessage());
         System.out.println("Main Error: " + e.getMessage());
         e.printStackTrace();
     }
   }

   public void processFile(String lanOpt, String mapFileIn, String mapFileOut, String inFile, String outFile)
   {
      
      // select language function
      if((lanOpt.compareToIgnoreCase("ver") == 0 ))
      {
         this.VeriObfuscate(mapFileIn, mapFileOut, inFile, outFile);

      }
      else
      {
        System.out.println("Main Error: Language option not supported");
      }

   }
   
public void VeriObfuscate(String mapFileIn, String mapFileOut, String inFile, String outFile) 
   {
     
      FileOutputStream           optfs;
      File                       optfile;
      org.antlr.v4.runtime.CharStream  dis;
      Verilog2001Lexer   lexer;

      DataOutputStream           dom;
      String                     outputString   = "";
      String                     hashString     = "";

      
      try
       {
		BufferedReader reader = new BufferedReader(new FileReader(new File(mapFileIn)));
        String line = null;
        HashMap<String, String> map = new HashMap<String, String>();
        while ((line = reader.readLine()) != null) {
            if (line.contains("=")) {
                String[] strings = line.split("=");
                map.put(strings[0], strings[1]);
            }
        }
		 obfHMap = map;
         dom                     = new DataOutputStream(new FileOutputStream(mapFileOut,true));
         dom.writeBytes("\n//Appended due to input file:\t" + inFile + "\n");

         // Input Verilog Lexer         
         dis         = org.antlr.v4.runtime.CharStreams.fromFileName(inFile);
         lexer       = new Verilog2001Lexer(dis);
      
         // Output Verilog File
         optfile     = new File(outFile);
         if(optfile.createNewFile())
         {           
           optfs     = new FileOutputStream(optfile);
         }
         else
         {
           System.out.println("Could not create output file: "+ outFile + "\n");
           return;
         }
         
         org.antlr.v4.runtime.Token t = lexer.nextToken();
         do {
            outputString = t.getText();
            if( t.getType() == Verilog2001Lexer.Simple_identifier )
            {
             // if ID avaliable in map
             if(obfHMap.containsKey(t.getText()))
             {
                //if debug on
                if(DebugTrue) System.out.print("Value of ID: " + outputString + "\t\trenamed to :");
                // update output string
                outputString = (String) obfHMap.get(t.getText());                
                //if debug on
                if(DebugTrue) System.out.println(outputString);
             }
             else
             {
                // generate hash string
                hashString = "ID_S_" + hash1(outputString) + "_" + hash2(outputString) + "_E";
                // add to hash map
                obfHMap.put(outputString , hashString );  
                dom.writeBytes( outputString + "=" + hashString + "\n");
                //if debug on
                if(DebugTrue) System.out.print("Value of ID: " + outputString + "\t\trenamed to :");
                // update output string
                outputString = hashString;
                
                //if debug on
                if(DebugTrue) System.out.println(hashString + " added in hash map");
             }
            }
            // strip comments and end of lines
            else if( (t.getType() == Verilog2001Lexer.One_line_comment) ||  
                     (t.getType() == Verilog2001Lexer.Block_comment)    ||   
                     (t.getType() == Verilog2001Lexer.White_space)
                   )
            {
              outputString = " ";
            }
            
            // write to output file
            optfs.write(outputString.getBytes());

            t = lexer.nextToken();
         }while(t.getType() != org.antlr.v4.runtime.Token.EOF);          
         
         dom.close();
         optfs.close();
       }
       catch(Exception e)
       {
           System.out.println("Error: " + e.getMessage());
           e.printStackTrace();
       }
   }

   public String  hash1(String str)
   {

      int hash = 5381;

      for(int i = 0; i < str.length(); i++)
      {

         hash = ((hash << 5) + hash) + str.charAt(i);

      }

      long ret_hash =  (hash & 0x7FFFFFFF);

      return Long.toHexString(ret_hash);


   }
   /* End Of DJB Hash Function */


   public String hash2(String str)
   {

      int hash = 0;

      for(int i = 0; i < str.length(); i++)
      {

         if ((i & 1) == 0)
         {
            hash ^=((hash << 7)^str.charAt(i)^(hash >> 3));
         }
         else
         {
            hash ^= (~((hash << 11)^str.charAt(i)^(hash >> 5)));
         }

      }

      long ret_hash =  (hash & 0x7FFFFFFF);

      return Long.toHexString(ret_hash);


   }



}
