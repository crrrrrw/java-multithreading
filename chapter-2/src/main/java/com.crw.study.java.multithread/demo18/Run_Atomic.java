package com.crw.study.java.multithread.demo18;

/**
 * P127
 * 使用原子类进行i++操作
 */
public class Run_Atomic {
    public static void main(String[] args) {
        AddCountThread countService = new AddCountThread();
        for (int i = 0; i <5; i++) {
            new Thread(countService).start();
        }
    }
}

/*
输出：
49949
49950
49951
49952
49953
49954
49955
49956
49957
49958
49959
49960
49961
49962
49963
49964
49965
49966
49967
49968
49969
49970
49971
49972
49973
49974
49975
49976
49977
49978
49979
49980
49981
49982
49983
49984
49985
49986
49987
49988
49989
49990
49991
49992
49993
49994
49995
49996
49997
49998
49999
50000
 */