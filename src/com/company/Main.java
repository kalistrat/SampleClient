package com.company;

import java.net.Socket;

public class Main {

    public static void main(String[] args) {

        try
        {
            // открываем сокет и коннектимся к localhost:3128
            // получаем сокет сервера
            Socket s = new Socket("localhost", 3128);

            // берём поток вывода и выводим туда первый аргумент
            // заданный при вызове, адрес открытого сокета и его порт
            //Message Example: add/semenov/sensor/123
            //Message Example: add/semenov/state/1234


            String InMessageValue = "add/k/task/2/";

            s.getOutputStream().write(InMessageValue.getBytes());

            // читаем ответ
            byte buf[] = new byte[256*1024];
            int r = s.getInputStream().read(buf);
            String data = new String(buf, 0, r);

            // выводим ответ в консоль
            System.out.println(data);
        }
        catch(Exception e)
        {
            System.out.println("init error: "+e);
        }

    }
}
