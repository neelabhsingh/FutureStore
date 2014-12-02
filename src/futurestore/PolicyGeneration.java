/*
 *This class will generate the policies which can be used by Future Store
 * i.e. generate association rules from frequent Itemsets
 */

package futurestore;
public class PolicyGeneration
{    
    static int position=0;
    String result[]={};
    AprioriAlgo Apriori;
    public PolicyGeneration(String file, int Sup, int Con) 
    {
        Apriori=new AprioriAlgo(file, Sup, Con);
    }    
    //method to find the final association rules for each frequent n-item set
    String[] Set_Result()
    {        
        int itemcount=Apriori.get_apriori();  // return 0,  
        System.out.println("Itemcount"+itemcount);
        while(true)
        {
            if(Apriori.get_Candidate(itemcount)==0)
            {
                System.out.println(itemcount);
                if(itemcount==0)
                {
                    System.out.println("No matches can be found");
                    result=new String[1];
                    result[0]="No matches can be found";
                    System.out.println("Not matched");
                }
                else
                    result=get_Association(itemcount);
                return result;
            }
            itemcount++;
            System.out.println("Item count= " +itemcount);
        }
        //return result;
    }
    
    //method to find the association of a supplied candidate item set form set_result method
    
    String[] get_Association(int lastCandidate)
    {
        int i, count_associate=0;
        String str="", arr[]={};
        String final_association[]=new String[100];
        String main_value[]={};
        System.out.println("In get_association");
        System.out.println(lastCandidate);
        try
        {
                for(int frequent_item_set=1; frequent_item_set<=lastCandidate; frequent_item_set++)    
                {
                    System.out.println("fre" + frequent_item_set);
                    for(i=0; i<Apriori.temp[frequent_item_set].size();i++)
                    {
                        position=0;

                        str=Apriori.temp[frequent_item_set].get(i).toString();
                        System.out.println(frequent_item_set + " deeps " +str);
                        main_value=str.split(",");
                         //System.out.println(main_value.length);
                        result= new String[Double.valueOf(java.lang.Math.pow(2,main_value.length)-2).intValue()];     
                        for(int j=0;j<main_value.length-1;j++)
                           result=subset_association(main_value,0,0,j+1,result);


                       // for(int j=0;j<result.length;j++)
                         //   System.out.println("subset result- " + result[j]);

                         //System.out.println(temp[lastCandidate].get(0));
                        //System.out.println(frequent_item_set);

                        // System.out.println(Apriori.temp[frequent_item_set].size());


                        //System.out.println(Sup_Count[0].get(temp[0].indexOf(result[0])));
                       // System.out.println("AD");
                        for(int result_count=0; result_count<result.length; result_count++)
                        {
                                String size[]=result[result_count].split(",");
                                //System.out.println(Apriori.Sup_Count[frequent_item_set].get(Apriori.temp[frequent_item_set].indexOf(str)).toString());
                               // System.out.println("Aghffhg");
                                //System.out.println(Apriori.Sup_Count[size.length-1].get(Apriori.temp[size.length-1].indexOf(result[result_count])).toString());


                                float confidence=(Float.parseFloat(Apriori.Sup_Count[frequent_item_set].get(Apriori.temp[frequent_item_set].indexOf(str)).toString()))/(Float.parseFloat(Apriori.Sup_Count[size.length-1].get(Apriori.temp[size.length-1].indexOf(result[result_count])).toString())) * 100;
                                System.out.println(size[0]);

                               // System.out.println(confidence + "deep confidence");

                                //this will execute only if confidence of particular item set is greater than given confidence
                                if(confidence>Apriori.Min_Conf)
                                {
                                   // final_association[count_associate]=result[result_count] + " can be associated with";
                                    final_association[count_associate]="";

                                    String item_set_arr[]=result[result_count].split(",");

                                    //find the item with which the item should be associated
                                        for(int out_search=0; out_search<main_value.length; out_search++)
                                        {
                                            boolean found=false;
                                            for(int item_set_arr_count=0; item_set_arr_count<item_set_arr.length;item_set_arr_count++)
                                            {
                                                if(main_value[out_search].equals(item_set_arr[item_set_arr_count]))
                                                {
                                                    found=true;
                                                    break;
                                                }
                                            }
                                            if(found==false)
                                            {
                                               // System.out.println("DeepsS");
                                                final_association[count_associate]=final_association[count_associate].concat(" " + main_value[out_search] + " and");
                                                System.out.println(final_association[count_associate] + main_value[out_search]);
                                            }

                                        }
                                  //  System.out.println(final_association[count_associate]);
                                    final_association[count_associate]=final_association[count_associate].substring(0, final_association[count_associate].length()-4);
                                    final_association[count_associate]=final_association[count_associate].concat(" can be grouped with " + result[result_count]);

                                        final_association[count_associate]=final_association[count_associate].concat(" with " + Math.round(confidence) + " confidence.");
                                        count_associate++;
                                       // System.out.println(final_association[count_associate]);
                                }
                                       // System.out.println(final_association[count_associate]);

                            }
                        }
                    }
        }
        catch(NullPointerException e)
        {
            System.out.println("Value not present");
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Array");
        }
       // System.out.println("Out of get_association");
        if(count_associate==0)
        {
            result=new String[count_associate+1];
            result[0]="No matches can be found";
        }
        else
        {
            result=new String[count_associate];
            System.out.println("Out");
            System.out.println(final_association[0] + " check");
            for(i=0;i<count_associate;i++)
                result[i]=final_association[i];
        }
        return result;
    }
    
    
    //to find the subset of each association
    String[] subset_association(String arr[], int start,int index,int no_of_subset, String[] result)
    {
	int i,j;
                
        String str;
        
        //System.out.println(arr.length);
	if(index-start+1==no_of_subset)
	{	
		if(no_of_subset==1)
                {
                    for(i=0;i<arr.length;i++)
                            result[position++]=arr[i].trim();
                }

		else
		{
			for(j=index;j<arr.length;j++)
			{
                            str="";
				for(i=start;i<index;i++)
					str=str.concat(arr[i].trim()+",");
				str=str.concat(arr[j].trim()+ ",");
                                result[position++]=str.substring(0, str.length()-1);
                                
			}
			if(start!=arr.length-no_of_subset)
				subset_association(arr,start+1,start+1,no_of_subset, result);
		}
	}
	else
	{
		subset_association(arr,start,index+1,no_of_subset, result);
	}
        
      return result;  
    }
}
