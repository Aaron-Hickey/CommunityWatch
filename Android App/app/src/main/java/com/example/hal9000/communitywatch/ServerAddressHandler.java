package com.example.hal9000.communitywatch;

public class ServerAddressHandler {

    private static ServerAddressHandler sah;
    //private String ServerAddress= "http://192.168.43.203:9000/";
    private String ServerAddress= "http://172.17.122.58:9000/";



    public static ServerAddressHandler getInstance()
    {
        if(sah == null)
        {
            sah = new ServerAddressHandler();
        }
        return sah;
    }

    public ServerAddressHandler()
    {

    }

    public String getAddress()
    {
        return ServerAddress;
    }
}
