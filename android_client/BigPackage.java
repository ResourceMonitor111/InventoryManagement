package com.example.student.android_client;

/**
 * Created by student on 17.16.8.
 */

public class  BigPackage  {
    Object sendablePackage;
    private Object receivablePackage;
    Boolean flag;       //if flag==true Net thread should work on this object
                        //if flag==false Main thread should work on this object
    Boolean proceed;
    public BigPackage(){
        super();
        flag=false;
        proceed=true;
    }

    public synchronized Object getReceivablePackage() {
        return receivablePackage;
    }

    public synchronized void setReceivablePackage(Object recivablePackage) {
        this.receivablePackage = recivablePackage;
    }
}
