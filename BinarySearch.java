class BinarySearch{
    public int binarySearch(int k , int[] a, int n){
        int lower = 0, hight = n - 1;
        while(lower <= hight){
            int mid = lower + (hight - lower)/2;
            int c = a[mid];
            if( k < c){
                hight = mid - 1;
            }
            else if( k > c){
                lower = mid + 1;
            }
            else{
                return mid;
            }
        }

        return lower;
    }

    public static void main(String[] args) {
         int[] a = {1,2,4,5,6,7};
         System.out.println(new BinarySearch().binarySearch(8, a, a.length));
    }
}