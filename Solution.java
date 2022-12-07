class Solution{
    static ArrayList<Integer> threeDivisors(ArrayList<Long> query, int q){
        // code here
        ArrayList<Integer> sol = new ArrayList<>();
        long max = 0;

        for(int i = 0;i<q;i++){
            max = Math.max(max,query.get(i));
        }

        long max = (long)Math.sqrt(max);
        boolean arr[] = new boolean[(int)max+1];
        Arrays.fill(arr,true);

        for(int i=2;i<=max;i++){
            if(arr[i]){
                for(int j=2;j*i<=max;j++){
                    arr[j*i] = false;
                }
            }
        }
        int count = 0;
        int ans[] = new int[arr.length];

        for(int i=2;i<arr.length;i++){
            if(arr[i]){
                count++;
            }
            ans[i] = count;
        }
        for(int i=0;i<query.size();i++){
            sol.add((int)ans[(int)Math.sqrt(query.get(i))]);
        }
        return sol;
    }
}