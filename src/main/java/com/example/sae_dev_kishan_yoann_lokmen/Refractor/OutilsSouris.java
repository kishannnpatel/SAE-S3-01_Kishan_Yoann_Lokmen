package com.example.sae_dev_kishan_yoann_lokmen.Refractor;

public class OutilsSouris {
    public OutilsSouris(){

    }

    public static int toBloc(int pixel , int tailleBloc){
        return pixel/tailleBloc;
    }

    public static int distanceCarree(int x1,int y1,int x2,int y2){
        int dx = x1 - x2;
        int dy = y1 - y2;
        return dx * dx + dy * dy;
    }
}
