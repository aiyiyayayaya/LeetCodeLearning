package base;

/**
 * Created by aiya on 2019/8/30 上午10:54
 */
public class Sort {
    //冒泡排序
    public void bubbleSort(int[] array){
        for (int i = 0; i < array.length-1; i++){
            for (int j = 0; j < array.length-1-i; i++){
                if (array[i] > array[i+1]){
                    int tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                }
            }
        }
    }
    //选择排序：减少交换次数
    public void selectionSort(int[] array){
        for (int i = 0; i < array.length -1; i++){
            int index = i;
            for (int j = i + 1; j < array.length; j++){
                if (array[index] > array[j]){
                    index = j;
                }
            }
            int tmp = array[index];
            array[index] = array[i];
            array[i] = tmp;
        }
    }
    //快排
    public void quickSort(int[] array, int start, int end){
        if (start<0 || end >=  array.length || start >= end)
            return;
        int left = start, right = end;
        //哨兵:left
        int key = array[left];
        while(left < right){
            //right先走
            while(left < right && array[right] >= key)
                right--;
            //交换
            if (left < right) {
                array[left] = array[right];
                left++;
            }
            //left走
            while (left < right && array[left] <= key)
                left++;
            if (left < right) {
                array[right] = array[left];
                right--;
            }
        }
        //key在正确位置上
        array[right] = key;
        System.out.println(key);
        quickSort(array, start, right-1);
        quickSort(array, right+1, end);
    }

    public void mergeSort(int[] array, int left, int right, int[] temp){
        if (left < right){
            int mid = (left + right) >> 1;
            mergeSort(array, left, mid, temp);
            mergeSort(array, mid + 1, right, temp);
            merge(array, left, right, mid, temp);
        }
    }
    public void merge(int[] array, int left, int right, int mid, int[] temp){
        //i:left start; j:right start
        int i = left, j = mid + 1;
        int t = 0;
        while(i <= mid && j<=right){
            if (array[i] < array[j]){
                temp[t++] = array[i++];
            }else
                temp[t++] = array[j++];
        }
        while (i <= mid)
            temp[t++] = array[i++];
        while (j <= right)
            temp[t++] = array[j++];
        //end of merge
        //覆盖回原数组
        t = 0;
        while (left <= right){
            array[left++] = temp[t++];
        }
        System.out.println("hello");
    }
    public static void main(String[] args) {
        Sort sort = new Sort();
        int[] array = {1, 9, 6, 7, 2, 3, 8, 5};
        int[] temp = new int[array.length];
        //sort.quickSort(array, 0, array.length-1);
        sort.mergeSort(array, 0, array.length-1, temp);
    }
}
