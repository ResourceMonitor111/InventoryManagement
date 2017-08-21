package main;

import com.google.zxing.Result;

public class GetResult {

    public static Result result;
    public static String codeString;
    public static long codeLong;

    public static Result getResult(){
        return result;
    }
    public static void setResult(Result code){
        result = code;
        setCodeLong(Long.parseLong(result.toString()));
        setCodeString(result.toString());
    }

    public static long getCodeLong(){
        return codeLong;
    }
    public static void setCodeLong(long code){
        codeLong = code;
    }

    public static String getCodeString(){
        return codeString;
    }
    public static void setCodeString(String code){
        codeString = code;
    }

}
