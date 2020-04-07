
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class JavaApplication1 {

   

    public static void main(String[] args) throws FileNotFoundException {
       
        
  

		String command; // used to save the command read from input file
		
		// OPEN FILES
		// Input File:
		File inputFile = new File("FCITbaqalah.in");
		if (!inputFile.exists()) {
			System.out.println("Input file, " + inputFile + ", does not exist.");
			System.exit(0);
		}
		// Output File:
		File outputFile = new File("FCITbaqalah.out");
		
		// Make Scanner variable to read from input file, and 
		// make Printwriter variable to print to output
		Scanner input = new Scanner(inputFile);
		PrintWriter output = new PrintWriter(outputFile);

		// Here is how you can print text to the output file
		output.println();
                output.println();
		
                int maxProducts=input.nextInt();
                int maxSales=input.nextInt();
                
                FCITbaqalahProduct[] products = new FCITbaqalahProduct[maxProducts];
                FCITbaqalahSale[] sales = new FCITbaqalahSale[maxSales];
                int index=-1;
                
                do {
			command = input.next();

			
			if (command.equals("ADDITEM") == true) {
				FCITbaqalahProduct saad=new FCITbaqalahProduct(input.nextInt(), input.next(),input.nextDouble(),input.nextInt(),input.nextInt());
                                if (products[0]==null) {
                                products[0]=saad;
                                index=-1;
                                
                            }else 
                             
                                   for (int i = 0; i <saad.getNumProducts() ; i++) {
                                       if (saad.getItemNum()>products[i].getItemNum()){
                                           index=i;
                                           break;
                                       }
                                   }
                               
                                if (index!=-1) {
                                
                            
                               for (int i = saad.getNumProducts(); i <=index ; i--) {
                                   products[i+1]=products[i];
                                   
                                   
                               }   
                                 products[index]=saad;    
                        }
                                else{
                                    products[saad.getNumProducts()]=saad;
                                    
                                }
                                
                                saad.plus();
                                output.print("ADDITEM:");
                                output.println("Item:"+saad.getItemNum()+","+saad.getItemName()+", with a cost of "+saad.getItemPrice()+", and initial stock of"+saad.getQuantity()+" has been added to the product database.");
                                 
                                System.out.println(saad.getItemNum());
                        }
			else if (command.equals("FINDITEM") == true) {
				
			}
			
			
			else if (command.equals("RESTOCK") == true) {
				
			}
                        else if (command.equals("CUSTOMER ") == true) {
				
			}else if (command.equals("INVENTORY") == true) {
				
			}else if (command.equals("PRINTSUMMARY") == true) {
				
			}
			
			// Command QUIT: Quit the Program
			else if (command.equals("QUIT") == true) {
				output.println("Goodbye.");
			}
			
			// Invalid Command
			
			
		} while (command.equals("QUIT") != true);

		// Close input and output
		input.close();
		output.close();
	}
    
  
    
    public static int binarySearch(FCITbaqalahProduct[] array, int key) {
    int low = 0, high = array.length-1, mid = 0;
    while (low <= high) {
    mid = (low + high)/2;
    if(key == array[mid].getItemNum())
    return mid;
    else if (key < array[mid].getItemNum()) // change high
    high = mid - 1;
    else // change low
    low = mid + 1;
    }
    return -1; // if key not found above
    }
    public static int linearSearch(FCITbaqalahProduct[] array, int key) {
    for(int i = 0; i<array.length; i++) {
if(key == array[i].getItemNum())
return i; //If found, return index of that element
}
return-1; //if not found, return -1
}
 public static FCITbaqalahProduct [] doSelectionSort(FCITbaqalahProduct[] array){
         
        for (int i = 0; i < FCITbaqalahProduct.getNumProducts() - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j <  FCITbaqalahProduct.getNumProducts(); j++)
                if (array[j].getItemNum() < array[index].getItemNum())
                    index = j;
      
            int smallerNumber = array[index].getItemNum(); 
            array[index] = array[i];
            array[i].getItemNum()= smallerNumber;
        }
        return array;
    }
  
}


    
    

