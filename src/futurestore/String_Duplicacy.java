/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package futurestore;

import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class String_Duplicacy 
{
    String initial_string, final_String;

    public String_Duplicacy(String str) 
    {
        initial_string=str;
        final_String="";
    }
    
    String remove_duplicacy()
    {
        String str_arr[]=initial_string.split(",");
        String str="";        
        try
        {
            for(int i=0;i<str_arr.length;i++)
            {
                for(int j=i-1;j>=0;j--)
                {
                    if(str_arr[i].equalsIgnoreCase(str_arr[j]))
                    {
                        str_arr[i] = "*";
                        break;
                    }
                }
            }
            for(int i=0;i<str_arr.length;i++)
            {
                if(str_arr[i]!="*")
                    final_String=final_String.concat(str_arr[i]+ ",");               
            }
            str=final_String.substring(0, final_String.length()-1);         
        }
        catch(StringIndexOutOfBoundsException e)
        {
            System.out.println(e.getMessage());
        }
        return str;
    }
}
