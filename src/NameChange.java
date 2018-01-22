//*************************************************************************
// DESCRIPTION: HDLObf: Identifier Name Change Module
//
// Code available from: https://sourceforge.net/projects/hdlobf/
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
//*************************************************************************

import java.io.*;
import java.util.*;

class NameChange
{
      
   private  IDMapLoader  idMapLoader;
   public   boolean      DebugTrue;   

   public NameChange( )
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
     NameChange   nc       = new NameChange();
     nc.DebugTrue          = true;
     try{

       // actual  option
       if(args.length > 3)
       {
         lanOpt  = args[0];
         mapFile = args[1];
         inFile  = args[2];            
         outFile = args[3];            
       }                                
       nc.processFile(lanOpt, mapFile, inFile, outFile);

     }catch (Exception e)
     {
         System.out.println("Usage: NameChange <Language Option> <map file> <input file> <output file>" + e.getMessage());
         System.out.println("Main Error: " + e.getMessage());
         e.printStackTrace();
     }
   }

   public void processFile(String lanOpt, String mapFile, String inFile, String outFile)
   {
        processFile(lanOpt,  (new File(mapFile)), (new File(inFile)), (new File(outFile)));
   }

   public void processFile(String lanOpt, File mapFile, File inFile, File outFile)
   {
      FileInputStream            ins;
      FileOutputStream           optfs;
      DataInputStream            dis;
      int                        simpelIDType = 0;
      FileInputStream            inm;
      DataInputStream            dim;
      IDMapLexer                 maplexer;

      
      // Start processing file
      try
       {
         // Input ID Map Lexer
         inm         = new FileInputStream(mapFile);           
         dim         = new DataInputStream(inm);
         maplexer    = new IDMapLexer(dim);
         // load id map
         idMapLoader = new IDMapLoader(maplexer);
         idMapLoader.source_text();       
         idMapLoader.DebugTrue = this.DebugTrue;
         
         // Input Verilog Lexer
         ins         = new FileInputStream(inFile);           
         dis         = new DataInputStream(ins);
         // Output Verilog File
         optfs     = new FileOutputStream(outFile);

         // select language function
         if((lanOpt.compareToIgnoreCase("ver") == 0 ) || (lanOpt.compareToIgnoreCase("sv") == 0 ))
         {
            SystemVerilogNoSkipLexer   lexer_vc;  
            simpelIDType               = SystemVerilogNoSkipLexer.SIMPLE_IDENTIFIER;
            lexer_vc                   = new SystemVerilogNoSkipLexer(dis);
            processSVFile(ins, optfs, lexer_vc, simpelIDType);
         }
         else if(lanOpt.compareToIgnoreCase("vhd") == 0 )
         {
            VhdlNoSkipLexer            lexer_vhd;
            simpelIDType               = VhdlNoSkipLexer.SIMPLE_IDENTIFIER;
            lexer_vhd                  = new VhdlNoSkipLexer(dis);
            processVHFile(ins, optfs, lexer_vhd, simpelIDType);
         }
         else if(lanOpt.compareToIgnoreCase("sc") == 0 )
         {
            System.out.println("Main Error: Language option SystemC not supported");
            return;
         }
         else
         {
            System.out.println("Main Error: Language option not supported");
            return;
         }

      
         optfs.close();
       }
       catch(Exception e)
       {
           System.out.println("Error: " + e.getMessage());
           e.printStackTrace();
       }
   } 

   private void processSVFile( FileInputStream ins, FileOutputStream optfs, SystemVerilogNoSkipLexer lexer, int simpelIDType)
   {
      String                     outputString = "";
      try
      {
         antlr.Token t = lexer.nextToken();
         do {
            outputString = t.getText();
            if( t.getType() == simpelIDType )
            {
             // if ID avaliable in map
             if(idMapLoader.idHMap.containsKey(t.getText()))
             {
                //if debug on
                if(DebugTrue) System.out.print("Value of ID: " + outputString + "\t\trenamed to :");
                
                outputString = (String) idMapLoader.idHMap.get(t.getText());
                
                //if debug on
                if(DebugTrue) System.out.println(outputString);
             }
            }
            // write to output file
            optfs.write(outputString.getBytes());
      
            t = lexer.nextToken();
         }while(t.getType() != antlr.Token.EOF_TYPE); 
      }
      catch(Exception e)
      {
          System.out.println("Error: " + e.getMessage());
          e.printStackTrace();
      }

   }

   private void processVHFile( FileInputStream ins, FileOutputStream optfs, VhdlNoSkipLexer lexer, int simpelIDType)
   {
      String                     outputString = "";
      try
      {
         antlr.Token t = lexer.nextToken();
         do {
            outputString = t.getText();
            if( t.getType() == simpelIDType )
            {
             // if ID avaliable in map
             if(idMapLoader.idHMap.containsKey(t.getText()))
             {
                //if debug on
                if(DebugTrue) System.out.print("Value of ID: " + outputString + "\t\trenamed to :");
                
                outputString = (String) idMapLoader.idHMap.get(t.getText());
                
                //if debug on
                if(DebugTrue) System.out.println(outputString);
             }
            }
            // write to output file
            optfs.write(outputString.getBytes());
      
            t = lexer.nextToken();
         }while(t.getType() != antlr.Token.EOF_TYPE); 
      }
      catch(Exception e)
      {
          System.out.println("Error: " + e.getMessage());
          e.printStackTrace();
      }

   }
}
