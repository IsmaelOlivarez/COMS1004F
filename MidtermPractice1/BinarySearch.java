package MidtermPractice1;

public class BinarySearch {
    
    //Will not work if the array is not sorted; MUST BE SORTED!!!!
    public static int binarySearch(int[] a, int v){
        int start = 0;
        int stop = a.length - 1;
        int location = -1;

        while(start<=stop){
            int mid = (start+stop)/2;
            if(a[mid]>v){//v is smaller than the mid point--means that v will appear in the lower half
                stop = mid-1; //non-inclusive
            }else if(a[mid] < v){ // v is greater than the mid point
                start = mid + 1;
            }else{//v is equal to a[mid]
                location = mid;
                break;
            }
        }
        return location;

    }
}
