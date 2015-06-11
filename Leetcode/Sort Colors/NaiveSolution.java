public class NaiveSolution {
    public void sortColors(int[] nums) {
        int redCount = 0;
        int whiteCount = 0;
        int blueCount = 0;
        for (int i = 0; i < nums.length; i++) {
            switch (nums[i]) {
                case 0:
                    redCount++;
                    break;
                case 1:
                    whiteCount++;
                    break;
                case 2:
                    blueCount++;
                    break;
            }
        }
        
        for (int i=0; i < nums.length; i++) {
            if (redCount > 0) {
                nums[i] = 0;
                redCount--;
            } else if (whiteCount > 0) {
                nums[i] = 1;
                whiteCount--;
            } else if (blueCount > 0) {
                nums[i] = 2;
                blueCount--;
            }
            
        }
    }
}