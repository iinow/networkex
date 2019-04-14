package com.ha.test;

import org.junit.Test;

import javax.imageio.ImageIO;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

public class MainTest {

    @Test
    public void getContent() throws Exception {
        //http://www.lolcats.com/api/v1/users/index.html?name=32
        URI uri = new URI("http://www.lolcats.com");
        URL u = uri.toURL();
        u.getProtocol();
        u.getFile();        //부위지정자 전까지.
        u.getPath();        //쿼리 전까지
        u.getRef();         //부위지정자
        u.getQuery();
        u.getAuthority();   //기관
        u.toURI();
        Object obj = u.getContent();
        System.out.println(obj);
    }

    @Test
    public void 같은지비교() throws Exception {
        URL www = new URL("http://www.ibiblio.org/");
        URL ibiblio = new URL("http://ibiblio.org/");
        if(www.equals(ibiblio)){
            System.out.println("같다");
        }else{
            System.out.println("같지 않다");
        }
    }

    @Test
    public void URLtoString() throws Exception {
        URL naver = new URL("http://www.naver.com");
        System.out.println(naver.toString());
        System.out.println(naver.toExternalForm());
        assertEquals("", "", "");
    }

    @Test
    public void manga() throws Exception {
//        URL url = new URL("http://fanfox.net/manga/aka_akatoretachi_no_monogatari/");
        URL url = new URL("http://fanfox.net/template-14007-s1/");
        URLConnection connection = url.openConnection();
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        StringBuilder builder = new StringBuilder();
        reader.lines().forEach(builder::append);

        System.out.println(builder.toString());
//        System.out.println(connection.toString());
    }

    @Test
    public void downloadImage() throws Exception {
        URL url = new URL("https://www.777x.com/digital/video/ebod00691/ebod00691ps.jpg");
        URLConnection connection = url.openConnection();
        InputStreamReader inputStreamReader = new InputStreamReader(connection.getInputStream());
        BufferedReader reader = new BufferedReader(inputStreamReader);

        File img = new File("E:\\ebod.jpg");
        FileWriter writer = new FileWriter(img);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        BufferedImage image = ImageIO.read(url);
        ImageIO.write(image, "jpg", img);
        /*int v = 0;
        while(v != -1){
            v = inputStreamReader.read();
            bufferedWriter.write(v);
        }*/
//        inputStreamReader.read()

        /*reader.lines().forEach((str)-> {
            try {
                bufferedWriter.write(str);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });*/

//        bufferedWriter.close();
    }
}
