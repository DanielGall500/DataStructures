class HeapSort
{

    public HeapSort(){}
    
    public void sort(int[] arr)
    {
	int n = arr.length;

	for(int i = n / 2 - 1; i >= 0; i--)
	    {
		heapify(arr, n, i);
	    }

	for(int i = n-1; i >= 0; i--)
	    {
		swap(arr, 0, i);

		heapify(arr, i, 0);
	    }
    }

    void swap(int[] arr, int i, int j)
    {
	int tmp = arr[i];
	arr[i] = arr[j];
	arr[j] = tmp;
    }

    void heapify(int arr[], int n, int i)
    {
	int largest = i;
	int l       = 2*i + 1;
	int r       = 2*i + 2;

	//Check if left child is larger than root
	if(l < n && arr[l] > arr[largest])
	    largest = l;

	//if right child larger than root
	if(r < n && arr[r] > arr[largest])
	    largest = r;

	//If largest is not root
	if(largest != i)
	    {
		swap(arr, largest, i);

		//RECURSIVE
		heapify(arr, n, largest);
	    }
    }

    public static void main(String[] args)
    {
	int[] arr = {6,4,1,3,5,2};

	HeapSort hs = new HeapSort();
	hs.sort(arr);

	for(int i = 0; i < arr.length; i++)
	    {
		System.out.print(arr[i] + " ");
	    }

	System.out.println();
    }

}
