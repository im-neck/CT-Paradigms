package search;


public class BinarySearch {

    //Pre:
    //      int x
    //      forall i=0..a.length - 1:  arr[i] - int && arr[i-1]>=arr[i] && arr[i]!=null

    //Post:
    //     1)if min(arr)>x>max(arr): res = i {i: ( arr[i]<=x) && (not exist i` : i`<i && arr[i`]<=x) && (-1 < i <= a.length)}
    //     2)if min(arr)>x: arr.length

    public static void main(String[] args) {
        //Consider: arr[-1] == +inf && a[len(a)] == -inf */
        int x = Integer.parseInt(args[0]);
        int[] arr = new int[args.length - 1];
        int sum = 0;
        for (int i = 1; i < args.length; i++) {
            arr[i - 1] = Integer.parseInt(args[i]);
            sum += arr[i - 1];
        }
        if (sum % 2 == 0) {
            System.out.println(recursiveBinSearch(x, arr));
        } else {
            System.out.println(iterativeBinSearch(x, arr));
        }
    }


    //Pre:
    //      int x
    //      forall i=0..a.length - 1:  arr[i] - int && arr[i-1]>=arr[i] && arr[i]!=null

    //Post:
    //     1)if min(arr)>x>max(arr): res = i {i: ( arr[i]<=x) && (not exist i` : i`<i && arr[i`]<=x) && (-1 < i <= a.length)}
    //     2)if min(arr)>x: arr.length
    public static int iterativeBinSearch(int x, int[] arr) {
        int l = -1;
        // l = -1

        int r = arr.length;
        // r = arr.length

        int mid;

        // I : l <= r && l, r ∈ [-1, arr.length],
        while (l < r - 1) {
            mid = (l + r) / 2;
            //(*) l < mid < r   prove: 1) (l+r)/2=l+(r-l)/2,  (r-l)/2>0 (l < r - 1) -> mid=(l+r)/2>l
            //                         2) (l+r)/2=r-(r-l)/2, -(r-l)/2<0             -> mid=(l+r)/2<r
            //Similarly  l` < mid` < r`
            if (arr[mid] > x) {
                //x<arr[mid`]
                l = mid;
                //l`=m` && I (by *)
            } else {
                //x>=arr[mid]
                r = mid;
                //r`=m` && I (by *)
            }
            //(*) l < mid < r   prove: 1) (l+r)/2=l+(r-l)/2,  (r-l)/2>0 (l < r - 1) -> mid=(l+r)/2>l
            //                         2) (l+r)/2=r-(r-l)/2, -(r-l)/2<0             -> mid=(l+r)/2<r
            //Similarly  l` < mid` < r`

            //mid' ∈ [l', r'] -> l', r' ∈ [l, r], l<r(by *) => I - true
        }

        return r;
    }


    //Pre:
    //      int x
    //      forall i=0..a.length - 1:  arr[i] - int && arr[i-1]>=arr[i] && arr[i]!=null

    //Post:
    //     1)if min(arr)>x>max(arr): (i: arr[i]<=x) && (not exist i` : i`<i && arr[i`]<=x)
    //     2)if min(arr)>x: arr.length
    public static int recursiveBinSearch(int x, int[] arr) {
        return recursiveBinSearchInner(x, arr, -1, arr.length);
    }


    //Pre:
    //      int x
    //      forall i=0..a.length - 1:  arr[i] - int && arr[i-1]>=arr[i] && arr[i]!=null

    //Post:
    //     1)if min(arr)>x>max(arr): (i: arr[i]<=x) && (not exist i` : i`<i && arr[i`]<=x)
    //     2)if min(arr)>x: arr.length
    public static int recursiveBinSearchInner(int x, int[] arr, int l, int r) {
        int mid = (l + r) / 2;
        // I: int l,r: l <= r && l, r ∈ [-1, arr.length]
        if (l < r - 1) {
            if (arr[mid] > x) {
                //l` = mid` < r(by *)
                return recursiveBinSearchInner(x, arr, mid, r);
            } else {
                //r` = mid` > l(by *)
                return recursiveBinSearchInner(x, arr, l, mid);
            }
            //(*) l < mid < r   prove: 1) (l+r)/2=l+(r-l)/2,  (r-l)/2>0 (l < r - 1) -> mid=(l+r)/2>l
            //                         2) (l+r)/2=r-(r-l)/2, -(r-l)/2<0             -> mid=(l+r)/2<r
            //Similarly  l` < mid` < r`

            //mid' ∈ [l', r'] -> l', r' ∈ [l, r], l<r(by *) => I - true
        }
        return r;
    }
    /*  3
     * 2 3 4 5 6 7 8*/
}
