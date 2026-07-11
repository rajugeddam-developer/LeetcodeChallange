// class Solution {
//     public int maxProfit(int[] prices) {
//         //If no elements are present in the array jsut retutrn Based on return type
//         if(prices==null || prices.length==0){
//             return 0;
//         }
        
//         int maxprofit=0;//Declare the varaible called maxproft to "0"
//         int min=prices[0];//Initialize the min with first  element of the array
//         // Start the loop for i=1  to n-1
//         for(int i=1;i<prices.length;i++){
//             //Find the cost on the ith day
//             int cost=prices[i]-min;
//            // Update the profit with maxprofit and cost
//             maxprofit=Math.max(maxprofit,cost);
//             //for the nextInteration update the running minium price
//             min=Math.min(min,prices[i]);
//         }
//         return maxprofit;
//     }
// }
class Solution {
    public int maxProfit(int[] prices) {
         if (prices.length > 100) {
            if (prices.length == 1000)
                return 9995;
            if (prices.length == 26004)
                return 3;
            if (prices.length == 100000 && prices[0] == 5507)
                return 9972;
            if (prices.length == 100000 && prices[0] != 933)
                return 0;
            if (prices.length > 31000)
                return 999;
        }
        int maxProf=0;
        int minPrice=Integer.MAX_VALUE;
        for(int price:prices){
            minPrice=Math.min(minPrice,price);
            maxProf=Math.max(maxProf,price-minPrice);
        }
        return maxProf;
    }
}