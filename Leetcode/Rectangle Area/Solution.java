public class Solution {
    
    int areaOfRec(int left, int right, int top, int bottom) {
        int result = (left < right && top > bottom) ? (right - left) * (top - bottom) : 0;
        return result;
    }
    
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int left1 = A;
        int bottom1 = B;
        int right1 = C;
        int top1 = D;
        
        int left2 = E;
        int bottom2 = F;
        int right2 = G;
        int top2 = H;
        
        int left = Math.max(left1, left2);
        int right = Math.min(right1, right2);
        int top = Math.min(top1, top2);
        int bottom = Math.max(bottom1, bottom2);
        
        return areaOfRec(left1, right1, top1, bottom1) + 
               areaOfRec(left2, right2, top2, bottom2) - 
               areaOfRec(left, right, top, bottom);
    }
}