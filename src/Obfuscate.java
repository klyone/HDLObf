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
   
   private String spaces;
   private Boolean top_handled;

   public Obfuscate( )
   {
      DebugTrue   = false;
      spaces = ""; 
      top_handled = false;        
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
     obf.DebugTrue         = false;
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
      else if((lanOpt.compareToIgnoreCase("vhd") == 0 ))
      {
		  this.VhdlObfuscate(mapFileIn, mapFileOut, inFile, outFile);
	  }
      else
      {
        System.out.println("Main Error: Language option not supported");
      }

   }

private Boolean VeriIsIdentifier(org.antlr.v4.runtime.Token t)
{
   if( t.getType() == Verilog2001Lexer.Simple_identifier ||
      t.getType() == Verilog2001Lexer.Escaped_identifier )
      return true;
   else
      return false;
}

private Boolean VeriIsIgnored(org.antlr.v4.runtime.Token t)
{
   if( (t.getType() == Verilog2001Lexer.One_line_comment) ||  
      (t.getType() == Verilog2001Lexer.Block_comment)    ||   
      (t.getType() == Verilog2001Lexer.White_space))
         return true;
   else
         return false;
}

private String VeriGenerateID(DataOutputStream dom, org.antlr.v4.runtime.Token t)
{
   String outputString = t.getText();
   String hashString;

   // if ID avaliable in map
   if(obfHMap.containsKey(t.getText()))
   {
      // update output string
      outputString = (String) obfHMap.get(t.getText());                
   }
   else
   {
      // generate hash string
      hashString = "ID_S_" + hash1(outputString) + "_" + hash2(outputString) + "_E";
      // add to hash map
      obfHMap.put(outputString , hashString );  
      try {
         dom.writeBytes( outputString + "=" + hashString + "\n");
      } catch(Exception e) {  
         System.out.println("Error: " + e.getMessage());
         e.printStackTrace();
      }
      outputString = hashString;

   }

   return outputString;
}

private org.antlr.v4.runtime.Token VeriDoIgnoreSpaces(Verilog2001Lexer lexer, org.antlr.v4.runtime.Token first)
{
   org.antlr.v4.runtime.Token tprev = first;
   org.antlr.v4.runtime.Token t = first;
   do {
      tprev = t;
      t = lexer.nextToken();
      spaces += " ";
   } while (VeriIsIgnored(t));

   return t;
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
      Boolean primitive = false;
      ArrayList<String> primitive_list = new ArrayList<String>();
      ArrayList<String> ignoremod_list = new ArrayList<String>();
      Boolean primitive_protected = false;
      Boolean ignore_module = false;
      
      try
       {
		BufferedReader reader = new BufferedReader(new FileReader(new File(mapFileIn)));
        String line = null;
        HashMap<String, String> map = new HashMap<String, String>();
        while ((line = reader.readLine()) != null) {
            primitive = line.startsWith("@PRIMITIVE");
            ignore_module = line.startsWith("@IGNOREMOD");
            if (line.contains("=")) {
               String[] strings = line.split("=");
               if (!primitive && !ignore_module)
                  map.put(strings[0], strings[1]);
               
               if(primitive || ignore_module)
                  primitive_list.add(strings[1]);
               if(ignore_module)
                  ignoremod_list.add(strings[1]);
            }
        }

        ignore_module = false;
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
         org.antlr.v4.runtime.Token tprev = t;
         do {
            outputString = t.getText();

            if(!top_handled) {
               if(VeriIsIdentifier(t)) {
                  obfHMap.put(t.getText(), t.getText());
               } else if (tprev.getText().equals(")") && t.getText().equals(";")) {
                  top_handled = true;
               }
            }

            if(tprev.getText().equals("module")) {
               spaces = "";
               t = VeriDoIgnoreSpaces(lexer, t);
               if(VeriIsIdentifier(t) && ignoremod_list.contains(t.getText())) {
                  ignore_module = true;
               }
               optfs.write(spaces.getBytes());
               outputString = t.getText();
            }

            if(ignore_module && t.getText().equals("endmodule")) {
               ignore_module = false;
            }

            if(primitive_protected && tprev.getText().equals(")") && t.getText().equals(";"))
               primitive_protected = false;

            if(VeriIsIdentifier(t) && !tprev.getText().equals(".") && primitive_list.contains(outputString)) {
               String id = t.getText();
               String primitive_str = "";

               spaces = "";
               t = VeriDoIgnoreSpaces(lexer, t);

               primitive_str += id;
               primitive_str += spaces;

               if(t.getText().equals("#")) {
                  primitive_protected = true;
               } else {
                  if(VeriIsIdentifier(t)) {
                     org.antlr.v4.runtime.Token tmp = t;
                     spaces = "";
                     t = VeriDoIgnoreSpaces(lexer, t);

                     if(t.getText().equals("("))
                        primitive_protected = true;

                     primitive_str += VeriGenerateID(dom, tmp);
                     primitive_str += spaces;
                  }
               }
               outputString = t.getText();
               optfs.write(primitive_str.getBytes());
            }

            if(VeriIsIdentifier(t))
            {
               if (!ignore_module && (!primitive_protected || !tprev.getText().equals("."))) {
                  outputString = VeriGenerateID(dom, t);
               }
            }
            // strip comments and end of lines
            else if(VeriIsIgnored(t))
            {
              outputString = " ";
            }
            
            // write to output file
            optfs.write(outputString.getBytes());

            tprev = t;
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
   
   public void VhdlObfuscate(String mapFileIn, String mapFileOut, String inFile, String outFile) 
   {
     
      FileOutputStream           optfs;
      File                       optfile;
      org.antlr.v4.runtime.CharStream  dis;
      vhdlLexer   lexer;

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
         lexer       = new vhdlLexer(dis);
      
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
            if( t.getType() == vhdlLexer.BASIC_IDENTIFIER ||
				t.getType() == vhdlLexer.EXTENDED_IDENTIFIER )
            {
             // if ID avaliable in map
             if(obfHMap.containsKey(t.getText()))
             {
                // update output string
                outputString = (String) obfHMap.get(t.getText());                
             }
             else
             {
                // generate hash string
                hashString = "ID_S_" + hash1(outputString) + "_" + hash2(outputString) + "_E";
                // add to hash map
                obfHMap.put(outputString , hashString );  
                dom.writeBytes( outputString + "=" + hashString + "\n");
                // update output string
                outputString = hashString;
                
             }
            }
            // strip comments and end of lines
            else if( (t.getType() == vhdlLexer.COMMENT) ||  
                     (t.getType() == vhdlLexer.SPACE)    ||   
                     (t.getType() == vhdlLexer.NEWLINE)  ||   
                     (t.getType() == vhdlLexer.CR)  || 
                     (t.getType() == vhdlLexer.TAB)
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
