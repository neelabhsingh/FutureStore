/*
 * This class will initialize the transaction file
 * given by the user
 */

package futurestore;


public class TransactionFile 
{
    String FileName;

    public TransactionFile(String file) 
    {
        FileName=file;
    }
    
    boolean check_file()
    {
        if(FileName.endsWith(".csv"))
            return true;
        else return false;
    }
}
