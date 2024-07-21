package search;

public class BinarySearchClosestA {
    // 1 2 3 4 4
    //Pre:
    //      int x
    //      forall i=0..a.length - 1:  arr[i] - int && arr[i-1]<=arr[i] && arr[i]!=null

    //Post:
    //     res = arr[ans] { ans: (not exist ans` : |arr[ans`]-x|<|arr[ans]-x|) && (-1<ans<arr.length) }
    //      (arr[l`]< res <=arr[r`])
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        int[] arr = new int[args.length - 1];
        int sum = 0;
        for (int i = 1; i < args.length; i++) {
            arr[i - 1] = Integer.parseInt(args[i]);
            sum += arr[i - 1];
        }
    /*    int[] qqq=new int[]{2,3,4,5};
        System.out.println("!!!!!!!!!!!!!!!!!");
        System.out.println(recursiveBinSearchExpanded(10,qqq,-1,4));*/
        if (sum % 2 == 0) {
            System.out.println(recursiveBinSearch(x, arr));
        } else {
            System.out.println(iterativeBinSearch(x, arr));
        }
    }


    //Pre:
    //      int x
    //      forall i=0..a.length - 1:  arr[i] - int && arr[i-1]<=arr[i] && arr[i]!=null

    //Post:
    //     res = arr[ans] { ans: (not exist ans` : |arr[ans`]-x|<|arr[ans]-x|) && (-1<ans<arr.length) }
    //    (arr[l`]< res <=arr[r`])
    public static int iterativeBinSearch(int x, int[] arr) {
        int l = -1;
        //l = -1
        int r = arr.length;
        // r = arr.length

        int mid;
        // I : l <= r && l, r ∈ [-1, arr.length],
        while (l < r - 1) {
            mid = (l + r) / 2;
            //(*) l < mid < r   prove: 1) (l+r)/2=l+(r-l)/2,  (r-l)/2>0 (l < r - 1) -> mid=(l+r)/2>l
            //                         2) (l+r)/2=r-(r-l)/2, -(r-l)/2<0             -> mid=(l+r)/2<r
            //Similarly  l` < mid` < r`
            if (arr[mid] < x) {
                //x>arr[mid]
                l = mid;
                //l`=m` && I (by *)
            } else {
                //x<=arr[mid]
                r = mid;
                //r`=m` && I (by *)
            }
            //(*) l < mid < r   prove: 1) (l+r)/2=l+(r-l)/2,  (r-l)/2>0 (l < r - 1) -> mid=(l+r)/2>l
            //                         2) (l+r)/2=r-(r-l)/2, -(r-l)/2<0             -> mid=(l+r)/2<r
            //Similarly  l` < mid` < r`

            //mid' ∈ [l', r'] -> l', r' ∈ [l, r], l<r(by *) =>I
        }
        return searchClosestA(x, arr, r);
    }


    //Pre:
    //      int x
    //      forall i=0..a.length - 1:  arr[i] - int && arr[i-1]<=arr[i] && arr[i]!=null

    //Post:
    //     res = arr[ans] { ans: (not exist ans` : |arr[ans`]-x|<|arr[ans]-x|) && (-1<ans<arr.length) }
    //     (arr[l`]< res <=arr[r`])

    public static int recursiveBinSearch(int x, int[] arr) {
        
        return searchClosestA(x, arr, recursiveBinSearchExpanded(x, arr, -1, arr.length));
    }


    //Pre:
    //      int x
    //      forall i=0..a.length - 1:  arr[i] - int && arr[i-1]<=arr[i] && arr[i]!=null
    //      -1 <= l < r <= a.length  &&  arr[l] < x <= arr[r]

    //Post:
    //     1)if min(arr)>x>max(arr): res = i {i: ( arr[i]<=x) && (not exist i` : i`<i && arr[i`]<=x) && (-1 < i <= a.length)}
    //     2)if max(arr)<x: arr.length
    public static int recursiveBinSearchExpanded(int x, int[] arr, int l, int r) {
        int mid = (l + r) / 2;
        // I: int l,r: l <= r && l, r ∈ [-1, arr.length]
        if (l < r - 1) {
            if (arr[mid] < x) {
                //l` = mid` < r(by *)
                return recursiveBinSearchExpanded(x, arr, mid, r);
            } else {
                //r` = mid` > l(by *)
                return recursiveBinSearchExpanded(x, arr, l, mid);
            }
            //(*) l < mid < r   prove: 1) (l+r)/2=l+(r-l)/2,  (r-l)/2>0 (l < r - 1) -> mid=(l+r)/2>l
            //                         2) (l+r)/2=r-(r-l)/2, -(r-l)/2<0             -> mid=(l+r)/2<r
            //Similarly  l` < mid` < r`

            //mid' ∈ [l', r'] -> l', r' ∈ [l, r], l < r(by *) => I - true
        }
        return r;
    }

    //Pre:
    //      int x
    //      forall i=0..a.length - 1:  arr[i] - int && arr[i-1]<=arr[i] && arr[i]!=null
    //      r :     1)if min(arr)>x>max(arr): r = i {i: ( arr[i]<=x) && (not exist i` : i`<i && arr[i`]<=x) && (-1 < i <= a.length)}
    //              2)if max(arr)<x: r = arr.length
    //Post:
    //     res = arr[ans] { ans: (not exist ans` : |arr[ans`]-x|<|arr[ans]-x|) && (-1<ans<arr.length) }
   //      (arr[l`]< res <=arr[r`])
    public static int searchClosestA(int x, int[] arr, int r) {
        // case1: (r > 0 && r < arr.length) && |arr[r-1]-x|<=|arr[r]-x|
        // case2: r == arr.length -> max(arr) < x
        if ((r > 0 && r < arr.length && Math.abs(arr[r - 1] - x) <= Math.abs(arr[r] - x)) || (r == arr.length)) {
            //case1: -1<(r-1)<arr.length &&  (not exist y : |arr[y]-x|<|arr[r-1]-x|)
            //case2: max(arr) < x -> (-1 < r-1=arr.length-1 < arr.length) (not exist y : |arr[y]-x|<|arr[r-1]-x|)
            return arr[r - 1];
        }
        // not (case1 || case2) ->
        // case3:(r==0) || case4:(|arr[r-1]-x|>|arr[r]-x| && -1< r <arr.length )
        // case3: x<=min(arr) -> i=0 (not exist i` : |arr[i`]-x|<|arr[i]-x|) && (-1<i<arr.length)
        // case4: -1< r <arr.length &&  (not exist y : |arr[y]-x|<|arr[r]-x|)
        return arr[r];
    }
}