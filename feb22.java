/*there are mainly two conditions 
 * 1.The judge must not trust anyone means in the given code trusting should be 0 for judge.
 * 2.Every one should trust judge means trusted[judge]=n-1 
 * if above confitions satisfy then we can return judge
 */
public class feb22 {
    public int findJudge(int n, int[][] trust) {
        
        int[] trusting=new int[n+1];
        int[] trusted=new int[n+1];
       
         for (int[] relation : trust) {
            trusting[relation[0]]++;
            trusted[relation[1]]++;
        }
        for(int i=1;i<=n;i++){
            if(trusting[i]==0 && trusted[i]==n-1) return i;
        }
        return -1;
        
    }
    
}
/* TC:O(no: of elements in trust arr+ no: of people)
Iterating through the trust array to populate the trusting and trusted arrays takes O(E), where E is the number of elements in the trust array.
The subsequent loop iterates through the trusting and trusted arrays, which takes O(V), where V is the number of vertices (or people) in the town.
Overall, the time complexity is O(E + V).
Space Complexity: O(n+1)*/
