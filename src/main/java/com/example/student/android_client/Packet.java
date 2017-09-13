package com.example.student.android_client;

/**
 * Created by student on 17.15.8.
 */

public class Packet {

    public static class ResponseGetProduct {
        public Product product;
    }

    public static class RequestGetProduct {
        public String barCode;
    }

    public static class ResponseInsertProduct {
        public boolean bool;
    }
    
    public static class RequestInsertProduct{
        public Product product;
    }
    
    public static class ResponseAddAmount {
        public boolean bool;
    }

    public static class RequestAddAmount {
        public String barCode;
        public int amount;
    }

    public static class ResponseSubtractAmount {
        public boolean bool;
    }

    public static class RequestSubtractAmount {
        public String barCode;
        public int amount;
    }

}
