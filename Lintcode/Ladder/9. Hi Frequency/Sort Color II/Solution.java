class Solution {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        
        if (colors == null || colors.length == 0 || k == 0) {
            return;
        }
        
        // 利用陣列中前k個元素作counter，負數代表該顏色有幾個
        // 如-1等於有1個，-2等於有2個，會選擇負數是因為顏色的表示皆為正
        // 若拜訪過也分到該到的bucket，則將該元素設為0
        for (int i = 0; i < colors.length; i++) {
            if (colors[i] > 0) {
                int pos = colors[i] - 1;
                if (colors[pos] <= 0) {
                    colors[pos]--;
                    colors[i] = 0;
                } else {
                    colors[i] = colors[pos];
                    colors[pos] = -1;
                    i--;
                }
            }
        }
        
        //從後面作回來，因為怕蓋掉前k個counter
        int i = colors.length - 1;
        int j = k - 1; //為counter的最後一個位置
        
        while (i >= 0) {
            while (colors[j] < 0) {
                colors[j] += 1;
                colors[i] = j + 1;
                i--;
            }
            j--;
        }
    }
}
