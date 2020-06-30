class LeetCodeHappyNumber {
    public boolean isHappy(int n) {
        HashSet<Integer> numbers = new HashSet<Integer>();
        int sum = 0;
        while(!numbers.contains(n)){
            numbers.add(n);
            while(n!= 0){
                int d = digit(n);
                sum += d*d;
                n = n/10;
            }
            if(sum == 1){
                return true;
            }
            n=sum;
            sum=0;
        }
        return false;
    }
    
    public int digit(int n){
        if(n==0){
            return 0;
        }
        return n%10; 
    }
}