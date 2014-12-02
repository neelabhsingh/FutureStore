/*
 * This class will find the frequent pattern item sets as per
 * given values of minimum support and confidence
 */

package futurestore;

import java.util.*;
import java.io.*;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
public class AprioriAlgo
{
    //String FileName;
    int Min_Sup, Min_Conf;
    
    Vector temp[];//=new Vector[100];
    Vector Sup_Count[];//=new Vector[100];
    TransactionFile file;
    AprioriAlgo(String file_name,int Sup, int con)
    {
        file=new TransactionFile(file_name);
        int no_trans;
        no_trans=set_trans();
        Min_Sup=Sup;
        Min_Conf=con;
        temp= new Vector[no_trans];
        Sup_Count= new Vector[no_trans];
    }
    //this will find the number of transactions in the given file
    int set_trans()
    {
        int no_trans=0;
        String str;   
        try
        {
            FileInputStream File1 = new FileInputStream(file.FileName);
            DataInputStream ds = new DataInputStream(File1);
            while(ds.available()!=0)
            { 
                no_trans++;
            	str=ds.readLine();              
            }
        }
        catch(IOException e)
        {}
        System.out.println(no_trans);
        return no_trans;
    }
    
    
    //this will generate the first candidate set using the transaction file given by the user
    int get_apriori()
    {
            int itemcount=-1;
            String final_result[], temp_string[],str="", Complete_String="";    //complete_string will contain the total items in tha file with redundancy
            String Complete_final_String;       //contains the total items in the transaction file without redundancy
            String temp1[], return_string[]=new String[1];

            System.out.println("min support=" + Min_Sup);
            try
            {
                FileInputStream File1 = new FileInputStream(file.FileName);
                DataInputStream ds = new DataInputStream(File1);            
                //this loop will generate the complete_string i.e. total items
                while(ds.available()!=0)
                { 
                    str=ds.readLine();   
                    str=remove_last_comma(str);//t100,i1,i2,i5,i6,,  remove last comma                
                    str=str.substring(str.indexOf(",")+1);//t100,i1,i2,i5,i6,, we need only i1,i2,i5,i6
                    /*
                    substring(str.indexOf(",")+1
                    Returns a new string that is a substring of this string. 
                    The substring begins with the character at the specified index and 
                    extends to the end of this string.
                    */
                    Complete_String=Complete_String.concat(str.toUpperCase() + ",");
                    // add comma in the last in every string.
                }
            }
            catch(IOException e)
            { 
                return_string[0]="File cannot be read";
                return -1;
            }
            catch(ArrayIndexOutOfBoundsException e)
            {
                System.out.println("Array 1");
            }                

            // i1,i2,i5,i6,i2,i4,i8,
            Complete_String=Complete_String.substring(0, Complete_String.length()-1);
            // i1,i2,i5,i6,i2,i4,i8 remove last comma   
            String_Duplicacy str_duplicate=new String_Duplicacy(Complete_String);
            Complete_final_String=str_duplicate.remove_duplicacy();
            System.out.println(Complete_final_String);
            temp1=Complete_final_String.split(",");            
            //System.out.println(Complete_String.length());
            System.out.println(temp1.length);
            int count=0;
            try
            {
                temp[0]=new Vector();
                Sup_Count[0]=new Vector();
               // Vector ds=new Vector();
            System.out.println("Complete String "+Complete_String);
            System.out.println("temp1.length="+temp1.length);
            // temp1 will contains the unique items from the given string
            for(int i=0; i<temp1.length;i++)
            {
                count=0;           
                //System.out.println(ds.get(i));
                //calculate the frequency of first candidate
                /*
                before=Complete_String.indexOf(",",next) 
                Returns the index within this string of the first occurrence of the specified substring, 
                starting at the specified index.
                */
                //Suppose complete_String is I1,I2,I5,I6,I2,I4,I8,I2,I3,I1,
                //temp1[0]=I1, Now search this string into Complete_String pos=0 next pos=27 
                //
                for(int before=0, next=0; before!=-1; before=Complete_String.indexOf(",",next))
                {                    
                    int pos=Complete_String.indexOf(temp1[i], before);            
                    System.out.print("Pos "+pos+" ");
                    if(pos>-1)
                    {
                        count++;
                        next=pos;// Now check next temp1[i] string from  pos
                    }
                    else
                        break;
                }
                System.out.println(count + "  "  + Min_Sup);
                if(count>=Min_Sup)
                {
                    Sup_Count[0].addElement(count);
                    temp[0].addElement(temp1[i]);
                }
            }    
            System.out.println("Print temp "+temp[0].size());
            for(int i=0; i<temp[0].size();i++)
                System.out.println("print temp"+temp[0].get(i).toString() + " " + Sup_Count[0].get(i));
            itemcount++;   
        }
        catch(NullPointerException e)
        { 
            System.out.println("value not present");
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Array");
        }
        return itemcount;
    }
    
    //to generate various candidate itemsets
    int get_Candidate(int current_candidate)
    {
        int i, j;
        String str1, str2, item_candidate;
        System.out.println("In get_candidate");
        //System.out.println("temp[n] size" + temp[n].size());
        if(temp[current_candidate].size()==1)
            return 0;
        try
        {
            temp[current_candidate+1]=new Vector();
            System.out.println(temp[current_candidate].size());
            for(i=0; i<temp[current_candidate].size();i++)
            {
                for(j=i+1; j<temp[current_candidate].size();j++)
                {
                    str1=temp[current_candidate].get(i).toString();
                    str2=temp[current_candidate].get(j).toString();
                    System.out.println(str1.toUpperCase() + "  " + str2.toUpperCase());
                    String_Duplicacy str=new String_Duplicacy(str1.toUpperCase() + "," + str2.toUpperCase());
                    item_candidate=str.remove_duplicacy();
                    System.out.println("item_candidate"+item_candidate);
                    String check_size[]=item_candidate.split(",");
                    System.out.println(check_size.length + " " + (current_candidate+2));
                    if(check_size.length==current_candidate+2)
                        temp[current_candidate+1].addElement(item_candidate);
                }  
            }
            System.out.println(temp[current_candidate+1].size());
            /*for(i=0;i<temp[current_candidate+1].size();i++)
                System.out.println("before=" + temp[current_candidate+1].get(i));*/
            temp[current_candidate+1]=vector_redundant(temp[current_candidate+1]);
           // for(i=0;i<temp[current_candidate+1].size();i++)
           //   System.out.println("after=" + temp[current_candidate+1].get(i));
        }
        
        catch(NullPointerException e)
        {
            System.out.println("Value not present");
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Array");
        }
        //System.out.println(temp[current_candidate+1].size() + " "+  temp[current_candidate+1].get(0).toString());
        //System.out.println("De");
        //to remove the infrequent item sets in the candidate set
        in_frequent(current_candidate);
        //System.out.println("Out of get_candidate");
        
        if(temp[current_candidate+1].size()>0)
        {            
            cal_frequency(current_candidate);
          //  System.out.println("size of temp[n+1]----" +temp[current_candidate+1].size());
            if(temp[current_candidate+1].size()>0)
            {
                //System.out.println("CONTINUE");
                return 1;
            }
            else
            {
                //System.out.println("STOPPING");
                return 0;
            }
            
        }
        
        else return 0;
    }
    
    
    //calculate the support count of each item set in candidate set this generating final frequent item set
    void cal_frequency(int current_candidate)
    {
        int i, count;
        String str;
        System.out.println("In cal_frequency");
        Sup_Count[current_candidate+1]=new Vector();        
        try
        {
            for(i=0; i<temp[current_candidate+1].size();)
            {
                count=0;                
                //System.out.println("cal frequency of" + temp[current_candidate+1].get(i));
                str=temp[current_candidate+1].get(i).toString();
                String to_search[]=str.split(",");
                FileInputStream File1 = new FileInputStream(file.FileName);
                DataInputStream ds = new DataInputStream(File1);
                while(ds.available()!=0)
                {
                    str=ds.readLine();
                    str=remove_last_comma(str.toUpperCase());                    
                    //String search_In[]=str.split(",");
                    System.out.println("cal frequency in " + str);
                    int present=1;
                    for(int search=0; search<to_search.length;search++)
                    {
                            if(str.indexOf(to_search[search])<0)
                            {
                                present=0;
                                break;
                            }
                    }
                    System.out.println(str.indexOf(temp[current_candidate+1].get(i).toString()));
                    if(present==1) 
                        count++;
                }
                if(count<Min_Sup)       //here the element from candidate set is deleted if count is less since it is infrequent
                {
                    //System.out.println("Deleting..." + temp[current_candidate+1].get(i));
                    temp[current_candidate+1].removeElementAt(i);
                }
                else
                {
                    Sup_Count[current_candidate+1].addElement(count);
                    i++;
                }
                ds.close();
            }
            
            /*for(i=0;i<temp[current_candidate+1].size();i++)
                System.out.println("Temp " + temp[current_candidate+1].get(i));
            for(i=0;i<Sup_Count[current_candidate+1].size();i++)
            {
                System.out.println(Sup_Count[current_candidate+1].get(i) + " candidate " + temp[current_candidate+1].get(i));
            }*/
            
        
        }
        catch (IOException e)
        {}   
        catch(NullPointerException e)
        {
            System.out.println("Value not present");
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Array");
        }
        
        /*System.out.println(temp[current_candidate+1].size() + ", sup_count"+ Sup_Count[current_candidate+1].size());
        for(i=0; i<temp[current_candidate+1].size();i++)
                System.out.println(temp[current_candidate+1].get(i).toString() + " " + Sup_Count[current_candidate+1].get(i));
        System.out.println("Out of cal_frequency");*/
        
        
        /*if(temp[n+1].size()==0)
        {
            temp[n+1]=null;
            Sup_Count[n+1]=null;
            return 0;
        }
        else
            return 1;*/
        
    }
    
    
    
    //method to remove the infrequent item set from candidate item set
    void in_frequent(int current_candidate)
    {
        int frequent_i;
        String str="", arr[]={};
        System.out.println("In in_frequent");
        try
        {
            for(frequent_i=0; frequent_i<temp[current_candidate+1].size();) 
            {
                 System.out.println("f");
                 str=temp[current_candidate+1].get(frequent_i).toString();
                 System.out.println(str + frequent_i);
                 arr=str.split(",");
                 //System.out.println(arr.length);
                 //System.out.println(arr[0]);
                    int size=Double.valueOf(Math.pow(2, arr.length)).intValue()-1;
                    if(!subset(arr,size))
                    {
                          temp[current_candidate+1].removeElementAt(frequent_i);
                    }
                      else     
                          frequent_i++;
            }
           //System.out.println(temp[current_candidate+1].size());
           //for(int i=0;i<temp[current_candidate+1].size();i++)
           // System.out.println(temp[current_candidate+1].get(i));
        }
        catch(NullPointerException e)
        {
            System.out.println("Value not present");
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Array");
        }
       // System.out.println("Out of in_frequent");
    }
    
    
    
    //function to find the subset of each itemset in candidate item set to find infrequent item set
    boolean subset(String arr[],int size)
    {
	int i,j, first_arr;
        String str="", search_in[];
        boolean equal=true, found=false;
        int size_counter;                
        //System.out.println("In subset");
        try
        {    
            for(i=size; i>=0; --i)
            {
		int index=arr.length-1;
		int num=i;
		str="";
		while(num>0)
                {           
			if(num%2!=0)
		           str=str.concat(arr[index]+",");	
			--index;
                        //System.out.println(index);
			num/=2;
		}
		str=str.substring(0, str.length()-1);
		System.out.println(str);
                String size_arr[]=str.split(",");
                if(arr.length!=size_arr.length)
                {                    
                    //this will seach each subset generated in respective frequent item set generated before the current one
                   for(j=0; j<temp[size_arr.length-1].size();j++)
                   {
                       equal=true;
                       search_in=temp[size_arr.length-1].get(j).toString().split(",");
                        for(first_arr=0; first_arr<size_arr.length-1; first_arr++)
                        {
                            found=false;  
                            for(size_counter=0; size_counter<search_in.length;size_counter++)
                            {                 
                                if(size_arr[first_arr].equalsIgnoreCase(search_in[size_counter]))
                                {
                                   found=true;
                                     break;
                                }
                            }
                            if(found==false)
                            {
                                equal=false;
                                break;
                            }
                        } 
                    }
                }
             } 
            if(equal==false)
            {
                    System.out.println("deleting...");
                    return false;
            }
        }
        catch(NullPointerException e)
        {
             System.out.println("Value not found");
        }
        catch(StringIndexOutOfBoundsException e)
        {
            System.out.println("Out of bound");
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Array");
        }
              // System.out.println("Out of subset"); 
        return true;
    }
            
	
    
    
    /*if(index-start+1==no_of_subset)
	{	
		if(no_of_subset==1)
		{
			for(i=0;i<arr.length;i++)
                        {	
                            str=arr[i].trim();
                           System.out.println(str);
                            if(!check.contains(str))
                            {
                                System.out.println("deleting...");
                                return false;
                            }
                        }
                        
		}
		else
		{
			for(j=index;j<arr.length;j++)
			{
                            str="";
				for(i=start;i<index;i++)
					str=str.concat(arr[i].trim()+",");
				str=str.concat(arr[j].trim()+",");
                                str=str.substring(0, str.length()-1);
                                System.out.println(str);
                                if(!check.contains(str))
                                {
                                    System.out.println("deleting...");
                                    return false;
                                }
                                
			}
			if(start!=arr.length-no_of_subset)
				subset(arr,start+1,start+1,no_of_subset,check,n);
		}
	}
	else
	{
                
		subset(arr,start,index+1,no_of_subset,check,n);
	}*/
        
    
    
   /* String[] generate_arr_subset(String str, String arr[])
    {
        
            /* StringTokenizer st = new StringTokenizer(str , ",");
             Vector out=new Vector();
             
             System.out.println("In generate_arr_subset");
             try
             {
             while(st.hasMoreTokens())
             {
                 out.addElement(st.nextToken());
             }
             }
             catch(NullPointerException e)
             {
                 System.out.println("deepak");
             }
             catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Array");
        }
             arr=str.split(",");
             //out.copyInto(arr);
             //Arrays.sort(arr);
             System.out.println(arr.length);
           System.out.println("Out of generate_arr_subset");
            return arr; 
    }*/
    
    
    // function to remove the last comma present in the string
    String remove_last_comma(String s)
    {
        if(s.charAt(s.length()-1)==',')
        {
            s=s.substring(0, s.length()-1);
            s=remove_last_comma(s);
        }
        return s;
    }
    
    
    //method to remove redundancy from a vector
    Vector vector_redundant(Vector initial)
    {
        int i,j ,h[], first_arr, second_arr;
        String a[], first[], second[];
        boolean equal, found;        
        for(i=0;i<initial.size();i++)
            System.out.println("vector redundant=" + initial.get(i));        
        try
        {
            for(i=0; i<initial.size(); i++)
            {
                System.out.println("first="+ initial.get(i).toString());
                first=initial.get(i).toString().split(",");
                for(j=i+1; j<initial.size();)
                {
                    System.out.println("second="+ initial.get(j).toString());
                    second=initial.get(j).toString().split(",");
                    equal=true;
                    for(first_arr=0; first_arr<first.length;first_arr++)
                    {
                        found=false;
                        for(second_arr=0; second_arr<second.length;second_arr++)
                        {
                            if(first[first_arr].equalsIgnoreCase(second[second_arr]))
                            {
                                found=true;
                                break;
                            }
                        }
                        if(found==false)
                        {
                            equal=false;
                            break;
                        }
                    }
                    if(equal==true)
                    {
                        System.out.println("Deleting vector..." + initial.get(j));
                        initial.removeElementAt(j);
                    }
                    else
                        j++;       
                }          
            }
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Error");
        }
        return initial;
    }
}

