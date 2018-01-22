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
      
   private  IDMapLoader  idMapLoader;
   public   boolean      DebugTrue;   

   public Obfuscate( )
   {
      DebugTrue   = false;         
   }


   public static void main(String[] args) 
   {
     // debug option
     String       lanOpt   = "";
     String       mapFile  = "";
     String       inFile   = "";
     String       outFile  = "";
     Obfuscate    obf      = new Obfuscate();
     obf.DebugTrue         = true;
     try{

       // actual  option
       if(args.length > 3)
       {
         lanOpt  = args[0];
         mapFile = args[1];
         inFile  = args[2];
         outFile = args[3];
       }
       obf.processFile(lanOpt, mapFile, inFile, outFile);

     }catch (Exception e)
     {
         System.out.println("Usage: NameChange <Language Option> <map file> <input file> <output file>" + e.getMessage());
         System.out.println("Main Error: " + e.getMessage());
         e.printStackTrace();
     }
   }

   public void processFile(String lanOpt, String mapFile, String inFile, String outFile)
   {
      
      // select language function
      if((lanOpt.compareToIgnoreCase("ver") == 0 ) || (lanOpt.compareToIgnoreCase("sv") == 0 ))
      {
         this.sysVeriObfuscate(mapFile, inFile, outFile);

      }
      else if(lanOpt.compareToIgnoreCase("vhd") == 0 )
      {
         this.vhdlObfuscate(mapFile, inFile, outFile);
      }
      else if(lanOpt.compareToIgnoreCase("sc") == 0 )
      {
         this.systemcObfuscate(mapFile, inFile, outFile);
      }
      else
      {
        System.out.println("Main Error: Language option not supported");
      }

   }
   
public void sysVeriObfuscate(String mapFile, String inFile, String outFile) 
   {
     
      FileInputStream            ins;
      FileOutputStream           optfs;
      File                       optfile;
      DataInputStream            dis;
      SystemVerilogNoSkipLexer   lexer;

      FileInputStream            inm;
      DataInputStream            dim;
      DataOutputStream           dom;
      IDMapLexer                 maplexer;
      String                     outputString   = "";
      String                     hashString     = "";
      HashMap                    obfHMap; 

      
      try
       {
         // Input ID Map Lexer
         inm         = new FileInputStream(mapFile);           
         dim         = new DataInputStream(inm);
         maplexer    = new IDMapLexer(dim);
         // load id map
         idMapLoader = new IDMapLoader(maplexer);
         idMapLoader.source_text();       
         idMapLoader.DebugTrue   = this.DebugTrue;
         obfHMap                 = idMapLoader.idHMap;
         inm.close();
         dom                     = new DataOutputStream(new FileOutputStream(mapFile,true));
         dom.writeBytes("\n//Appended due to input file:\t" + inFile + "\n");

         // Input Verilog Lexer
         ins         = new FileInputStream(inFile);           
         dis         = new DataInputStream(ins);
         lexer       = new SystemVerilogNoSkipLexer(dis);
      
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
         
         antlr.Token t = lexer.nextToken();
         do {
            outputString = t.getText();
            if( t.getType() == SystemVerilogNoSkipLexer.SIMPLE_IDENTIFIER )
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
            else if( (t.getType() == SystemVerilogNoSkipLexer.ONE_LINE_COMMENT) ||  
                     (t.getType() == SystemVerilogNoSkipLexer.BLOCK_COMMENT)    ||   
                     (t.getType() == SystemVerilogNoSkipLexer.WHITE_SPACE)
                   )
            {
              outputString = " ";
            }
            // set end of line before and after compiler directive
            else if( t.getType() == SystemVerilogNoSkipLexer.COMPILER_DIRECTIVE )
            {
              outputString = "\n" + outputString + "\n";
            }
            // write to output file
            optfs.write(outputString.getBytes());

            t = lexer.nextToken();
         }while(t.getType() != antlr.Token.EOF_TYPE);          
         
         dom.close();
         optfs.close();
       }
       catch(Exception e)
       {
           System.out.println("Error: " + e.getMessage());
           e.printStackTrace();
       }
   }

   public void vhdlObfuscate(String mapFile, String inFile, String outFile) 
   {
        
         FileInputStream            ins;
         FileOutputStream           optfs;
         File                       optfile;
         DataInputStream            dis;
         VhdlNoSkipLexer   lexer;
   
         FileInputStream            inm;
         DataInputStream            dim;
         DataOutputStream           dom;
         IDMapLexer                 maplexer;
         String                     outputString   = "";
         String                     hashString     = "";
         HashMap                    obfHMap; 
   
         
         try
          {
            // Input ID Map Lexer
            inm         = new FileInputStream(mapFile);           
            dim         = new DataInputStream(inm);
            maplexer    = new IDMapLexer(dim);
            // load id map
            idMapLoader = new IDMapLoader(maplexer);
            idMapLoader.source_text();       
            idMapLoader.DebugTrue   = this.DebugTrue;
            obfHMap                 = idMapLoader.idHMap;
            inm.close();
            dom                     = new DataOutputStream(new FileOutputStream(mapFile,true));
            dom.writeBytes("\n//Appended due to input file:\t" + inFile + "\n");
   
            // Input Verilog Lexer
            ins         = new FileInputStream(inFile);           
            dis         = new DataInputStream(ins);
            lexer       = new VhdlNoSkipLexer(dis);
         
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
            
            antlr.Token t = lexer.nextToken();
            do {
               outputString = t.getText();
               if( t.getType() == VhdlNoSkipLexer.SIMPLE_IDENTIFIER )
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
               else if(t.getType() == VhdlNoSkipLexer.COMMENT) 
               {
                 outputString = " ";
               }
               // write to output file
               optfs.write(outputString.getBytes());
   
               t = lexer.nextToken();
            }while(t.getType() != antlr.Token.EOF_TYPE);          
            
            dom.close();
            optfs.close();
          }
          catch(Exception e)
          {
              System.out.println("Error: " + e.getMessage());
              e.printStackTrace();
          }
   }


   
   public void systemcObfuscate(String mapFile, String inFile, String outFile) 
   {
      System.out.println("SystemC is not supported in this release ");
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
