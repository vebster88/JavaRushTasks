package com.javarush.task.task17.task1714;

/* 
Comparable
*/

public class Beach implements Comparable<Beach> {
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    @Override
    public synchronized int compareTo(Beach o) {
        if ((this.quality > o.quality && this.distance <= o.distance) || (this.quality >= o.quality && this.distance < o.distance)) {
            return 1;
        } else if ((this.quality < o.quality && this.distance >= o.distance) || (this.quality <= o.quality && this.distance > o.distance)) {
            return -1;
        } else return 0;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    public static void main(String[] args) {
        Beach a = new Beach("A", 200, 9);
        Beach b = new Beach("B", 500, 10);
        Beach c = new Beach("C", 100, 5);
        Beach d = new Beach("D", 200, 8);
//        System.out.println(a.compareTo(b));
//        System.out.println(b.compareTo(c));
//        System.out.println(c.compareTo(d));
//        System.out.println(a.compareTo(c));
//        System.out.println(a.compareTo(d));
//        System.out.println(b.compareTo(d));
//        System.out.println(d.compareTo(a));

    }
}
