public class InsertionSort 
{
	void sort(int inputArray[]) 
	{
    for (int i=1; i<inputArray.length; i++) 
    {
        int key = inputArray[i];
        int j = i-1;
        while (j>=0 && inputArray[j] > key) 
        {
            inputArray[j+1] = inputArray[j];
            j = j-1; 
        }
        inputArray[j+1] = key; 
     }
} 
}

