package 난이도별.level01.K번째수;

import java.util.Arrays;
import java.util.stream.IntStream;

// commands[[i,j,k],[i,j,k]]

public class sjjyy {
    public static int[] solution(int[] array, int[][] commands)
    {
        int len = commands.length;
        int [] answer = new int[len];

        for(int i = 0 ; i < len ; i++)
        {
            int [] nowCommands = commands[i];
            int [] tmp = new int[nowCommands[1]-(nowCommands[0]-1)];
            int tLen = tmp.length;

            for(int j = 0 ; j < tLen; j++)
                tmp[j] = array[(nowCommands[0]-1) + j];
            // System.arraycopy(array, 0 + (commands[i][0] - 1), tmp, 0, tLen);

            Arrays.sort(tmp);
            answer[i] = tmp[nowCommands[2]-1];
        }
        return answer;
    }

    public static int[] solution2(int[] array, int[][] commands) // 다른 사람 풀이
    {
        int[] answer = new int[commands.length];

        for(int i = 0 ; i < commands.length ; i++)
        {
            int [] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2]-1];
        }

        return answer;

    }

    public static int[] solution3(int[] array, int[][] commands)
    {
        return IntStream.range(0, commands.length).map(i -> {
            int[] nowCommands = commands[i];
            int [] temp = Arrays.copyOfRange(array, nowCommands[0]-1, nowCommands[1]);
            Arrays.sort(temp);
            return temp[nowCommands[2]-1];
        }).toArray();
    }

    public static void main(String [] args)
    {
        int[] arr= {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        System.out.println(Arrays.toString(solution(arr, commands))); // [5, 6, 3]
        System.out.println(Arrays.toString(solution2(arr, commands))); // [5, 6, 3]
        System.out.println(Arrays.toString(solution3(arr, commands))); // [5, 6, 3]
    }
}
