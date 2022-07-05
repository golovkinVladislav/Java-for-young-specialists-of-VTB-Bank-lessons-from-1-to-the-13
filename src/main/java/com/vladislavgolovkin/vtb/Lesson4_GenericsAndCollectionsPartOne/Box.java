package com.vladislavgolovkin.vtb.Lesson4_GenericsAndCollectionsPartOne;

import java.util.ArrayList;
import java.util.Arrays;


public class Box<T extends Fruit> {
    private ArrayList<T> arrayList;

    public Box(T... fruits) {
        this.arrayList = new ArrayList<>(Arrays.asList(fruits));
    }

    public Box() {
        this.arrayList = new ArrayList<>();
    }
    public void add(T fruit){
        this.arrayList.add(fruit);
    }

    public void add(T... fruits){
        this.arrayList.addAll(Arrays.asList(fruits));
    }

    public float getWeight (){
        if(arrayList.size()==0){
            return 0.0f;
        }
        float sum = 0;
        for (int i=0; i<this.arrayList.size();i++){
           sum += this.arrayList.get(i).getWeight();
        }
        return sum;
    }


    public boolean compare(Box<?> box){
        float sum1 =0;
        float sum2 =0;
        for(int i=0; i<this.arrayList.size();i++){
           sum1+=this.arrayList.get(i).getWeight();

        }
        for(int i=0; i<box.arrayList.size();i++){
            sum2 += box.arrayList.get(i).getWeight();
        }
        if(sum1 == sum2){
            return true;
        }
        return false;
    }

    public void transfer(Box<? super T> another){
        if(this == another){
            return;
        }
        another.arrayList.addAll(this.arrayList);
        this.arrayList.clear();
    }


    public ArrayList<T> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<T> arrayList) {
        this.arrayList = arrayList;
    }
}
