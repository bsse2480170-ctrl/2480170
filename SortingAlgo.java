import java.util.Arrays;

public class SortingAlgo {
    public static void main(String[] args) {
        int[] arr1={5,1,4,2,8};
        int[] arr2={5,1,4,2,8};

        mergeSort(arr1, 0, arr1.length-1);
        System.out.println("Array after Merge Sort:"+Arrays.toString(arr1));

        quickSort(arr2,0, arr2.length-1);
        System.out.println("Array after Quick Sort:"+Arrays.toString(arr2));
    }
    static void mergeSort(int[] arr, int left,int right){
        if(left<right){
            int mid =(left+right)/2;
            mergeSort(arr,left,mid);
            mergeSort(arr,mid+1,right);

            merge(arr,left,mid,right);
        }
    }
    static void merge(int[] arr,int left,int mid,int right){
        int n1=mid-left+1;
        int n2=right-mid;

        int[] l=new int[n1];
        int[] r=new int[n2];

        for(int i=0;i<n1;i++)
            l[i]=arr[left+i];
        for(int j=0;j<n2;j++)
            r[j]=arr[mid+1+j];
        int i=0,j=0,k=left;
        while(i<n1&&j<n2){
            if(l[i]<=r[j]){
                arr[k++]=l[i++];
            }else {
                arr[k++]=r[j++];
            }
        }
        while(i<n1){
            arr[k++]=l[i++];
        }
    }
    static void quickSort(int[] arr,int low,int high){
        if(low<high){
            int pivotIndex=partition(arr,low,high);

            quickSort(arr,low,pivotIndex-1);
            quickSort(arr,pivotIndex+1,high);
        }
    }
    static int partition(int[] arr,int low,int high){
        int pivot=arr[high];
        int i=low-1;
        for(int j=low;j<high;j++){
            if(arr[j]<=pivot){
                i++;
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        int temp=arr[i+1];
        arr[i+1]=arr[high];
        arr[high]=temp;
        return i+1;
    }
}
